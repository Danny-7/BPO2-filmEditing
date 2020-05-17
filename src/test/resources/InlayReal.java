package test.resources;

import film.Film;

public class InlayReal implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 20;

    private Film original;
    private Film toInlay;
    private int row;
    private int column;

    public InlayReal(Film f, Film toInlay, int r, int c){
        this.original = f;
        this.toInlay = toInlay;
        this.row = r-1;
        this.column = c-1;
    }

    @Override
    public int hauteur() {
        return this.original.hauteur();
    }

    @Override
    public int largeur() {
        return this.original.largeur();
    }

    @Override
    public boolean suivante(char[][] écran) {
        if(original.suivante(écran)){
            //écran du deuxième film
            char[][] display = new char[toInlay.hauteur()][toInlay.largeur()];
            if(num > row/toInlay.hauteur() && toInlay.suivante(display))
                for(int i = 0; row< original.hauteur(); ++row){
                    for(int j = 0; column < original.largeur(); ++column) {
                        if (!(row > display.length && column > display[0].length)) {
                            écran[row][column] = display[i][j];
                            ++j;
                        }
                    }
                    column = 0;
                    ++i;
                }
            ++num;
            return true;
        }
        return false;
    }

    @Override
    public void rembobiner() {

    }
}
