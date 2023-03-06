package Inlämningsuppgift2;

import java.util.ArrayList;
import java.util.List;

interface PrintOrders{
    void print();
}

public class Orders {
    List<Order> orderList = new ArrayList<Order>();

    void addOrder(Order order){
        orderList.add(order);
    }

    PrintOrders printOrders = () -> { //lambda expression för att printa ordrar
        System.out.println("\n" +
                String.format("%-10s", "Shoe") + " " +
                String.format("%-15s", "Category") + " " +
                String.format("%-10s", "Size") + " " +
                String.format("%-15s", "Color") + " " +
                String.format("%-5s", "Price"));
        System.out.println("-----------------------------------------------------------");
        orderList.forEach(o->System.out.println(o.toString()));
    };

    void clearOrders(){
        orderList.clear();
    }
}

