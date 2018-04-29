/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/hrschema?zeroDateTimeBehavior=convertToNull";
    private String dbuser = "";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat koneksi");
        }
    }
    
    public ArrayList<Karyawan> loadKaryawan() {
        try {
            ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
            String query = "select employee_id, first_name, department_id from employees";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Karyawan k = new Karyawan(rs.getString("employee_id"), rs.getString("first_name"), rs.getString("department_id"));
                daftarKaryawan.add(k);
            }
            return daftarKaryawan;
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load karyawan");
        }
    }
    
    public Karyawan srcKaryawan(String yangdicari) {
        for (Karyawan k : loadKaryawan()) {
            if (k.getId_karyawan().equals(yangdicari)) {
                return k;
            }
        }
        return null;
    }
    
    public ArrayList<String> loadKategori() {
        try {
            ArrayList<String> daftarKategori = new ArrayList<>();
            String query = "SELECT * from kategori";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String k = rs.getString(1);
                daftarKategori.add(k);
            }
            return daftarKategori;
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load kategori");
        }
    }
    
    public void saveKategori(String Kategori) {
        try {
            String query = "INSERT INTO kategori(nama_kategori) VALUES"
                    + "('" + Kategori + "')";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save kategori");
        }
    }
    
    public void updateKategori(String Kategori) {
        try {
            String query = "UPDATE kategori SET nama_kategori='"
                    + Kategori + "'";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update kategori");
        }
    }
    
    
    public void removeKategori(String Kategori) {
        try {
            String query = "DELETE FROM kategori WHERE nama_kategori= " + "'" + Kategori + "'" ;
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat hapus kategori");
        }
    }
    
    public ArrayList<AkunKaryawan> loadAkunKaryawan() {
        try {
            ArrayList<AkunKaryawan> daftarAkunKaryawan = new ArrayList<>();
            String query = "select username, password, email, jabatan from akunkaryawan";
            ResultSet rs = statement.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                AkunKaryawan p = new AkunKaryawan(rs.getString("username"), rs.getString("password"),rs.getString("email"), rs.getString("jabatan"));
                daftarAkunKaryawan.add(p);
                i++;
            }
            return daftarAkunKaryawan;
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load akunKaryawan");
        }
    }
    
    public ArrayList<Polling> loadPolling() {
        try {
            ArrayList<Polling> daftarPolling = new ArrayList<>();
            String query = "select * from polling";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Polling k = new Polling(rs.getString("username"),rs.getString("nama_karyawan"),rs.getString("kategori"));
                daftarPolling.add(k);
            }
            return daftarPolling;
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat load Polling");
        }
    }
    
    public void savePolling(Polling P) {
        try {
            String query = "INSERT INTO polling(username, nama_karyawan, kategori) VALUES"
                    + "('" + P.username + "','"+P.namaKaryawan+"','"+P.kategori+"')";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat save Polling");
        }
    }
    
    public void updatePolling(Polling p) {
        try {
            String query = "UPDATE polling SET nama_karyawan='"
                    + p.namaKaryawan + "'WHERE kategori='"+p.kategori+"'"+" AND username='"+p.username+"'";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat update materi");
        }
    }
    
    public void removeAllPoll() {
        try {
            String query = "TRUNCATE table polling";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException e) {
            throw new IllegalArgumentException("terjadi kesalahan saat hapus kategori");
        }
    }
}
