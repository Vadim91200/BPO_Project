package appli;

import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
public class FonctionsJoueur {
    public static void Initialiser(Joueur Entré) {
        Entré.Pioche = 52;
        Entré.ascendant.push(01);
        Entré.descendant.push(60);
        for(int n=0; n<6; n++){
            Random r = new Random();
            Entré.main.add(r.nextInt(52));
        }
        Collections.sort(Entré.main);
    }
    public static boolean fini(boolean b, Joueur j1, Joueur j2 ) {
        if(b){
            return perdu(j1) || gagne(j1);
        }
        else{
            return perdu(j2) || gagne(j2);
        }
    }

    public static boolean perdu(Joueur j) {
        return j.main.size()<2;
    }

    public static boolean gagne(Joueur j) {
        if (perdu(j))
            return false;
        if (j.main.size()>0)
            return false;
        return true;
    }

    public static boolean jouer(boolean b, Joueur j1, Joueur j2) {
        if (fini(b, j1, j2)) {
            if (b = true) {
                 System.out.println("partie finie, SUD a gagne");
                 return b;
            } else {
                System.out.println("partie finie, NORD a gagne");
                return b;
            }
        } else {
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println(s);
            Scanner k = new Scanner(s);
            while(k.hasNext()) {
                String x = k.next();
                if(EstValide(x)){

                }

            }
            j1.main.remove(0);
        }
        return b = !b;
    }
    public static boolean EstValide(String s) {
        boolean b =true;
        return b;
    }
    public static void Ajouter(String s) {
        if (s.contains("'")){

        }else if (s.contains("^")){

        }else if (s.contains("v")){

        }
    }
}
