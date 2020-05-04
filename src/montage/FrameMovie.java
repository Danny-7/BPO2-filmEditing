package montage;

import film.Film;
import film.Films;

import java.util.List;
import java.util.ListIterator;

public class FrameMovie {

    private static Frame getFrame(Film f, Frame e){
        char[][] framedScreen = new char[f.hauteur()+2][f.largeur()+2];
        Films.effacer(framedScreen);
        char[][] frame = e.getFrame();
        /**for (int i = 0; i < framedScreen.length; ++i) {
            framedScreen[0][i] = '*'; // ligne horizontale du haut
            System.out.println(Films.toString(framedScreen));
            framedScreen[i][0] = '*'; // ligne vertical gauche
            framedScreen[i][(f.largeur()+1) - 1] = '*'; //ligne vertical droite
            framedScreen[(f.hauteur()+2) - 1][i] = '*'; // ligne horizontale du bas
        }
        System.out.println(Films.toString(framedScreen));
        for (int i = 2; i < framedScreen.length; ++i) {
            for(int j = 2; j< framedScreen[0].length; ++j){
                framedScreen[i][j] = frame[i][j];
            }
        }*/
        for (int i = 0; i < framedScreen.length; i++) {
            framedScreen[i][0] = '*';
            framedScreen[i][framedScreen.length-1] = '*';
            for (int j = 0; j < framedScreen[0].length; j++) {
                framedScreen[0][j] = '*';
                if(!(i > 9 || j >9))
                    framedScreen[i+1][j+1] = frame[i][j];
                framedScreen[(f.hauteur()+2) - 1][j]= '*';
            }
        }
        return new Frame(framedScreen);
    }

    public static Film frameAMovie(Film f){
        Movie temp = (Movie)f;
        ListIterator<Frame> frames = temp.listIterator();
        while(frames.hasNext()){
           Frame framesTemp =  frames.next();
           frames.set(getFrame(temp,framesTemp));
        }
        return temp;
    }
}
