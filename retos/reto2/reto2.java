package retos.reto2;
import java.util.ArrayList;
import java.util.Scanner;

public class reto2 {

    public static void main(String[] args) {
        

        Scanner input = new Scanner(System.in);

        int numPacientes = Integer.parseInt(input.nextLine());

        Paciente[] pacientes = new Paciente[numPacientes];

        ArrayList<String> ciudades = new ArrayList<String>();

        for (int i = 0; i < numPacientes; i++) {

            String entry = input.nextLine();

            String str[] = entry.split("-");

            Paciente nuevoPaciente = new Paciente(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4], str[5]);

            pacientes[i] = nuevoPaciente;

            ciudades.add(str[3]);

        }
        input.close();

        int conteo[] = new int[ciudades.size()];

        int indexOfLargest = 0;

        for (int i = 0; i < ciudades.size(); i++) {

            for (int j = 0; j < numPacientes; j++) {

                if (ciudades.get(i).equals(pacientes[j].getCiudad())) {

                    conteo[i]++;

                }

                if (conteo[i] > conteo[indexOfLargest]) {
                    indexOfLargest = i;
                }
            }
        }

        System.out.println(ciudades.get(indexOfLargest));
        for (int i = 0; i < numPacientes; i++) {

            System.out.println(pacientes[i].getCc() +" " + pacientes[i].clasificarEdad());

        }
        System.out.println(ciudades.get(indexOfLargest));
    }

}
