package retos.reto1;

import java.util.ArrayList;
import java.util.Scanner;

public class reto1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pacientes = Integer.parseInt(input.nextLine());

        String ciud = " ";

        ArrayList<String> df = new ArrayList<String>();

        for (int i = 0; i <= pacientes; i++) {

            if (i == pacientes) {

                ciud = input.nextLine();

            } else {

                String entry = input.nextLine();

                String str[] = entry.split("-");

                for (int j = 0; j < str.length; j++) {

                    df.add(str[j]);

                }
            }

        }

        String data[] = df.toArray(new String[0]);

        String ciudades[] = ciud.split("-");

        int conteo[] = new int[ciudades.length];
        int indexOfLargest = 0;

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[j].equals(ciudades[i])) {
                    conteo[i]++;
                }
            }
            if (conteo[i] > conteo[indexOfLargest]) {
                indexOfLargest = i;
            }
        }
        System.out.println(ciudades[indexOfLargest]);
    }
}
