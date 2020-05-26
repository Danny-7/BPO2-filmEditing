package exemple;

import film.Film;
import film.Films;
import editing.*;

import java.io.FileNotFoundException;

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
        Film filmTest = new Movie(new LineJump('d'));
       Film repeat = Editing.repeat(filmTest, 2);
        repeat = Editing.paste(repeat, film);
        repeat = Editing.inlay(film, repeat, 54, 5);
        repeat = Editing.frameAMovie(repeat);
        Films.projeter(repeat);
        repeat.rembobiner();

        try {
            Films.sauvegarder(repeat, "test.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
        }
    }
}
