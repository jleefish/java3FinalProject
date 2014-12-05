package pricing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dataaccess.CarTypeNotFoundException;
import dataaccess.DataAccess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

/**
 *
 * @author junghun lee and julio tain sueiras
 */
@WebServlet(name = "ValidationTest")
public class ValidationTest extends HttpServlet {
    private RentalBean custBean = new RentalBean();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            RentalFormValidator formValidator = new RentalFormValidator(request);
            boolean validation = formValidator.isValid();
            if (validation) {
                DataAccess db = new DataAccess();
                db.connection();

                boolean custNumberExist = db.doesCustNumberExist(Integer.parseInt(request.getParameter("customerNo")));

                if (custNumberExist) {
                    custBean = formValidator.getBean();

                    try {
                        custBean.setPriceSchedule(db.getCarTypePriceSchedule(custBean.getRentalType()));
                    } catch (CarTypeNotFoundException e) {
                        getServletContext().getRequestDispatcher("/invalidCustomer.jsp").forward(request, response);
                    }
                    System.out.println(custBean.getPrice());
                    db.disconnect();
                    request.setAttribute("bean", custBean);
                    getServletContext().getRequestDispatcher("/rentals.jsp").forward(request, response);

                } else {
                    db.disconnect();
                    getServletContext().getRequestDispatcher("/invalidCustomer.jsp").forward(request, response);
                }

            } else {
                ArrayList<Integer> errorList = formValidator.getErrorCodes();
                request.setAttribute("errorCodes", errorList);
                getServletContext().getRequestDispatcher("/errors.jsp").forward(request, response);
            }
        }catch(StringIndexOutOfBoundsException e){
            getServletContext().getRequestDispatcher("/invalidCustomer.jsp").forward(request, response);
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
