package personalTest.framed;

import exemple.LineJump;
import film.Film;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;
import personalTest.TestMovie;
import personalTest.resources.FramedMovie;

import static org.junit.jupiter.api.Assertions.*;


public class FramedMovieTest extends TestMovie {

    private FramedMovieTest(){ super();}

    @Test
    public void test(){

        Film f = new FramedMovie(new LineJump());
        Film filmToTest = new Movie(new LineJump());
        // construit un film encadré
        Film finalFilmToTest = Editing.frameAMovie(filmToTest);

        String filmToTestString =  toString(finalFilmToTest);
        String film = toString(f);

        // comparaison de deux réprésentation de film (film attendu, film obtenu)
        assertEquals(film, filmToTestString);
        // verification que la hauteur et la largeur a changé
        assertTrue(finalFilmToTest.hauteur() == f.hauteur() && finalFilmToTest.largeur() == f.largeur());
    }
}
