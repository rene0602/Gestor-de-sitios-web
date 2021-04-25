/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiosweb.modelotablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sitiosweb.Modelo.sitios;
import sitiosweb.vista.VistaWeb;

/**
 *
 * @author USER
 */
public class ModelTableSitioweb extends AbstractTableModel  {
    public String[] m_colNames = {"Nombre del sitio web", "Enlace del sitio web", "Fecha de guardado"};

    public java.util.List<sitios> sitio;

//    private ComunicacionVistaModelosTablas comunicacionsitios;
    private VistaWeb gContable;
    public  ModelTableSitioweb(java.util.List<sitios> sitio,VistaWeb gContable) {
        this.sitio = sitio;
        this.gContable = gContable;
    }
 //Determina el número de filas que tengo en mi tabla.
    @Override
    public int getRowCount() {
        return sitio.size();
    }
//Determina el número de columnas que tengo en mi tabla.
    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        sitios macData = sitio.get(rowIndex);
        switch (columnIndex) {
            case 0:
                 return macData.getNombreweb();
            case 1:
                return macData.getEnlaceweb();
            case 2:
                return macData.getFecharegistro();
           
        }
        System.out.println("Select sitio?" + macData.toString());
        return new String();
    }

    //Sirve para definir los nombres de las columnas
    
    @Override
    public String getColumnName(int column) {
        return m_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clicksitios(sitio.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);
    }
    public List<sitios> getsitios() {
        return sitio;
    }

    public void setsitios(List<sitios> sitio) {
        this.sitio = sitio;
    }
    
}
    
