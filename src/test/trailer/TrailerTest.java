package test.trailer;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrailerTest {

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
        int start = 2;
        int end = 15;

        Film f = new Movie(new RealTrailer(start, end));

        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.trailer(filmToTest, start, end);

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
