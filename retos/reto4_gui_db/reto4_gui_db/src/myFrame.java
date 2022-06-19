import java.awt.Dimension;
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

public class myFrame extends JFrame implements ActionListener {

    private JTextField nombre;
    private JTextField docIdnt;
    private JTextField ciudad;
    private JTextField edad;
    private JTextField eps;
    private JTextField enfermedad;

    private JTextField documento;
    private JTextField nombre_2;
    private JTextField docIdnt_2;
    private JTextField ciudad_2;
    private JTextField edad_2;
    private JTextField eps_2;
    private JTextField enfermedad_2;

    private JPanel ingreso;

    JTable result_table;

    JTextArea result_area;

    private JButton inButton;
    private JButton proButton;
    private JButton cleanButton;
    private JButton obtButton;
    private JButton busButton;
    private JButton editButton;
    private JButton delButton;

    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    ArrayList<String> dataInstance = new ArrayList<String>();

    Connect db_input = new Connect();

    boolean cargar = true;

    public void input_clean() {

        nombre.setText("");
        docIdnt.setText("");
        ciudad.setText("");
        edad.setText("");
        eps.setText("");
        enfermedad.setText("");
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

    void resultadosEstudios() {
        result_area.setText("");

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

        for (int i = 0; i < pacientes.size(); i++) {

            result_area.append((pacientes.get(i)).getCc() +
                    " - " + (pacientes.get(i)).clasificarEdad());
            result_area.append("\n");

        }

        result_area.append(pacientes.get(indexOfLargest).getCiudad());
        result_area.append("\n");
        result_area.append("\n");

    }

    myFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(2, 2));
        setTitle("Estudio de prevención de Mortalidad");

        inButton = new JButton("Ingresar");
        inButton.addActionListener(this);

        proButton = new JButton("Procesar");
        proButton.addActionListener(this);

        cleanButton = new JButton("Limpiar");
        cleanButton.addActionListener(this);

        obtButton = new JButton("Cargar");
        obtButton.addActionListener(this);

        busButton = new JButton("Buscar");
        busButton.addActionListener(this);

        editButton = new JButton("Editar");
        editButton.addActionListener(this);

        delButton = new JButton("Eliminar");
        delButton.addActionListener(this);

        /*
         * LABELS DE TEXTO
         */

        JLabel lbl_nombre = new JLabel("Nombre:");

        nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_nombre_2 = new JLabel("Nombre:");
        nombre_2 = new JTextField();

        JLabel lbl_cc = new JLabel("Documento:");

        docIdnt = new JTextField();
        docIdnt.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_cc_2 = new JLabel("Documento:");
        docIdnt_2 = new JTextField();
        docIdnt_2.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_edad = new JLabel("Edad:");
        lbl_edad.setBounds(10, 50, 50, 20);

        edad = new JTextField();
        edad.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_edad_2 = new JLabel("Edad:");
        lbl_edad_2.setBounds(10, 50, 50, 20);

        edad_2 = new JTextField();
        edad_2.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_ciudad = new JLabel("Ciudad:");

        ciudad = new JTextField();
        ciudad.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_ciudad_2 = new JLabel("Ciudad:");

        ciudad_2 = new JTextField();
        ciudad_2.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_eps = new JLabel("Eps:");
        eps = new JTextField();
        eps.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_eps_2 = new JLabel("Eps:");
        eps_2 = new JTextField();
        eps_2.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_enfermedad = new JLabel("Enfermedad:");
        enfermedad = new JTextField();
        enfermedad.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_enfermedad_2 = new JLabel("Enfermedad:");
        enfermedad_2 = new JTextField();
        enfermedad_2.setPreferredSize(new Dimension(150, 20));

        /*
         * PANEL CREATION
         */

        /*
         * panel 1
         */

        ingreso = new JPanel(new GridLayout(7, 2, 5, 5));
        ingreso.setOpaque(false);

        /*
         * panel 2
         */

        JPanel panel2_data = new JPanel(new BorderLayout(5, 5));
        panel2_data.setOpaque(false);

        JPanel panel2_button = new JPanel(new BorderLayout());
        panel2_button.setOpaque(false);

        JPanel validacion = new JPanel(new GridLayout(1, 2, 5, 5));
        validacion.setOpaque(false);

