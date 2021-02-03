package appli;

import java.util.Random;

public class Application {
    public static void Afficher(Joueur NORD, Joueur SUD, boolean TOUR) {
        System.out.println("NORD ^"+NORD.ascendant +" v" +NORD.descendant+ " (m"+NORD.main.size()+"p"+NORD.Pioche+")");
        System.out.println("SUD ^"+SUD.ascendant +" v" +SUD.descendant+ " (m"+SUD.main.size()+"p"+SUD.Pioche+")");
        if(TOUR == true){
            System.out.print("cartes NORD { ");
            for(int i : NORD.main){
                System.out.print(i+" ");
            }
            System.out.println("}");
        }else{
            System.out.print("cartes SUD { ");
            for(int i : SUD.main){
                System.out.print(i+" ");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args){
        Joueur NORD = new Joueur();
        Joueur SUD = new Joueur();
        boolean TOUR= true, fini = false;
        FonctionsJoueur.Initialiser(NORD);
        FonctionsJoueur.Initialiser(SUD);
        Afficher(NORD, SUD, TOUR);
        while (!FonctionsJoueur.fini(TOUR, NORD, SUD)) {
            TOUR = FonctionsJoueur.jouer(TOUR, NORD, SUD);
            Afficher(NORD, SUD, TOUR);
        }
    }
}
