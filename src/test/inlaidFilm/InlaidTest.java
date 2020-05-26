package test.inlaidFilm;

import editing.Editing;

import film.Film;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.InlayReal;
import test.resources.ShortFilm;
import static org.junit.jupiter.api.Assertions.*;
public class InlaidTest extends TestMovie {

    @Test
    public void inlayTest(){
        Film f = new ShortFilm('c', 5);
        Film f2 = new ShortFilm('d', 4);
        Film f3 = new ShortFilm('a',5,5,10);

        // incrustation basique
        mainTest(f, f2, 5, 1);
        Film paste = Editing.paste(f, f2);
        // incrustation composé d'un film collé
        mainTest(paste, f2, 10, 2);


    }

    private void mainTest(Film f, Film f1, int row, int col){

        Film f3 = new InlayReal(f, f1, row, col);

        Film toTest = Editing.inlay(f,f1,row,col);
        String filmToTest = TestMovie.toString(toTest);
        String filmExpected = TestMovie.toString(f3);

        // vérification que le film obtenu soit le même que le film attendu
        assertEquals(filmExpected, filmToTest);
        // on vérifie que la largeur et la hauteur du film n'aie pas changé
        assertTrue(toTest.hauteur() == f.hauteur());
        assertTrue(toTest.largeur() == f.largeur());
    }

}
