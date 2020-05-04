package montage;

import film.Film;

import java.util.ListIterator;

public class FrameMovie {

    private char[][] getFrame(Film f, Frame e){
        char[][] framedScreen = new char[f.hauteur()+2][f.largeur()+2];
        char[][] frame = e.getFrame();
        for(int i =0; i < framedScreen.length; ++i){
            for(int j = 0; j < framedScreen[0].length;++j){
                framedScreen[0][i] = '*';
                framedScreen[i+1] = frame[i];
                framedScreen[i][0] = '*';
                framedScreen[i][f.largeur() -1] = '*';
                framedScreen[f.hauteur()-1][i] = '*';
                framedScreen[i+1][j] = ' ';
            }

        }
        return framedScreen;
    }
}
