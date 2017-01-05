package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAndSaveAppliance extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] fields = Appliance.getFields();
        SimpleDateFormat df = Util.getDateFormat();
        try {
            Appliance newAppliance = new Appliance(req.getParameter(fields[0]),
                    Double.parseDouble(req.getParameter(fields[1])),
                    df.parse(req.getParameter(fields[2])),
                    req.getParameter(fields[3]), Double.parseDouble(req.getParameter(fields[4])),
                    req.getParameter(req.getParameter(fields[5])));
            Util.datastore.saveThing(newAppliance);
            resp.sendRedirect("/enterAppliancePage.jsp?applianceName=" + newAppliance.getDescription());
        } catch (ParseException ex) {
            Logger.getLogger(CreateAndSaveAppliance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
