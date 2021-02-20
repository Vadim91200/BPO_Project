

import java.util.Random;

public class Application {
    public static void Afficher(Joueur NORD, Joueur SUD) {
        System.out.println("NORD ^["+String.format("%02d", NORD.getAscendant()) +"] v[" +String.format("%02d",NORD.getDescendant())+ "] (m"+NORD.getMain().size()+"p"+NORD.getPcarte().getElement().size()+")");
        System.out.println("SUD ^["+String.format("%02d", SUD.getAscendant()) +"] v[" +String.format("%02d",SUD.getDescendant())+ "] (m"+SUD.getMain().size()+"p"+SUD.getPcarte().getElement().size()+")");
        if(NORD.getTour()%2==0){
            System.out.print("cartes NORD { ");
            for(int i : NORD.getMain()){
                System.out.print(String.format("%02d", i)+" ");
            }
            System.out.println("}");
        }else{
            System.out.print("cartes SUD { ");
            for(int i : SUD.getMain()){
                System.out.print(String.format("%02d", i)+" ");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args){
        Joueur NORD = new Joueur();
        Joueur SUD = new Joueur();
        Afficher(NORD, SUD);
        while (!FonctionsJoueur.fini(NORD,SUD)) {
            if(NORD.getTour()%2==0){
                FonctionsJoueur.jouer(NORD, SUD);
            }else {
                FonctionsJoueur.jouer(SUD, NORD);
            }
            Afficher(NORD, SUD);
        }
    }
}