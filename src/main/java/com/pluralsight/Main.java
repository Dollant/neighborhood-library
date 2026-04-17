package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Book[] books = {
                new Book(1,  "978-0-7432-7356-5", "The Great Gatsby"),
                new Book(2,  "978-0-06-112008-4", "To Kill a Mockingbird"),
                new Book(3,  "978-0-7432-7357-2", "1984"),
                new Book(4,  "978-0-14-028329-7", "Of Mice and Men"),
                new Book(5,  "978-0-7432-7358-9", "The Catcher in the Rye"),
                new Book(6,  "978-0-06-093546-9", "Brave New World"),
                new Book(7,  "978-0-14-303943-3", "The Odyssey"),
                new Book(8,  "978-0-7432-7359-6", "Fahrenheit 451"),
                new Book(9,  "978-0-14-028330-3", "Lord of the Flies"),
                new Book(10, "978-0-06-112009-1", "Jane Eyre"),
                new Book(11, "978-0-14-243723-0", "Crime and Punishment"),
                new Book(12, "978-0-7432-7360-2", "The Alchemist"),
                new Book(13, "978-0-06-093548-3", "Slaughterhouse-Five"),
                new Book(14, "978-0-14-028331-0", "Animal Farm"),
                new Book(15, "978-0-7432-7361-9", "The Hobbit"),
                new Book(16, "978-0-06-112010-7", "Harry Potter and the Sorcerer's Stone"),
                new Book(17, "978-0-14-303944-0", "The Hunger Games"),
                new Book(18, "978-0-7432-7362-6", "Percy Jackson and the Lightning Thief"),
                new Book(19, "978-0-06-093549-0", "The Maze Runner"),
                new Book(20, "978-0-14-028332-7", "Divergent")
        };

        boolean running = true;

        while (running) {
            System.out.println("\n₊✩‧₊˚౨ৎ˚₊✩‧₊ Neighborhood Library ₊✩‧₊˚౨ৎ˚₊✩‧₊");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice (˶˃ ᵕ ˂˶) : ");

            String homeChoice = keyboard.nextLine().trim();

            switch (homeChoice) {

                case "1":
                    // Show available books
                    System.out.println("\n₊✩‧₊˚౨ৎ˚₊✩‧₊ Available Books ₊✩‧₊˚౨ৎ˚₊✩‧₊");
                    System.out.printf("%-5s %-20s %-40s%n", "ID", "ISBN", "Title");
                    System.out.println("⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊⊹⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊⊹⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊⊹");

                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.printf("%-5d %-20s %-40s%n",
                                    book.getId(),
                                    book.getIsbn(),
                                    book.getTitle());
                        }
                    }
                    System.out.println("\nEnter a Book ID to check out, or X to go back: ");
                    String availableChoice = keyboard.nextLine().trim();

                    if (!availableChoice.equalsIgnoreCase("X")) {
                        int selectedId = Integer.parseInt(availableChoice);
                        Book selectedBook = null;

                        for (Book book : books) {
                            if (book.getId() == selectedId) {
                                selectedBook = book;
                                break;
                            }
                        }

                        if (selectedBook == null) {
                            System.out.println("Book not found! >~<");
                        } else if (selectedBook.isCheckedOut()) {
                            System.out.println("Sorry, that book is already checked out! ^^;");
                        } else {
                            System.out.print("Enter your name: ");
                            String userName = keyboard.nextLine().trim();
                            selectedBook.checkOut(userName);
                            System.out.println( "\n\"" + selectedBook.getTitle() + "\" checked out to " + userName + "Enjoy! :3");
                        }
                    }
                    break;

            }
        }
    }
}
