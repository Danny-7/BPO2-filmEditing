package test.resources;

import film.Film;

public class EmptyMovie implements Film {
    @Override
    public int hauteur() {
        return 14;
    }

    @Override
    public int largeur() {
        return 17;
    }

    @Override
    public boolean suivante(char[][] écran) {
        return false;
    }

    @Override
    public void rembobiner() {
        //RIP
    }
}
