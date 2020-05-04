package exemple;

import java.io.FileNotFoundException;
import java.io.IOException;

import film.Film;
import film.Films;
import montage.FrameMovie;
import montage.Movie;
import montage.MovieTrailer;
import montage.PasteTwoFilm;

/**
 * Un exemple basique d'implémentation de l'interface Film.
 */
public class LaDiagonaleDuFou implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 20;

    @Override
    public int hauteur() {
        return 10;
    }

    @Override
    public int largeur() {
        return hauteur(); // ce sera un carré
    }

    @Override
    public boolean suivante(char[][] écran) {
        if (num == NB_IMAGES)
            return false;
        écran[num % hauteur()][num % hauteur()] = 'a'; // un 'a' se balade sur
        // la diagonale
        ++num;
        return true;
    }

    @Override
    public void rembobiner() {
        num = 0;
    }


    /**
     * La projection (puis la sauvegarde) d'un tel film.
     */
    public static void main(String[] args) {

        Film film = new Movie(new LaDiagonaleDuFou());
        Film filmTest = new Movie(new Ligne());
//        Films.projeter(film);

        Film pasteTwoFilm = PasteTwoFilm.paste(film, filmTest);
        Films.projeter(pasteTwoFilm);
        pasteTwoFilm.rembobiner();
        try {
            Films.sauvegarder(pasteTwoFilm, "test.txt");
//            Films.sauvegarder(trailer, "fou.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
        }


    }
}
