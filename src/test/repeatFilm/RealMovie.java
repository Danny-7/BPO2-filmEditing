package test.repeatFilm;

import film.Film;

public class RealMovie implements Film {
    private static int nbRep;
    private int num = 0;
    private static final int NB_IMAGES = 20* nbRep;

    public RealMovie(int nbRep){
        nbRep = nbRep;
    }

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
}
