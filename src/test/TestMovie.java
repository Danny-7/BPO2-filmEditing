package test;

import film.Film;
import film.Films;

public class TestMovie {

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
            // ajout de chaque image dans le builder de la chaine  de caractères
            sb.append(Films.toString(display)+ "\n");
            Films.effacer(display);
        }
        f.rembobiner();
        return sb.toString();
    }

    /**
     * Retourne le nombre d'images attendu d'un film
     * @param f Le film
     * @param expected nombre d'images attendues
     * @return un int
     */
    public static int nbFrame(Film f, int expected) {
        int i = 0;
        char[][] frame = Films.getEcran(f);
        while (i <= expected && f.suivante(frame))
            ++i;
        f.rembobiner();
        return i;
    }

    /**
     * Retourne le nombre d'images d'un film
     * @param f Le film
     * @return nombre d'images
     */
    public static int nbFrame(Film f) {
        int i = 0;
        char[][] frame = Films.getEcran(f);
        while (f.suivante(frame))
            ++i;
        f.rembobiner();
        return i;
    }

}
