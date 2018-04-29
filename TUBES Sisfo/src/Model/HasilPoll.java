/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Windows
 */
public class HasilPoll {
    String kategori;
    ArrayList<String>KumpKaryawan = new ArrayList<>();
    String pemenangPoll;

    public HasilPoll(String kategori) {
        this.kategori = kategori;
    }


    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public ArrayList<String> getKumpKaryawan() {
        return KumpKaryawan;
    }

    public void setKumpKaryawan(ArrayList<String> KumpKaryawan) {
        this.KumpKaryawan = KumpKaryawan;
    }
    
    public void addKaryawan (String p) {
        KumpKaryawan.add(p);
    }

    public String getPemenangPoll() {
        return pemenangPoll;
    }

    public void setPemenangPoll(String pemenangPoll) {
        this.pemenangPoll = pemenangPoll;
    }
    
    public String searchPoll(String kar){
        for (String m : KumpKaryawan) {
            if (kar.equals(m)) {
                return m;
            }
        }
        return null;
    }
    public String pemenangPolling(){
        Set<String> namaNominasi = new HashSet<>();
        namaNominasi.addAll(KumpKaryawan);
        ArrayList<String> namaNominasiList = new ArrayList<>();
        ArrayList<Integer> scoress = new ArrayList<>();
        namaNominasiList.addAll(namaNominasi);
        for (int i = 0; i < namaNominasiList.size(); i++) {
            int score = 0;
            for (int j = 0; j < KumpKaryawan.size(); j++) {
                if(namaNominasiList.get(i).equals(KumpKaryawan.get(j))){
                    score=score+1;
                }    
            }
            System.out.println(score);
            scoress.add(score);
        }
        int max = -1;
        int indxMax = 0;
        for (int i = 0; i < scoress.size(); i++) {
            if(scoress.get(i)>max){
                max = scoress.get(i);
                indxMax = i;
                pemenangPoll=namaNominasiList.get(indxMax);
            }
        }
                
        return pemenangPoll;
    }
}
