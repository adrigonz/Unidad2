/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DoctoDAOImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DoctoTramiteTitulacion;

/**
 *
 * @author adri_
 */
public class DoctoController extends HttpServlet {
    
    private final String LISTA_DOCTOS = "/lista_doctos.jsp";
    private final String AGREGAR = "/docto.jsp";
    private DoctoDAOImp dao;
    
    public DoctoController(){
        dao = new DoctoDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_DOCTOS;
            int idDocto = Integer.parseInt(request.getParameter("idDocto"));
            dao.borrarDocto(idDocto);
            request.setAttribute("doctos", dao.desplegarDocto());
        }else if(action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR;
            int idDocto = Integer.parseInt(request.getParameter("idDocto"));
            DoctoTramiteTitulacion docto = dao.elegirDocto(idDocto);
            request.setAttribute("docto", docto);
        }else if(action.equalsIgnoreCase("agregar")){
            forward = AGREGAR;            
        }else {
            forward = LISTA_DOCTOS;
            request.setAttribute("doctos", dao.desplegarDocto());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DoctoTramiteTitulacion docto = new DoctoTramiteTitulacion();
        docto.setNotas(request.getParameter("notas"));
        docto.setTramiteTitulacion(Integer.parseInt(request.getParameter("tramite_titulacion")));
        docto.setActivo(request.getParameter("activo"));
        docto.setDescripcion(request.getParameter("descripcion"));
        
        String idDocto = request.getParameter("idDocto");
        
        if(idDocto==null || idDocto.isEmpty()){
            dao.agregarDocto(docto);
        }else{
            docto.setIdDocto(Integer.parseInt(idDocto));
            dao.cambiarDocto(docto);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LISTA_DOCTOS);
        request.setAttribute("doctos", dao.desplegarDocto());
        view.forward(request, response);
    }

}
