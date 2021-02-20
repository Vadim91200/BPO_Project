import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Pioche {
    public static final int NBCARTESPIOCHE = 60;
    private List<Integer> element = new ArrayList<>();

    public List<Integer> getElement() {
        return element;
    }

    public Pioche() {
        for(int n=1; n<=NBCARTESPIOCHE; n++) {
            element.add(n);
        }
    }
    public Integer tirage(){
        Random r = new Random();
        int a = r.nextInt(element.size());
        Integer iter = element.get(a);
        element.remove(a);
        return iter;
    }
}
