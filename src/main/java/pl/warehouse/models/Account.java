package pl.warehouse.models;

import javax.persistence.*;

@Entity(name = "taccounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String surname;

    @OneToOne
    @JoinColumn(name = "warehousemen_ID")
    private Warehouseman warehousemen;

    public Account() {
    }

    public Account(String login, String surname, Warehouseman warehousemen) {
        this.login = login;
        this.surname = surname;
        this.warehousemen = warehousemen;
    }

    public Account(int id, String login, String surname, Warehouseman warehousemen) {
        this.id = id;
        this.login = login;
        this.surname = surname;
        this.warehousemen = warehousemen;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Warehouseman getWarehousemen() {
        return warehousemen;
    }

    public void setWarehousemen(Warehouseman warehousemen) {
        this.warehousemen = warehousemen;
    }
}
