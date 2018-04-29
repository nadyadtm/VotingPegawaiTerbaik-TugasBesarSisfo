/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aplikasi;
import Model.Polling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class ControllerHalamanPegawai implements ActionListener{
    Aplikasi model;
    HalamanPegawai viewPegawai;
    String username;
    String password;
    int no = 0;
    

    public ControllerHalamanPegawai(String username, String password) {
        model = new Aplikasi();
        viewPegawai = new HalamanPegawai();
        this.username = username;
        this.password = password;
        viewPegawai.addActionListener(this);
        viewPegawai.setVisible(true);
        viewPegawai.getKategori1().setVisible(false);
        viewPegawai.getKategori2().setVisible(false);
        viewPegawai.getKategori3().setVisible(false);
        viewPegawai.getInputkat1().setVisible(false);
        viewPegawai.getInputkat2().setVisible(false);
        viewPegawai.getInputkat3().setVisible(false);
        if (getdftKategori().size()==3){
            viewPegawai.getKategori1().setVisible(true);
            viewPegawai.getKategori2().setVisible(true);
            viewPegawai.getKategori3().setVisible(true);
            viewPegawai.getInputkat1().setVisible(true);
            viewPegawai.getInputkat2().setVisible(true);
            viewPegawai.getInputkat3().setVisible(true);
            viewPegawai.getKategori1().setText(getdftKategori().get(0));
            viewPegawai.getKategori2().setText(getdftKategori().get(1));
            viewPegawai.getKategori3().setText(getdftKategori().get(2));
        }
        else if (getdftKategori().size()==2){
            viewPegawai.getKategori1().setVisible(true);
            viewPegawai.getKategori2().setVisible(true);
            viewPegawai.getInputkat1().setVisible(true);
            viewPegawai.getInputkat2().setVisible(true);
            viewPegawai.getKategori1().setText(getdftKategori().get(0));
            viewPegawai.getKategori2().setText(getdftKategori().get(1));
        }
        else if (getdftKategori().size()==1){
            viewPegawai.getKategori1().setVisible(true);
            viewPegawai.getInputkat1().setVisible(true);
            viewPegawai.getKategori1().setText(getdftKategori().get(0));
        }
    }
    
    public ArrayList<String> getdftKategori() {
        ArrayList<String> k = new ArrayList<>();
        for (int i = 0; i < model.getListKategori().size(); i++) {
            k.add(model.getListKategori().get(i));
        }
        return k;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewPegawai.getVoting())) {
            if (getdftKategori().size()==3){
                String pil1 = viewPegawai.getInputKategori1();
                String pil2 = viewPegawai.getInputKategori2();
                String pil3 = viewPegawai.getInputKategori3();
                if (model.srcKar(pil1)==true && model.srcKar(pil2)==true &&  model.srcKar(pil3)==true ){
                    Polling p1 = new Polling (username,pil1,getdftKategori().get(0));
                    Polling p2 = new Polling (username,pil2,getdftKategori().get(1));
                    Polling p3 = new Polling (username,pil3,getdftKategori().get(2));
                    model.addPolling(p1);
                    model.addPolling(p2);
                    model.addPolling(p3);
                    JOptionPane.showMessageDialog(null, "Sukses Polling,");
                } else{
                    JOptionPane.showMessageDialog(null, "Gagal Polling,");
                }
            }
            else if (getdftKategori().size()==2){
                String pil1 = viewPegawai.getInputKategori1();
                String pil2 = viewPegawai.getInputKategori2();
                if (model.srcKar(pil1)==true && model.srcKar(pil2)==true){
                    Polling p1 = new Polling (username,pil1,getdftKategori().get(0));
                    Polling p2 = new Polling (username,pil2,getdftKategori().get(1));
                    model.addPolling(p1);
                    model.addPolling(p2);
                    JOptionPane.showMessageDialog(null, "Sukses Polling,");
                } else{
                    JOptionPane.showMessageDialog(null, "Gagal Polling,");
                }
            }
            else if (getdftKategori().size()==1){
                String pil1 = viewPegawai.getInputKategori1();
                if (model.srcKar(pil1)==true){
                    Polling p1 = new Polling (username,pil1,getdftKategori().get(0));
                    model.addPolling(p1);
                    JOptionPane.showMessageDialog(null, "Sukses Polling,");
                } else{
                    JOptionPane.showMessageDialog(null, "Gagal Polling,");
                }
            }
        }
        else if (source.equals(viewPegawai.getCariKategori())){
            String kategori = viewPegawai.getCariKat();
            Polling p = model.srcPoll(username, kategori);
            viewPegawai.getNamabaru().setText(p.getNamaKaryawan());
        }
        else if (source.equals(viewPegawai.getUpdate_nama())){
            String kategori = viewPegawai.getCariKat();
            Polling p = model.srcPoll(username, kategori);
            if (p!=null){
                p.setNamaKaryawan(viewPegawai.getNamaBaru());
                model.updatePolling(p);
                JOptionPane.showMessageDialog(null, "Sukses Update Polling");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal Update Polling");
            }
        }
    }
}
