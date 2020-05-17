package editing;

import film.Film;
import java.util.List;
import java.util.ListIterator;

 class InlayFilm {
   static boolean first = true;

    private InlayFilm(){}

    /**
     * Renvoie un film incrusté dans un autre film à partir d'une position
     *
     * @param f1 Film de départ
     * @param f2 Film à incruster
     * @param row ligne d'incrustation
     * @param column colonne d'incrustation
     * @return un film incrusté
     */
    public static Film inlay(Film f1, Film f2, int row, int column){
        // Obtention d'un movie à partir d'un film
        Movie film1 = Movie.getMovie(f1);
        Movie film2 = Movie.getMovie(f2);
        // Obtient l'image où le film a incrusté va être incrusté
        int indexStartOfInlay = row / f1.hauteur();
        
        // le curseur de départ de l'incrustation
        ListIterator<Frame> iteratorOfTheInlay = film1.listIterator(indexStartOfInlay);
        // le curseur du film à être incrusté
        ListIterator<Frame> iteratorFromFilmToInlaid = film2.listIterator();

        List<Frame> frames = film1.getFrames();
        // incrustation du film
        inlayFilm(frames, iteratorOfTheInlay, iteratorFromFilmToInlaid, row, column);
        film1.setMovie(frames);

        return (Film) film1;
    }

    /**
     * Incruste un film dans un autre film
     *
     * @param frames liste d'images du film
     * @param it1 curseur du 1er film
     * @param it2 curseur du film à incruster
     * @param row ligne d'incrustation
     * @param column colone d'inscrustation
     */
    private static void inlayFilm(List frames, ListIterator<Frame> it1, ListIterator<Frame> it2, int row, int column) {
        while(it1.hasNext() && it2.hasNext()){
            Frame e = it1.next();
            Frame e2 = it2.next();
            // si première image à incrusté
            if(first) {
                frames.set(it1.previousIndex(), fill(e, e2, row - 1, column - 1));
                first = false;
            }
            else
                frames.set(it1.previousIndex(), fill(e, e2, 0,0));
        }
    }

    /**
     * Incruste une image dans une image de départ
     *
     * @param original l'image de départ à modifier
     * @param dest l'image à incruster
     * @param row ligne d'incrustation
     * @param column colonne d'incrustation
     * @return une image incrusté
     */
    private static Frame fill(Frame original, Frame dest, int row, int column ){
        char[][] frame = original.getFrame();
        char[][] frameToInlay = dest.getFrame();
        int k = 0; int l = 0;

        for(; row< frame.length; ++row){
            for(; column< frame[0].length; ++column){
                if(!(row > frameToInlay.length && column > frameToInlay[0].length)){
                    frame[row][column] = frameToInlay[k][l];
                    ++l;
                }
            }
            column = 0; l = 0;
            ++k;
        }
        return new Frame(frame);
    }
}
