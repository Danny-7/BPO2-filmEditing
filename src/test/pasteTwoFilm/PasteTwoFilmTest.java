package test.pasteTwoFilm;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import exemple.Ligne;
import film.Film;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.FilmExpectedtoPaste;

import static org.junit.jupiter.api.Assertions.*;

public class PasteTwoFilmTest extends TestMovie {

    private void testPasteTwoFilm(){
        Film f = new Movie(new FilmExpectedtoPaste(new LaDiagonaleDuFou(), new Ligne()));

        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        Film filmToTest2 = new Movie(new Ligne());

        Film finalFilmPaste = Editing.paste(filmToTest, filmToTest2);
        String filmToTestString = toString(finalFilmPaste);
        String film = toString(f);

        assertEquals(film, filmToTestString);
        // vérifie la condition de la hauteur et largeur du film collé (la hauteur et la largeur doit être le max
        // entre les deux films)

        assertTrue(finalFilmPaste.hauteur() == Math.max(filmToTest.hauteur(),filmToTest2.hauteur()) &&
                finalFilmPaste.largeur() == Math.max(filmToTest.largeur(),filmToTest2.largeur()));
    }

    @Test
    public void test(){
        testPasteTwoFilm();
    }
}
