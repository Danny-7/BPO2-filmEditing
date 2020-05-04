package montage;

import film.Film;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PasteTwoFilm {

    private PasteTwoFilm(){}

    /**
     * Permet d'obtenir la hauteur maximal entre un film et un autre
     * @param f1 1er film
     * @param f2 2ème film
     * @return la hauteur maximal
     */
    private static int getMaxHeight(Film f1, Film f2){
        return f1.hauteur() > f2.hauteur()? f1.hauteur(): f2.hauteur();
    }

    /**
     * Permet d'obtenir la largeur maximal entre un film et un autre
     * @param f1 1er film
     * @param f2 2ème film
     * @return la largeur maximal
     */
    private static int getMaxWidth(Film f1, Film f2){
        return f1.largeur() > f2.largeur()? f1.largeur(): f2.largeur();
    }

    /**
     * Permet d'obtenir un film à partir de deux films mis en séquences l'un à la suite de l'autre
     * @param f1 1er film
     * @param f2 2ème film
     * @return Un nouveau film
     */
    public static Film paste(Film f1, Film f2){
        Movie pasteFilm = new Movie(f1);
        Movie film1 = (Movie) f1;
        Movie film2 = (Movie) f2;

        pasteFilm.setHeight(getMaxHeight(f1, f2));
        pasteFilm.setWidth(getMaxWidth(f1, f2));

        List<Frame> temp = new LinkedList<>();

        ListIterator<Frame> it1 = film1.listIterator();
        ListIterator<Frame> it2 = film2.listIterator();

        while(it1.hasNext()){
            temp.add(it1.next());
        }
        while(it2.hasNext()){
            temp.add(it2.next());
        }
        pasteFilm.setMovie(temp);
        return (Film)pasteFilm;
    }
}
