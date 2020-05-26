package test.resources;

import film.Film;

public class ShortFilm implements Film {
    private char content;
    private int nbFrame;
    private int height;
    private int width;
    private static int num = 0;

    public ShortFilm(char content, int nbFrame){
        this.content = content;
        this.nbFrame = nbFrame;
        this.height = 4;
        this.width = 5;
    }

    public ShortFilm(char content, int nbFrame, int height, int width){
        this(content, nbFrame);
        this.height = height;
        this.width = width;
    }

    @Override
    public int hauteur() {
        return this.height;
    }

    @Override
    public int largeur() {
        return this.width;
    }

    @Override
    public boolean suivante(char[][] écran) {
        char c = content;
        if(num == nbFrame)
            return false;
        for(int i = 0; i< hauteur(); ++i){
            for (int j = 0; j < largeur(); ++j){
                écran[i][j] = c;
            }
            ++c;
        }
        ++num;
        return true;
    }

    @Override
    public void rembobiner() {
        num = 0;
    }

}
