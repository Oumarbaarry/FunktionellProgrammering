package Inlämningsuppgift2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface SearchItem{
    int search(String make, String category, int size, String color);
}

interface PrintStore{
    void print();
}

public class ItemStore {
    List<Item> itemStore = new ArrayList<Item>();

    void addItem(Item item){
        itemStore.add(item);
    }
    // Här kommer vi att använda lambda-uttryck för att söka efter en artikel från en lista och hämta information som storlek, färg etc.
    SearchItem searchItem = (String make, String category, int size, String color) -> {
        List<Item> items = itemStore.stream()
                .filter(i -> i.getMake().equalsIgnoreCase(make) &&
                        i.getCategory().equalsIgnoreCase(category) &&
                        i.getSize()==size &&
                        i.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
        return (items.size()>0) ? items.get(0).getItemId() : 0;
    };

    PrintStore printStore = () -> { //här är lambda uttrycken som kallar på utskrivs koden
        System.out.println("\n" +
                String.format("%-10s", "Shoe") + " " +
                String.format("%-10s", "Category") + " " +
                String.format("%-4s", "Size") + " " +
                String.format("%-10s", "Color") + " " +
                String.format("%-5s", "Price"));
        System.out.println("-------------------------------------------");
        itemStore.forEach(i->System.out.println(i.toString()));
    };

    void clearItemStore(){
        itemStore.clear();
    }
}

