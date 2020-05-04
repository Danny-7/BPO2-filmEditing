package montage;

import film.Film;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MovieTrailer {

    private MovieTrailer(){}

    public static Film trailer(Film f, int start, int end){
        Movie temp = new Movie(f);
        List<Frame> trailer = new LinkedList<>();
        if(end < start){
            temp.setMovie(trailer);
        }
        else{
            ListIterator<Frame> originalMovie = temp.listIterator(start);
            for(int i = start; i < end; ++i){
                trailer.add(originalMovie.next());
            }
        }
        temp.setMovie(trailer);
        return (Film) temp;
    }
}
