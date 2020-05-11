package test.repeatFilm;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.RealMovie;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatFilmTest extends TestMovie {

    private RepeatFilmTest(){ super();}

    private void testRepeatFilm(int nbRep){
        Film f = new Movie(new RealMovie(nbRep));

        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.repeat(filmToTest, nbRep);
        String filmToTestString = toString(filmToTest);
        String film = toString(f);

        // test si le film répeter
        assertEquals(film, filmToTestString);
    }

    private void testEmptyRepeatFilm(){
        testRepeatFilm(0);
    }

    private void testTrueRepeatFilm(){
        testRepeatFilm(5);
    }

    @Test
    public void test(){
        testTrueRepeatFilm();
        testEmptyRepeatFilm();
    }


}