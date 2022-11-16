package Lab3.Persons;

import Lab3.Objects.Book;
public final class Znayika extends Person {
    private Book Book;
    public Znayika(Mood mood, PersonState state) {
        super("Znayka", 7, mood, state);
    }
    public Book getBook() {
        return this.Book;
    }

    public void startReading(Book book) {
        this.setState(PersonState.READ);
        if (this.getState() == PersonState.READ) {
            this.Book = book;
            // Znayka becomes happy when he starts reading
            this.setMood(Mood.HAPPY);
            System.out.println("Znayka is happy cuz he started to read " + book.getName() + " and will never stop ");
            // no stop reading cuz why not lol
            // jk i will add it later

        }
    }
    public void stopReading(PersonState newState) {
        this.Book = null;
        this.setState(newState);
    }
}
