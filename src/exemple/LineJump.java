package exemple;

import film.Film;

public class LineJump implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 2;

    @Override
    public int hauteur() {
        return 5;
    }

    @Override
    public int largeur() {
        return 5;
    }

    public int getNbFrame(){
        return NB_IMAGES;
    }

    @Override
    public boolean suivante(char[][] écran) {
        if(num == NB_IMAGES)
            return false;
        for (int i = 0; i < hauteur(); i+=2) {
            for (int j = 0; j < largeur(); j+=2) {
                écran[i][j] = 'l'+1;
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
