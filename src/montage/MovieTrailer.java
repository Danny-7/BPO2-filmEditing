package montage;

import film.Film;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MovieTrailer {

    private MovieTrailer(){}

    public Film trailer(Film f, int start, int end){
        Movie temp = new Movie(f);
        List<Frame> trailer = new LinkedList<>();
        if(end < start){
            temp.setMovie(trailer);
        }
        Iterator<Frame> originalMovie = temp.iterator()
        else{
            for(int  = start; )
        }
    }
}
