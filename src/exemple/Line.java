package exemple;
import film.Film;

/**
 * Un exemple basique d'implémentation de l'interface Film.
 */
public class Line implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 30;

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
        if(num == NB_IMAGES)
            return false;
        écran[num % hauteur()][num % hauteur()] = '%';
        ++num;
        return true;
    }

    @Override
    public void rembobiner() {
        num = 0;
    }

}
