package Lab3.Persons;

import Lab3.Objects.Book;

import static Lab3.Persons.PersonState.READ;

public final class Znayika extends Person {
    // The book which Znayka is reading
    private Book Book;
    public Znayika(Mood mood, PersonState state) {
        super("Znayka", 7, mood, state);
    }
    public Book getBook() {
        return this.Book;
    }

//    @Override
//    public void setState(PersonState newState) {
//        switch (this.getState()) {
//            case SLEEP, WALK -> System.out.println("Znayika can't do this while he is " + this.getState());
//            default -> super.setState(newState);
//        }
//    }

    public void startReading(Book book) {
        this.setState(READ);
        if (this.getState() == READ) {
            this.Book = book;
            // Znayka becomes happy when he starts reading
            this.setMood(Mood.HAPPY);
            System.out.println("Znayka is happy cuz he started to read " + book.getName() + " and will never stop ");
            // no stop reading cuz why not lol
        }
    }
}
