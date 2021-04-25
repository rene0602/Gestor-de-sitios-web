/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiosweb.Modelo;

import java.util.Date;



/**
 *
 * @author USER
 */
public class sitios {
     private int idSitiosweb;
    private String Nombreweb;
    private String Enlaceweb;
    private Date Fecharegistro;

    public sitios() {
    }

    public int getIdSitiosweb() {
        return idSitiosweb;
    }

    public void setIdSitiosweb(int idSitiosweb) {
        this.idSitiosweb = idSitiosweb;
    }

    public String getNombreweb() {
        return Nombreweb;
    }

    public void setNombreweb(String Nombreweb) {
        this.Nombreweb = Nombreweb;
    }

    public String getEnlaceweb() {
        return Enlaceweb;
    }

    public void setEnlaceweb(String Enlaceweb) {
        this.Enlaceweb = Enlaceweb;
    }

    public Date getFecharegistro() {
        return Fecharegistro;
    }

    public void setFecharegistro(Date Fecharegistro) {
        this.Fecharegistro = Fecharegistro;
    }

    @Override
    public String toString() {
        return "sitios{" + "idSitiosweb=" + idSitiosweb + ", Nombreweb=" + Nombreweb + ", Enlaceweb=" + Enlaceweb + ", Fecharegistro=" + Fecharegistro + '}';
    }
   
    
}
