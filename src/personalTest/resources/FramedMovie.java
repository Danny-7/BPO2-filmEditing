package personalTest.resources;

import film.Film;
import film.Films;

public class FramedMovie implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 20;
    private Film f;

    public FramedMovie(Film f){
        this.f = f;
    }

    @Override
    public int hauteur() {
        return f.hauteur()+2 ;
    }

    @Override
    public int largeur() {
        return f.largeur()+2;
    }

    @Override
    public boolean suivante(char[][] écran) {
        Films.effacer(écran);
        if (num == NB_IMAGES)
            return false;
        for (int i = 0; i < hauteur(); i++) {
            écran[i][0] = '*'; // ligne vertical gauche
            écran[i][largeur() - 1] = '*'; // ligne vertical droite
            for (int j = 0; j < largeur(); j++) {
                écran[0][j] = '*';   // ligne horizontale haut
                écran[hauteur()-1][j] = '*';
            }
        }
        for (int i = 1; i < hauteur() -1; i+=2) {
            for (int j = 1; j < largeur() -1; j+=2) {
                écran[i][j] = 'a';
            }
        }
        ++num;
        return true;
    }

    @Override
    public void rembobiner() {
        num = 0;
    }

}
