package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

// http://stackoverflow.com/questions/5434419/how-to-test-my-servlet-using-junit
public class CreateAndSaveFoodTest {

    public CreateAndSaveFoodTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of doPost method, of class CreateAndSaveFood.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        CreateAndSaveFood instance = new CreateAndSaveFood();

        when(request.getParameter("foodDescription")).thenReturn("Cheese");
        when(request.getParameter("foodPrice")).thenReturn("4.00");
        when(request.getParameter("purchaseDate")).thenReturn("11/27/2016");
        when(request.getParameter("expireDate")).thenReturn("06/21/2017");
        when(request.getParameter("amount")).thenReturn("16");
        when(request.getParameter("amountType")).thenReturn("ounces");

        instance.doPost(request, response);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(response).sendRedirect(captor.capture());
        assertEquals("/enterFoodPage.jsp?foodName=Cheese", captor.getValue());
    }
}
