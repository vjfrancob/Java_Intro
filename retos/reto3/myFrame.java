import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

    private JPanel ingreso;

    JTable result_table;

    JTextArea result_area;

    private JButton inButton;
    private JButton proButton;

    ArrayList<String> ciudades = new ArrayList<String>();

    ArrayList<Object> pacientes = new ArrayList<Object>();

    int i = 0;

    public void input_clean() {

        nombre.setText("");
        docIdnt.setText("");
        ciudad.setText("");
        edad.setText("");
        eps.setText("");
        enfermedad.setText("");
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

        int conteo[] = new int[ciudades.size()];

        int indexOfLargest = 0;

        for (int i = 0; i < ciudades.size(); i++) {

            for (int j = 0; j < pacientes.size(); j++) {

                if (ciudades.get(i).equals(((Paciente) pacientes.get(j)).getCiudad())) {

                    conteo[i]++;

                }

                if (conteo[i] > conteo[indexOfLargest]) {
                    indexOfLargest = i;
                }
            }
        }

        System.out.println(ciudades.get(indexOfLargest));
        for (int i = 0; i < pacientes.size(); i++) {

            result_area.append(((Paciente) pacientes.get(i)).getCc() +
                    " - " + ((Paciente) pacientes.get(i)).clasificarEdad());
            result_area.append("\n");

        }

        // System.out.println(ciudades.get(indexOfLargest));

        result_area.append(ciudades.get(indexOfLargest));
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

        JLabel lbl_nombre = new JLabel("Nombre:");

        nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_cc = new JLabel("Documento:");

        docIdnt = new JTextField();
        docIdnt.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_edad = new JLabel("Edad:");
        lbl_edad.setBounds(10, 50, 50, 20);

        edad = new JTextField();
        edad.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_ciudad = new JLabel("Ciudad:");

        ciudad = new JTextField();
        ciudad.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_eps = new JLabel("Eps:");
        eps = new JTextField();
        eps.setPreferredSize(new Dimension(150, 20));

        JLabel lbl_enfermedad = new JLabel("Enfermedad:");
        enfermedad = new JTextField();
        enfermedad.setPreferredSize(new Dimension(150, 20));

        /*
         * PANEL CREATION
         */

        ingreso = new JPanel(new GridLayout(7, 2, 5, 5));

        JPanel validacion = new JPanel(new GridLayout(1, 1, 1, 1));

        // JPanel resultados = new JPanel(new GridLayout(1,1,1,1));
        JPanel resultados = new JPanel(new BorderLayout());

        ingreso.setOpaque(false);
        ingreso.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)),
                "Ingreso de Información"));

        validacion.setOpaque(false);
        validacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)),
                "Pacientes Ingresados"));

        resultados.setOpaque(false);
        resultados.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)),
                "Resultados"));

        /*
         * JTABLE FOR VALIDATION OF DATA ENTRY
         */
        result_table = new JTable();

        String columNames[] = { "No.", "Nombre", "Documento", "Edad", "Ciudad", "Eps", "Enfermedad" };
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

        result_area = new JTextArea(10, 100);
        JScrollPane result_scroll = new JScrollPane(result_area,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        /*
         * ADD ITEMS TO PANELS
         */

        /*
         * RESULTADOS - PANEL
         */

        resultados.add(result_scroll, BorderLayout.CENTER);

        /**
         * VALIDACION - PANEL
         */

        validacion.add(new JScrollPane(result_table,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

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
        ingreso.add(proButton);

        /*
         * ADD PANELS TO FRAME
         */

        add(ingreso, BorderLayout.WEST);
        add(validacion, BorderLayout.CENTER);
        add(resultados, BorderLayout.SOUTH);

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
                i++;

                String data[] = { String.valueOf(i), nombre.getText(), docIdnt.getText(), edad.getText(),
                        ciudad.getText(), eps.getText(),
                        enfermedad.getText() };

                /*
                 * Print data to JTable
                 */

                DefaultTableModel tableModel = (DefaultTableModel) result_table.getModel();
                tableModel.addRow(data);

                /*
                 * Create cities string
                 */

                ciudades.add(ciudad.getText());

                /*
                 * OOP to new structure Stuff
                 */

                Paciente nuevoPaciente = new Paciente(nombre.getText(), docIdnt.getText(),
                        Integer.parseInt(edad.getText()), ciudad.getText(), eps.getText(), enfermedad.getText());

                pacientes.add(nuevoPaciente);

                input_clean();

            }
        }

        if (e.getSource() == proButton) {

            resultadosEstudios();
        }
    }
}
