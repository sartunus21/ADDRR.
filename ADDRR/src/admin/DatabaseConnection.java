/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;
// 1. Import semua kelas yang dibutuhkan
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DAMAR
 */
public class DatabaseConnection {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/addrr";
                String user = "root";
                String password = "";
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "FATAL ERROR: Koneksi Database Gagal! " + e.getMessage());
                System.exit(1);
            }
        }
        return koneksi;
    }

    static Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
