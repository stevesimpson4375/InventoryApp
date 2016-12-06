package com;

import com.google.appengine.api.datastore.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.cmd.Query;
import java.util.ArrayList;
import java.util.List;

public class Util {

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
        
        public static class search{
            
            public static ArrayList<InventoryItem> byDescription(String description){                
                List<InventoryItem> temp = ofy().load().type(InventoryItem.class).filter(
                        "description", description).list();
                ArrayList<InventoryItem> results = new ArrayList<>(temp.size());
                    results.addAll(temp);
                return results;
            }
        }
    }

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
