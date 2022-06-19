
public class Paciente extends Persona {

    Paciente (String nombre, String cc, int edad, String ciudad, String eps, String enfermedad){

        super(nombre, cc, edad, ciudad, eps, enfermedad);
    }

    public String clasificarEdad() {

        if (this.getEdad() >= 21 && this.getEdad() <= 30) {

            return "Joven adulto";

        }

        else if (this.getEdad() > 30 && this.getEdad() <= 60) {

            return "Adulto";

        }

        else if (this.getEdad() > 60) {

            return "Tercera edad";

        }

        else {

            return "";

        }

    }

}