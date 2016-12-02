package com;

import com.google.appengine.api.datastore.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.cmd.Query;

public class Util {
    
    
    public static void saveThing(InventoryItem thing){
        ofy().save().entity(thing);   
    }
    
    public static Query<InventoryItem> retreiveAll() {
        Query<InventoryItem> all;
        all = ofy().load().type(InventoryItem.class);
        return all;
    }
}
