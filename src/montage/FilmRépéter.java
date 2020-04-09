package montage;

import film.Film;
import film.Films;

@SuppressWarnings("SpellCheckingInspection")
public class FilmRépéter implements Film  {

    private static int nbRepetitions;
    private Film f;

    /**
     * Initialise un film à répéter
     *
     * @param f Film à répéter
     * @param nbRep nombre de répétitions du film
     */
    public FilmRépéter(Film f, int nbRep){
        nbRepetitions = nbRep;
        this.f = f;
    }

    /**
     * Indique le nombre de répétitions
     *
     * @return nombres de répétitions
     */
    public static int nbRep(){
        return nbRepetitions;
    }

    @Override
    public int hauteur() {
        return this.f.hauteur();
    }

    @Override
    public int largeur() {
        return this.f.largeur();
    }

    @Override
    public boolean suivante(char[][] écran) {
       return f.suivante(écran);
    }

    @Override
    public void rembobiner() {
        suivante(Films.getEcran(f));
    }






}
