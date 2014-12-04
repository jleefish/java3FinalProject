package pricing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author junghun lee and julio tain sueiras
 */
@WebServlet(urlPatterns = {"/ValidationTest"})
public class ValidationTest extends HttpServlet {

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
        
        RentalFormValidator formValidator = new RentalFormValidator(request);
        boolean validation = formValidator.isValid();
        ArrayList<Integer> errorList = formValidator.getErrorCodes();
        RentalBean bean = new RentalBean();
        bean.setCustomerNumber(Integer.parseInt(request.getParameter("customerNo")));
        bean.setPickupHour(Integer.parseInt(request.getParameter("pickupHour")));
        bean.setPickupDay(Integer.parseInt(request.getParameter("pickupDay")));
        bean.setPickupMon(Integer.parseInt(request.getParameter("pickupMonth")));
        bean.setPickupYear(Integer.parseInt(request.getParameter("pickupYear")));
        bean.setDropoffHour(Integer.parseInt(request.getParameter("dropoffHour")));
        bean.setDropoffDay(Integer.parseInt(request.getParameter("dropoffDay")));
        bean.setDropoffMon(Integer.parseInt(request.getParameter("dropoffMonth")));
        bean.setDropoffYear(Integer.parseInt(request.getParameter("dropoffYear")));
        bean.setRentalType(request.getParameter("carType"));
        bean.setCardType(request.getParameter("cardType"));
        bean.setCardNumber(request.getParameter("creditCardNo"));


        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidationTest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidationTest at " + request.getContextPath() + "</h1>");
            out.println("<h1>validation: "+validation+"</h1>");
            out.println(bean.getCustomerNumber()+" "+bean.getPickupHour()+" "+bean.getPickupDay()+" "+bean.getPickupMon()+" "+bean.getPickupYear());
            for(int error : errorList){
                out.println("error code: "+error+"<br>");
            }
            out.println("</body>");
            out.println("</html>");
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
