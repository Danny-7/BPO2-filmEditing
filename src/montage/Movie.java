package montage;

import film.Film;
import film.Films;

import java.util.*;

public class Movie implements Film {
    private List<Frame> movie;
    private Film f;
    private static int num = 0;

    /**
     * Permet de créer un film structuré à partir d'un film existant
     *
     * @param f Le film qu'on veut structurer
     */
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

    /**
     * Permet de changer la liste de notre film
     *
     * @param list La liste qu'on veut set
     */
    public void setMovie(List<Frame> list){
        movie = list;
    }

    /**
     * Permet d'obtenir un itérateur de notre liste
     *
     * @return Un itérateur de movie
     */
    public ListIterator<Frame> listIterator(){
        return movie.listIterator();
    }

    /**
     * Permet de créer une image du film
     *
     * @param frame l'écran qui nous est donné
     * @return l'écran correspondant à l'image selectionnée
     */
    private char[][] createFrame(char[][] frame){
        char [][] temp =  movie.listIterator(num).next().getFrame();
        for(int i = 0; i< temp.length; ++i) {
            for (int j = 0; j < temp[0].length; ++j) {
                frame[i][j] = temp[i][j];
            }
        }
        return frame;
    }

    /**
     *  Vérifie s'il y'a encore une image disponible
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
        num =0;
    }

}

class Frame{
    private char[][] frame;

    /**
     * Permet de créer une image
     *
     * @param frameTemp écran donné
     */
    public Frame(char[][] frameTemp){
        frame = new char[frameTemp.length][frameTemp[0].length];
        // retourne une nouvelle image depuis un écran
        frame = Arrays.stream(frameTemp).map(char[]::clone).toArray(char[][]::new);
    }

    /**
     * Modifie l'image actuelle
     *
     * @param frameTemp
     */
    public void setFrame(char[][] frameTemp){
        this.frame = frameTemp;
    }

    /**
     * Retourne une image
     *
     * @return une image
     */
    public char[][] getFrame(){
        return this.frame;
    }

}




