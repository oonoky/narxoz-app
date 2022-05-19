package kz.narxoz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private static Connection connection;

    static {

        try{

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/narxoz_db", "postgres", "postgres");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Item> getItems(){

        ArrayList<Item> items = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items ORDER BY price DESC");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                String category = resultSet.getString("category");

                Item item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setModel(model);
                item.setCategory(category);

                items.add(item);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return items;

    }

    public static void addItem(Item item){

        item = setItemCategory(item);

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, model, price, category) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setString(2, item.getModel());
            statement.setInt(3, item.getPrice());
            statement.setString(4, item.getCategory());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Item getItem(Long id){

        Item item = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                String category = resultSet.getString("category");

                item = new Item();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setModel(model);
                item.setCategory(category);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;

    }

    public static void updateItem(Item item){

        item = setItemCategory(item);

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE items SET name = ?, model = ?, price = ?, category = ? WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setString(2, item.getModel());
            statement.setInt(3, item.getPrice());
            statement.setString(4, item.getCategory());
            statement.setLong(5, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteItem(Item item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM items WHERE id = ?");
            statement.setLong(1, item.getId());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static Item setItemCategory(Item item){

        if(item.getPrice()>=100000){
            item.setCategory("TOP");
        }else if(item.getPrice()>=50000){
            item.setCategory("MIDDLE");
        }else if(item.getPrice()>=20000){
            item.setCategory("SIMPLE");
        }else{
            item.setCategory("CHEAP");
        }

        return item;

    }

}
