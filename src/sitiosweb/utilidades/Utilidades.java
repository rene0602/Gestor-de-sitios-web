/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiosweb.utilidades;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Utilidades {
     public String fechaRegistro(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }
      public String devolverFecha(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);
      }
      public static boolean isValidURL(String url) {

    try {
        (new URL(url)).openStream().close();
        return true;
    } catch (Exception e) {
    }

    return false;
}
       public void noDejaEscribir(JTextField texto) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent km) {
                char c = km.getKeyChar();
                if (!Character.isDigit(c)) {
                    km.consume();
                } else {
                    km.consume();
                }
            }
            
            @Override
            public void keyPressed(KeyEvent km) {
                char c = km.getKeyChar();
                if (!Character.isDigit(c)) {
                    km.consume();
                } else {
                    km.consume();
                }
            }
        });
    }
      
}
