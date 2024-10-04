import java.util.*;

public class maca {
    public static void main(String args[]) {
        ArrayList<Integer> maca = new ArrayList<>();
        maca.add(7);
        maca.add(5);
        maca.add(2);
        maca.add(8);
        maca.add(6);
        maca.add(1);
        maca.add(3);
        maca.add(4);

        System.out.println("Maçãs compradas: " + maca);

        ArrayList<Integer> ruins = new ArrayList<>();

        for (int i = 0; i < maca.size(); i++) {
            //System.out.println(maca.get(i));
            int m = maca.get(i) % 2;
                ruins.add(m);
        }

        System.out.println("Maçãs podres: " + ruins);
        System.out.println("Maçãs boas: " + maca);
    }
}
