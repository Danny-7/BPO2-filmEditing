package montage;

import film.Film;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class InlayFilm {

    private InlayFilm(){}

    public static Film insert(Film f1, Film f2, int row, int column){
        //Movie editFilm = Movie.getMovie(f1);
        Movie film1 = Movie.getMovie(f1);
        Movie film2 = Movie.getMovie(f2);

        int indexStartOfInlay = row / f1.hauteur();

        ListIterator<Frame> iteratorOfTheInlay = film1.listIterator(indexStartOfInlay);
        ListIterator<Frame> iteratorFromFilmToInlaid = film2.listIterator();

        List<Frame> frames = film1.getMovie();

        while(iteratorOfTheInlay.hasNext()){
            insertFilm(frames, iteratorOfTheInlay, iteratorFromFilmToInlaid, indexStartOfInlay, column);
        }
        film1.setMovie(frames);
        return (Film) film1;
    }


    private static void insertFilm(List frames, ListIterator<Frame> it1, ListIterator<Frame> it2, int row, int column) {
        while(it1.hasNext() && it2.hasNext()){
            Frame e = it1.next();
            Frame e2 = it2.next();
            frames.set(it1.previousIndex(), (fill(e, e2, row, column)));
        }
    }

    private static Frame fill(Frame original, Frame dest, int row, int column ){
        char[][] frame = original.getFrame();
        char[][] frameToInlay = dest.getFrame();
        int k = 0; int l = 0;
        int i = row - 1; //impossible
        int j = column-1; // impossible
        for(; i< frame.length; ++i){
            for(; j< frame[0].length; ++j){
                if(!(i > frameToInlay.length && j > frameToInlay[0].length)){
                    frame[i][j] = frameToInlay[k][l];
                    ++l;
                }
            }
            j = 0; l = 0;
            ++k;
        }
        return new Frame(frame);
    }
}
