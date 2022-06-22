
package supportClasses;

import java.util.ArrayList;

public class Paciente extends Persona {

    private String eps;
    private String enfermedad;
    private String medico;

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

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
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

    public ArrayList<Object> totxt() {
        ArrayList<Object> outPaciente = new ArrayList<Object>();
        outPaciente.clear();
        outPaciente.add(this.getNombre());
        outPaciente.add(this.getCc());
        outPaciente.add(this.getEdad());
        outPaciente.add(this.getCiudad());
        outPaciente.add(this.getEps());
        outPaciente.add(this.getEnfermedad());

        return outPaciente;

    }

}