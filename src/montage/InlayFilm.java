package montage;

import film.Film;

import java.util.ListIterator;

public class InlayFilm {

    private InlayFilm(){}

    public static Film insert(Film f1, Film f2, int row, int column){
        Movie editFilm = Movie.getMovie(f1);
        Movie film1 = Movie.getMovie(f1);
        Movie film2 = Movie.getMovie(f2);

        int indexStartOfInlay = row / f1.hauteur();

        ListIterator<Frame> iteratorOfTheInlay = film1.listIterator(indexStartOfInlay);
        ListIterator<Frame> iteratorFromFilmToInlaid = film2.listIterator();

        while(iteratorOfTheInlay.hasNext()){
            insertFilm(iteratorOfTheInlay, iteratorFromFilmToInlaid, row, column);
        }


        return null;
    }

    private static void insertFilm(ListIterator<Frame> it1, ListIterator<Frame> it2, int row, int column) {

    }
}
