/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Windows
 */
public class AkunKaryawan {
    Karyawan karyawan;
    String username;
    String password;
    String email;
    String jabatan;

    public AkunKaryawan(String username, String password, String email, String jabatan) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.jabatan = jabatan;
    }

    
    
    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean cekValidasi (String username, String Password){
        if (username.equals(this.username)&&Password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }
}
