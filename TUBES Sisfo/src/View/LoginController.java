/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows
 */
public class LoginController implements ActionListener{
    LoginForm viewLogin;
    HalamanHRD viewHRD;
    HalamanPegawai viewPegawai;
    Aplikasi model;

    public LoginController() {
        viewLogin = new LoginForm();
        viewHRD = new HalamanHRD();
        viewPegawai = new HalamanPegawai();
        model = new Aplikasi();
        viewLogin.addActionListener(this);
        viewLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(viewLogin.getLoginBut())) {
            String user = viewLogin.getUserText();
            String pass = viewLogin.getPassText();
            if (user.equals("HRD")) {
                if (pass.equals("12345")) {
                    new ControllerHRD();
                    viewLogin.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password atau Username salah");
                }
            }
            else{
                if (model.mskAkunKar(user, pass)==true) {
                   user = viewLogin.getUserText();
                   pass = viewLogin.getPassText();
                   new ControllerHalamanPegawai(user,pass);
                   viewLogin.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password atau username salah");
                }
            }
        }
    }
}
