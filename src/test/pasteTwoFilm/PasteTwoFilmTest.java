package test.pasteTwoFilm;

import editing.Editing;
import exemple.LaDiagonaleDuFou;
import exemple.Line;
import exemple.LineJump;
import film.Film;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.EmptyMovie;
import test.resources.FilmExpectedtoPaste;

import static org.junit.jupiter.api.Assertions.*;

public class PasteTwoFilmTest extends TestMovie {

    private void testPasteTwoFilm(){

        Film diagonal = new LaDiagonaleDuFou();
        Film line = new Line();
        Film lineJump = new LineJump('s');
        Film emptyMovie = new EmptyMovie();

        // test normal
        Film f = new FilmExpectedtoPaste(diagonal, line);
        Film paste = Editing.paste(diagonal, line);
        String filmToTestString = toString(paste);
        String film = toString(f);

        assertEquals(50, nbFrame(paste, 50));
        // vérifie la condition de la hauteur et largeur du film collé (la hauteur et la largeur doit être le max
        // entre les deux films)
        assertTrue(paste.hauteur() == Math.max(diagonal.hauteur(), line.hauteur()));
        assertTrue(paste.largeur() == Math.max(diagonal.largeur(), line.largeur()));

        assertEquals(film, filmToTestString);

        // test avec une composition
        Film f2 = new FilmExpectedtoPaste(paste, lineJump);
        Film paste2 = Editing.paste(paste,lineJump);
        String filmToTestString2 = toString(paste2);
        String film2 = toString(f2);

        assertEquals(70, nbFrame(paste2, 70));

        assertTrue(paste2.hauteur() == Math.max(paste.hauteur(), lineJump.hauteur()));
        assertTrue(paste2.largeur() == Math.max(paste.largeur(), lineJump.largeur()));

        assertEquals(film2, filmToTestString2);

        // test avec le deuxième film vide
        Film f3 = new FilmExpectedtoPaste(lineJump, emptyMovie);
        f3.rembobiner();
        Film paste3 = Editing.paste(lineJump,emptyMovie);
        String filmToTestString3 = toString(paste2);
        String film3 = toString(f2);

        assertEquals(20, nbFrame(paste3, 20));

        assertTrue(paste3.hauteur() == Math.max(lineJump.hauteur(), emptyMovie.hauteur()));
        assertTrue(paste3.largeur() == Math.max(lineJump.largeur(), emptyMovie.largeur()));

        assertEquals(film3, filmToTestString3);
    }

    @Test
    public void test(){
        testPasteTwoFilm();
    }
}
