package test.framed;

import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import editing.Editing;
import editing.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramedMovieTest {

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

        Film f = new Movie(new FramedMovie());
        Film filmToTest = new Movie(new LaDiagonaleDuFou());
        filmToTest = Editing.frameAMovie(filmToTest);
        String filmToTestString = "";
        String film = "";
        filmToTestString = toString(filmToTest);
        film = toString(f);
        assertEquals(film, filmToTestString);
    }
}
