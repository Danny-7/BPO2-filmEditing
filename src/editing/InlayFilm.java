package editing;

import film.Film;
import java.util.List;
import java.util.ListIterator;

class InlayFilm {

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

        if(row < 0 && column < 0) {
            row = 0;
            column = 0;
        }

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
            frames.set(it1.previousIndex(), fill(e, e2, row,column));
        }
    }

    /**
     * Vérifie que la ligne ou la colonne ne dépasse pas du film à incruster
     * @param frame l'image du film
     * @param row la ligne d'incrustation
     * @param column la colonne d'incrustation
     * @return true or false
     */
    private static boolean checkFrame(char[][] frame, int row, int column){
        if(column > frame[0].length-1)
            return false;
        if(row > frame.length -1)
            return false;

        return true;
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
        int tempCol = column;

        for(; row< frame.length; ++row){
            for(; column< frame[0].length; ++column){
                if(checkFrame(frameToInlay, k, l)){
                    frame[row][column] = frameToInlay[k][l];
                    ++l;
                }
            }
            column = tempCol; l = 0;
            ++k;
        }
        return new Frame(frame);
    }
}
