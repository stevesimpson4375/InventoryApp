package com;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveAppliance extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] fields = Appliance.getFields();
        Appliance newAppliance = new Appliance(req.getParameter(fields[0]),
                Double.parseDouble(req.getParameter(fields[1])), req.getParameter(fields[2]),
                req.getParameter(fields[3]), Double.parseDouble(req.getParameter(fields[4])),
                req.getParameter("type"));
        Util.datastore.saveThing(newAppliance);
        resp.sendRedirect("/enterAppliancePage.jsp?applianceName=" + newAppliance.getDescription());
    }
}