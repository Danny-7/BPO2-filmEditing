package test;

import film.Film;
import film.Films;

public class TestMovie {
    private static int nbFrame = 0;

    public TestMovie() {
    }

    public static String toString(Film f){
        StringBuilder sb = new StringBuilder("");
        char[][] display = new char[f.hauteur()][f.largeur()];
        while(f.suivante(display)){
            ++nbFrame;
            sb.append(Films.toString(display)+ "\n");
        }
        return sb.toString();
    }

    public static int getNbFrames(){
       return nbFrame;
    }
}
