package vn.edu.poly.practice_demo_custom_adapter;

public class Products {
    int id;
    String name;
    int id_img;

    public Products() {
    }

    public Products(int id, String name, int id_img) {
        this.id = id;
        this.name = name;
        this.id_img = id_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }
}
