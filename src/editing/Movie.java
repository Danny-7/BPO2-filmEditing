package editing;

import film.Film;
import film.Films;

import java.util.*;

public class Movie implements Film {
    private int num;
    private List<Frame> movie;
    private int height;
    private int width;

    /**
     * Permet de créer un film structuré à partir d'un film existant
     *
     * @param f Le film qu'on veut structurer
     */
    public Movie(Film f){
        this.height = f.hauteur();
        this.width = f.largeur();
        this.num = 0;
        movie = new LinkedList<>();
        char[][] écran = Films.getEcran(f);
        while(f.suivante(écran)) {
            movie.add(new Frame(écran));
            Films.effacer(écran);
        }
        f.rembobiner();
    }

    /**
     * Renvoie un nouvel objet copié profondément
     *
     * @param film  Film à copié
     * @return Le film avec nouvelle référence
     */
    static Movie getMovie(Film film){
        return new Movie(film);
    }

    @Override
    public int hauteur() {
        return this.height;
    }

    @Override
    public int largeur() {
        return this.width;
    }

    /**
     * Permet de modifier la hauteur de notre film dans le paquetage montage
     *
     * @param height la nouvelle hauteur du film
     */
    void setHeight(int height){
        this.height = height;
    }

    /**
     * Permet de modifier la largeur de notre film dans le paquetage montage
     *
     * @param width la nouvelle largeur du film
     */
    void setWidth(int width){
        this.width = width;
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
     * Permet d'obtenir un itérateur commençant à la position donnée
     *
     * @param index position de départ
     * @return un itérateur de movie à une position
     */
    public ListIterator<Frame> listIterator(int index){
        return movie.listIterator(index);
    }

    /**
     * Permet d'obtenir la liste du film
     *
     * @return liste de frame
     */
    List<Frame> getFrames(){
        return movie;
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
                //si l'écran passé en paramètre est vide à cette position
                if(frame[i][j] == ' ')
                    frame[i][j] = temp[i][j];
            }
        }
        return frame;
    }

    /**
     * Vérifie s'il y'a encore une image disponible
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
     * @param frameTemp le tableau 2D à affecter
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