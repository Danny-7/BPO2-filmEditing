package montage;

import film.Film;
import film.Films;


@SuppressWarnings("SpellCheckingInspection")
public class Bibliothèque extends FilmRépéter {

    /**
     * Construit la bibliothèque pour monter un film
     *
     * @param f Le film à monté
     */
    public Bibliothèque(Film f){
        super(f,nbRep());
    }

    /**
     * Répète un film n fois donné
     *
     * @param f Le film à répéter
     * @return Retourne un film répété n fois
     */
    public Film répéter(Film f){
        int nbFois = nbRep();
        // Création d'un écran
        char[][] écran = Films.getEcran(f);

        int nb = 0;
        // On compte le nombre d'image du film
        while(f.suivante(écran)){
            nb++;
        }
        f.rembobiner();

        Film film = new FilmRépéter(f,nbFois*nb);

        for(int i = 0; i < nbFois; i++){
            while(f.suivante(écran)){
                // On obtient l'image suivante du nouveau film
                film.suivante(écran);
            }
            // rejoue le film nbfois donné
            f.rembobiner();
        }
        return film;
    }

}
