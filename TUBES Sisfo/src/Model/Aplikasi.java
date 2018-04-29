/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class Aplikasi {
    ArrayList<String> listKategori = new ArrayList<>();
    ArrayList<Polling> listPolling = new ArrayList<>();
    ArrayList<Karyawan> listKaryawan = new ArrayList<>();
    ArrayList<AkunKaryawan> listAkunKaryawan = new ArrayList<>();
    Database db;

    public Aplikasi() {
        db = new Database();
        db.connect();
        this.listKategori = db.loadKategori();
        this.listPolling = db.loadPolling();
        this.listKaryawan = db.loadKaryawan();
        this.listAkunKaryawan = db.loadAkunKaryawan();
    }
    
    public AkunKaryawan srclogKar(String username) {
        for (AkunKaryawan m : listAkunKaryawan) {
            if (username.equals(m.getUsername())) {
                return m;
            }
        }
        return null;
    }
    
    public boolean srcKar(String nama) {
        System.out.println(listKaryawan.get(0).getNamaKaryawan());
        for (Karyawan m : listKaryawan) {
            if (nama.equals(m.getNamaKaryawan())) {
                return true;
            }
        }
        return false;
    }

    public boolean mskAkunKar(String username, String password) {
        if (srclogKar(username) != null) {
            if (srclogKar(username).cekValidasi(username, password) == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean cekKategori(String Kategori) {
        for (String k : listKategori) {
            if (Kategori.equals(k)) {
                return true;
            }
        }
        return false;
    }
    
    public void addKategori(String Kategori) {
        String k = Kategori;
        listKategori.add(k);
        db.saveKategori(k);
    }
    
    public void updateKategori(String Kategori){
        db.updateKategori(Kategori);
        listKategori = db.loadKategori();
    }
    
    public void deleteKategori(String Kategori) {
        listKategori.remove(Kategori);
        db.removeKategori(Kategori);
    }
    
    public void addPolling(Polling k) {
        listPolling.add(k);
        db.savePolling(k);
    }
    
    public void updatePolling(Polling k){
        db.updatePolling(k);
        listPolling = db.loadPolling();
    }

    public ArrayList<String> getListKategori() {
        return listKategori;
    }

    public ArrayList<Polling> getListPolling() {
        return listPolling;
    }
    
    public Polling srcPoll(String username, String kategori) {
        for (Polling k : listPolling) {
            if (username.equals(k.username)&&kategori.equals(k.kategori)) {
                return k;
            }
        }
        return null;
    }
    
    public void resetAll(){
        listPolling.clear();
        db.removeAllPoll();
    }
}
