package test.repeatFilm;

import exemple.LaDiagonaleDuFou;
import exemple.Line;
import exemple.LineJump;
import film.Film;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.RealMovie;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatFilmTest extends TestMovie {

    private RepeatFilmTest(){ super();}

    /**
     * Un test général pour répéter un film
     *
     * @param nbRep nombre de répétitions
     */
    private void testRepeatFilm(Film f, int nbRep){
        if(nbRep < 0)
            nbRep = 0;
        Film film = new RealMovie(nbRep);

        Film film1 = f;
        Film filmToTest = Editing.repeat(film1, nbRep);
        String filmToTestString = toString(filmToTest);
        String filmString = toString(film);

        int nbFrame = nbFrame(film1);
        assertEquals(nbFrame*nbRep, nbFrame(filmToTest,nbFrame*nbRep));

        assertTrue(film1.hauteur() == filmToTest.hauteur());
        assertTrue(film1.largeur() == filmToTest.largeur());

        // test si le film répéter est celui attendu
        assertEquals(filmString, filmToTestString);
    }
    // test lors d'une entrée de nbRep <= 0
    private void testEmptyRepeatFilm(){
        testRepeatFilm(new LaDiagonaleDuFou(), 0);
    }

    // test lors d'une entrée de nbRep > 0
    private void testTrueRepeatFilm(){
        testRepeatFilm(new LaDiagonaleDuFou(), 5);
    }

    // test lors d'une entrée de nbRep < 0
    private void testnbRepNegative(){
        testRepeatFilm(new LaDiagonaleDuFou(), -5);
    }

    @Test
    public void test(){
        testTrueRepeatFilm();
        testEmptyRepeatFilm();
        testnbRepNegative();
    }
}