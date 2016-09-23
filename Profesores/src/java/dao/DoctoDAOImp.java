/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DoctoTramiteTitulacion;
import util.UtilDB;

/**
 *
 * @author adri_
 */
public class DoctoDAOImp implements DoctoDAO{
    
    private Connection connection;
    
    public DoctoDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarDocto(DoctoTramiteTitulacion docto) {
        String sql = "INSERT INTO doctotramitetitulacion "
                + " (notas,tramite_titulacion,activo,descripcion) "
                + " VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, docto.getNotas());
            ps.setInt(2, docto.getTramiteTitulacion());
            ps.setString(3, docto.getActivo());
            ps.setString(4, docto.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarDocto(int idDocto) {
        String sql= "DELETE FROM doctotramitetitulacion WHERE id_docto=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDocto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarDocto(DoctoTramiteTitulacion docto) {
        String sql = " UPDATE doctotramitetitulacion SET " + 
                " notas = ?, tramite_titulacion = ?, activo = ?, descripcion = ? " +
                " WHERE id_docto = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, docto.getNotas());
            ps.setInt(2, docto.getTramiteTitulacion());
            ps.setString(3, docto.getActivo());
            ps.setString(4, docto.getDescripcion());
            ps.setInt(5, docto.getIdDocto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DoctoTramiteTitulacion> desplegarDocto() {
        List<DoctoTramiteTitulacion> doctos = new ArrayList<DoctoTramiteTitulacion>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM doctotramitetitulacion");
            while(rs.next()){
                DoctoTramiteTitulacion docto = new DoctoTramiteTitulacion(rs.getInt("id_docto"),
                        rs.getString("notas"), 
                        rs.getInt("tramite_titulacion"), 
                        rs.getString("activo"),
                        rs.getString("descripcion"));
                doctos.add(docto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctos;
    }

    @Override
    public DoctoTramiteTitulacion elegirDocto(int idDocto) {
        DoctoTramiteTitulacion docto = null;
        try {
            String sql = "SELECT * FROM doctotramitetitulacion where id_docto=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDocto);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                docto = new DoctoTramiteTitulacion(rs.getInt("id_docto"),
                        rs.getString("notas"), 
                        rs.getInt("tramite_titulacion"), 
                        rs.getString("activo"),
                        rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docto;
    }
    
}
