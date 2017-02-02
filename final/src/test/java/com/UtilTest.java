package com;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import java.io.Closeable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
    
    private static final LocalServiceTestHelper helper
        = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    static Closeable session;
    
    public UtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        session = ObjectifyService.begin();
        Util.setup.classRegister();
        helper.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() throws IOException {
        session.close();
        helper.tearDown();
    }

    @Test
    public void testSaveThing() throws InterruptedException {
        Util.datastore.saveThing(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait()); // Saving to the datastore is not always instant
        InventoryItem[] results = Util.datastore.search.byDescription(TestUtilities.
                createFood().getDescription());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testSaveFood() throws InterruptedException{
        Util.datastore.saveFood(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait()); // Saving to the datastore is not always instant
        InventoryItem[] results = Util.datastore.search.byDescription(TestUtilities.
                createFood().getDescription());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testRetrieveAll(){
    }
    
    @Test
    public void testRetrieveAllArrayList(){
    }
    
    @Test
    public void testRetreiveDescriptions(){
    }
    
    @Test
    public void testDeleteAll(){
    }
    
    @Test
    public void testDeleteEntity(){
    }
    
    @Test
    public void testDeleteById(){
    }
    
    // Search Tests
    @Test
    public void searchTypeResolver(){
    }
    
    @Test
    public void testByDescription() throws InterruptedException{
        
        Util.datastore.saveThing(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait()); // Saving to the datastore is not always instant
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(
                "Description", TestUtilities.createFood().getDescription());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        
        // The case insensitive search is also checked
        InventoryItem[] resultsCaseInsensitive = Util.datastore.search.searchTypeResolver(
                "Description", TestUtilities.createFood().getDescription().toLowerCase());
        assertEquals(resultsCaseInsensitive[0].toString(), TestUtilities.createFood().toString());
        
        // The partial search is also checked
        InventoryItem[] resultsPartial = Util.datastore.search.searchTypeResolver(
                "Description", TestUtilities.createFood().getDescription().toLowerCase().substring(0,3)); 
        assertEquals(resultsPartial[0].toString(), TestUtilities.createFood().toString());
        
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testByPrice() throws InterruptedException{
        Util.datastore.saveThing(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait());
        InventoryItem[] results = Util.datastore.search.searchTypeResolver("Price",
                TestUtilities.createFood().getPrice().toString());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testByPurchaseDate() throws InterruptedException{
        Util.datastore.saveThing(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait());
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(
                "Purchase Date", TestUtilities.createFood().getPurchaseDate());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testByEpireDate() throws InterruptedException{
        Util.datastore.saveFood(TestUtilities.createFood());
        Thread.sleep(TestUtilities.getThreadWait());
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(
                "Expiration Date", TestUtilities.createFood().
                        getExpireDate());
        assertEquals(results[0].toString(), TestUtilities.createFood().toString());
        Util.datastore.deleteAll();
    }
    
    @Test
    public void testByApplianceType() throws InterruptedException{
        Util.datastore.saveThing(TestUtilities.createAppliance());
        Thread.sleep(TestUtilities.getThreadWait());
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(
                "Appliance Type", TestUtilities.createAppliance().getType());
        assertEquals(results[0].toString(), TestUtilities.createAppliance().toString());
    }
    
    @Test
    public void testByHouseHoldType() throws InterruptedException{
        Util.datastore.saveThing(TestUtilities.createHouseHoldProduct());
        Thread.sleep(TestUtilities.getThreadWait());
        InventoryItem[] results = Util.datastore.search.searchTypeResolver(
                "Household Product Type", TestUtilities.createHouseHoldProduct()
                        .getType());
        assertEquals(results[0].toString(), TestUtilities.createHouseHoldProduct().toString());
    }
}
