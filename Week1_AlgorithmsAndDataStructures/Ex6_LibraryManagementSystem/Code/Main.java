package Week1_AlgorithmsAndDataStructures.Ex6_LibraryManagementSystem.Code;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B101", "The Alchemist", "Paulo Coelho"),
            new Book("B102", "1984", "George Orwell"),
            new Book("B103", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B104", "The Hobbit", "J.R.R. Tolkien")
        };
        Library library = new Library(books);

        System.out.println("\nLinear Search for '1984':");
        System.out.println(library.linearSearchByTitle("1984"));

        System.out.println("\nBinary Search for 'The Hobbit':");
        System.out.println(library.binarySearchByTitle("The Hobbit"));
    }
}

