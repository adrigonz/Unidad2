/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProfesorDAOImp;
import model.Profesor;

/**
 *
 * @author Adriana Gonzalez
 */
@WebServlet(name = "ProfesorController", urlPatterns = {"/ProfesorController"})
public class ProfesorController extends HttpServlet {
 private final String LISTA_PROFESORES = "/lista_profesores.jsp";
    private final String AGREGAR_CAMBIAR = "/profesor.jsp";
    private ProfesorDAOImp dao;
    
    public ProfesorController(){
        dao = new ProfesorDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_PROFESORES;
            int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));
            dao.borrarProfesor(idProfesor);
            request.setAttribute("profesores", dao.desplegarProfesores());
        }else if(action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_CAMBIAR;
            int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));
            Profesor profesor = dao.elegirProfesor(idProfesor);
            request.setAttribute("profesor", profesor);
        }else if(action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_CAMBIAR;            
        }else {
            forward = LISTA_PROFESORES;
            request.setAttribute("profesores", dao.desplegarProfesores());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Profesor profesor = new Profesor();
        profesor.setNombre(request.getParameter("nombre"));
        profesor.setCarrera(request.getParameter("carrera"));
        profesor.setExperiencia(Integer.parseInt(request.getParameter("experiencia")));
        
        String idProfesor = request.getParameter("idProfesor");
        
        if(idProfesor==null || idProfesor.isEmpty()){
            dao.agregarProfesor(profesor);
        }else{
            profesor.setIdProfesor(Integer.parseInt(idProfesor));
            dao.cambiarProfesor(profesor);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LISTA_PROFESORES);
        request.setAttribute("profesores", dao.desplegarProfesores());
        view.forward(request, response);
    }
    

}
