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
import static org.junit.Assert.*;

public class CreateAndSaveApplianceTest {
    
    private static final LocalServiceTestHelper helper
            = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    static Closeable session;

    
    public CreateAndSaveApplianceTest() {
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
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CreateAndSaveAppliance instance = new CreateAndSaveAppliance();
        String[] fields = Appliance.getFields();
        when(request.getParameter(fields[0])).thenReturn("Oster Bread Machine");
        when(request.getParameter(fields[1])).thenReturn("75.00");
        when(request.getParameter(fields[2])).thenReturn("11/27/2016");
        when(request.getParameter(fields[3])).thenReturn("Metal");
        when(request.getParameter(fields[4])).thenReturn("4");
        when(request.getParameter("type")).thenReturn("Bread Machine");

        instance.doPost(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        assertEquals("/enterAppliancePage.jsp?applianceName=Oster Bread Machine",
                captor.getValue());

        Query<InventoryItem> all = Util.datastore.retreiveAll();
        for (InventoryItem q : all) {
            System.out.println(q.toString());
            Util.datastore.deleteEntity(q);
        }
    }  
}