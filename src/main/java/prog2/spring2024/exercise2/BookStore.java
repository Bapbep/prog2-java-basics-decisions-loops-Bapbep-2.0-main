package prog2.spring2024.exercise2;

import java.time.LocalDate;
import java.util.*;

/**
 * Hello world!
 *
 */
public class BookStore 
{
    private String orderedBook;
    private Date orderDate;
    private String orderID;
    private Double transactionAmount;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userID;
    private String orderType;

    public BookStore(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getOrderedBook() {
        return orderedBook;
    }

    public void setOrderedBook(String orderedBook) {
        this.orderedBook = orderedBook;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = "TANLUS" + (getFirstName() + getLastName()).toUpperCase().substring(0,5);
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BookDetails searchBook(String id) {
        for (BookDetails book : BookDetails.values()) {
            if (id.equals(book.getBookID())) {
                return book;
            }
        }
        return null;
    }

    public void orderBook(int id) {

        switch (id) {
            case (1) :
                System.out.println("You have chosen to rent this book and the rental is for one month only and you will be charged €5 for that period.\n" +
                        "After one month, you will no longer be able to use the book.");
                this.setTransactionAmount(5.0);
                this.setOrderType("Renting");
                this.setUserID();
                break;
            case (2) :
                System.out.println("You have successfully purchased the book and the price of the book will be deducted from your account");
                this.setOrderType("Purchase");
                this.setUserID();
                break;
            case (3) :
                System.out.println("quit");
                System.exit(0);  //停止虚拟机运行
                break;
            default :
                System.out.println("There is no such option");
        }
    }

    public void orderConfirmation() {
        String expectedOutput = "Dear," + firstName + lastName + "," + System.lineSeparator() +
                "Thank you for ordering " + orderedBook + " from Turn-A-New-Leaf. Following are your details" + System.lineSeparator() +
                "Order ID: " + orderID + System.lineSeparator() +
                "Order Date: " + LocalDate.now() + System.lineSeparator() +
                "User ID: " + userID + System.lineSeparator() +
                "User contact: "  + emailAddress + System.lineSeparator() +
                "Transaction type: "  + orderType + System.lineSeparator() +
                "Transaction amount: "  + transactionAmount + System.lineSeparator();
        System.out.println(expectedOutput);
    }

    public enum BookDetails {
        // TANL01;Carrie;Stephen King;272;Horror;3,98;Wings;1974;14
        TANL01("001", "Carrie", "Stephen King", 272, "Horror", 3.98, 1974, "Wings", 14.0, 5.0),
        // TANL02;The Firm;Robin Waterfield / John Grisham;448;Thriller;4,01;Addison Wesley Publishing Company;1991;25
        TANL02("002", "The Firm", "Robin Waterfield / John Grisham", 448, "Thriller", 4.01, 1991, "Addison Wesley Publishing Company", 25.0, 5.0),
        // TANL03;Slaughterhouse-Five;Kurt Vonnegut Jr.;275;Sci-Fi;4,1;Dial Press;1969;18
        TANL03("003", "Slaughterhouse-Five", "Kurt Vonnegut Jr.", 275, "Sci-Fi", 4.1, 1969, "Dial Press", 18.0, 5.0),
        // TANL04;The Great Gatsby;F. Scott Fitzgerald;188;Classic;3,91;Scribner;1925;8
        TANL04("004", "The Great Gatsby", "F. Scott Fitzgerald", 188, "Classic", 3.91, 1925, "Scribner", 8.0, 5.0),
        // TANL05;American Gods;Neil Gaiman;635;Fantasy;4,11;Harper Collins;2001;4,11
        TANL05("005", "American Gods", "Neil Gaiman", 635, "Fantasy", 4.11, 2001, "Harper Collins", 4.11, 5.0),
        ;


        private String bookID;
        private String bookName;
        private String bookAuthor;
        private Integer bookPages;
        private String bookGenre;
        private Double bookRating;
        private Integer bookPublishedYear;
        private String bookPublisher;
        private Double bookPrice;
        private Double bookRent = 5.0;

        private BookDetails(String bookID, String bookName, String bookAuthor, Integer bookPages, String bookGenre, Double bookRating, Integer bookPublishedYear, String bookPublisher, Double bookPrice, Double bookRent) {
            this.bookID = bookID;
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookPages = bookPages;
            this.bookGenre = bookGenre;
            this.bookRating = bookRating;
            this.bookPublishedYear = bookPublishedYear;
            this.bookPublisher = bookPublisher;
            this.bookPrice = bookPrice;
            this.bookRent = bookRent;
        }

        public String getBookID() {
            return bookID;
        }

        public void setBookID(String bookID) {
            this.bookID = bookID;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public Integer getBookPages() {
            return bookPages;
        }

        public void setBookPages(Integer bookPages) {
            this.bookPages = bookPages;
        }

        public String getBookGenre() {
            return bookGenre;
        }

        public void setBookGenre(String bookGenre) {
            this.bookGenre = bookGenre;
        }

        public Double getBookRating() {
            return bookRating;
        }

        public void setBookRating(Double bookRating) {
            this.bookRating = bookRating;
        }

        public Integer getBookPublishedYear() {
            return bookPublishedYear;
        }

        public void setBookPublishedYear(Integer bookPublishedYear) {
            this.bookPublishedYear = bookPublishedYear;
        }

        public String getBookPublisher() {
            return bookPublisher;
        }

        public void setBookPublisher(String bookPublisher) {
            this.bookPublisher = bookPublisher;
        }

        public Double getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(Double bookPrice) {
            this.bookPrice = bookPrice;
        }

    }

}
