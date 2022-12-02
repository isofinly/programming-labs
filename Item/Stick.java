package Item;

public class Stick extends Item{
    private int size;

    public Stick(String name) {
        super(name);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stick stick = (Stick) o;

        return size == stick.size;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    public String toString() {
        return "Stick{" +
                "size=" + size +
                '}';
    }
}
