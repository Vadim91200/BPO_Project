import java.util.Scanner;
public class FonctionsJoueur {
    public static boolean fini(Joueur j,Joueur j2) {
    	if(j.getTour()%2==0)
    		return perdu(j) || gagne(j);
    	else {
    		return perdu(j2) || gagne(j2);
    	}
    }

    public static boolean perdu(Joueur j) {
    	int c=0,k=0;
    	if(j.getMain().size()<2) {
    		return true;
    	}
    	else{
    		for(int i=0;i<j.getMain().size();i++) {
    		if(j.getMain().get(i)< j.getAscendant()) {
    			c++;
    		}
    		else if(j.getMain().get(i)>j.getDescendant()) {
    			k++;
    		}
    	}
    	if(c==j.getMain().size() || k==j.getMain().size()) {
    		return true;
    	}
    }
		return false;
}

    public static boolean gagne(Joueur j) {
    	 if (perdu(j))
             return false;
         if (j.getMain().size()>0)
             return false;
         return true;
    }

    public static void jouer(Joueur j1, Joueur j2) {
        if (fini(j1,j2)) {
            if (j1.getTour()%2==0) {
                 System.out.println("partie finie, SUD a gagne");
            } else {
                System.out.println("partie finie, NORD a gagne");
            }
        } else {
            int c=0, g=0;
            boolean isValid = true;
            String x = "";
            do {
                System.out.print("> ");
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                Scanner k = new Scanner(s);
                while (k.hasNext()) {
                    g=1;
                    x = k.next();
                    if(!k.hasNext()&& c==0){
                        isValid = false;
                    }
                    if (EstValide(x, j1,j2) == true && isValid == true) {
                        Ajouter(x, j1, j2);
                        c++;
                    }else{
                        g++;
                        c=0;
                    }
                }
                if (g==1){
                    Remplissage(j1, s, c);
                    g=0;
                    break;
                }
                System.out.print("#");
                g=0;
                isValid = true;
                }while (true);
            j1.ChangementTour();
        }
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

        } else {
            j1.remplirMain(2);
            System.out.println(c + " cartes posées, 2 cartes piochées ");
        }
    }
    public static boolean EstValide(String s, Joueur j, Joueur j2) {
        if (s.length()<3){
            return false;
        }
        boolean isValid = true;
        String NB = s.substring(0, 2);
        try{ Integer.parseInt(NB); }
        catch(NumberFormatException nfe){ isValid = false; }
        if (isValid){
            if(!j.getMain().contains(Integer.parseInt(NB))){
                return false;
            }
            String Crochet = s.substring(2,3);
            if(Crochet.equals("v") || Crochet.equals("^")){
                if (s.contains("'")) {
                    String Apostrophe = s.substring(3, 4);
                    if (Apostrophe.equals("'")){
                        return (EstPosable(s,j,j2, NB));
                    }else return false;
                }else return true;
            }else return false;

        }return false;
    }
    private static boolean EstPosable(String s, Joueur j, Joueur j2, String NB) {
        if (s.contains("'")){
            if (s.contains("^")) {
                return (Integer.parseInt(NB)<j2.getAscendant());
            }else{

                return (Integer.parseInt(NB)>j2.getDescendant());
            }
        }else if (s.contains("^")){
            return (Integer.parseInt(NB)>j.getAscendant() || (j.getAscendant() - Integer.parseInt(NB)) == 10);
        }else if (s.contains("v")){
            return (Integer.parseInt(NB)<j.getDescendant() || (Integer.parseInt(NB)-j.getDescendant()) == 10);
        }
        return false;
    }
    public static void Ajouter(String s, Joueur j1, Joueur j2) {
        assert(EstValide(s,j1,j2));
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