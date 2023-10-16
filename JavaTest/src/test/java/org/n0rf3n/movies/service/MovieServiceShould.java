package org.n0rf3n.movies.service;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.n0rf3n.movies.data.MovieRepository;
import org.n0rf3n.movies.model.Genre;
import org.n0rf3n.movies.model.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository mr = Mockito.mock(MovieRepository.class);//Simula la clase o repositorio.
        Mockito.when(mr.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );//Mockito simula la respuesta de la clase.
        movieService = new MovieService(mr);
    }


    private static List<Integer> getMoviesExtractor(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void return_movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> moviesIds = getMoviesExtractor(movies);

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3,6)));

    }


    @Test
    public void return_movies_by_lenght() {

        Collection<Movie> movies = movieService.findMoviesByLength(120);

        List<Integer> moviesIds = getMoviesExtractor(movies);

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2,3,4,5,6)));

    }

}