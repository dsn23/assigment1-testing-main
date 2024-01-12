public class Pancake {

    int size;

    public Pancake(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //ToString so that we don't get the object when printing the Stack/Plate
    @Override
    public String toString() {
        return "Pancake{" +
                "size=" + size +
                '}';
    }
}
