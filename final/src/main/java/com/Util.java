package com;

import com.google.appengine.api.datastore.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.cmd.Query;
import java.util.ArrayList;
import java.util.List;

public class Util {

    /* The datastore class contains everything needed for working with Google's
        Ojectify */
    public static class datastore {

        public static void saveThing(InventoryItem thing) {
            ofy().save().entity(thing);
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
        
        public static ArrayList<String> retrieveDescriptions(){
            
            Query<InventoryItem> results = retreiveAll();
            ArrayList<String> items = new ArrayList<>();
                for (InventoryItem i : results) { items.add(i.toString());}
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
        
        public static void deleteById(Long id){
            ofy().delete().type(InventoryItem.class).id(id).now();
        }
        
        /* The searches used by the ap are all found here */
        public static class search{
            
            /* The search type is determined by the attribute selected by the
                user in the browser. The searchTypeResolver accesses the 
                appropriate search method. */
            public static InventoryItem[] searchTypeResolver(String searchBy, 
                    String searchValue){
            InventoryItem[] results;
                switch(searchBy){
                    case "Description":
                        results = byDescription(searchValue);
                        break;
                    case "Price":
                        results = byPrice(Double.parseDouble(searchValue));
                        break;
                    default:
                        results =  new InventoryItem[1];
                }
                return results;
            }
            
            
            /* The searches return arrays since List types require a function
                to access fields, which browsers cannot use */
            
            public static InventoryItem[] byDescription(String description){                
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                        .filter("description", description).list();
                InventoryItem[] results = new InventoryItem[temp.size()];
                    for(int i = 0; i < temp.size(); i++){
                        results[i] = temp.get(i);
                    }
                return results;
            }
            
            public static InventoryItem[] byPrice(double price){
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                        .filter("price", price).list();
                InventoryItem[] results = new InventoryItem[temp.size()];
                    for(int i = 0; i < temp.size(); i++){
                        results[i] = temp.get(i);
                    }
                    return results;
            }
            
            public static ArrayList<InventoryItem> byPurchaseDate(String date){
                    List<InventoryItem> temp = ofy().load().type(InventoryItem.class)
                            .filter("purchaseDate", date).list();
                    ArrayList<InventoryItem> results = new ArrayList<>(temp.size());
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
