package test.inlaidFilm;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import exemple.Ligne;
import film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.InlayReal;

public class InlaidTest extends TestMovie {

    @Test
    public void test(){
        Film f = new Movie(new LaDiagonaleDuFou());
        Film f2 = new Movie(new Ligne());
        Film f3 = new InlayReal(f,f2,5,4);

        Film toTest = Editing.inlay(f,f2,5,4);
        String filmToTest = TestMovie.toString(toTest);
        String filmNotExpected = TestMovie.toString(f3);

        // vérification que le film attendu n'est pas le même que le film obtenu
        Assertions.assertNotEquals(filmNotExpected, filmToTest);
        // on vérifie que la largeur et la hauteur du film n'aie pas changé
        Assertions.assertTrue(toTest.largeur() == f.largeur() && toTest.hauteur() == f.hauteur());

    }

}
