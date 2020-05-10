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

    private static String toString(Film f){
        StringBuilder sb = new StringBuilder("");
        char[][] display = new char[f.hauteur()][f.largeur()];
        while(f.suivante(display)){
            sb.append(Films.toString(display)+ "\n");
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

        String filmToTestString = "";
        String film = "";

        filmToTestString = toString(filmToTest);

        film = toString(f);

        assertEquals(film, filmToTestString);
    }
}
