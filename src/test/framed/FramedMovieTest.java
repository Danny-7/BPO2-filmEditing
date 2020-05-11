package test.framed;

import exemple.LineJump;
import film.Film;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.FramedMovie;

import static org.junit.jupiter.api.Assertions.*;


public class FramedMovieTest extends TestMovie {

    private FramedMovieTest(){ super();}

    @Test
    public void test(){

        Film f = new FramedMovie(new LineJump());
        Film filmToTest = new Movie(new LineJump());

        Film finalFilmToTest = Editing.frameAMovie(filmToTest);

        String filmToTestString =  toString(finalFilmToTest);
        String film = toString(f);

        assertEquals(film, filmToTestString);
        assertTrue(finalFilmToTest.hauteur() == f.hauteur() && finalFilmToTest.largeur() == f.largeur());
    }
}
