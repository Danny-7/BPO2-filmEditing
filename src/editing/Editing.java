package editing;

import film.Film;

public class Editing {

    private Editing(){}

    public static Film repeat(Film f, int nbrep){ return RepeatFilm.repeatFilm(f, nbrep); }

    public static Film frameAMovie(Film f){
        return MovieFramed.frameAMovie(f);
    }

    public static Film trailer(Film f, int start, int end){
        return MovieTrailer.trailer(f, start, end);
    }

    public static Film paste(Film f, Film f2){
        return PasteTwoFilm.paste(f, f2);
    }

    public static Film inlay(Film f, Film f2, int row, int column){
        return InlayFilm.inlay(f, f2, row, column);
    }
}
