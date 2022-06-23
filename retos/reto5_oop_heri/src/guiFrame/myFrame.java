package guiFrame;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import supportClasses.Medico;

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
     * Tablas y areas de texto
     */

    private JPanel ingreso_master;

    JTable ip_table;
    JTable im_table;

    JTextArea edad_ciudad_area;
    JTextArea pacientes_asignados;

    /*
     * ComboBox
     */

    private JComboBox<String> idt_medico;
    private JComboBox<String> asig_medico;

    private JButton inButtonPaciente;
    private JButton cleanPaciente;
    private JButton inButtonMedico;
    private JButton cleanMedico;
    private JButton selectMedico;
    private JButton asigMedico;

    private JButton proedadButton;
    private JButton promedButton;

    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    ArrayList<Medico> medicos = new ArrayList<Medico>();

    int i = 0;

    // boolean cargar = true;

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

    public static boolean isNumeric(String edad) {

        try {
            Integer.parseInt(edad);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void availablesMedicCombofill() {

        idt_medico.removeAllItems();
        asig_medico.removeAllItems();

        idt_medico.addItem("");
        asig_medico.addItem("");
        for (int i = 0; i < medicos.size(); i++) {
            idt_medico.addItem(medicos.get(i).getCc());
            asig_medico.addItem(medicos.get(i).getCc());
        }

    }

    private void clasificacionEdad() {

        edad_ciudad_area.setText("\n");
        edad_ciudad_area.setText("CLASIFICACIÓN DE EDADES DE PACIENTES: \n");
        edad_ciudad_area.append("\n");

        int conteo[] = new int[pacientes.size()];
        int indexOfLargest = 0;

        for (int i = 0; i < pacientes.size(); i++) {

            for (int j = 0; j < pacientes.size(); j++) {

                if (pacientes.get(i).getCiudad().equals((pacientes.get(j)).getCiudad())) {

                    conteo[i]++;

                }

                if (conteo[i] > conteo[indexOfLargest]) {
                    indexOfLargest = i;
                }
            }
        }
        edad_ciudad_area.append("\n");
        for (int i = 0; i < pacientes.size(); i++) {

            edad_ciudad_area.append(pacientes.get(i).clasificarEdad() + "\n");

        }

        edad_ciudad_area.append(pacientes.get(indexOfLargest).getCiudad());

    }

    private void calculoPacientes(ArrayList<String> pacientes) {

        pacientes_asignados.setText("\n");
        pacientes_asignados.setText("PACIENTES ASIGNADOS PARA ATENDER: \n");
        pacientes_asignados.append("\n");

        for (int i = 0; i < pacientes.size(); i++) {

            pacientes_asignados.append(pacientes.get(i));
        }

    }

    public myFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(2, 2));
        setTitle("Estudio de prevención de Mortalidad");

        inButtonPaciente = new JButton("Ingresar Paciente");
        inButtonPaciente.addActionListener(this);

        cleanPaciente = new JButton("Limpiar");
        cleanPaciente.addActionListener(this);

        inButtonMedico = new JButton("Ingresar Medico");
        inButtonMedico.addActionListener(this);

        cleanMedico = new JButton("Limpiar");
        cleanMedico.addActionListener(this);

        selectMedico = new JButton("Seleccionar");
        selectMedico.addActionListener(this);

        asigMedico = new JButton("Mostrar");
        asigMedico.addActionListener(this);

        proedadButton = new JButton("Clasificar Edad de los Pacientes");
        proedadButton.addActionListener(this);

        promedButton = new JButton("Identificar Pacientes asignados al Médico");
        promedButton.addActionListener(this);

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
         * seleccion de medicos
         */

        JLabel lbl_seleccion_medico = new JLabel("Seleccione su médico:");

        // DefaultComboBoxModel<String> udt_medico_model = new DefaultComboBoxModel<>();
        idt_medico = new JComboBox<>();
        idt_medico.addActionListener(this);

        /*
         * revision asignacion medico
         */

        JLabel lbl_asig_medico = new JLabel("Seleccione documento del médico:");
        // DefaultComboBoxModel<String> asig_medico_model = new
        // DefaultComboBoxModel<>();

        asig_medico = new JComboBox<>();
        asig_medico.addActionListener(this);

        /*
         * ESOACIOS PARA DARLE ORDEN
         */

        JLabel space0 = new JLabel("");
        JLabel space1 = new JLabel("");
        JLabel space2 = new JLabel("");
        JLabel space3 = new JLabel("");

        /*
         * PANEL CREATION
         */

        /**
         * VENTANA DE INGRESO
         */

        JPanel super_ingreso_master = new JPanel(new GridLayout(1, 2));
        super_ingreso_master.setOpaque(false);

        ingreso_master = new JPanel(new BorderLayout(5, 5));
        ingreso_master.setOpaque(false);

        /*
         * recibo de ingresos
         */

        JPanel ingreso_intermedio = new JPanel(new GridLayout(1, 2));
        ingreso_intermedio.setOpaque(false);

        /*
         * recibo de ingresos
         */

        JPanel seleccion_intermedia = new JPanel(new GridLayout(3, 2));
        seleccion_intermedia.setOpaque(false);
        seleccion_intermedia.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)),
                        "Verifique Asignación de pacientes"));

        /*
         * ingreso pacientes
         */

        JPanel im_pacientes = new JPanel(new GridLayout(8, 2));
        im_pacientes.setOpaque(false);
        im_pacientes.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Ingreso de Pacientes"));

        /*
         * ingreso medicos
         */

        JPanel im_medicos = new JPanel(new GridLayout(6, 2));
        im_medicos.setOpaque(false);
        im_medicos.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Ingreso de Medicos"));

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
        im_pacientes.add(lbl_seleccion_medico);
        im_pacientes.add(idt_medico);
        im_pacientes.add(inButtonPaciente);
        im_pacientes.add(cleanPaciente);

        seleccion_intermedia.add(space0);
        seleccion_intermedia.add(space1);
        seleccion_intermedia.add(lbl_asig_medico);
        seleccion_intermedia.add(asig_medico);
        seleccion_intermedia.add(space2);
        seleccion_intermedia.add(space3);

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
        im_medicos.add(inButtonMedico);
        im_medicos.add(cleanMedico);

        ingreso_intermedio.add(im_medicos);
        ingreso_intermedio.add(im_pacientes);

        ingreso_master.add(ingreso_intermedio, BorderLayout.CENTER);
        ingreso_master.add(seleccion_intermedia, BorderLayout.SOUTH);
        super_ingreso_master.add(ingreso_master);

        /*
         * VENTANA DE VISUALIZACION DE INGRESOS
         */

        JPanel super_validacion_master = new JPanel(new BorderLayout());
        super_validacion_master.setOpaque(false);

        JPanel validacion_master = new JPanel(new GridLayout(2, 4, 5, 5));
        validacion_master.setOpaque(false);

        JPanel vm_pacientes = new JPanel(new GridLayout(1, 1));
        vm_pacientes.setOpaque(false);

        vm_pacientes.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Pacientes Ingresados"));

        JPanel vm_medicos = new JPanel(new GridLayout(1, 1));
        vm_medicos.setOpaque(false);

        vm_medicos.setBorder(BorderFactory
                .createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)), "Medicos Ingresados"));

        ip_table = new JTable();
        String ip_columNames[] = { "Nombre", "Documento", "Edad", "Ciudad", "Eps", "Enfermedad" };
        DefaultTableModel ip_tableMOdel = new DefaultTableModel(ip_columNames, 0);
        ip_table.setModel(ip_tableMOdel);

        ip_table.setOpaque(false);
        ip_table.setBackground(new Color(61, 114, 148, 58));
        ip_table.getTableHeader().setBackground(new Color(58, 161, 145, 63));
        ip_table.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        ip_table.setSelectionBackground(new Color(210, 95, 58, 82));

        im_table = new JTable();
        String im_columNames[] = { "Nombre", "Documento", "Edad", "Ciudad", "Especialidad" };
        DefaultTableModel im_tableMOdel = new DefaultTableModel(im_columNames, 0);
        im_table.setModel(im_tableMOdel);

        im_table.setOpaque(false);
        im_table.setBackground(new Color(61, 114, 148, 58));
        im_table.getTableHeader().setBackground(new Color(58, 161, 145, 63));
        im_table.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        im_table.setSelectionBackground(new Color(210, 95, 58, 82));

        vm_pacientes.add(new JScrollPane(ip_table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        vm_medicos.add(new JScrollPane(im_table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        validacion_master.add(vm_medicos);
        validacion_master.add(vm_pacientes);

        /*
         * VENTA DE RESULTADOS
         */

        edad_ciudad_area = new JTextArea();

        JScrollPane edadClasi_scroll = new JScrollPane(edad_ciudad_area,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        pacientes_asignados = new JTextArea();

        JScrollPane paciAsig_scroll = new JScrollPane(pacientes_asignados,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel panel_botones = new JPanel(new GridLayout(2, 1));
        panel_botones.setOpaque(false);

        panel_botones.add(proedadButton);
        panel_botones.add(promedButton);

        validacion_master.add(edadClasi_scroll);
        validacion_master.add(paciAsig_scroll);

        super_validacion_master.add(validacion_master, BorderLayout.CENTER);
        super_validacion_master.add(panel_botones, BorderLayout.SOUTH);

        super_ingreso_master.add(super_validacion_master);

        /*
         * INCLUIR PESTAÑAS AL FRAME
         */

        add(super_ingreso_master);

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
            } else if (idt_medico.getSelectedItem() == null || idt_medico.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Seleccione su médico",
                        "Información faltante",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                String data[] = { nombre_paciente.getText(), docIdnt_paciente.getText(), edad_paciente.getText(),
                        ciudad_paciente.getText(), eps_paciente.getText(), enfermedad_paciente.getText() };

                DefaultTableModel ip_tableMOdel = (DefaultTableModel) ip_table.getModel();
                ip_tableMOdel.addRow(data);

                Paciente nuevoPaciente = new Paciente(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4],
                        data[5]);
                pacientes.add(nuevoPaciente);

                pacientes.get(i).setccMedico((String) idt_medico.getSelectedItem());
                i++;

                idt_medico.setSelectedIndex(0);

                System.out.println("whatever");

                input_clean();
            }
        }

        if (e.getSource() == cleanPaciente) {

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
                        ciudad_medico.getText(), especialidad_medico.getText() };

                DefaultTableModel im_tableMOdel = (DefaultTableModel) im_table.getModel();
                im_tableMOdel.addRow(data);

                Medico nuevoMedico = new Medico(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                medicos.add(nuevoMedico);
                availablesMedicCombofill();

                input_clean();
            }

        }

        if (e.getSource() == cleanMedico) {

            input_clean();

        }

        if (e.getSource() == proedadButton) {

            clasificacionEdad();
        }

        if (e.getSource() == promedButton) {

            if (asig_medico.getSelectedItem() == null || asig_medico.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(ingreso_master,
                        "Seleccione médico",
                        "Información faltante",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                Medico nuevoMedico = new Medico();

                ArrayList<String> asignacionPacientes = new ArrayList<String>();

                asignacionPacientes.clear();

                asignacionPacientes = nuevoMedico.pacientes(pacientes, (String) asig_medico.getSelectedItem());

                calculoPacientes(asignacionPacientes);




            }

        }

    }
}
