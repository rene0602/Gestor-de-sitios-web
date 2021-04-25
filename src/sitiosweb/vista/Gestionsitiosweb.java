/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiosweb.vista;

import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sitiosweb.Modelo.sitios;
import sitiosweb.utilidades.Utilidades;

/**
 *
 * @author USER
 */
public class Gestionsitiosweb {
    
    private JTextField txtNombreWeb;
    private JTextField txtEnlaceWeb;
    private JTextField jDateFechaGuardado;
    private JFrame frameVistaWeb;
    private Utilidades utilidades;
    
    public Gestionsitiosweb(JTextField txtNombreWeb, JTextField txtEnlaceWeb, JTextField jDateFechaGuardado,Utilidades utilidades, JFrame frameVistaWeb){
        
        this.txtNombreWeb = txtNombreWeb;
        this.txtEnlaceWeb = txtEnlaceWeb;
        this.jDateFechaGuardado = jDateFechaGuardado;
        this.frameVistaWeb = frameVistaWeb;
        this.utilidades= utilidades;
    }
    public JTextField getTxtNombreWeb() {
        return txtNombreWeb;
    }

    public void setTxtNombreWeb(JTextField txtNombreWeb) {
        this.txtNombreWeb = txtNombreWeb;
    }

    public JTextField getTxtEnlaceWeb() {
        return txtEnlaceWeb;
    }

    public void setTxtEnlaceWeb(JTextField txtEnlaceWeb) {
        this.txtEnlaceWeb = txtEnlaceWeb;
    }

    public JTextField getjDateFechaGuardado() {
        return jDateFechaGuardado;
    }

    public void setjDateFechaGuardado(JTextField jDateFechaGuardado) {
        this.jDateFechaGuardado = jDateFechaGuardado;
    }

    public JFrame getFrameVistaWeb() {
        return frameVistaWeb;
    }

    public void setFrameVistaWeb(JFrame frameVistaWeb) {
        this.frameVistaWeb = frameVistaWeb;
    }
    
     public void limpiarsitios() {
        //Este es el metodo el cuaal nos ayudara a limpiar los campos de nuestra tabla con mayor facilidad
         txtNombreWeb.setText("");
         txtEnlaceWeb.setText("");
         jDateFechaGuardado.setText(null);
     }
     
     public boolean guardarEditar() {
        if (txtNombreWeb.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameVistaWeb, "El campo nombres no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombreWeb.requestFocus();
            return false;
        }
        if (txtEnlaceWeb.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameVistaWeb, "El campo Enlace web no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtEnlaceWeb.requestFocus();
            return false;
          }
        if (!utilidades.isValidURL(txtEnlaceWeb.getText())) {
            JOptionPane.showMessageDialog(frameVistaWeb, "El campo Enlace web estan mal los datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtEnlaceWeb.requestFocus();
            return false;    
        }
        if (jDateFechaGuardado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameVistaWeb, "El campo Fecha de Guardado no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            jDateFechaGuardado.requestFocus();
            return false;
        }
//         sitios Sitio = new sitios();
//        Sitio.setNombreweb(txtNombreWeb.getText());
//        Sitio.setEnlaceweb(txtEnlaceWeb.getText());
//        if (isEditar) {
//            Sitio.setFecharegistro(new Date());       
//        }else{
//            Sitio.setFecharegistro(new Date());
//        }
        
        return true;
    }

}
