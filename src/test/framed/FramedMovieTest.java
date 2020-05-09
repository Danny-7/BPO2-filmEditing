package test.framed;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramedMovieTest {

    private static String toString(Console console){
        StringBuilder sb = new StringBuilder("");
        while(console != null){
            sb.append(console.readLine() + "\n");
        }
        return sb.toString();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Test
    public void test(){

        Film f = new Movie(new FramedMovie());
        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.frameAMovie(filmToTest);
        Films.projeter(filmToTest);
        String filmToTestString = "";
        String film = "";
        Console console = System.console();
        filmToTestString = toString(console);
        clearScreen();
        Films.projeter(f);
        film = toString(console);


        assertEquals(film, filmToTestString);
    }
}
