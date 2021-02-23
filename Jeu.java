package appli;

public class Jeu {
    private Joueur NORD = new Joueur();
    private Joueur SUD = new Joueur();
    private static int Tour;
    public Jeu() {
        Tour = 0;
    }
    public int getTour() {
        return Tour;
    }

    public Joueur getNORD() {
        return NORD;
    }

    public Joueur getSUD() {
        return SUD;
    }

    public void changementTour() {
        Tour++;
    }
    public Joueur joueurCourant(){
        if (Tour % 2 == 0) {
            return NORD;
        } else {
            return SUD;
        }
    }
    public Joueur joueurEnattente(){
        if (Tour % 2 == 0) {
            return SUD;
        } else {
            return NORD;
        }
    }
}
