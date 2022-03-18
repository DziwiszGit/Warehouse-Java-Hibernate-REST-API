package pl.warehouse.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tproducts")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private double weight;

    @Temporal(TemporalType.DATE)
    private Date date;


    public Product() {
    }

    public Product(int id, String name, double weight, Date date) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.date = date;
    }

    public Product(String name, double weight, Date date) {
        this.name = name;
        this.weight = weight;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
