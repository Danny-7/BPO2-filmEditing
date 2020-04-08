package montage;

import film.Film;
import film.Films;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Opération {

    private LinkedList<Film> films;
    private ArrayList<char[][]> ecran;

    /**
     * Créer un film monté avec n répétition du film
     *
     * @param f film entré
     * @param nbRepetition nombre de répétition du film
     * @return Une liste d'un film répété n fois
     * @throws InvalidClassException
     */
     public LinkedList<Film> repeter(Film f, int nbRepetition) throws InvalidClassException {
         if (!(f instanceof Film))
             throw new InvalidClassException("Le paramètre entré n'est pas un film ! ");
         films = new LinkedList<>();
         if (nbRepetition != 0) {
             for (int i = 0; i < nbRepetition; ++i) {
                 films.add(f);
             }
         } else
             films.add(f);

         return films;
     }

    /**
     * Créer le nombre d'écrans utiles
     *
     * @param f film entré
     * @return un tableau de plusieurs écrans
     */
     public ArrayList<char[][]> getEcran(Film f){
         ecran = new ArrayList<>();
         for(Film film: films)
             ecran.add(Films.getEcran(film));
         return ecran;
     }

    /**
     * Renvoie le film monté
     *
     * @return La chaine correspondante aux écrans
     */
    public String toString(){
         StringBuilder sb = new StringBuilder("");
         for(char[][] e: ecran){
             sb.append(Films.toString(e)+ System.lineSeparator());
         }
         return sb.toString();
    }

}
