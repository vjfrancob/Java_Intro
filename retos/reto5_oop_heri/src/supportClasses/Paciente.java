
package supportClasses;

public class Paciente extends Persona {

    private String eps;
    private String enfermedad;
    private String cc_medico;

    public Paciente(){       
    }

    public Paciente(String nombre, String cc, int edad, String ciudad, String eps, String enfermedad) {

        super(nombre, cc, edad, ciudad);
        this.eps = eps;
        this.enfermedad = enfermedad;

    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public String getccMedico() {
        return cc_medico;
    }

    public void setccMedico(String cc_medico) {
        this.cc_medico = cc_medico;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String clasificarEdad() {

        if (this.getEdad() >= 21 && this.getEdad() <= 30) {

            return this.getCc() + " - " + "Joven adulto";

        }

        else if (this.getEdad() > 30 && this.getEdad() <= 60) {

            return this.getCc() + " - " + "Adulto";

        }

        else if (this.getEdad() > 60) {

            return this.getCc() + " - " + "Tercera edad";

        }

        else {

            return "";

        }

    }

}