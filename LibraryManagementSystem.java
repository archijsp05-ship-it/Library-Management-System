import java.util.*;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Add sample books
        library.addBook(new Book(101, "Java Programming", "James Gosling"));
        library.addBook(new Book(102, "Python Basics", "Guido van Rossum"));
        library.addBook(new Book(103, "Data Structures", "Mark Allen"));

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    library.issueBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    library.searchBook(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

class Book {

    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }
}

class Library {

    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        for (Book b : books) {
            System.out.println(b.id + " | " + b.title + " | " + b.author +
                    " | " + (b.issued ? "Issued" : "Available"));
        }
    }

    void issueBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book Issued Successfully.");
                } else {
                    System.out.println("Book Already Issued.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id) {
                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book Returned Successfully.");
                } else {
                    System.out.println("Book Was Not Issued.");
                }
                return;
            }
        }
        System.out.println("Book Not Found.");
    }

    void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + b.id + " | " + b.title + " | " + b.author);
                return;
            }
        }
        System.out.println("Book Not Found.");
    }
}