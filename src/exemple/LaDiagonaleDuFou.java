package exemple;

import java.io.FileNotFoundException;
import java.io.IOException;

import film.Film;
import film.Films;
import montage.Répéter;
import montage.NewFilm;
import montage.Répéter;


/**
 * Un exemple basique d'implémentation de l'interface Film.
 */
public class LaDiagonaleDuFou implements Film {
	private int num = 0;
	private static final int NB_IMAGES = 20;

	@Override
	public int hauteur() {
		return 10;
	}

	@Override
	public int largeur() {
		return hauteur(); // ce sera un carré
	}

	@Override
	public boolean suivante(char[][] écran) {
		if (num == NB_IMAGES)
			return false;
		écran[num % hauteur()][num % hauteur()] = 'a'; // un 'a' se balade sur
		// la diagonale
		++num;
		return true;
	}

	@Override
	public void rembobiner() {
		num = 0;
	}

	/**
	 * La projection (puis la sauvegarde) d'un tel film.
	 */
	public static void main(String[] args) throws FileNotFoundException {
//		Film film = new LaDiagonaleDuFou();
		Film f = new NewFilm();
		try{
			NewFilm.createFilm("./vidéothèque/decompte.txt");
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

		Films.projeter(f);
		f.rembobiner();
		/*try {
			Films.sauvegarder(film, "fou.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier 'fou.txt' n'a pas pu être créé.");
		}*

		/*Répéter.projeter(film,5);
		try{
			Répéter.sauvegarder(film,5,"fou.txt");
		}catch( FileNotFoundException e){
			System.err.println("Le fichier n'a pas pu être créé !");
		}*/


	}
}
