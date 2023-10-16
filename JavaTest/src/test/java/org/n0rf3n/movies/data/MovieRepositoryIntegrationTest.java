package org.n0rf3n.movies.data;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.n0rf3n.movies.model.Genre;
import org.n0rf3n.movies.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class MovieRepositoryIntegrationTest {


    @Test
    public void load_all_movies() throws SQLException {

        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");//h2 crea base de datos en memoria.

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);//dataSource es la conexion en la base de datos.

        MovieRepositoryjdbc movieRepository = new MovieRepositoryjdbc(jdbcTemplate);

        Collection<Movie> movies = movieRepository.findAll();

        assertThat( movies,
                is(Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "Matrix", 136, Genre.ACTION)
                )) );
    }

}