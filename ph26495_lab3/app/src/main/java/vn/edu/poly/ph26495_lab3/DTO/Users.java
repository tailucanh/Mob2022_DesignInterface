package vn.edu.poly.ph26495_lab3.DTO;

public class Users {

    int id_ur;
    String name;
    int avatar;

    public Users() {
    }

    public Users(int id_ur, String name, int avatar) {
        this.id_ur = id_ur;
        this.name = name;
        this.avatar = avatar;
    }

    public int getId_ur() {
        return id_ur;
    }

    public void setId_ur(int id_ur) {
        this.id_ur = id_ur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
