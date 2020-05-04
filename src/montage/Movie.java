package montage;

import film.Film;
import film.Films;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Movie implements Film {
    private List<Frame> movie;
    private Film f;
    private static int num = 0;

    public Movie(Film f){
        this.f = f;
        movie = new LinkedList<>();
        char[][] écran = Films.getEcran(f);
        while(f.suivante(écran)) {
            movie.add(new Frame(écran));
            Films.effacer(écran);
        }
        f.rembobiner();
    }

    @Override
    public int hauteur() {
       return f.hauteur();
    }

    @Override
    public int largeur() {
        return f.largeur();
    }

    public void setMovie(List<Frame> list){
        movie = list;
    }

    /**
     * Permet d'obtenir un itérateur de notre liste
     *
     * @return Un itérateur de movie
     */
    public Iterator<Frame> iterator(){
        return movie.iterator();
    }

    private char[][] createFrame(char[][] frame){
        char [][] temp =  movie.get(num).getFrame();
        for(int i = 0; i< temp.length; ++i) {
            for (int j = 0; j < temp[0].length; ++j) {
                frame[i][j] = temp[i][j];
            }
        }
        return frame;
    }

    /**
     *
     * @param écran
     *            L'écran où afficher l'image
     * @return Vrai si 'image suivante a été affiché sinon faux
     */
    @Override
    public boolean suivante(char[][] écran) {
        if(num == movie.size())
            return false;
        else{
            écran = createFrame(écran);
            ++num;
        }
        return true;
    }

    @Override
    public void rembobiner() {
        f.rembobiner();
    }

}

class Frame{
    private char[][] frame;

    public Frame(char[][] frameTemp){
        frame = new char[frameTemp.length][frameTemp[0].length];
        frame = Arrays.stream(frameTemp).map(char[]::clone).toArray(char[][]::new);
    }

    /**
     * Modifie l'image actuelle du film
     * @param frameTemp
     */
    public void setFrame(char[][] frameTemp){
        this.frame = frameTemp;
    }

    /**
     * Retourne une image
     * @return
     */
    public char[][] getFrame(){
        return this.frame;
    }

}




