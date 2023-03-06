package Inlämningsuppgift2;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBConnection db = new DBConnection("root", "And1lover!");
        //Anropa DBConnection-klassen med användarnamn och lösenord och anslut.
        db.connectDB.connect();

        try {
            Scanner myObj = new Scanner(System.in); // För att läsa data från användare används Scanner-klassen./

            System.out.print("Please Enter Customer Name: ");
            String name = myObj.nextLine(); //Scanner klass för att läsa data

            System.out.print("Please Enter Password: ");
            String password = myObj.nextLine();
// Här kommer data från kundtabellen att användas. Vi har också lagt till en kolumn som heter lösenord i kundtabellen och ställt in lösenordet där.
            String query1 = "select * from kund where upper(namn)='"+name.toUpperCase()+"' and password = '" + password+"'";
            ResultSet rs = db.executeQuery.execute(query1); //executing query som vi skrev kod i DBConnection-klassen

            if(rs.next())
            {
                int customerId = rs.getInt(1); // Om det inte finns någon rad betyder det att användarnamnet eller lösenordet är felaktigt.
                System.out.println("Logged In. Customer ID : " + customerId);

                ItemStore itemStore = new ItemStore();
                Orders orders = new Orders();

                String sel;
                do {//Kod för att hämta försäljningssammanfattning eller lägga till ny order
                    System.out.print("\nPlease enter 1 to see sales summary, 2 for new order : ");
                    int menu = Integer.parseInt(myObj.nextLine());

                    if(menu==1)
                    {
                        orders.clearOrders();

                        String queryOrders = "select b.id, b.Datum date, s.märke, b.Betalsätt payType, s.pris price" +
                                " from beställning b inner join skor s on b.skoid = s.id where b.KundId = " + customerId + ";";
//Väljer flera saker med hjälp av inner join i SQL.
                        rs = db.executeQuery.execute(queryOrders);

                        while (rs.next()) // för att få alla rader
                            orders.addOrder(new Order( rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getInt(5)));

                        orders.printOrders.print();
                    }
                    else if(menu==2)
                    {
                        itemStore.clearItemStore();

                        String queryItems = "SELECT s.id, s.märke make, k.Knamn category, s.storlek size, s.färg color, s.pris price" +
                                "  FROM webbshop.skor s inner join webbshop.kategori k on s.id = k.Kid;";
//Väljer flera saker med hjälp av inner join
                        rs = db.executeQuery.execute(queryItems);

                        while (rs.next())
                            itemStore.addItem(new Item( rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getInt(6)));

                        itemStore.printStore.print();
                        //Fråga användare och ta information som skor, namn, storlek etc.
                        System.out.print("\nPlease Enter Shoe Name : ");
                        String shoe = myObj.nextLine();

                        System.out.print("Please Enter Category : ");
                        String category = myObj.nextLine();

                        System.out.print("Please Enter Size : ");
                        int size = Integer.parseInt(myObj.nextLine());

                        System.out.print("Please Enter Color : ");
                        String color = myObj.nextLine();

                        int prodId = itemStore.searchItem.search(shoe, category, size, color);

                        if(prodId > 0){
                            System.out.println("\nPlease selet payment method.");
                            System.out.print("Please enter 1 for Debit Card, 2 for Credit Card : ");
                            String payMet = Integer.parseInt(myObj.nextLine()) == 1 ? "Debit Card" : "Credit Card";

                            String currDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                            // call the store procedure AddtoCart för att sätta in eller uppdatera i table
                            String query3 = "Call AddToCart(" + customerId + ","
                                    + "NULL" + ","
                                    + "'" + payMet + "',"
                                    + "'" + currDate + "',"
                                    + prodId + ");";

                            db.executeQuery.execute(query3);

                            System.out.println("Order has been placed.");
                        }
                        else
                        {
                            System.out.println("Item not found.");
                        }
                    }

                    System.out.print("\nDo you want to continue? Y/N :"); //Köra programmet igen eller exit
                    sel = myObj.nextLine().equalsIgnoreCase("Y") ? "Y" : "N";
                }
                while(sel.equals("Y"));
            }
            else
            {
                System.out.println("Customer Not Found.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        db.closeDB.close();
    }
}