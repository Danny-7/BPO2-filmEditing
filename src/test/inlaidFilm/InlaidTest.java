package test.inlaidFilm;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import exemple.Ligne;
import exemple.LineJump;
import film.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.InlayReal;
import test.resources.RealMovie;

public class InlaidTest extends TestMovie {
    @Test
    public void test(){
        Film f = new Movie(new LaDiagonaleDuFou());
        Film f2 = new Movie(new Ligne());
        Film f3 = new InlayReal(f2,f,80,4);

        Film toTest = Editing.inlay(f2,f,80,4);
        String filmToTest = TestMovie.toString(toTest);
        String filmExpected = TestMovie.toString(f3);

        // test si le film répeter
        Assertions.assertEquals(filmExpected, filmToTest);
    }

}
