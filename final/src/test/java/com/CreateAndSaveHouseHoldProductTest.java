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
        when(request.getParameter(fields[0])).thenReturn("Irish Spring");
        when(request.getParameter(fields[1])).thenReturn("1");
        when(request.getParameter(fields[2])).thenReturn("11/27/2016");
        when(request.getParameter(fields[3])).thenReturn("1");
        when(request.getParameter(fields[4])).thenReturn("Each");
        when(request.getParameter("type")).thenReturn("Soap");

        instance.doPost(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        assertEquals("/enterHouseHoldProductsPage.jsp?productName=Irish Spring", captor.getValue());

        Query<InventoryItem> all = Util.datastore.retreiveAll();
        for (InventoryItem q : all) {
            System.out.println(q.toString());
            Util.datastore.deleteEntity(q);
        }

    }
}