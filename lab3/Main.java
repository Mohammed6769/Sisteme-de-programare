package lab3;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("in.txt"));

        String linie;

        while ((linie = br.readLine()) != null) {


            System.out.println(linie);


            String[] bucati = linie.split("\\.");
            for (String b : bucati) {
                System.out.println(b + ".");
            }
        }

        br.close();
    }
}