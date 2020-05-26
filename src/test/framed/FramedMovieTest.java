package test.framed;

import exemple.LineJump;
import film.Film;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.EmptyMovie;
import test.resources.FramedMovie;

import static org.junit.jupiter.api.Assertions.*;


public class FramedMovieTest extends TestMovie {

    private FramedMovieTest(){ super();}

    @Test
    public void test(){

        Film f = new FramedMovie(new LineJump('c'), 'c');
        Film film = new LineJump('c');
        // construit un film encadré
        Film finalFilmToTest = Editing.frameAMovie(film);

        String filmToTestString =  toString(finalFilmToTest);
        String filmString = toString(f);

        // verification que la hauteur et la largeur a changé
        assertTrue(finalFilmToTest.hauteur() == f.hauteur());
        assertTrue(finalFilmToTest.largeur() == f.largeur());

        // comparaison de deux réprésentation de film (film attendu, film obtenu)
        assertEquals(filmString, filmToTestString);



    }
}
