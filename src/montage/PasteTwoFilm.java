package montage;

import film.Film;

import java.util.List;
import java.util.ListIterator;

 class PasteTwoFilm {

    private PasteTwoFilm(){}

    /**
     * Permet d'obtenir la hauteur maximale entre un film et un autre
     *
     * @param f1 1er film
     * @param f2 2ème film
     * @return la hauteur maximale
     */
    private static int getMaxHeight(Film f1, Film f2){
        return Math.max(f1.hauteur(), f2.hauteur());
    }

    /**
     * Permet d'obtenir la largeur maximale entre un film et un autre
     *
     * @param f1 1er film
     * @param f2 2ème film
     * @return la largeur maximale
     */
    private static int getMaxWidth(Film f1, Film f2){
        return Math.max(f1.largeur(), f2.largeur());
    }

    /**
     * Ajoute des images dans une liste
     *
     * @param it itérateur de la liste source
     * @param list liste destinatrice
     */
    private static void addToList(ListIterator it, List list){
        while(it.hasNext()){
            list.add(it.next());
        }
    }

    /**
     * Permet d'obtenir un film à partir de deux films mis en séquences l'un à la suite de l'autre
     *
     * @param f1 1er film
     * @param f2 2ème film
     * @return Un nouveau film
     */
    public static Film paste(Film f1, Film f2) {
        Movie film1 = Movie.getMovie(f1);
        Movie film2 = Movie.getMovie(f2);

        film1.setHeight(getMaxHeight(f1, f2));
        film1.setWidth(getMaxWidth(f1, f2));

        List<Frame> temp = film1.getFrames();

        // curseur du deuxième film à coller
        ListIterator<Frame> it2 = film2.listIterator();

        addToList(it2, temp);

        return (Film) film1;
    }
}
