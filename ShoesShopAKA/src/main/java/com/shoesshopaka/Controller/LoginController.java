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
import javax.servlet.http.HttpSession;

/**
 *
 * @author enteecaay
 */
public class LoginController extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (action.equals("Login")) {
                UserDAO dao = new UserDAO();
                UserDTO user = dao.login(username, password);

                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usersession", user);
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("error", "username or password is incorrect");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } else if (action != null && action.equals("logout")) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                request.setAttribute("error", "Logout successfully");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else if(action.equals("Sign-up")){
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.forward(request, response);
            }
//            if(action !=null || action.equals("Create")){
//                String newUsername = request.getParameter("username");
//                String newPassword = request.getParameter("password");
//                String newEmail = request.getParameter("email");
//                String newPhone = request.getParameter("phone");
//                String newFirstname = request.getParameter("firstname");
//                String newLastname = request.getParameter("lastname");
//                String newSex = request.getParameter("sex");
//                String newBirthdate = request.getParameter("birthdate");
//                LocalDate newDate = LocalDate.parse(newBirthdate);
//                String newProvinceTown = request.getParameter("province");
//                String newDistricttown = request.getParameter("districttown");
//                String newAddress = request.getParameter("address");
//
//                UserDTO user = new UserDTO();
//                
//                user.setUsername(newUsername);
//                user.setPassword(newPassword);
//                user.setEmail(newEmail);
//                user.setPhone(newPhone);
//                user.setFirstName(newFirstname);
//                user.setLastName(newLastname);
//                user.setSex(newSex);
//                user.setBirthDate(newDate);
//                user.setProvince(newProvinceTown);
//                user.setDistrictTown(newDistricttown);
//                user.setAddressLine(newAddress);
//                UserDAO userDAO = new UserDAO();
//                if (userDAO.checkDuplicate(newUsername)){
//                boolean inserted = userDAO.insert(user);
//                if (inserted) {
//                    request.setAttribute("usersession", user);
//                    request.setAttribute("messageSignup", "Sign-up successful. Please log in!");
//                } else {
//                    request.setAttribute("messageSignup", "Sign-up failed. Please try again!");
//                }
//                } else {
//                    request.setAttribute("messageSignup", "Sign-up failed. Username already exist");
//                }
////                response.sendRedirect("login.jsp");
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);     
//            } else{
//                System.out.println("Action not found or not Create");
//            }
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
