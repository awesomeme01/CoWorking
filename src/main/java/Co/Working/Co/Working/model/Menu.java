package Co.Working.Co.Working.model;

import javax.persistence.*;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dishes;
    private double price;

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", dishes='" + dishes + '\'' + ", price=" + price + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Menu(long id, String dishes, double price) {
        this.id = id;
        this.dishes = dishes;
        this.price = price;
    }
}