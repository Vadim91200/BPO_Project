package appli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Joueur {
    public static final int nbCarteMain = 6;
    private Stack<Integer> ascendant = new Stack<Integer>();
    private int ascendantTemporaire;
    private int descendantTemporaire;
    private Stack<Integer> descendant = new Stack<Integer>();
    private ArrayList<Integer> main = new ArrayList<>();
    private Pioche pcarte = new Pioche();


    public Joueur() {
        ascendant.push(pcarte.getElement().get(0));
        pcarte.getElement().remove(0);
        ascendantTemporaire =1;
        descendant.push(pcarte.getElement().get(58));
        pcarte.getElement().remove(58);
        descendantTemporaire = 60;
        remplirMain(nbCarteMain);
    }
    public int getAscendantTemporaire() {
        return ascendantTemporaire;
    }

    public void setAscendantTemporaire(int ascendantTemporaire) {
        this.ascendantTemporaire = ascendantTemporaire;
    }

    public void setDescendantTemporaire(int descendantTemporaire) {
        this.descendantTemporaire = descendantTemporaire;
    }

    public int getDescendantTemporaire() {
        return descendantTemporaire;
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

    public Stack<Integer> PileAscendante() {
        return ascendant;
    }

    public Stack<Integer> PileDescendante() {
        return descendant;
    }

    public ArrayList<Integer> getMain() {
        return main;
    }

    public void remplirMain(int l) {
        for (int i = 0; i < l; i++) {
            main.add(pcarte.tirage());
        }
        Collections.sort(main);
    }

}
