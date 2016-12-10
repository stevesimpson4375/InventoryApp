package com;

import com.googlecode.objectify.ObjectifyService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.cmd.Query;
import java.io.Closeable;
import java.io.IOException;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import java.util.ArrayList;

public class CreateAndSaveHouseHoldProductTest {

    private static final LocalServiceTestHelper helper
            = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    static Closeable session;

    public CreateAndSaveHouseHoldProductTest() {
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

    /**
     * Test of doPost method, of class CreateAndSaveHouseHoldProduct.
     * @throws java.lang.Exception
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CreateAndSaveHouseHoldProduct instance = new CreateAndSaveHouseHoldProduct();
        String[] fields = HouseHoldProduct.getFields();
        String [] attributes = testUtil.getHouseHoldProductAttributes();
        when(request.getParameter(fields[0])).thenReturn(attributes[0]);
        when(request.getParameter(fields[1])).thenReturn(attributes[1]);
        when(request.getParameter(fields[2])).thenReturn(attributes[2]);
        when(request.getParameter(fields[3])).thenReturn(attributes[3]);
        when(request.getParameter(fields[4])).thenReturn(attributes[4]);
        when(request.getParameter("type")).thenReturn(attributes[5]);

        instance.doPost(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        assertEquals("/enterHouseHoldProductsPage.jsp?productName=" + 
                attributes[0], captor.getValue());

        ArrayList<InventoryItem> results = Util.datastore.search.byDescription(attributes[0]);
        System.out.println(results.size()); // This confirms that the item was saved and retrieved
        
        // This boolean and for() confirms that the found object matches expectations
        boolean found = false;
        for(InventoryItem i: results){
            if(i.getDescription().equals(attributes[0])){
                found = true;
            }           
        }
        assertEquals(true, found);
    }
}