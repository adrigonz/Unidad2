/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.DoctoTramiteTitulacion;
import model.Profesor;

/**
 *
 * @author adri_
 */
public interface DoctoDAO {
    void agregarDocto(DoctoTramiteTitulacion docto);
    void borrarDocto(int idDocto);
    void cambiarDocto(DoctoTramiteTitulacion docto);
    List<DoctoTramiteTitulacion> desplegarDocto();
    DoctoTramiteTitulacion elegirDocto(int idDocto);
}
