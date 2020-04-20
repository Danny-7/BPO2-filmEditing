package montage;

import film.Film;
import film.Films;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


@SuppressWarnings("SpellCheckingInspection")
public class Répéter  {
    private Répéter(){}

    /**
     * Projète un film répété le nombres de fois voulu
     *
     * @param f Le film devant être projeté.
     * @param nbRep Le nombres de répétitions voulu
     */
    public static void projeter(Film f, int nbRep) {
        char[][] écran = Films.getEcran(f);
        for (int i = 0; i < nbRep; ++i) {
            while (f.suivante(écran)) {

                System.out.println(Films.toString(écran));
                Films.pause(1. / 12);
                Films.effacer(écran);
            }
            f.rembobiner();

        }
    }

    /**
     * Sauvegarder un film qui à été répété
     *
     * @param f Le film devant être sauvegardé
     * @param nbRep Le nombres de répétitions voulu
     * @param nom le nom du fichier où sauvegarder le film.
     * @throws FileNotFoundException
     */
    public static void sauvegarder(Film f,int nbRep, String nom) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(nom)) {
            char[][] écran = Films.getEcran(f);
            out.println(f.largeur() + " " + f.hauteur());
            for(int i = 0; i< nbRep; ++i){
                while (f.suivante(écran)) {
                    out.println(Films.toString(écran));
                    out.println("\\newframe");
                    Films.effacer(écran);
                }
                f.rembobiner();
            }
        }
    }



}
