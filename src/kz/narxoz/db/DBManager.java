package kz.narxoz.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();

    public static void addItem(Item item){
        items.add(item);
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }

}
