package Inlämningsuppgift2;

public class Order {
    private int id;
    private String date;
    private String shoe;
    private String payType;
    private int price;


    public Order(int id, String date, String shoe, String payType, int price) {
        this.id = id;
        this.date = date;
        this.shoe = shoe;
        this.payType = payType;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getShoe() {
        return shoe;
    }

    public String getPayType() {
        return payType;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {// overriding default string function
        return String.format("%-10s", id) + " " +
                String.format("%-15s", date) + " " +
                String.format("%-10s", shoe) + " " +
                String.format("%-15s", payType) + " " +
                String.format("%-5s", price);
    }
}

