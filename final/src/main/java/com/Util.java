package com;

import com.google.appengine.api.datastore.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.cmd.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    
    public static SimpleDateFormat getDateFormat(){
        return new SimpleDateFormat("MM/dd/yyyy");
    }
    
    public static String[] getValidApplianceTypes(){
        return new String[] {"Air Conditioner", "Air Fryer", "Bread Machine", "Clothes Dryer",
            "Coffee Maker", "Dish Washer", "Deep Fryer", "Espresso Machine", "Freezer",
            "Garbage Disposal", "Microwave", "Oven", "Refridgerator", "Sewing Machine",
            "Sump Pump", "Toaster", "Washing Machine", "Water Heater"};
    }
    
    public static String[] getValidProductTypes() {
        return new String[] { "Dish Soap", "Dryer Sheets", "Hand Soap", "Laundry Soap",
            "Paper Towels", "Soap", "Straws", "Toilet Paper"};
    }
    
    public static String[] getExampleFoods() {
        return new String[] { "", "Apples", "Bacon", "Cheese", "Red Baron Pizza, Pepperoni"};
    }
    
    public static String[] getExampleHouseHoldProducts() {
        return new String[] {"", "Ultra Palmolive Original"};
    }
    
    public static String[] getExampleAppliances() {
        return new String[] {"", "Farberware Oil-Less Fryer", "Bread Machine", "Coffee Maker"};
    }

    /* The datastore class contains everything needed for working with Google's
        Ojectify */
    public static class datastore {

        public static void saveThing(InventoryItem thing) {
            ofy().save().entity(thing);
        }
        
        public static void saveFood(Food food){
            ofy().save().entity(food);
        }

        public static Query<InventoryItem> retreiveAll() {
            Query<InventoryItem> all;
            all = ofy().load().type(InventoryItem.class);
            return all;
        }

        public static ArrayList<InventoryItem> retreiveAllArrayList() {
            Query<InventoryItem> all = ofy().load().type(InventoryItem.class);
            ArrayList<InventoryItem> itemList = new ArrayList<>();
            for (InventoryItem i : all) {
                itemList.add(i);
            }
            return itemList;
        }

        public static ArrayList<String> retrieveDescriptions() {

            Query<InventoryItem> results = retreiveAll();
            ArrayList<String> items = new ArrayList<>();
            for (InventoryItem i : results) {
                items.add(i.toString());
            }
            return items;
        }

        public static void deleteAll() {
            Query<InventoryItem> all = retreiveAll();

            for (InventoryItem q : all) {
                ofy().delete().entity(q).now();
            }
        }

        public static void deleteEntity(InventoryItem item) {
            ofy().delete().entity(item).now();
        }

        public static void deleteById(Long id) {
            ofy().delete().type(InventoryItem.class).id(id).now();
        }

        /* The searches used by the app are all found here */
        public static class search {

            /* The search type is determined by the attribute selected by the
                user in the browser. The searchTypeResolver accesses the 
                appropriate search method. */
            public static InventoryItem[] searchTypeResolver(String searchBy,
                    String searchValue) {
                InventoryItem[] results;
                SimpleDateFormat df = Util.getDateFormat();
                switch (searchBy) {
                    case "Description":
                        results = byDescription(searchValue);
                        break;
                    case "Price":
                        results = byPrice(Double.parseDouble(searchValue));
                        break;
                    case "Purchase Date":                                         
                            try {
                                results = byPurchaseDate(df.parse(searchValue));
                            } catch (ParseException ex) {
                                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                                results = new InventoryItem[1];
                            }

                        break;
                    case "Expiration Date":                      
                            try {
                                results = byExpireDate(df.parse(searchValue));
                            } catch (ParseException ex) {
                                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                                results = new InventoryItem[1];
                            }

                        break;
                    case "Appliance Type":                        
                            results = byApplianceType(searchValue);                      
                        break;
                        
                    case "Household Product Type":                        
                            results = byApplianceType(searchValue);                      
                        break;

                    default:
                        results = new InventoryItem[1];
                }
                return results;
            }

            /* The searches return arrays since List types require a function
                to access fields, which more complex in browsers */
            public static InventoryItem[] byDescription(String description) {
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                        .filter("description", description).list();
                InventoryItem[] results = new InventoryItem[temp.size()];
                for (int i = 0; i < temp.size(); i++) {
                    results[i] = temp.get(i);
                }
                
                /* If nothing is found and the user entered a resonable amount
                of characters, a search for contains occurs */
                
                if(results.length == 0 && description.length() > 2) {
                    ArrayList<InventoryItem> found = new ArrayList<>();
                    Query<InventoryItem> all = retreiveAll();
                    
                    for(InventoryItem i : all){
                        if(i.getDescription().contains(description)){
                            found.add(i);
                        }
                    }
                    
                    if (!found.isEmpty()) {
                        InventoryItem[] results2 = new InventoryItem[found.size()];
                        for (int i = 0; i < found.size(); i++) {
                            results2[i] = found.get(i);
                        }
                        return results2;
                    }
                }
                
                return results;
            }

            public static InventoryItem[] byPrice(double price) {
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                        .filter("price", price).list();
                InventoryItem[] results = new InventoryItem[temp.size()];
                for (int i = 0; i < temp.size(); i++) {
                    results[i] = temp.get(i);
                }
                return results;
            }

            public static InventoryItem[] byPurchaseDate(Date date) {
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                        .filter("purchaseDate", date).list();
                InventoryItem[] results = new InventoryItem[temp.size()];
                for (int i = 0; i < results.length; i++) {
                    results[i] = temp.get(i);
                }
                return results;
            }
            
            // Food only searches
            public static Food[] byExpireDate(Date date){
                List<Food> temp = ofy().load().type(Food.class).filter(
                        "expireDate", date).list();
                Food[] results = new Food[temp.size()];
                for(int i = 0; i < results.length; i++){
                    results[i] = temp.get(i);
                }
                return results;
            }
            
            // Appliance only searches
            public static Appliance[] byApplianceType(String type){
                List<Appliance> temp = ofy().load().type(Appliance.class).filter(
                    "type", type).list();
                Appliance[] results = new Appliance[temp.size()];
                for(int i = 0; i < results.length; i++){
                    results[i] = temp.get(i);
                }
                return results;
            }
            
            // House Hold Products searches
            public static HouseHoldProduct[] byHouseHoldProductType(String type){
                List<HouseHoldProduct> temp = ofy().load().type(HouseHoldProduct.
                        class).filter(
                    "type", type).list();
                HouseHoldProduct[] results = new HouseHoldProduct[temp.size()];
                for(int i = 0; i < results.length; i++){
                    results[i] = temp.get(i);
                }
                return results;
            }
        }
    }

    // This class registers the DAO classes with Objectify
    public static class setup {

        public static void classRegister() {
            ObjectifyService.register(InventoryItem.class);
            ObjectifyService.register(Durable.class);
            ObjectifyService.register(Consumable.class);
            ObjectifyService.register(Appliance.class);
            ObjectifyService.register(HouseHoldProduct.class);
            ObjectifyService.register(Food.class);
        }
    }
}
