package montage;

import film.Film;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static film.Films.effacer;


public class NewFilm implements Film {
    private String path;
    private static int height;
    private static int width;

    private static List<char[][]> frames = new ArrayList<char[][]>();
    private static int num = 0;

    public NewFilm() {
    }

    public static void createFilm(String path) throws IOException {
        int lineCount = (int) Files.lines(Paths.get(path)).count();
        Scanner data = new Scanner(new FileInputStream(path));
        String line = data.nextLine();
        width = Integer.parseInt(line.split(" ")[0]);
        height = Integer.parseInt(line.split(" ")[1]);
        char[][] film = new char[height][width];
        while (lineCount - 1 > 0) {
            int i = 0;
            effacer(film);
            String charSequence = "";
            while (!charSequence.startsWith("\\new") && data.hasNextLine()) {
                charSequence = data.nextLine();
                --lineCount;
                if (!charSequence.startsWith("\\new")) {
                    film[i] = charSequence.toCharArray();
                    ++i;
                }
            }
            frames.add(film);
        }
    }

    @Override
    public int hauteur() {
        return height;
    }

    @Override
    public int largeur() {
        return width;
    }

    @Override
    public boolean suivante(char[][] écran) {
        écran = frames.remove(0); // retourne une frame du film
       return !frames.isEmpty();
    }

    @Override
    public void rembobiner() {
        num = 0;
    }
}
