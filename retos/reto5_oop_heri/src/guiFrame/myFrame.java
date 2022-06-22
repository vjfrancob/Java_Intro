package guiFrame;
//package supportClasses.Medico;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import supportClasses.Paciente;

public class myFrame extends JFrame implements ActionListener {

    /*
     * Ingreso Pacientes
     */

    private JTextField nombre_paciente;
    private JTextField docIdnt_paciente;
    private JTextField ciudad_paciente;
    private JTextField edad_paciente;
    private JTextField eps_paciente;
    private JTextField enfermedad_paciente;

    /*
     * Ingreso Medicos
     */

    private JTextField nombre_medico;
    private JTextField docIdnt_medico;
    private JTextField ciudad_medico;
    private JTextField edad_medico;
    private JTextField especialidad_medico;

    /*
     * Modificación de Pacientes
     */

    private JTextField documento;
    private JTextField nombre_2;
    private JTextField docIdnt_2;
    private JTextField ciudad_2;
    private JTextField edad_2;
    private JTextField eps_2;
    private JTextField enfermedad_2;

    private JPanel ingreso_master;

    JTable result_table;

    JTextArea result_area;

    private JButton inButtonPaciente;
    private JButton cleanButton;
    private JButton inButtonMedico;

    private JButton proButton;

    private JButton obtButton;
    private JButton busButton;
    private JButton editButton;
    private JButton delButton;

    // ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    ArrayList<String> dataInstance = new ArrayList<String>();

    boolean cargar = true;

    public void input_clean() {

        nombre_paciente.setText("");
        docIdnt_paciente.setText("");
        ciudad_paciente.setText("");
        edad_paciente.setText("");
        eps_paciente.setText("");
        enfermedad_paciente.setText("");

        nombre_medico.setText("");
        docIdnt_medico.setText("");
        ciudad_medico.setText("");
        edad_medico.setText("");
        especialidad_medico.setText("");
    }

    public void clean_2() {

        nombre_2.setText("");
        docIdnt_2.setText("");
        edad_2.setText("");
        ciudad_2.setText("");
        eps_2.setText("");
        enfermedad_2.setText("");
        documento.setText("");
    }

