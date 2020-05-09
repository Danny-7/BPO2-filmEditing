package test.repeatFilm;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatFilmTest{

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String toString(Console console){
        StringBuilder sb = new StringBuilder("");
        while(console != null){
           sb.append(console.readLine() + "\n");
        }
        return sb.toString();
    }

    @Test
    public void test(){
        int nbRep = 2;

        Film f = new Movie(new RealMovie(nbRep));
        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.repeat(filmToTest, nbRep);
        Films.projeter(filmToTest);
        String filmToTestString = "";
        String film = "";
        Console console = System.console();
        filmToTestString = toString(console);
        clearScreen();
        Films.projeter(f);
        film = toString(console);

        // test si le film répeter
        assertEquals(film, filmToTestString);
    }


}