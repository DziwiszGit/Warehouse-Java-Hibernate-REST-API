package pl.warehouse.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "twarehousemen")
public class Warehouseman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private int age;

    @Enumerated(EnumType.STRING)
    private Position position;

    public Warehouseman() {
    }

    public Warehouseman(int id, String name, String surname, int age, Position position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
    }

    public Warehouseman(String name, String surname, int age, Position position) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Warehouseman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
