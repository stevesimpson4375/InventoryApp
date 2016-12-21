package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveFood extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] foodFields = Food.getFields();
        SimpleDateFormat df = Util.getDateFormat();
        try {
            Food newFood = new Food(req.getParameter(foodFields[0]),
                    Double.parseDouble(req.getParameter(foodFields[1])),
                    df.parse(req.getParameter(foodFields[2])),
                    df.parse(req.getParameter(foodFields[3])),
                    Double.parseDouble(req.getParameter(foodFields[4])),
                    req.getParameter(foodFields[5]));
            Util.datastore.saveThing(newFood);
            resp.sendRedirect("/enterFoodPage.jsp?foodName=" + newFood.getDescription());
        } catch (ParseException ex) {
            Logger.getLogger(CreateAndSaveFood.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
