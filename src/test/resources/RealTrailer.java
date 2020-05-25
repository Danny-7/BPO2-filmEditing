package test.resources;

import film.Film;

public class RealTrailer implements Film {
    private int num = 0;
    private static int NB_IMAGES = 20;

    public RealTrailer(int start, int end){
        num+= start;
        NB_IMAGES = end+1;
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
