/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiosweb.Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sitiosweb.Conexion.Conecion;
import sitiosweb.Modelo.sitios;
import sitiosweb.utilidades.Utilidades;

/**
 *
 * @author USER
 */
public class sitiosbd {
    
    public Utilidades utilidades;

    public sitiosbd() {
        utilidades = new Utilidades();
    }
    
     public boolean registrarSitios(sitios sitios) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        String sql;
            sql = "INSERT INTO `sitioweb`.`sitio_web` (`Id_sitioweb`, `Nombre`, `Enlace`, `FechaRegistro`) VALUES"
                    + " ('"+sitios.getIdSitiosweb()+"',"
                    + " '"+sitios.getNombreweb()+"', "
                    + "'"+sitios.getEnlaceweb()+"', "
                    + "'"+utilidades.fechaRegistro(sitios.getFecharegistro())+"')";
        try {
            //Es una instancia de la conexion previamente creada.
            Conecion conexion = new Conecion();
            con = conexion.Conexion_Mysql();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }
      //ACtualizar la persona e la base de datos.
    public boolean actualizar(sitios sitios) {
        // Conexion con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `sitioweb`.`sitio_web` SET `Nombre` = '"+sitios.getNombreweb()+"', `Enlace` = '"+sitios.getEnlaceweb()+"', `FechaRegistro` = '"+ utilidades.devolverFecha(sitios.getFecharegistro())+"' WHERE (`Id_sitioweb` = '"+sitios.getIdSitiosweb()+"');";

        try {
             Conecion conexion = new Conecion();
            connect = conexion.Conexion_Mysql();
            //Puente entre la conexion y el codigo
            stm = connect.createStatement();
            stm.execute(sql);
            JOptionPane.showMessageDialog(null, "Sitio editada con exito del sitema.");
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return actualizar;
    }
    public boolean eliminar(sitios sitios) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `sitioweb`.`sitio_web` WHERE (`Enlace` = '"+String.valueOf(sitios.getEnlaceweb()) + "');";
        try {
            connect = new Conecion().Conexion_Mysql();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
    public ArrayList<sitios> obtenersitios() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM sitioweb.sitio_web;";
        ArrayList<sitios> listasitios = new ArrayList<sitios>();
        try {
            co = new Conecion().Conexion_Mysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                sitios c = new sitios();
                c.setIdSitiosweb(rs.getInt(1));
                c.setNombreweb(rs.getString(2));
                c.setEnlaceweb(rs.getString(3));
                c.setFecharegistro(rs.getDate(4));
                listasitios.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("ErrorListarsitios:" + e.getMessage());
        }

        return listasitios;
    }
     //Metodo para buscar una persona por Nombre
    public List<sitios> getSitiosNombre(String Nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<sitios> nombresEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM sitioweb.sitio_web where Nombre like \"%" + Nombre + "%\"";
        try {
            co = new Conecion().Conexion_Mysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                sitios c = new sitios();
                c.setIdSitiosweb(rs.getInt(1));
                c.setNombreweb(rs.getString(2));
                c.setEnlaceweb(rs.getString(3));
                c.setFecharegistro(rs.getDate(4));
               
                nombresEncontrados.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return nombresEncontrados;
    }
    
    public sitios getSitio(String Nombre) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        sitios sitio = null;
        String sql = "SELECT * FROM sitioweb.sitio_web where Enlace like \"%" + Nombre + "%\"";
        try {
            co = new Conecion().Conexion_Mysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                sitio  = new sitios();
                sitio.setIdSitiosweb(rs.getInt(1));
                sitio.setNombreweb(rs.getString(2));
                sitio.setEnlaceweb(rs.getString(3));
                sitio.setFecharegistro(rs.getDate(4));           
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return sitio;
    }

    //Metodo para buscar una persona por enlace
    public List<sitios> getEnlace(String Enlace) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        List<sitios> EnlacesEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM sitioweb.sitio_web where Enlace like \"%" + Enlace + "%\"";
        try {
             co = new Conecion().Conexion_Mysql();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                 sitios c = new sitios();
                c.setIdSitiosweb(rs.getInt(1));
                c.setNombreweb(rs.getString(2));
                c.setEnlaceweb(rs.getString(3));
                c.setFecharegistro(rs.getDate(4));
                EnlacesEncontrados.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return EnlacesEncontrados;
    }

}

   