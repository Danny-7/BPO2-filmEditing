package personalTest.trailer;

import editing.Editing;
import editing.Movie;
import exemple.LaDiagonaleDuFou;
import film.Film;
import org.junit.jupiter.api.Test;
import personalTest.TestMovie;
import personalTest.resources.RealTrailer;

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
        // vérification que le nombre d'images est bien cohérent avec les données entrées
        assertFalse(TestMovie.getNbFrames()/2 != nbFrame);
    }
}
