package homework6.task2;

import java.io.Serializable;

public class Weel implements Cloneable, Serializable {

    private String author;
    private String size;

    public Weel(String author, String size) {
        this.author = author;
        this.size = size;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    protected Object clone() {
        try {
            return (Weel)super.clone();
        } catch (CloneNotSupportedException e) {
            return new Weel(this.author, this.size);
        }
    }
}
