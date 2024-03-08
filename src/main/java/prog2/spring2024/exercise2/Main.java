package prog2.spring2024.exercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Welcome to Turn-A-New-Leaf-----------");
        System.out.println("Please enter your firstName lastName emailAddress separated by ;");
        while (true) {
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            String[] arrayList = choice.split(";");
            if (arrayList.length != 3) {
                System.out.println("The input format is wrong! please enter again!");
            } else {
                BookStore bookStore = new BookStore(arrayList[0], arrayList[1], arrayList[2]);
                System.out.println("-The following is a list of books in our store-");
                System.out.println("bookID;bookName;bookAuthor;bookPages;bookGenre;bookRating;bookPublishedYear;bookPublisher;bookPrice (€)");
                for (BookStore.BookDetails book : BookStore.BookDetails.values()) {
                    System.out.println(book.getBookID() + ";" + book.getBookName() + ";" + book.getBookAuthor() + ";" + book.getBookPages() + ";"
                            + book.getBookGenre() + ";" + book.getBookRating() + ";" + book.getBookPublishedYear() + ";" + book.getBookPublisher() + ";"
                            + book.getBookPrice()
                    );
                }
                System.out.println("Please enter the name of the book you are interested in bookID");
                while (true) {
                    Scanner input3 = new Scanner(System.in);
                    String choice3 = input3.next();  //nextInt只能录入一个数字，
                    if (bookStore.searchBook(choice3) != null) {
                        System.out.println("If you want to rent a book please enter: 1");
                        System.out.println("If you want to buy this book please enter: 2");
                        System.out.println("If you want to exit the system please enter :3");
                        while (true) {
                            Scanner input2 = new Scanner(System.in);
                            int choice2 = input2.nextInt();
                            if (choice2 > 3) {
                                System.out.println("Please re-enter.");
                            } else {
                                while (true) {
                                    BookStore.BookDetails bookDetails = bookStore.searchBook(choice3);
                                    bookStore.setTransactionAmount(bookDetails.getBookPrice());
                                    bookStore.setOrderedBook(bookDetails.getBookName());
                                    bookStore.setOrderID("TANLOD" + LocalDate.now() + bookDetails.getBookName().toUpperCase().substring(0, 3));
                                    bookStore.orderBook(choice2);
                                    bookStore.orderConfirmation();
                                    System.exit(0);  //停止虚拟机运行
                                }
                            }
                        }
                    } else {
                        System.out.println("The book does not exist. Please re-enter.");
                    }
                }

            }
        }

    }
}
