package com;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveFood extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[]  foodFields = Food.getFields();
        Food newFood = new Food(req.getParameter(foodFields[0]),
                Double.parseDouble(req.getParameter(foodFields[1])), req.getParameter(foodFields[2]),
                req.getParameter(foodFields[3]), Double.parseDouble(req.getParameter(foodFields[4])),
                req.getParameter(foodFields[5]));
        Util.datastore.saveThing(newFood);
        resp.sendRedirect("/enterFoodPage.jsp?foodName=" + newFood.getDescription());
    }
}
