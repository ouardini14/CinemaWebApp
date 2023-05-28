package com.project.cinemaBackend.service;

import com.project.cinemaBackend.dao.*;
import com.project.cinemaBackend.entity.*;
import com.project.cinemaBackend.dao.*;
import com.project.cinemaBackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInitServiceImpl  implements ICinemaInitService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProjectionRepository projectionRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void initUsers() {
        Stream.of("Farah", "Anas", "Ihssane", "Ibrahim", "Hanane", "Lmiae")
                .forEach(username -> {
                    userRepository.save(new User(username+"@gmail.com", username, "1234"));
                });
    }

    @Override
    public void initCities() {
        Stream.of("Casablanca", "Rabat", "Fes", "Meknès", "Marrakech", "Tanger")
                .forEach(city -> {
                    cityRepository.save(new City(city));
                });
    }

    @Override
    public void initCinemas() {
        cityRepository.findAll()
                .forEach(city -> {
                    Stream.of("MEGARAMA", "Cinéma RIF","CHAHRAZAD", "Cinela Lynx", "Cinema Rialto", "Royal", "Paradise", "IMAX", "FOUNOUN").forEach(cinemaName->{
                        cinemaRepository.save(new Cinema(cinemaName, "",10, city));
                    });
                });
    }

    @Override
    public void initRooms() {
        cinemaRepository.findAll().forEach(cinema -> {
           for (int i = 0; i < cinema.getCountRooms(); i++) {
               Room room = new Room("Room " + (i + 1) , 15, cinema);
               roomRepository.save(room);
           }
        });
    }

    @Override
    public void initSeats() {
        roomRepository.findAll().forEach(room -> {
                    for (int i = 0; i < room.getCountSeats(); i++) {
                        Seat seat = new Seat(i + 1, room);
                        seatRepository.save(seat);
                    }
                });
    }

    @Override
    public void initSessions() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("10:00", "13:00", "15:00", "19:00", "21:00").forEach(startSession -> {
            try {
                Session session = new Session(dateFormat.parse(startSession));
                sessionRepository.save(session);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void initCategories() {
        Stream.of("DRAMA", "ACTION", "HORROR", "SCI-FI", "COMEDY", "ROMANCE", "CRIME")
                .forEach(category -> categoryRepository.save(new Category(category)));
    }

    @Override
    public void initMovies() {
        List<Category> categories = categoryRepository.findAll();
        Stream.of("Jocker","Parasite","The call").forEach(movieName -> {
            String photoName = movieName.replaceAll(" ", "");
            Movie movie = new Movie(movieName, "director1", "desc1", 134, new Date(), categories.get(new Random().nextInt(categories.size())), photoName);
            // save movie
            movieRepository.save(movie);
        });

    }

    @Override
    public void initReviews() {
        movieRepository.findAll().forEach(movie -> {
            userRepository.findAll().forEach(user -> {
                reviewRepository
                        .save(new Review(movie.getTitle()+" is a Great Movie",
                                movie, user));
            });
        });
    }

    @Override
    public void initProjections() {
        List<Movie> movies = movieRepository.findAll();
        cityRepository.findAll().forEach(city -> {
            city.getCinemas().forEach(cinema -> {
                cinema.getRooms().forEach(room -> {
                        int index = new Random().nextInt(movies.size());
                        Movie movie = movies.get(index);
                        sessionRepository.findAll().forEach(session -> {
                            ProjectionMovie projectionMovie =
                                    new ProjectionMovie(new Date(), 40, room, movie, session);
                            // save projection movie
                            projectionRepository.save(projectionMovie);
                        });

                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projectionMovie -> {
            projectionMovie.getRoom().getSeats().forEach(seat -> {
                Ticket ticket =
                        new Ticket("", projectionMovie.getPrice(), false, seat, projectionMovie);
                ticketRepository.save(ticket);
            });
        });
    }

}
