package Week1_AlgorithmsAndDataStructures.Ex6_LibraryManagementSystem.Code;

import java.util.Arrays;
import java.util.Comparator;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    // Linear Search by Title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search by Title (Assumes Sorted by Title)
    public Book binarySearchByTitle(String title) {
        // Ensure books array is sorted by title
        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int compare = books[mid].getTitle().compareToIgnoreCase(title);
            if (compare == 0) {
                return books[mid];
            } else if (compare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

