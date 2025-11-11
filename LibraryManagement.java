import java.util.*;

// Book class to store basic info
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return String.format("%-5d | %-20s | %-15s | %-10s",
                id, title, author, (isIssued ? "Issued" : "Available"));
    }
}

// Library class using HashMap + ArrayList (DSA-based)
class Library {
    HashMap<Integer, Book> books = new HashMap<>();

    // Add new book
    void addBook(Book b) {
        if (books.containsKey(b.id)) {
            System.out.println("[ERROR] Book with ID " + b.id + " already exists!");
            return;
        }
        books.put(b.id, b);
        System.out.println("[OK] Book added successfully.");
    }

    // Remove book by ID
    void removeBook(int id) {
        if (books.remove(id) != null) {
            System.out.println("[OK] Book removed successfully.");
        } else {
            System.out.println("[ERROR] Book not found.");
        }
    }

    // Search book by title
    void searchBook(String title) {
        boolean found = false;
        for (Book b : books.values()) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("[INFO] No book found with that title.");
    }

    // Issue a book
    void issueBook(int id) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("[ERROR] Invalid Book ID.");
            return;
        }
        if (b.isIssued) {
            System.out.println("[WARN] Book already issued.");
        } else {
            b.isIssued = true;
            System.out.println("[OK] Book issued successfully.");
        }
    }

    // Return a book
    void returnBook(int id) {
        Book b = books.get(id);
        if (b == null) {
            System.out.println("[ERROR] Invalid Book ID.");
            return;
        }
        if (!b.isIssued) {
            System.out.println("[WARN] This book was not issued.");
        } else {
            b.isIssued = false;
            System.out.println("[OK] Book returned successfully.");
        }
    }

    // Display all books sorted by title
    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("[INFO] No books available in the library.");
            return;
        }
        ArrayList<Book> list = new ArrayList<>(books.values());
        bubbleSortByTitle(list);
        System.out.println();
        System.out.println("ID    | Title                | Author          | Status");
        System.out.println("------------------------------------------------------------");
        for (Book b : list) System.out.println(b);
    }

    // Bubble Sort implementation for sorting by title
    void bubbleSortByTitle(ArrayList<Book> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).title.compareToIgnoreCase(list.get(j + 1).title) > 0) {
                    Book temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}

// Main class with CLI Menu
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        while (true) {
            System.out.println();
            System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR!! Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        lib.addBook(new Book(id, title, author));
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR!! Invalid ID. Operation cancelled.");
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("Enter Book ID to remove: ");
                        int id = Integer.parseInt(sc.nextLine());
                        lib.removeBook(id);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR!! Invalid ID.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Title to search: ");
                    String title = sc.nextLine();
                    lib.searchBook(title);
                }
                case 4 -> {
                    try {
                        System.out.print("Enter Book ID to issue: ");
                        int id = Integer.parseInt(sc.nextLine());
                        lib.issueBook(id);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR!! Invalid ID.");
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Enter Book ID to return: ");
                        int id = Integer.parseInt(sc.nextLine());
                        lib.returnBook(id);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR!! Invalid ID.");
                    }
                }
                case 6 -> lib.displayBooks();
                case 7 -> {
                    System.out.println("Exiting. Goodbye.");
                    sc.close();
                    return;
                }
                default -> System.out.println("ERROR!! Invalid choice. Try again.");
            }
        }
    }
}
