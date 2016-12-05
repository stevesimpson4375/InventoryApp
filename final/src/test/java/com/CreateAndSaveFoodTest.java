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

// http://stackoverflow.com/questions/5434419/how-to-test-my-servlet-using-junit
public class CreateAndSaveFoodTest {

    private static final LocalServiceTestHelper helper
            = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    static Closeable session;

    public CreateAndSaveFoodTest() {
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
        CreateAndSaveFood instance = new CreateAndSaveFood();
        String[] fields = Food.getFields();
        when(request.getParameter(fields[0])).thenReturn("Cheese");
        when(request.getParameter(fields[1])).thenReturn("4.00");
        when(request.getParameter(fields[2])).thenReturn("11/27/2016");
        when(request.getParameter(fields[3])).thenReturn("06/21/2017");
        when(request.getParameter(fields[4])).thenReturn("16");
        when(request.getParameter(fields[5])).thenReturn("ounces");

        instance.doPost(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        assertEquals("/enterFoodPage.jsp?foodName=Cheese", captor.getValue());

        Query<InventoryItem> all = Util.datastore.retreiveAll();
        ArrayList<InventoryItem> it = new ArrayList<>();
        for (InventoryItem q : all) {
            System.out.println(q.toString());
            it.add(q);
            Util.datastore.deleteEntity(q);
        }
        
        for (InventoryItem w : it) {
            System.out.println(w.toString());
        }

        ofy().clear();
    }
}
