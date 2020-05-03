package montage;

import film.Film;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RepeatFilm {

    private RepeatFilm(){}

    /**
     * Permet de répéter n fois un film
     *
     * @param f Le film à répéter
     * @param nbRep le nombre de fois qu'on veut répéter le film
     * @return le film répété
     */
    public static Film repeatFilm(Film f, int nbRep){
        // Création d'un film
        Movie temp = new Movie(f);
        List<Frame> movieReapeated = new LinkedList<>();
        // Création d'un itérateur de notre film
        Iterator<Frame> originalMovie = temp.iterator();
        for(int i = 0; i< nbRep; ++i){
            while(originalMovie.hasNext()){
                movieReapeated.add(originalMovie.next());
            }
            originalMovie = temp.iterator();
        }
        // On switch de list pour notre film répété
        temp.setMovie(movieReapeated);
        return (Film) temp;
    }
}
