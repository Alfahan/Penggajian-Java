package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class koneksi {

    Connection konn;
    Statement st;
    ResultSet rs;

    public Connection setKoneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            konn = DriverManager.getConnection("jdbc:mysql://localhost/penggajian_cv_mega", "root", "");
            st = konn.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Silahkan Aktifkan Apache dan Mysql di XAMPP Anda atau pecahkan masalah di " + e);
        }
        return konn;
    }

}
