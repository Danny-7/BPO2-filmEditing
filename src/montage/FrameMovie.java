package montage;

import film.Film;
import film.Films;

import java.util.List;
import java.util.ListIterator;

public class FrameMovie {
    private final static int SPC_STARS = 2;
    private FrameMovie(){}

    /**
     *  Permet d'obtenir une image encadré
     *
     * @param f Le film donné
     * @param e L'image à encadré
     * @return une image encadré
     */
    private static Frame getFrame(Film f, Frame e){
        char[][] framedScreen = new char[f.hauteur()+SPC_STARS][f.largeur()+SPC_STARS];
        Films.effacer(framedScreen);
        char[][] frame = e.getFrame();
        int height = f.hauteur();
        int width = f.largeur();

        for (int i = 0; i < framedScreen.length; i++) {
            framedScreen[i][0] = '*'; // ligne vertical gauche
            framedScreen[i][framedScreen.length-1] = '*'; // ligne vertical droite
            for (int j = 0; j < framedScreen[0].length; j++) {
                framedScreen[0][j] = '*';   // ligne horizontale haut
                if(!(j >= width || i >= height))
                    framedScreen[i+1][j+1] = frame[i][j];
                framedScreen[framedScreen.length - 1][j]= '*'; // ligne horizontale bas
            }
        }
        return new Frame(framedScreen);
    }

    /**
     * Permet d'obtenir un film encadré (chque image est encadré)
     *
     * @param f Film à encadré
     * @return Le film encadré
     */
    public static Film frameAMovie(Film f){
        Movie temp = (Movie)f;
        ListIterator<Frame> frames = temp.listIterator();
        while(frames.hasNext()){
           Frame framesTemp =  frames.next();
           // modifie l'image actuelle par une image encadré
           frames.set(getFrame(temp,framesTemp));
        }
        temp.setHeight(f.hauteur() +SPC_STARS);
        temp.setWidth(f.hauteur()+SPC_STARS);
        return temp;
    }
}
