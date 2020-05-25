package exercices;

import static org.junit.Assert.assertNotNull;

import editing.Editing;
import film.Film;

public class Exercice {
	/*
	 * Dans chacune des 5 m�thodes suivantes, une instruction doit �tre
	 * modifi�e. Elles correspondent aux 5 op�rations �l�mentaires du sujet.
	 * 
	 * Vous pouvez compl�ter les m�thodes dans l'ordre que vous voulez. Vous
	 * pouvez ex�cuter les tests m�me si vous n'avez pas encore compl�t� toutes
	 * les m�thodes.
	 * 
	 */
	public static Film collage(Film f, Film g) {
		if (f == null || g == null)
			return null;
		// - Vous devez retourner le film correspondant au collage de g � la suite
		// de f.
		// - La taille des images du film r�sultant doit �tre suffisamment grande
		// pour contenir aussi bien celles de f que celles de g.
		Film c = Editing.paste(f,g); // � modifier
		
		assertNotNull("Vous devez compl�ter la m�thode Exercice.collage", c);
		return c;
	}

	public static Film extrait(Film g, int d, int f) {
		if (g == null)
			return null;
		// - Vous devez retourner le film correspondant � l'extrait du film g,
		// c'est � dire incluant toutes les images de g portant les num�ros
		// compris entre d et f (inclues). La premi�re image porte le num�ro 0.
		// - Seules les images portant des num�ros l�gaux compris entre d et f
		// sont � consid�rer (les num�ros inf�rieurs � z�ro ou
		// sup�rieurs au nombre d'images de g doivent �tre ignor�s).
		// - Si aucun des num�ros compris entre d et f n'est l�gal, vous devez
		// retourner un film vide (mais dont la taille d'image est la m�me que
		// celle de g).
		Film e = Editing.trailer(g,d,f); // � modifier
		
		assertNotNull("Vous devez compl�ter la m�thode Exercice.extrait", e);
		return e;
	}

	public static Film cadre(Film f) {
		if (f == null)
			return null;
		// - Vous devez retourner le film o� chaque image de f est encadr�e par
		// des caract�res '*'.
		Film c = Editing.frameAMovie(f); // � modifier
		
		assertNotNull("Vous devez compl�ter la m�thode Exercice.cadre", c);
		return c;
	}

	public static Film cycle(Film f, int n) {
		if (f == null)
			return null;
		// - Vous devez retourner le film o� f est r�p�t� n fois.
		// - Si n est inf�rieur ou �gal � z�ro, vous retournerez un film vide
		// (mais dont la taille d'image est la m�me que celle de f).
		Film c = Editing.repeat(f,n); // � modifier

		assertNotNull("Vous devez compl�ter la m�thode Exercice.cycle", c);
		return c;
	}

	public static Film incrustation(Film f, Film g, int li, int co) {
		if (f == null || g == null)
			return null;
		// - Vous devez retourner le film o� les images de g sont incrust�es
		// dans celles de f � la position (li, co).
		// - Si g est compos� de plus d'images que f, les images en trop sont
		// ignor�es.
		// - Si f est compos� de plus d'images que f, les derni�res images de f
		// ne comportent pas d'incrustation.
		// - Si la taille des images de g est trop grande par rapport � la
		// taille des images de f, tout ce qui d�passe est tronqu�.
		// Si li (ou co) est n�gatif, sa valeur est remplac�e par z�ro.
		Film i = Editing.inlay(f, g, li, co); // � modifier
		
		assertNotNull("Vous devez compl�ter la m�thode Exercice.incrustation", i);
		return i;
	}
	
	private Exercice() {}
}
