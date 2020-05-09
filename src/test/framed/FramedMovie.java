package test.framed;

import film.Film;

public class FramedMovie implements Film {
    private int num = 0;
    private static final int NB_IMAGES = 20;

    @Override
    public int hauteur() {
        return 10 +2 ;
    }

    @Override
    public int largeur() {
        return hauteur()+2; // ce sera un carré
    }

    @Override
    public boolean suivante(char[][] écran) {
        if (num == NB_IMAGES)
            return false;
        for (int i = 0; i < hauteur(); i++) {
            écran[i][0] = '*'; // ligne vertical gauche
            écran[i][hauteur()-1] = '*'; // ligne vertical droite
            for (int j = 0; j < largeur(); j++) {
                écran[0][j] = '*';   // ligne horizontale haut
                if(!(j >= largeur() || i >= hauteur()))
                    écran[num % hauteur()][num% largeur()] = 'a';
                écran[hauteur() - 1][j]= '*'; // ligne horizontale bas
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
