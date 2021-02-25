package appli;

import java.util.Random;

public class Application {
    public static void Afficher(Jeu theGame) {
        System.out.println("NORD ^["+String.format("%02d", theGame.getNORD().getAscendant()) +"] v[" +String.format("%02d", theGame.getNORD().getDescendant())+ "] (m"+theGame.getNORD().getMain().size()+"p"+theGame.getNORD().getPcarte().getElement().size()+")");
        System.out.println("SUD ^["+String.format("%02d", theGame.getSUD().getAscendant()) +"] v[" +String.format("%02d", theGame.getSUD().getDescendant())+ "] (m"+theGame.getSUD().getMain().size()+"p"+theGame.getSUD().getPcarte().getElement().size()+")");

        if(theGame.getTour()%2==0){
            System.out.print("cartes NORD { ");
            for(int i : theGame.getNORD().getMain()){
                System.out.print(String.format("%02d", i)+" ");
            }
            System.out.println("}");
        }else{
            System.out.print("cartes SUD { ");
            for(int i : theGame.getSUD().getMain()){
                System.out.print(String.format("%02d", i)+" ");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args){
        Jeu theGame = new Jeu();
        Afficher(theGame);
        while (!FonctionsJoueur.fini(theGame)) {
            FonctionsJoueur.jouer(theGame);
            Afficher(theGame);
        }
        if (theGame.joueurCourant() == theGame.getNORD()) {
            System.out.println("partie finie, SUD a gagne");
        } else {
            System.out.println("partie finie, NORD a gagne");
        }
    }
}
