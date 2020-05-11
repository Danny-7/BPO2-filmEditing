package test.resources;

import film.Film;

public class InlayReal implements Film {
    private Film f;
    private Film f2;

    public InlayReal(Film f, Film f2){
        this.f = f;
        this.f2 = f2;
    }
    @Override
    public int hauteur() {
        return this.f.hauteur();
    }

    @Override
    public int largeur() {
        return this.f.largeur();
    }

    @Override
    public boolean suivante(char[][] écran) {
        return false;
    }

    @Override
    public void rembobiner() {

    }
}
