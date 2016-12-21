package com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchBy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // The double is declared and assigned to eliminate calling parseDouble more than once
        //Double searchValue = Double.parseDouble(request.getParameter("searchValue"));
        
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(request.
                getParameter("searchedBy"), request.getParameter("searchValue"));
        
        Long[] Ids = new Long[results.length]; /* Ids are used to provide buttons
            to select individual records */
        
        for(int i = 0; i < results.length; i++){
            Ids[i] = results[i].getId();
        }
        
        request.setAttribute("results", results);
        request.setAttribute("ids", Ids);
        request.setAttribute("searchedBy", request.getParameter("searchedBy"));
        request.setAttribute("searchValue", request.getParameter("searchValue"));
	RequestDispatcher view = request.getRequestDispatcher("searchResults.jsp");			
	view.forward(request, response);
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
