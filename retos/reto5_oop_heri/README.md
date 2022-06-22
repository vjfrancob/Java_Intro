## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Referencias anteriores



        
        /**
         * String nombre, String cc, int edad, String ciudad, String eps, String
         * enfermedad
         */

        for (int i = 0; i < 10; i++) {

            Paciente nuevoPaciente = new Paciente("Vicente", "1140850527", i, "Barranquilla", "Sanitas", "Locura");
            paciente.add(nuevoPaciente);

        }

        // System.out.println(paciente.get(0).getEdad());

        /*
         * public Medico(String nombre, String cc, int edad, String ciudad, String
         * especialidad) {
         * super(nombre, cc, edad, ciudad);
         * this.especialidad = especialidad;
         * }
         */

        for (int i = 0; i < 10; i++) {

            Medico nuevoMedico = new Medico("Jonathan", "1140850527", i, "Barranquilla", "ortopedia");
            medico.add(nuevoMedico);

        }


        paciente.get(0).setMedico(medico.get(0).getNombre());

        System.out.println(paciente.get(0).totxt());

        medico.get(0).setnewPaciente(paciente.get(0));

        System.out.println(paciente.get(1).getMedico().equals(medico.get(0).getNombre()));

        System.out.println(medico.get(0).getnewPaciente());

        */
