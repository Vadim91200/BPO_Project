package appli;

import java.util.Scanner;
public class FonctionsJoueur {
    public static boolean fini(Joueur j) {
        return perdu(j) || gagne(j);
    }

    public static boolean perdu(Joueur j) {
        return j.getMain().size()<2;
    }

    public static boolean gagne(Joueur j) {
        if (perdu(j))
            return false;
        if (j.getMain().size()>0)
            return false;
        return true;
    }

    public static void jouer(Joueur j1, Joueur j2) {
        if (fini(j1)) {
            if (j1.getTour()%2==0) {
                 System.out.println("partie finie, SUD a gagne");
            } else {
                System.out.println("partie finie, NORD a gagne");
            }
        } else {
            int c=0, g=0;
            String x = "";
            do {
                System.out.print("> ");
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                Scanner k = new Scanner(s);
                while (k.hasNext()) {
                    x = k.next();
                    if (EstValide(x, j1)) {
                        Ajouter(x, j1, j2);
                        c++;
                    }else{
                        g++;
                    }
                }
                Remplissage(j1, s, c);
                if (g==0){
                    break;
                }
                System.out.print("#");
                }while (!EstValide(x,j1));
        }
        j1.ChangementTour();
    }
    private static void Remplissage(Joueur j1, String s, int c){
        if (j1.getPcarte().getElement().size()<6) {
            if (j1.getPcarte().getElement().size() == 0) {
                System.out.println(c + " cartes posées, 0 cartes piochées ");
            } else {
                System.out.println(c + " cartes posées, " + j1.getPcarte().getElement().size() + " cartes piochées ");
                j1.remplirMain(j1.getPcarte().getElement().size());
            }
        }
        else if (s.contains("'")) {
            int i = 0;
            while (j1.getMain().size() < 6) {
                j1.remplirMain(1);
                i++;
            }
            System.out.println(c + " cartes posées, " + i + " cartes piochées ");

        } else if (s.contains("^")) {
            j1.remplirMain(2);
            System.out.println(c + " cartes posées, 2 cartes piochées ");
        }
    }
    public static boolean EstValide(String s, Joueur j) {
        if (s.contains("'")){

        }else if (s.contains("^")){

        }else if (s.contains("v")){

        }
        return false;
    }
    public static void Ajouter(String s, Joueur j1, Joueur j2) {
        String k = s.substring(0, 2);
        if (s.contains("'")){
        	if (s.contains("^")){
                j2.PileAscendante().push(Integer.parseInt(k));
            }else{
                j2.PileDescendante().push(Integer.parseInt(k));
            }
            j1.getMain().remove((Integer) Integer.parseInt(k));
        }else if (s.contains("^")){
            j1.PileAscendante().push(Integer.parseInt(k));
            j1.getMain().remove((Integer) Integer.parseInt(k));
        }else if (s.contains("v")){
            j1.PileDescendante().push(Integer.parseInt(k));
            j1.getMain().remove((Integer) Integer.parseInt(k));
        }
    }
}
