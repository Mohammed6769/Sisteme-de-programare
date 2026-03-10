package lab2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        Set<Integer> xPlusYLimitedByP = new TreeSet<>();

        Random r = new Random();

        for(int i=0;i<5;i++)
            x.add(r.nextInt(11));

        for(int i=0;i<7;i++)
            y.add(r.nextInt(11));

        Collections.sort(x);
        Collections.sort(y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);

        for(Integer i : x)
            if(y.contains(i))
                zSet.add(i);

        for(Integer i : x)
            if(!y.contains(i))
                xMinusY.add(i);

        for(Integer i : x)
            if(i<=p)
                xPlusYLimitedByP.add(i);

        for(Integer i : y)
            if(i<=p)
                xPlusYLimitedByP.add(i);

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("xPlusY = " + xPlusY);
        System.out.println("zSet = " + zSet);
        System.out.println("xMinusY = " + xMinusY);
        System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);
    }
}
