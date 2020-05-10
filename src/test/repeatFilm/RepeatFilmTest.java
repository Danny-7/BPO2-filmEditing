package test.repeatFilm;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatFilmTest{

    private static String toString(Film f){
        StringBuilder sb = new StringBuilder("");
        char[][] display = new char[f.hauteur()][f.largeur()];
        while(f.suivante(display)){
           sb.append(Films.toString(display)+ "\n");
        }
        return sb.toString();
    }

    private void testRepeatFilm(){
        int nbRep = 2;

        Film f = new Movie(new RealMovie(nbRep));
        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.repeat(filmToTest, nbRep);
        String filmToTestString = "";
        String film = "";
        filmToTestString = toString(filmToTest);
        film = toString(f);
        // test si le film répeter
        assertEquals(film, filmToTestString);
    }

    private void testEmptyRepeatFilm(){
        int nbRep = 0;
        Film f = new Movie(new RealMovie(nbRep));
        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.repeat(filmToTest, nbRep);
        String filmToTestString = "";
        String film = "";
        filmToTestString = toString(filmToTest);
        film = toString(f);
        // test si le film répeter
        assertEquals(film, filmToTestString);
    }

    @Test
    public void test(){
        testRepeatFilm();
        testEmptyRepeatFilm();
    }


}