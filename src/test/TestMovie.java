package test;

import film.Film;
import film.Films;

public class TestMovie {
    private static int nbFrame = 0;

    public TestMovie() {}

    /**
     * Retourne une représentation d'un film en chaine de caractères
     *
     * @param f Le film
     * @return une chaine de caractères
     */
    public static String toString(Film f){
        StringBuilder sb = new StringBuilder("");
        char[][] display = Films.getEcran(f);
        while(f.suivante(display)){
            ++nbFrame;
            // ajout de chaque image dans le builder de la chaine  de caractères
            sb.append(Films.toString(display)+ "\n");
            Films.effacer(display);
        }
        f.rembobiner();
        return sb.toString();
    }

    public static int nbFrame(Film f, int expected) {
        int i = 0;
        char[][] frame = Films.getEcran(f);
        while (i <= expected && f.suivante(frame))
            ++i;
        f.rembobiner();
        return i;
    }

    public static int nbFrame(Film f) {
        int i = 0;
        char[][] frame = Films.getEcran(f);
        while (f.suivante(frame))
            ++i;
        f.rembobiner();
        return i;
    }


    /**
     * Obtient le nombre d'images du film représenter
     *
     * @return un entier
     */
    public static int getNbFrames(){
       return nbFrame;
    }
}
