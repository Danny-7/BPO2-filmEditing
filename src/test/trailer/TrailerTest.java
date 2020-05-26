package test.trailer;

import editing.Editing;
import exemple.LaDiagonaleDuFou;
import film.Film;
import org.junit.jupiter.api.Test;
import test.TestMovie;
import test.resources.RealTrailer;

import static org.junit.jupiter.api.Assertions.*;

public class TrailerTest extends TestMovie {

    private TrailerTest(){ super();}

    @Test
    public void trailerTest(){
        // extrait d'un film normal
        mainTest(2, 15, 14);
        // extrait commençant à une valuer négative (doit commencer à 0)
        mainTest(-2, 5, 6);
        // extrait d'un film avec des bornes négatives (film vide)
        mainTest(-3, -3, 0);
        // borne de fin plus grande que le nombre d'images (même film quu'en entrée)
        mainTest(0, 60, 20);
    }

    private void mainTest(int start, int end, int nbFrameExpected){

        Film filmToTest = new LaDiagonaleDuFou();

        Film finalFilmToTest = Editing.trailer(filmToTest, start, end);
        if(start < 0)
            start = 0;
        Film f = new RealTrailer(start, end);

        //extrait de film
        String filmToTestString = toString(finalFilmToTest);
        String film = toString(f);

        assertEquals(filmToTest.hauteur(),finalFilmToTest.hauteur());
        assertEquals(filmToTest.largeur(), finalFilmToTest.largeur());

        assertEquals(film, filmToTestString);
        // vérification que le nombre d'images est bien cohérent avec les données entrées
        assertFalse( nbFrame(finalFilmToTest,nbFrameExpected) != nbFrameExpected);
    }
}
