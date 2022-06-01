package retos.reto1;

import java.util.Arrays;
import java.util.Scanner;

public class reto1_old {

    static String ciudades(int pacientes) {

        int countBarr = 0, countBog = 0;

        Scanner input = new Scanner(System.in);
        Integer.parseInt(input.nextLine());

        for (int i = 0; i <= pacientes; i++) {

            String entry = input.nextLine();

            String data[] = entry.split("-");

            for (int j = 0; j < data.length; j++) {

                if (data[j].equals("Barranquilla")) {
        
                    countBarr++;

                }

                else if (data[j].equals("Bogota")) {

                    countBog++;

                }

            }

        }

        if (countBog > countBarr) {

            return "Bogota";
        }

        else if (countBog < countBarr) {

            return "Barranquilla";
        }

        else {
            return "Empate";
        }

    }

    public static void main(String[] args) {

        System.out.println(ciudades(3));

        // int countBarr = 0, countBog = 0;
        //
        // Scanner input = new Scanner(System.in);
        //
        //// System.out.print("No. Pacientes: ");
        // Integer.parseInt(input.nextLine());
        //// System.out.println("Pacientes: "+ pacientes);
        //
        //// System.out.print("Info: ");
        // String data1 = input.nextLine();
        //// System.out.println("Record: "+ data1);
        //
        //// System.out.print("Info: ");
        // String data2 = input.nextLine();
        //// System.out.println("Record: "+ data2);
        //
        //// System.out.print("Info: ");
        // String data3 = input.nextLine();
        //// System.out.println("Record: "+ data3);
        //
        //// System.out.print("Info: ");
        // String data4 = input.nextLine();
        //// System.out.println("Record: "+ data4);
        //
        // input.close();
        //
        // String data [] = (data1 + "-" + data2 + "-" + data3 + "-" +
        // data4).split("-");
        //
        //// System.out.println("Resultado: "+ data.length);
        //
        // for (int i = 0; i < data.length; i++) {
        //
        // if (data[i] == "Barranquilla") {
        //
        // countBarr ++;
        //
        // } else if (data[i] == "Bogota") {
        //
        // countBog ++;
        // }
        // }
        //
        // if (countBog > countBarr) {
        //
        // System.out.println("Bogota");
        //
        // } else {
        //
        // System.out.println("Barranquilla");
        // }
        //
    }
}
