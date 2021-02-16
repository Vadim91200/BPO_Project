package appli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Joueur {
    public static final int nbCarteMain = 6;
    private Stack<Integer> ascendant = new Stack<Integer>();
    private Stack<Integer> descendant = new Stack<Integer>();
    private ArrayList<Integer> main = new ArrayList<>();
    private Pioche pcarte = new Pioche();
    private static int Tour;

    public Joueur(){
        ascendant.push(pcarte.getElement().get(0));
        pcarte.getElement().remove(0);
        descendant.push(pcarte.getElement().get(58));
        pcarte.getElement().remove(58);
        remplirMain(nbCarteMain);
        Tour = 0;
    }
    public Pioche getPcarte() {
        return pcarte;
    }
    public Integer getAscendant() {
        return ascendant.peek();
    }
    public Integer getDescendant() {
        return descendant.peek();
    }
    public Stack<Integer> PileAscendante(){
        return ascendant;
    }
    public Stack<Integer> PileDescendante() {
        return descendant;
    }

    public ArrayList<Integer> getMain() {
        return main;
    }
    public void remplirMain(int l){
        for(int i = 0; i<l; i++ ){
            main.add(pcarte.tirage());
        }
        Collections.sort(main);
    }
    public int getTour(){ return Tour;}
    public void ChangementTour(){ Tour++;}
}

