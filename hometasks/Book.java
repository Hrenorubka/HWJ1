package hometasks;

import java.util.ArrayList;
public class Book {
    private String name;
    private ArrayList<Author> authors;
    private double price;
    private int qty = 0;

    public Book(){
        name = "";
    }

    public Book(String name, ArrayList<Author> authors, double price) {
        this.name = name;
        this.authors = new ArrayList<Author>();
        this.authors.addAll(authors);
        this.price = price;
    }

    public Book(String name, ArrayList<Author> authors, double price, int qty) {
        this(name, authors, price);
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames()
    {
        String AutorsNames = "";
        for (int i=0; i < authors.size() - 1; i++) {
            AutorsNames = authors.get(i).getName() + ", ";
        }
        AutorsNames = AutorsNames +authors.get(authors.size() - 1).getName();
        return AutorsNames;
    }

    @Override
    public String toString()
    {
        String strAutors = "";
        for (int i=0; i < authors.size() - 1; i++) {
            strAutors = authors.get(i).toString() + ", ";
        }
        strAutors = strAutors +authors.get(authors.size() - 1).toString();
        return "Book[name = " + name + "authors = {" + strAutors + "}, price = " + ((Double) price).toString() + ", qty = " + ((Integer) qty).toString() + ']';
    }
}
