package test.trailer;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import film.Film;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.RealTrailer;

import static org.junit.jupiter.api.Assertions.*;

public class TrailerTest extends TestMovie {

    private TrailerTest(){ super();}

    @Test
    public void test(){
        int start = 2;
        int end = 15;
        int nbFrame = end - start;

        Film f = new Movie(new RealTrailer(start, end));

        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        Film finalFilmToTest = Editing.trailer(filmToTest, start, end);

        String filmToTestString = toString(finalFilmToTest);

        String film = toString(f);

        assertEquals(film, filmToTestString);
        assertFalse(TestMovie.getNbFrames()/2 != nbFrame);
    }
}
