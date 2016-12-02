package com;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveFood extends HttpServlet {
    @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      Food newFood = new Food(req.getParameter("foodDescription"),
              Double.parseDouble(req.getParameter("foodPrice")), req.getParameter("purchaseDate"),
                req.getParameter("expireDate"), Double.parseDouble(req.getParameter("amount")),
                        req.getParameter("amountType"));
      Util.saveThing(newFood);
      resp.sendRedirect("/enterFoodPage.jsp?foodName=" + newFood.getDescription());
  }
}
