package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtilities {
    
    private static int threadWait = 3000;

    public static int getThreadWait() {
        return threadWait;
    }
    
    public static String[] getFoodAttributes(){
        String[] attributes = { "Cheese", "4.00", "2016-11-27",
            "2017-06-21", "16", "ounces" };
        return attributes;
    }
    
    public static String[] getHouseHoldProductAttributes(){
        String[] attributes = { "Irish Spring", "1", "2016-11-27", "1", "Each",
        "Soap"};
        return attributes;
    }
    
    public static String[] getApplianceAttributes(){
        String[] attributes = { "Oster Bread Machine", "75.00", "2016-11-27",
            "Metal", "4", "Bread Machine" };
        return attributes;
    }
    
    public static Food createFood(){
        String[] attributes = getFoodAttributes();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Food food;
        try {
            return new Food(attributes[0], Double.parseDouble(attributes[1]),
                    df.parse(attributes[2]), df.parse(attributes[3]),
                    Double.parseDouble(attributes[4]), attributes[5]);
        } catch (ParseException ex) {
            Logger.getLogger(TestUtilities.class.getName()).log(Level.SEVERE, null, ex);
            food = new Food();
        }
        return food;
    }
    
    public static Appliance createAppliance(){
        String[] attributes = getApplianceAttributes();
        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
        Appliance appliance;
        try {
            return new Appliance(attributes[0], Double.parseDouble(attributes[1]),
                    df.parse(attributes[2]), attributes[3],
                    Double.parseDouble(attributes[4]), attributes[5]);
        } catch (ParseException ex) {
            Logger.getLogger(TestUtilities.class.getName()).log(Level.SEVERE, null, ex);
            appliance = new Appliance();
        }
        
        return appliance;
    }
}
        
