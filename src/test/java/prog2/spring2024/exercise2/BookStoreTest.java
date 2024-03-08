package prog2.spring2024.exercise2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import prog2.spring2024.exercise2.BookStore.BookDetails;
import java.util.Random;

public class BookStoreTest 
{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    public void testOrderConfirmation() {
        BookStore store = new BookStore("Hank", "Azaria", "hankazaria@me.com");
        
        store.setUserID();
        String id = "004";
        store.orderBook(2);
        String orderedBook = "";

        /* for (BookDetails book : BookDetails.values()) {
            if (id.equals(book.getBookID())) {
                orderedBook = book.getBookName();
            } 
        } */

        String orderID = "TANLOD" + LocalDate.now() + "THE";
        store.searchBook(id);
        store.orderConfirmation();
        
        for (BookDetails book : BookDetails.values()) {
            if (id.equals(book.getBookID())) {
                orderedBook = book.getBookName();
            } 
        }

        String expectedOutput = "Dear, Hank Azaria," + System.lineSeparator() +
                                "Thank you for ordering " + orderedBook + " from Turn-A-New-Leaf. Following are your details" + System.lineSeparator() +
                                "Order ID: " + orderID + System.lineSeparator() +
                                "Order Date: " + LocalDate.now() + System.lineSeparator() +
                                "User ID: " + store.getUserID() + System.lineSeparator() +
                                "User contact: hankazaria@me.com" + System.lineSeparator() +
                                "Transaction type: Purchase" + System.lineSeparator() +
                                "Transaction amount: €18.0" + System.lineSeparator();

        
        assertTrue("Output should contain the book name 'The Great Gatsby'", expectedOutput.toString().contains("The Great Gatsby"));
        assertTrue("Output should contain the user ID 'TANLUSHANKA'", expectedOutput.toString().contains("TANLUSHANKA"));
        
    }
    
    @Test
    public void testRandomBookDetail() {
        
        BookStore.BookDetails[] books = BookStore.BookDetails.values();
        
        int randomIndex = new Random().nextInt(books.length);
        
        BookStore.BookDetails randomBook = books[randomIndex];
        
        assertNotNull(randomBook.getBookID(), "Book ID should not be null");
        
        assertNotNull(randomBook.getBookName(), "Book Name should not be null");
        
        assertNotNull(randomBook.getBookAuthor(), "Book Author should not be null");
        
    }

     @Test
     public void testEnumConstantsCount() {
        assertEquals("There should be exactly 5 enum constants in BookDetails.", 5, BookStore.BookDetails.values().length);
    }

    @Test
    public void testBookStoreConstructor() {
        BookStore store = new BookStore("John", "Doe", "john.doe@example.com");
        assertEquals("John", store.getFirstName());
        assertEquals("Doe", store.getLastName());
        assertEquals("john.doe@example.com", store.getEmailAddress());
    }

    @Test
    public void testGetBookName() {
        String id = "002";
        for (BookDetails book : BookDetails.values()) {
            if (id.equals(book.getBookID())) {
                assertEquals("The Firm", book.getBookName());
            } 
        }
    }

}
