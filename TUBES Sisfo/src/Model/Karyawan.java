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
public class Karyawan {
    String id_karyawan;
    String namaKaryawan;
    String department_id;

    public Karyawan(String id_karyawan, String namaKaryawan, String department_id) {
        this.id_karyawan = id_karyawan;
        this.namaKaryawan = namaKaryawan;
        this.department_id = department_id;
    }

    
    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }
    
    
}
