package supportClasses;

import java.util.ArrayList;

public class Medico extends Persona {

    private String especialidad;

    private ArrayList<Object> newPaciente = new ArrayList<Object>();


    public Medico(String nombre, String cc, int edad, String ciudad, String especialidad) {

        super(nombre, cc, edad, ciudad);

        this.especialidad = especialidad;

        this.newPaciente = new ArrayList<Object>();

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Object> pacientes() {

        return newPaciente;
    }

    /**
     * ! POR DEFINIR INFORMACIÓN QUE CARGA DEL PACIENTE
     */

    public ArrayList<Object> setPacientes(Paciente paciente) {

        this.newPaciente.add(paciente.getNombre());
        this.newPaciente.add(paciente.getCc());
        this.newPaciente.add(paciente.getEdad());
        this.newPaciente.add(paciente.getEnfermedad());

        return newPaciente;
    }

}
