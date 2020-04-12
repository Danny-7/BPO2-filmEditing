package montage;

import film.Film;
import film.Films;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


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

    public void projeter(Film f){
        char[][] écran = Films.getEcran(f);
        for(int i = 0; i < nbRepetitions; ++i){
            while (suivante(écran)) {

                System.out.println(Films.toString(écran));
                Films.pause(1. / 12);
                Films.effacer(écran);
            }
            rembobiner();
        }
    }

    public void sauvegarder(Film f, String nom) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(nom)) {
            char[][] écran = Films.getEcran(f);
            out.println(largeur() + " " + hauteur());
            for(int i = 0; i< nbRepetitions; ++i){
                while (suivante(écran)) {
                    out.println(Films.toString(écran));
                    out.println("\\newframe");
                    Films.effacer(écran);
                }
                rembobiner();
            }

        }
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
        f.rembobiner();
    }


}
