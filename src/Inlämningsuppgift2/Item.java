package Inlämningsuppgift2;
public class Item {
    private int itemId;
    private String make;
    private String category;
    private int size;
    private String color;
    private int price;

    public Item(int itemId, String make, String category, int size, String color, int price) {

        this.itemId = itemId;
        this.make = make;
        this.category = category;
        this.size = size;
        this.color = color;
        this.price = price;
    }


    public int getItemId() {
        return itemId;
    }

    public String getMake() {
        return make;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() { // Denna metod kommer skriva över default string funktion till format string
        return String.format("%-10s", make) + " " +
                String.format("%-10s", category) + " " +
                String.format("%-4s", size) + " " +
                String.format("%-10s", color) + " " +
                String.format("%-5s", price);
    }
}
