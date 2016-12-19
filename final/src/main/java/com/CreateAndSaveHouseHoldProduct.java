package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveHouseHoldProduct extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] fields = HouseHoldProduct.getFields();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            HouseHoldProduct newProduct = new HouseHoldProduct(req.getParameter(fields[0]),
                    Double.parseDouble(req.getParameter(fields[1])),
                    df.parse(req.getParameter(fields[2])),
                    Double.parseDouble(req.getParameter(fields[3])),
                    req.getParameter(fields[4]), req.getParameter("type"));
            Util.datastore.saveThing(newProduct);
            resp.sendRedirect("/enterHouseHoldProductsPage.jsp?productName=" + newProduct.getDescription());
        } catch (ParseException ex) {
            Logger.getLogger(CreateAndSaveHouseHoldProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