    public static boolean isNumeric(String edad) {

        try {
            Integer.parseInt(edad);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // void resultadosEstudios() {
    // result_area.setText("");
    //
    // int conteo[] = new int[pacientes.size()];
    //
    // int indexOfLargest = 0;
    //
    // for (int i = 0; i < pacientes.size(); i++) {
    //
    // for (int j = 0; j < pacientes.size(); j++) {
    //
    // if (pacientes.get(i).getCiudad().equals((pacientes.get(j)).getCiudad())) {
    //
    // conteo[i]++;
    //
    // }
    //
    // if (conteo[i] > conteo[indexOfLargest]) {
    // indexOfLargest = i;
    // }
    // }
    // }
    //
    // for (int i = 0; i < pacientes.size(); i++) {
    //
    // result_area.append((pacientes.get(i)).getCc() +
    // " - " + (pacientes.get(i)).clasificarEdad());
    // result_area.append("\n");
    //
    // }
    //
    // result_area.append(pacientes.get(indexOfLargest).getCiudad());
    // result_area.append("\n");
    // result_area.append("\n");
    //
    // }

    public myFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(2, 2));
        setTitle("Estudio de prevención de Mortalidad");

        inButtonPaciente = new JButton("Ingresar Paciente");
        inButtonPaciente.addActionListener(this);

        cleanButton = new JButton("Limpiar");
        cleanButton.addActionListener(this);

        inButtonMedico = new JButton("Ingresar Medico");
        inButtonMedico.addActionListener(this);

        /*
         * 
         * proButton = new JButton("Procesar");
         * proButton.addActionListener(this);
         * 
         * 
         * 
         * obtButton = new JButton("Cargar");
         * obtButton.addActionListener(this);
         * 
         * busButton = new JButton("Buscar");
         * busButton.addActionListener(this);
         * 
         * editButton = new JButton("Editar");
         * editButton.addActionListener(this);
         * 
         * delButton = new JButton("Eliminar");
         * delButton.addActionListener(this);
         */

        /*
         * LABELS DE TEXTO
         */

        /**
         * Ingreso pacientes
         */

        JLabel lbl_nombre_paciente = new JLabel("Nombre:");
        nombre_paciente = new JTextField();

        JLabel lbl_docIdnt_paciente = new JLabel("Documento:");
        docIdnt_paciente = new JTextField();

        JLabel lbl_edad_paciente = new JLabel("Edad:");
        edad_paciente = new JTextField();

        JLabel lbl_ciudad_paciente = new JLabel("Ciudad:");
        ciudad_paciente = new JTextField();

        JLabel lbl_eps_paciente = new JLabel("Eps:");
        eps_paciente = new JTextField();

        JLabel lbl_enfermedad_paciente = new JLabel("Enfermedad:");
        enfermedad_paciente = new JTextField();

        /**
         * Ingreso medicos
         */

        JLabel lbl_nombre_medico = new JLabel("Nombre:");
        nombre_medico = new JTextField();

        JLabel lbl_docIdnt_medico = new JLabel("Documento:");
        docIdnt_medico = new JTextField();

        JLabel lbl_edad_medico = new JLabel("Edad:");
        edad_medico = new JTextField();

        JLabel lbl_ciudad_medico = new JLabel("Ciudad:");
        ciudad_medico = new JTextField();

        JLabel lbl_especialidad_medico = new JLabel("Especialidad:");
        especialidad_medico = new JTextField();

        /*
         * CREACION DE PESTAÑAS
         */

        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBackground(new Color(255, 255, 255));
        pestañas.setOpaque(true);

        /*
         * PANEL CREATION
         */

        /**
         * VENTANA DE INGRESO
         */

        ingreso_master = new JPanel(new BorderLayout(5, 5));
        ingreso_master.setOpaque(false);

        JPanel im_intermedio = new JPanel(new GridLayout(1, 2));
        im_intermedio.setOpaque(false);

        /*
         * ingreso pacientes
         */
        JPanel im_pacientes = new JPanel(new GridLayout(6, 2));
        im_pacientes.setOpaque(false);
        im_pacientes.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Ingreso de Pacientes"));

        /*
         * ingreso medicos
         */

        JPanel im_medicos = new JPanel(new GridLayout(5, 2));
        im_medicos.setOpaque(false);
        im_medicos.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Ingreso de Medicos"));

        /*
         * posicionamiento botones
         */

        JPanel im_botones = new JPanel(new GridLayout(1, 3));
        im_botones.setOpaque(false);

        /*
         * asignacion de objetos a panel
         */

        im_pacientes.add(lbl_nombre_paciente);
        im_pacientes.add(nombre_paciente);
        im_pacientes.add(lbl_docIdnt_paciente);
        im_pacientes.add(docIdnt_paciente);
        im_pacientes.add(lbl_edad_paciente);
        im_pacientes.add(edad_paciente);
        im_pacientes.add(lbl_ciudad_paciente);
        im_pacientes.add(ciudad_paciente);
        im_pacientes.add(lbl_eps_paciente);
        im_pacientes.add(eps_paciente);
        im_pacientes.add(lbl_enfermedad_paciente);
        im_pacientes.add(enfermedad_paciente);

        im_medicos.add(lbl_nombre_medico);
        im_medicos.add(nombre_medico);
        im_medicos.add(lbl_docIdnt_medico);
        im_medicos.add(docIdnt_medico);
        im_medicos.add(lbl_edad_medico);
        im_medicos.add(edad_medico);
        im_medicos.add(lbl_ciudad_medico);
        im_medicos.add(ciudad_medico);
        im_medicos.add(lbl_especialidad_medico);
        im_medicos.add(especialidad_medico);

        im_botones.add(inButtonPaciente);
        im_botones.add(cleanButton);
        im_botones.add(inButtonMedico);

        im_intermedio.add(im_pacientes);
        im_intermedio.add(im_medicos);

        ingreso_master.add(im_intermedio, BorderLayout.CENTER);
        ingreso_master.add(im_botones, BorderLayout.SOUTH);

        pestañas.addTab("Ingreso de Información", null, ingreso_master);

        /*
         * INCLUIR PESTAÑAS AL FRAME
         */

        add(pestañas);

        pack();
        setVisible(true);
        getContentPane().setBackground(new Color(61, 114, 148, 58));
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == inButtonPaciente) {

            if (nombre_paciente.getText().equals("") || docIdnt_paciente.getText().equals("")
                    || edad_paciente.getText().equals("") ||
                    ciudad_paciente.getText().equals("") || eps_paciente.getText().equals("")
                    || enfermedad_paciente.getText().equals("")) {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Por favor diligencie todos los campos",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);

            } else if (isNumeric(edad_paciente.getText()) == false) {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Ingrese una edad valida",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                String data[] = { nombre_paciente.getText(), docIdnt_paciente.getText(), edad_paciente.getText(),
                        ciudad_paciente.getText(), eps_paciente.getText(), enfermedad_paciente.getText() };

                input_clean();
            }
        }

        if (e.getSource() == cleanButton) {

            input_clean();

        }

        if (e.getSource() == inButtonMedico) {

            if (nombre_medico.getText().equals("") || docIdnt_medico.getText().equals("")
                    || edad_medico.getText().equals("") ||
                    ciudad_medico.getText().equals("") || especialidad_medico.getText().equals("")) {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Por favor diligencie todos los campos",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);

            } else if (isNumeric(edad_medico.getText()) == false) {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Ingrese una edad valida",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                String data[] = { nombre_medico.getText(), docIdnt_medico.getText(), edad_medico.getText(),
                        ciudad_medico.getText(), especialidad_medico.getText()};

                input_clean();
            }

        }

    }
}
