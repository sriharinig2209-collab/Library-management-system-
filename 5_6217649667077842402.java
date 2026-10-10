import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title, author, category;
    boolean available = true;

    Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    void display() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Available: " + available);
        System.out.println("-------------------");
    }
}

public class Main {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- LIBRARY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Search by Category");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Display Available Books");
            System.out.println("9. Display Issued Books");
            System.out.println("10. Remove Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    books.add(new Book(id, title, author, category));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    for (Book b : books) {
                        b.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter title: ");
                    String t = sc.nextLine();

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(t)) {
                            b.display();
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter author: ");
                    String a = sc.nextLine();

                    for (Book b : books) {
                        if (b.author.equalsIgnoreCase(a)) {
                            b.display();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String c = sc.nextLine();

                    for (Book b : books) {
                        if (b.category.equalsIgnoreCase(c)) {
                            b.display();
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter Book ID to issue: ");
                    id = sc.nextInt();

                    boolean found = false;

                    for (Book b : books) {
                        if (b.id == id) {
                            found = true;

                            if (b.available) {
                                b.available = false;
                                System.out.println("Book issued successfully!");
                            } else {
                                System.out.println("Book is already issued.");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 7:
                    System.out.print("Enter Book ID to return: ");
                    id = sc.nextInt();

                    found = false;

                    for (Book b : books) {
                        if (b.id == id) {
                            found = true;

                            if (!b.available) {
                                b.available = true;
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("Book was not issued.");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 8:
                    for (Book b : books) {
                        if (b.available) {
                            b.display();
                        }
                    }
                    break;

                case 9:
                    for (Book b : books) {
                        if (!b.available) {
                            b.display();
                        }
                    }
                    break;

                case 10:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();

                    boolean removed = books.removeIf(b -> b.id == id);

                    if (removed) {
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}