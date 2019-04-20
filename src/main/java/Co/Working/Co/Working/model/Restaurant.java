package Co.Working.Co.Working.model;

import javax.persistence.*;

@Entity
@Table
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "feedback_id")
    Feedback feedback;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    Menu menu;
    private String address;
    private Integer rating;

    public Restaurant() {
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Restaurant(long id, String name, Feedback feedback, Menu menu, String address, Integer rating) {
        this.id = id;
        this.name = name;
        this.feedback = feedback;
        this.menu = menu;
        this.address = address;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", name='" + name + '\'' + ", feedback=" + feedback + ", menu=" + menu + ", address='" + address + '\'' + ", rating=" + rating + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Restaurant(long id, String name, Menu menu, String address, Integer rating) {
        this.id = id;
        this.name = name;
        this.menu = menu;
        this.address = address;
        this.rating = rating;
    }
}