        JPanel botones_2 = new JPanel(new GridLayout(2, 1, 5, 5));
        botones_2.setOpaque(false);

        /*
         * panel 3
         */

        JPanel panel3_master = new JPanel(new BorderLayout(10, 10));
        panel3_master.setOpaque(false);

        JPanel panel3_search = new JPanel(new GridLayout(1, 3, 10, 10));
        panel3_search.setOpaque(false);

        JPanel panel3_input = new JPanel(new GridLayout(7, 2, 10, 10));
        panel3_input.setOpaque(false);

        JLabel lbl_idnt = new JLabel("Documento del paciente:", SwingConstants.CENTER);

        documento = new JTextField();

        /*
         * JTABLE FOR VALIDATION OF DATA ENTRY
         */
        result_table = new JTable();

        String columNames[] = { "Nombre", "Documento", "Edad", "Ciudad", "Eps", "Enfermedad" };
        DefaultTableModel tableModel = new DefaultTableModel(columNames, 0);

        result_table.setModel(tableModel);

        result_table.setOpaque(false);
        result_table.setBackground(new Color(61, 114, 148, 58));

        result_table.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        result_table.getTableHeader().setOpaque(false);
        result_table.getTableHeader().setBackground(new Color(58, 161, 145, 63));
        result_table.setSelectionBackground(new Color(210, 95, 58, 82));

        /*
         * RESULT AREA
         */

        result_area = new JTextArea();

