/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Genre;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javax.sql.DataSource;

public class SqlGenreRepository implements Repository<Genre> {

    private static final String ID_GENRE = "IDGenre";
    private static final String NAME = "Name";

    private static final String SELECT_GENRES = "{ CALL selectGenres  }";
    private static final String SELECT_GENRE = "{ CALL selectGenre (?) }";
    private static final String CREATE_GENRE = "{ CALL createGenre (?,?) }";
    private static final String UPDATE_GENRE = "{ CALL updateGenre (?,?) }";
    private static final String DELETE_GENRE = "{ CALL deleteGenre (?) }";

    private static final String DELETE_ALL_GENRES = "{ CALL deleteAllGenres }";

    @Override
    public int create(Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {
            stmt.setString(1, genre.getName());
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.executeUpdate();

            return stmt.getInt(2);
        }
    }


    @Override
    public void update(int id, Genre data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_GENRE)) {
            stmt.setInt(1, id);
            stmt.setString(2, data.getName());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_GENRE)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Genre> select(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con  = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_GENRE)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return Optional.of(new Genre(
                            id, 
                            rs.getString(NAME)));
                }
            }
                
        }
        return Optional.empty();
    }

    @Override
    public List<Genre> selectAll() throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try(Connection con  = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_GENRES);
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    genres.add(new Genre(
                            rs.getInt(ID_GENRE), 
                            rs.getString(NAME)));
                }
            }
        return genres;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ALL_GENRES)) {
            stmt.executeUpdate();
        }
    }

}
