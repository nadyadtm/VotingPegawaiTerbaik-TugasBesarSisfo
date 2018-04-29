/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aplikasi;
import Model.HasilPoll;
import Model.Polling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class ControllerHRD implements ActionListener {
    private Aplikasi model;
    private HalamanHRD viewHRD;

    public ControllerHRD() {
        this.model = new Aplikasi();
        this.viewHRD = new HalamanHRD();
        viewHRD.setVisible(true);
        viewHRD.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewHRD.getInput())) {
            String kategori = viewHRD.getInputKategori();
            model.addKategori(kategori);
        }
        else if (source.equals(viewHRD.getCari())){
            if (model.cekKategori(viewHRD.getDeleteKat()) == true) {
                int dialogButton = JOptionPane.showConfirmDialog(null, "Apa anda yakin untuk menghapus Kategori ini?", "DELETE", JOptionPane.YES_NO_OPTION);
                if (dialogButton == 0) {
                    model.deleteKategori(viewHRD.getDeleteKat());
                    JOptionPane.showMessageDialog(null, "Kategori Berhasil dihapus");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        }
        else if (source.equals(viewHRD.getUpdate())){
            String KategoriLama = viewHRD.getKategoriLama();
            if (viewHRD.getKategoriLama().equals("")) {
                JOptionPane.showMessageDialog(null, "Kategori Tidak Boleh Kosong");
            } else {
                if (model.cekKategori(KategoriLama) == true) {
                    String KategoriBaru = viewHRD.getKategoriBaru();
                    model.updateKategori(KategoriBaru);
                    JOptionPane.showMessageDialog(null, "Sukses Update Kategori");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Update Kategori");
                }
            }
        }
        else if (source.equals(viewHRD.getRefresh())){
            ArrayList<Polling> daftarPolling = model.getListPolling();
            ArrayList<HasilPoll> hasil = new ArrayList<>();
            for (int i = 0; i < model.getListKategori().size(); i++) {
                hasil.add(new HasilPoll(model.getListKategori().get(i)));
            }
            for (int i = 0; i < hasil.size(); i++) {
                for (int j = 0; j < daftarPolling.size(); j++) {
                    if(hasil.get(i).getKategori().equals(daftarPolling.get(j).getKategori())){
                        hasil.get(i).addKaryawan(daftarPolling.get(j).getNamaKaryawan());
                    }                
                }
            }
            
            String Pemenang = "";
            for (int i = 0; i < hasil.size(); i++){
                Pemenang = Pemenang + "Pegawai " + hasil.get(i).getKategori()+"\n"+hasil.get(i).pemenangPolling()+"\n\n";
            }
            viewHRD.setPengumuman(Pemenang);
        }
        else if (source.equals(viewHRD.getResetAll())){
            model.resetAll();
        }
    }
    
    
}
