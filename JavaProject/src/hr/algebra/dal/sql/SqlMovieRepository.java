/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Genre;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import hr.algebra.model.Movie;
import hr.algebra.model.Person;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class SqlMovieRepository implements Repository<Movie> {

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String DESCRIPTION = "Description";
    private static final String ORIGINAL_NAME = "OrigName"; //
    private static final String PUBLISHED_DATE = "PubDate";
    private static final String LENGTH = "Length"; //
    private static final String POSTER = "Poster";

    private static final String ID_GENRE = "IDGenre"; //
    private static final String NAME = "Name";

    private static final String ID_PERSON = "IDPerson";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";

    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?,?,?) }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_MOVIES = "{ CALL selectMovies }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";

    private static final String CREATE_MOVIEGENRE = "{ CALL createMovieGenre (?,?) }"; //
    private static final String CREATE_MOVIEACTOR = "{ CALL createMovieActor (?,?) }";
    private static final String CREATE_MOVIEDIRECTOR = "{ CALL createMovieDirector (?,?) }";

    private static final String SELECT_ACTORS_FROM_MOVIE = "{ CALL selectActorsFromMovie (?) }";
    private static final String SELECT_DIRECTORS_FROM_MOVIE = "{ CALL selectDirectorsFromMovie (?) }"; //
    private static final String SELECT_GENRES_FROM_MOVIE = "{ CALL selectGenresFromMovie (?) }"; //
    
     private static final String DELETE_GENRES_FROM_MOVIE = "{ CALL deleteGenresFromMovie (?) }";
     private static final String DELETE_ACTORS_FROM_MOVIE = "{ CALL deleteActorsFromMovie (?) }";
     private static final String DELETE_DIRECTORS_FROM_MOVIE = "{ CALL deleteDirectorsFromMovie (?) }";

    private static final String DELETE_ALL_MOVIES = "{ CALL deleteAllMovies }";

    @Override
    public int create(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getPublishedDate().format(Movie.DATE_FORMATTER));
            stmt.setString(3, movie.getDescription());
            stmt.setString(4, movie.getOrigName());
            stmt.setInt(5, movie.getLength());
            stmt.setString(6, movie.getPosterPath());

            stmt.registerOutParameter(7, Types.INTEGER);
            stmt.executeUpdate();

            if (movie.getDirectors() != null) {
                movie.getDirectors().forEach(d -> {
                    try {
                        addDirector(stmt.getInt(7), d.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            if (movie.getGenres() != null) {
                movie.getGenres().forEach(g -> {
                    try {
                        addGenre(stmt.getInt(7), g.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            if (movie.getActors() != null) {
                movie.getActors().forEach(a -> {
                    try {
                        addActor(stmt.getInt(7), a.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }

            return stmt.getInt(7);
        }
    }

    private void addDirector(int movieId, int directorId) throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIEDIRECTOR)) {

            stmt.setInt(1, movieId);
            stmt.setInt(2, directorId);

            stmt.executeUpdate();

        }
    }
    
    private void deleteDirectors(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_DIRECTORS_FROM_MOVIE)) {

            stmt.setInt(1, movieID);
            
            stmt.executeUpdate();

        }
    }

    private void addGenre(int movieId, int genreId) throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIEGENRE)) {
            stmt.setInt(1, movieId);
            stmt.setInt(2, genreId);

            stmt.executeUpdate();
        }
    }
    
    private void deleteGenres(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_GENRES_FROM_MOVIE)) {

            stmt.setInt(1, movieID);
            
            stmt.executeUpdate();

        }
    }

    private void addActor(int movieId, int actorId) throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIEACTOR)) {
            stmt.setInt(1, movieId);
            stmt.setInt(2, actorId);

            stmt.executeUpdate();
        }
    }
    
    private void deleteActors(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ACTORS_FROM_MOVIE)) {

            stmt.setInt(1, movieID);
            
            stmt.executeUpdate();

        }
    }

    @Override
    public void update(int id, Movie data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            stmt.setString(1, data.getTitle());
            stmt.setString(2, data.getPublishedDate().format(Movie.DATE_FORMATTER));
            stmt.setString(3, data.getDescription());
            stmt.setString(4, data.getOrigName());
            stmt.setInt(5, data.getLength());
            stmt.setString(6, data.getPosterPath());
            stmt.setInt(7, id);

            stmt.executeUpdate();
            if (data.getDirectors() != null) {
                deleteDirectors(id);
                data.getDirectors().forEach(d -> {
                    try {
                        addDirector(id, d.getId());
                    } catch (Exception ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            if (data.getGenres() != null) {
                deleteGenres(id);
                data.getGenres().forEach(g -> {
                    try {
                        addGenre(id, g.getId());
                    } catch (Exception ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            if (data.getActors() != null) {
                deleteActors(id);
                data.getActors().forEach(a -> {
                    try {
                        addActor(id, a.getId());
                    } catch (Exception ex) {
                        Logger.getLogger(SqlMovieRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Movie> select(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE);
                CallableStatement stmtActors = con.prepareCall(SELECT_ACTORS_FROM_MOVIE);
                CallableStatement stmtDirectors = con.prepareCall(SELECT_DIRECTORS_FROM_MOVIE);
                CallableStatement stmtGenres = con.prepareCall(SELECT_GENRES_FROM_MOVIE);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    List<Person> actors = new ArrayList<>();
                    stmtActors.setInt(1, id);
                    try (ResultSet rsActors = stmtActors.executeQuery()) {
                        while (rsActors.next()) {
                            actors.add(new Person(
                                    rsActors.getInt(ID_PERSON),
                                    rsActors.getString(FIRST_NAME),
                                    rsActors.getString(LAST_NAME)));
                        }
                    }
                    List<Person> directors = new ArrayList<>();
                    stmtDirectors.setInt(1, id);
                    try (ResultSet rsDirectors = stmtDirectors.executeQuery()) {
                        while (rsDirectors.next()) {
                            directors.add(new Person(
                                    rsDirectors.getInt(ID_PERSON),
                                    rsDirectors.getString(FIRST_NAME),
                                    rsDirectors.getString(LAST_NAME)
                            ));

                        }
                    }

                    List<Genre> genres = new ArrayList<>();
                    stmtGenres.setInt(1, id);
                    try (ResultSet rsGenres = stmtGenres.executeQuery()) {
                        while (rsGenres.next()) {
                            genres.add(new Genre(
                                    rsGenres.getInt(ID_GENRE),
                                    rsGenres.getString(NAME)
                            ));

                        }
                    }
                    return Optional.of(new Movie(
                            id, 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Movie.DATE_FORMATTER), 
                            rs.getString(DESCRIPTION),
                            rs.getString(ORIGINAL_NAME),
                            directors,
                            actors,
                            rs.getInt(LENGTH),
                            genres,
                            rs.getString(POSTER)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> selectAll() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                CallableStatement stmtActors = con.prepareCall(SELECT_ACTORS_FROM_MOVIE);
                CallableStatement stmtDirectors = con.prepareCall(SELECT_DIRECTORS_FROM_MOVIE);
                CallableStatement stmtGenres = con.prepareCall(SELECT_GENRES_FROM_MOVIE);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(ID_MOVIE);

                List<Person> actors = new ArrayList<>();
                stmtActors.setInt(1, id);
                try (ResultSet rsActors = stmtActors.executeQuery()) {
                    while (rsActors.next()) {
                        actors.add(new Person(
                                rsActors.getInt(ID_PERSON),
                                rsActors.getString(FIRST_NAME),
                                rsActors.getString(LAST_NAME)));
                    }

                }
                List<Person> directors = new ArrayList<>();
                stmtDirectors.setInt(1, id);
                try (ResultSet rsDirectors = stmtDirectors.executeQuery()) {
                    while (rsDirectors.next()) {
                        directors.add(new Person(
                                rsDirectors.getInt(ID_PERSON),
                                rsDirectors.getString(FIRST_NAME),
                                rsDirectors.getString(LAST_NAME)
                        ));

                    }
                }
                List<Genre> genres = new ArrayList<>();
                stmtGenres.setInt(1, id);
                try (ResultSet rsGenres = stmtGenres.executeQuery()) {
                    while (rsGenres.next()) {
                        genres.add(new Genre(
                                rsGenres.getInt(ID_GENRE),
                                rsGenres.getString(NAME)
                        ));

                    }
                }

                movies.add(new Movie(
                        id,
                        rs.getString(TITLE),
                        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), Movie.DATE_FORMATTER),
                        rs.getString(DESCRIPTION),
                        rs.getString(ORIGINAL_NAME),
                        directors,
                        actors,
                        rs.getInt(LENGTH),
                        genres,
                        rs.getString(POSTER)));

            }

        }
        return movies;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ALL_MOVIES)) {

            stmt.executeUpdate();

        }
    }
}
