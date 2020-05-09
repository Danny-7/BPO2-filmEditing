package montage;

import film.Film;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class MovieTrailer {

    private MovieTrailer(){}

    /**
     * Permet d'ajouter dans une liste des élements à partir d'une position de début et de fin
     *
     * @param list la liste où l'on doit ajouter des éléments
     * @param it itérateur des élements présent dans une liste
     * @param start position de départ
     * @param end position de fin
     */
    private static void addToListByPos(List list, ListIterator it, int start, int end){
        for(; start < end; ++start){
            list.add(it.next());
        }
    }

    /**
     * Permet d'obtenir un extrait d'un film à une position donnée
     *
     * @param f le film donné
     * @param start la position de départ
     * @param end la position de fin
     * @return Un extrait d'un film
     */
    public static Film trailer(Film f, int start, int end){
        Movie temp = Movie.getMovie(f);
        List<Frame> trailer = new LinkedList<>();
        // si la position de fin est inférieur à la position de départ on retourne un film vide
        if(end < start){
            temp.setMovie(trailer);
        }
        else{
            ListIterator<Frame> originalMovie = temp.listIterator(start);
            addToListByPos(trailer, originalMovie, start, end );
        }
        temp.setMovie(trailer);
        return (Film) temp;
    }
}
