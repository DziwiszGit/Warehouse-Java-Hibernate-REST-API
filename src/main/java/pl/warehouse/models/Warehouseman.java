package pl.warehouse.models;

import javax.persistence.*;

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


    public void setId(int id) {
        this.id = id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
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
