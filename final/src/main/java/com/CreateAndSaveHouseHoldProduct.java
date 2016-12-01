package com;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveHouseHoldProduct extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      HouseHoldProduct newProduct = new HouseHoldProduct(req.getParameter("description"),
              Double.parseDouble(req.getParameter("price")), req.getParameter("purchaseDate"),
                Double.parseDouble(req.getParameter("amount")), 
                    req.getParameter("amountType"), req.getParameter("type"));
      resp.sendRedirect("/enterHouseHoldProducts.jsp?productName=" + newProduct.getDescription());
  }
}
