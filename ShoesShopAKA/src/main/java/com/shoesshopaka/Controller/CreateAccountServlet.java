/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoesshopaka.Controller;

import com.shoesshopaka.User.UserDAO;
import com.shoesshopaka.User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author enteecaay
 */
public class CreateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            
            if(action !=null && action.equals("Create")){
                String newUsername = request.getParameter("username");
                String newPassword = request.getParameter("password");
                String newEmail = request.getParameter("email");
                String newPhone = request.getParameter("phone");
                String newFirstname = request.getParameter("firstname");
                String newLastname = request.getParameter("lastname");
                String newSex = request.getParameter("sex");
                String newBirthdate = request.getParameter("birthdate");
                LocalDate newDate = LocalDate.parse(newBirthdate);
                String newProvinceTown = request.getParameter("province");
                String newDistricttown = request.getParameter("districttown");
                String newAddress = request.getParameter("address");

                UserDTO user = new UserDTO(newUsername, newPassword, newEmail, newPhone, newFirstname, newLastname, newSex, newDate, newProvinceTown, newDistricttown, newAddress);
                
                UserDAO userDAO = new UserDAO();
                if (userDAO.checkDuplicate(newUsername)) {
                    request.setAttribute("messageSignup", "Sign-up failed. Username already exists.");
                } else {
                    boolean inserted = userDAO.insert(user);
                    if (inserted) {
                        request.setAttribute("usersession", user);
                        request.setAttribute("messageSignup", "Sign-up successful. Please log in!");
                    } else {
                        request.setAttribute("messageSignup", "Sign-up failed. Please try again!");
                    }
                }

                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);    
            } else{
                System.out.println("Action not found or not Create");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