        JScrollPane result_scroll = new JScrollPane(result_area,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        /**
         * VALIDACION - PANEL
         */

        validacion.add(new JScrollPane(result_table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        validacion.add(new JScrollPane(result_scroll,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

        botones_2.add(obtButton);
        botones_2.add(proButton);

        panel2_data.add(validacion, BorderLayout.CENTER);
        panel2_data.add(botones_2, BorderLayout.WEST);

        /*
         * GESTION PANEL
         */

        panel3_search.add(lbl_idnt);
        panel3_search.add(documento);
        panel3_search.add(busButton);

        panel3_input.add(lbl_nombre_2);
        panel3_input.add(nombre_2);
        panel3_input.add(lbl_cc_2);
        panel3_input.add(docIdnt_2);
        panel3_input.add(lbl_edad_2);
        panel3_input.add(edad_2);
        panel3_input.add(lbl_ciudad_2);
        panel3_input.add(ciudad_2);
        panel3_input.add(lbl_eps_2);
        panel3_input.add(eps_2);
        panel3_input.add(lbl_enfermedad_2);
        panel3_input.add(enfermedad_2);
        panel3_input.add(editButton);
        panel3_input.add(delButton);

        panel3_master.add(panel3_search, BorderLayout.NORTH);
        panel3_master.add(panel3_input, BorderLayout.CENTER);

        /*
         * TABS CREATION
         */

        JTabbedPane tabbedPane = new JTabbedPane();

        /*
         * ingreso
         */
        tabbedPane.addTab("Ingreso de pacientes", null, ingreso);

        /*
         * validacion - procesado
         */

        tabbedPane.addTab("Procesamiento de datos", null, panel2_data);

        /*
         * gestion - eliminacion
         */

        tabbedPane.addTab("Gestion de datos", null, panel3_master);

        /*
         * INGRESO - PANEL
         */

        ingreso.add(lbl_nombre);
        ingreso.add(nombre);
        ingreso.add(lbl_cc);
        ingreso.add(docIdnt);
        ingreso.add(lbl_edad);
        ingreso.add(edad);
        ingreso.add(lbl_ciudad);
        ingreso.add(ciudad);
        ingreso.add(lbl_eps);
        ingreso.add(eps);
        ingreso.add(lbl_enfermedad);
        ingreso.add(enfermedad);
        ingreso.add(inButton);
        ingreso.add(cleanButton);

        /*
         * ADD PANELS TO FRAME
         */

        add(tabbedPane);

        /*
         * WRAP UP FRAME
         */

        pack();
        setVisible(true);
        getContentPane().setBackground(new Color(61, 114, 148, 58));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inButton) {

            if (nombre.getText().equals("") || docIdnt.getText().equals("") || edad.getText().equals("") ||
                    ciudad.getText().equals("") || eps.getText().equals("") || enfermedad.getText().equals("")) {
                JOptionPane.showMessageDialog(ingreso,
                        "Por favor diligencie todos los campos",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (isNumeric(edad.getText()) == false) {
                JOptionPane.showMessageDialog(ingreso,
                        "Ingrese una edad valida",
                        "Información erronea",
                        JOptionPane.ERROR_MESSAGE);
            }

            else {

                /**
                 * Read input data
                 */

                String data[] = { nombre.getText(), docIdnt.getText(), edad.getText(),
                        ciudad.getText(), eps.getText(),
                        enfermedad.getText() };

                /*
                 * Add to db
                 */

                db_input.insert(data);

                /*
                 * Print data to JTable
                 */

                DefaultTableModel tableModel = (DefaultTableModel) result_table.getModel();
                tableModel.addRow(data);

                /*
                 * Create cities string
                 */

                // ciudades.add(ciudad.getText());

                input_clean();

            }
        }

        if (e.getSource() == proButton) {

            dataInstance.clear();
            pacientes.clear();
            dataInstance = db_input.cargar_db();
            for (int i = 0; i < dataInstance.size() / 6; i++) {
                int counter = i * 6;

                Paciente nuevoPaciente = new Paciente(dataInstance.get(0 + counter), dataInstance.get(1 + counter),
                        Integer.parseInt(dataInstance.get(2 + counter)), dataInstance.get(3 + counter),
                        dataInstance.get(4 + counter),
                        dataInstance.get(5 + counter));
                pacientes.add(nuevoPaciente);

            }

            resultadosEstudios();

        }

        if (e.getSource() == cleanButton)

        {

            input_clean();

        }

        if (e.getSource() == obtButton) {

            dataInstance.clear();
            dataInstance = db_input.cargar_db();
            DefaultTableModel tableModel = (DefaultTableModel) result_table.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }

            for (int i = 0; i < dataInstance.size() / 6; i++) {

                int counter = i * 6;

                String jtableUpdate[] = { dataInstance.get(counter), dataInstance.get(counter + 1),
                        dataInstance.get(counter + 2),
                        dataInstance.get(counter + 3), dataInstance.get(counter + 4), dataInstance.get(counter + 5) };
                tableModel.addRow(jtableUpdate);
            }
        }

        if (e.getSource() == busButton) {

            if (documento.getText().equals("")) {

                JOptionPane.showMessageDialog(ingreso,
                        "Ingrese documento del paciente",
                        "Información faltante",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                String cc = documento.getText();
                System.out.println(cc);

                try {
                    ArrayList<String> data = db_input.leer_db(cc);

                    nombre_2.setText(data.get(0));
                    docIdnt_2.setText(data.get(1));
                    edad_2.setText(data.get(2));
                    ciudad_2.setText(data.get(3));
                    eps_2.setText(data.get(4));
                    enfermedad_2.setText(data.get(5));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(ingreso,
                            "Documento erroneo, no se encuentra en la db",
                            "Información erronea",
                            JOptionPane.ERROR_MESSAGE);

                }

            }

        }

        if (e.getSource() == editButton) {

            if (nombre_2.getText().equals("") || docIdnt_2.getText().equals("") || edad_2.getText().equals("") ||
                    ciudad_2.getText().equals("") || eps_2.getText().equals("") || enfermedad_2.getText().equals("") ||
                    documento.getText().equals("")) {

                JOptionPane.showMessageDialog(ingreso,
                        "Todos los campos deben estar diligenciados",
                        "Información faltante",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                String data[] = { nombre_2.getText(), docIdnt_2.getText(), edad_2.getText(),
                        ciudad_2.getText(), eps_2.getText(), enfermedad_2.getText(), documento.getText() };

                db_input.update_db(data);

            }

        }

        if (e.getSource() == delButton) {

            if (nombre_2.getText().equals("") || docIdnt_2.getText().equals("") || edad_2.getText().equals("") ||
                    ciudad_2.getText().equals("") || eps_2.getText().equals("") || enfermedad_2.getText().equals("") ||
                    documento.getText().equals("")) {

                JOptionPane.showMessageDialog(ingreso,
                        "Todos los campos deben estar diligenciados",
                        "Información faltante",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                db_input.del_entry(documento.getText());
                clean_2();

            }

        }

    }

}
