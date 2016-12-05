package com;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveHouseHoldProduct extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] fields = HouseHoldProduct.getFields();
        HouseHoldProduct newProduct = new HouseHoldProduct(req.getParameter(fields[0]),
                Double.parseDouble(req.getParameter(fields[1])), req.getParameter(fields[2]),
                Double.parseDouble(req.getParameter(fields[3])),
                req.getParameter(fields[4]), req.getParameter("type"));
        Util.datastore.saveThing(newProduct);
        resp.sendRedirect("/enterHouseHoldProductsPage.jsp?productName=" + newProduct.getDescription());
    }
}