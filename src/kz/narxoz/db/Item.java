package kz.narxoz.db;

public class Item {

    private Long id;
    private String name;
    private String model;
    private int price;
    private String category;

    public Item() {
    }

    public Item(String name, String model, int price, String category) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.category = category;
    }

    public Item(Long id, String name, String model, int price, String category) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
