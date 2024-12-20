## Library Management System

### Code
```java
import java.util.Scanner;

class CentralLibrary {
    private String[] books = new String[10]; // Array to hold books
    private int numberOfBooksInLibrary = 0; // Counter for number of books

    // Method to add a book to the library
    public void addBook(String bookName) {
        books[numberOfBooksInLibrary++] = bookName;
        System.out.println(bookName + " book is added to Library.");
    }

    // Method to check if a book is available in the library
    public boolean isAvailable(String bookName) {
        for (int i = 0; i < numberOfBooksInLibrary; i++) {
            if (bookName.equals(books[i])) {
                return true;
            }
        }
        return false;
    }

    // Method to issue a book from the library
    public void issueBook(String bookName) {
        if (isAvailable(bookName)) {
            System.out.println(bookName + " is Issued");
            // Remove the book from the list (simplified version)
            for (int i = 0; i < numberOfBooksInLibrary; i++) {
                if (books[i].equals(bookName)) {
                    books[i] = books[--numberOfBooksInLibrary];
                    books[numberOfBooksInLibrary] = null;
                    break;
                }
            }
        } else {
            System.out.println("Book is not Available");
        }
    }

    // Method to return a book to the library
    public void returnBook(String bookName) {
        if (numberOfBooksInLibrary < books.length) {
            books[numberOfBooksInLibrary++] = bookName;
            System.out.println(bookName + " has been returned.");
        } else {
            System.out.println("Library is full, cannot accept more books.");
        }
    }

    // Method to display all available books in the library
    public void showAvailableBooks() {
        System.out.println("Available books in Library are:");
        for (int i = 0; i < numberOfBooksInLibrary; i++) {
            System.out.println("* "+books[i]);
        }
    }
}

public class Library {
    public static void main(String[] args) {
        CentralLibrary manager = new CentralLibrary();
        Scanner sc = new Scanner(System.in);

        while (true) { // Loop to keep the program running until exit
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Available Books");
            System.out.println("3. I want a book");
            System.out.println("4. Want to return issued book");
            System.out.println("5. Exit");
            System.out.print("Enter Operation: ");
            int operation = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            switch (operation) {
                case 1:
                    System.out.print("Enter name of Book to be added: ");
                    String bookName = sc.nextLine();
                    manager.addBook(bookName);
                    break;
                case 2:
                    manager.showAvailableBooks();
                    break;
                case 3:
                    System.out.print("Enter name of book which you want: ");
                    String bookToIssue = sc.nextLine();
                    manager.issueBook(bookToIssue);
                    break;
                case 4:
                    System.out.print("Name of Book to return: ");
                    String bookToReturn = sc.nextLine();
                    manager.returnBook(bookToReturn);
                    break;
                case 5:
                    System.out.println("Exiting the Library.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
```
