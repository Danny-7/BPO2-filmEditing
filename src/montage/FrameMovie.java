package montage;

import film.Film;
import film.Films;
import java.util.ListIterator;

 class FrameMovie {
    private final static int SPC_STARS = 2; // espace pour encadrer le film

    private FrameMovie(){}

    /**
     * Remplit une image pour quelle soit encadrée
     *
     * @param f Le film où se trouve l'image
     * @param frame l'image originale
     * @param framedScreen l'image à remplir
     */
    private static void fillFrame(Film f, char[][] frame, char[][] framedScreen){
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
    }
    /**
     *  Permet d'obtenir une image encadré
     *
     * @param f Le film donné
     * @param e L'image à encadrer
     * @return une image encadrée
     */
    private static Frame getFrame(Film f, Frame e){
        char[][] framedScreen = new char[f.hauteur()+SPC_STARS][f.largeur()+SPC_STARS];
        Films.effacer(framedScreen);
        fillFrame(f, e.getFrame(),framedScreen);

        return new Frame(framedScreen);
    }

    /**
     * Permet d'obtenir un film encadré (chaque image est encadrée)
     *
     * @param f Film à encadrer
     * @return Le film encadré
     */
    public static Film frameAMovie(Film f){
        Movie temp = Movie.getMovie(f);
        ListIterator<Frame> frames = temp.listIterator();
        while(frames.hasNext()){
           Frame framesTemp =  frames.next();
           // modifie l'image actuelle par une image encadrée
           frames.set(getFrame(temp,framesTemp));
        }
        // on change la hauteur et la largeur du film
        temp.setHeight(f.hauteur() +SPC_STARS);
        temp.setWidth(f.hauteur()+SPC_STARS);
        return temp;
    }
}
