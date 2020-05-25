package personalTest.resources;

import film.Film;

public class FilmExpectedtoPaste implements Film {
    private Film f;
    private Film f2;

    public FilmExpectedtoPaste(Film f, Film f2){
        this.f = f;
        this.f2 = f2;
    }

    @Override
    public int hauteur() {
        return Math.max(f.hauteur(), f2.hauteur());
    }

    @Override
    public int largeur() {
        return Math.max(f.largeur(), f2.largeur());
    }

    @Override
    public boolean suivante(char[][] écran) {
        if(f.suivante(écran)) {
            return true;
        }
        if(f2.suivante(écran))
            return true;
        return false;
    }

    @Override
    public void rembobiner() {
    }
}
