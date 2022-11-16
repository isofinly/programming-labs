package Lab3.Objects;

import java.util.Arrays;

public class Book extends Artificial {
    // Author of the book
    private final String Author;
    // Book name
    private final String BookName;
    // Text that was written in the book
    private String[] PageData;
    // Number of pages in the book
    private int PageCount;

    public Book(State currentState, Material material, String bookName, String[] pageData) {
        super(currentState, material);
        BookName = bookName;
        PageData = pageData;
        PageCount = pageData.length;
        Author = "Unknown";
    }

    public Book(State currentState, Material material, String bookName, String[] pageData, String author) {
        super(currentState, material);
        BookName = bookName;
        PageData = pageData;
        PageCount = pageData.length;
        Author = author;
    }

    public final int getNumberOfPages() {
        return PageCount;
    }

    public final String getAuthor() {
        return Author;
    }

    public final String getName() {
        return BookName;
    }

    public final String[] getData() {
        return PageData;
    }

    @Override
    public boolean equals(Object otherBook) {
        // Check if the object is the same by hashcode
        if (otherBook.getClass().isInstance(this)) {
            return (this == otherBook);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Author.hashCode() + BookName.hashCode() + PageCount + Arrays.hashCode(PageData);
    }

    @Override
    public String toString() {
        return "Book: " + BookName + " by " + Author + " with " + PageCount +
                " pages\nBook's text: " + Arrays.toString(PageData);
    }
}

