package com.pluralsight.library;

import java.util.Scanner;
import java.util.ArrayList;

public class NeighborhoodLibraryApp {
    public static Scanner scanner = null;

    static ArrayList<Book> books = new ArrayList<>();

    static boolean isRunning;

    public static void main(String[] arg) {
        launchLibrary();
        scanner = new Scanner(System.in);

        showStoreHomeScreen();
    }

    private static void launchLibrary() {
    }

    public static void runLibrary(){
        books.add(new Book(1, "12345", "The Hunger Games", false, ""));
        books.add(new Book(2, "67890", "Catching Fire", false, ""));
        books.add(new Book(3, "23456\n", "Mockingjay", false, ""));
        books.add(new Book(4, "34567\n", "The Great Gatsby", false, ""));
        books.add(new Book(5, "45678\n", "Insurgent", false,  ""));
        books.add(new Book(6, "56789\n", "Allegiant", false, ""));
        books.add(new Book(7, "67812\n", "No, David!", false, ""));
        books.add(new Book(8, "78901\n", "Rich Dad Poor Dad", false, ""));
        books.add(new Book(9, "89012\n", "Divergent", false, ""));
        books.add(new Book(10, "90123\n", "Harry Potter and the Sorcerer's Stone", false, ""));
        books.add(new Book(11, "01234\n", "The Maze Runner", false, ""));
        books.add(new Book(12, "13579\n", "Self-Care for Black Men", false, ""));
        books.add(new Book(13, "24680\n", "48 Laws Of Hustling", false, ""));
        books.add(new Book(14, "79135\n", "The Outsiders", false, ""));
        books.add(new Book(15, "57913\n", "Mindset: The New Psychology of Success", false, ""));
        books.add(new Book(16, "46802\n", "The 7 Habits of Highly Effective People", false, ""));
        books.add(new Book(17, "52158\n", "The Millionaire Next Door", false, ""));
        books.add(new Book(18, "11289\n", "Think Like A Man", false, ""));
        books.add(new Book(19, "24680\n", "Think and Grow Rich", false, ""));
        books.add(new Book(20, "63875\n", "Shh, Sleep Tight", false, ""));
      }

    public static void showStoreHomeScreen() {
        String prompt = """
                =================================================               
                     WELCOME TO THE AMAZING WORLD OF PAGES =)               
                =================================================
                
                A. List Available Books =)
                B. List Checked Out/Unavailable books =(
                C. Im Done, Bai-Bai! 
                
                
                Please Select One Of The Option Above To Continue
                """;

        isRunning = true;

        do {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();

            switch (input.toLowerCase()) {
                case "a":
                    presentAvailableBooks();
                    break;
                case "b":
                    printCheckoutBooks();
                    break;
                case "c":
                    isRunning = false;
                    break;
            }
        } while (isRunning);
    }

    public static void presentAvailableBooks() {

        for (Book book : books) {
            System.out.println(book);
        }

        String availableBooks = """
            A: Yay, let's check out a book! (Enter A)
            B: Eh, not ready yet. Home screen please! (Enter B)
            """;


        System.out.println(availableBooks);
        String input = scanner.nextLine().trim();
        switch (input) {
            case "A", "a":
                System.out.println("Hey, Who Are You!? Enter Your First and Last Name!");
                String name = scanner.nextLine().trim();

                System.out.println("Ah, Thanks! ... Uhh, Which Book Again? (Enter Book ID)");
                int id = scanner.nextInt();
                scanner.nextLine();

                checkoutBook(name,id);
                System.out.println("CA-CHING! The Book Is Yours! Well, For Now..!");
                break;
            case "B", "b":
                showStoreHomeScreen();
                break;

        }


    }

    static void checkoutBook(String name, int id){

        if(!name.isEmpty() && confirmBookInLibrary(id)){

            for(Book book: books){
                if(book.getId() == id){
                    book.setCheckedOut(true);
                    book.setCheckedOutTo(name);
                    System.out.println(book);
                }
            }



        }

    }

    static boolean confirmBookInLibrary(int bookId) {
        for (Book book : books) {

            if (book.getId() == bookId) {
                return true;
            }
        }
        return false;
    }

    public static void printCheckoutBooks(){
        for(Book book: books){
            if(book.isCheckedOut()){
                System.out.println(book.getTitle());
            }
        }
    }
}