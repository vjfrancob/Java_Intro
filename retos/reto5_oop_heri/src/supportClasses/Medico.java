package supportClasses;

import java.util.ArrayList;

public class Medico extends Persona {

    private String especialidad;

    public Medico() {

    }

    public Medico(String nombre, String cc, int edad, String ciudad, String especialidad) {

        super(nombre, cc, edad, ciudad);

        this.especialidad = especialidad;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<String> pacientes(ArrayList<Paciente> pacientes, String ccMedico) {

        ArrayList<String> pacientesAsignados = new ArrayList<>();

        for (int i = 0; i < pacientes.size(); i++) {

            if (pacientes.get(i).getccMedico().equals(ccMedico)) {

                pacientesAsignados.add(pacientes.get(i).getCc());
            }
        }
        return pacientesAsignados;
    }

}
