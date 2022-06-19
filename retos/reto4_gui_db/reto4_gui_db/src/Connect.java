import java.sql.*;
import java.util.ArrayList;

public class Connect {

    private Connection connect() {

        Connection con = null;

        try {

            con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "/db/db_pacientes.db");

            if (con != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion.");
        }
        return con;
    }

    public void insert(String data[]) {

        String query = "INSERT INTO pacientes (nombre, cedula, edad, ciudad, eps, enfermedad)"
                + "VALUES (?,?,?,?,?,?)";

        try {

            Connection con = this.connect();
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setInt(3, Integer.parseInt(data[2]));
            pstmt.setString(4, data[3]);
            pstmt.setString(5, data[4]);
            pstmt.setString(6, data[5]);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<String> cargar_db() {

        ArrayList<String> data = new ArrayList<String>();
        String query = "SELECT * FROM pacientes";

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                data.add(rs.getString("nombre"));
                data.add(rs.getString("cedula"));
                data.add(rs.getString("edad"));
                data.add(rs.getString("ciudad"));
                data.add(rs.getString("eps"));
                data.add(rs.getString("enfermedad"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;

    }

    public ArrayList<String> leer_db(String cc) {

        ArrayList<String> data = new ArrayList<String>();

        String query = "SELECT * FROM pacientes WHERE cedula = ?";

        try {
            Connection conn = this.connect();

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cc);
            ResultSet rs = stmt.executeQuery();

            // pstmt.executeUpdate();

            // Statement pstmt = conn.createStatement();
            // ResultSet rs = pstmt.executeQuery(query);
            // System.out.println(rs);

            while (rs.next()) {

                data.add(rs.getString("nombre"));
                data.add(rs.getString("cedula"));
                data.add(rs.getString("edad"));
                data.add(rs.getString("ciudad"));
                data.add(rs.getString("eps"));
                data.add(rs.getString("enfermedad"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return data;

    }

    public void update_db(String data[]) {

        String query = "UPDATE pacientes SET nombre = ?, "
        + "cedula = ?, edad = ?, ciudad = ?, eps = ?, enfermedad = ?"
        +"WHERE cedula = ?";

        try {
            Connection conn = this.connect();

            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setInt(3, Integer.parseInt(data[2]));
            pstmt.setString(4, data[3]);
            pstmt.setString(5, data[4]);
            pstmt.setString(6, data[5]);
            pstmt.setString(7, data[6]);

            pstmt .executeUpdate();

        } catch (SQLException e){

            System.out.println(e.getMessage());

        }

    }

    public void del_entry(String cc){

        String query = "DELETE FROM pacientes WHERE cedula = ?";

        try {
            Connection conn = this.connect();

            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, cc);
            pstmt .executeUpdate();

        } catch (SQLException e){

            System.out.println(e.getMessage());

        }





    }

}