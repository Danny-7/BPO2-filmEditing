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
        }
        return sb.toString();
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
