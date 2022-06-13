package gui_interface.src;

public class Persona {

    private String nombre;
    private String cc;
    private int edad;
    private String ciudad;
    private String eps;
    private String enfermedad;

    public Persona(String nombre, String cc, int edad, String ciudad, String eps, String enfermedad) {

        this.nombre = nombre;
        this.cc = cc;
        this.edad = edad;
        this.ciudad = ciudad;
        this.eps = eps;
        this.enfermedad = enfermedad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

}
