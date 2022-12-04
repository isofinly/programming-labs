package Item;

public abstract class Item {
    protected String name;

    Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}