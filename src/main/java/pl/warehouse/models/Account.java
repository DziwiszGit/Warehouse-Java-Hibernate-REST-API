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
        private String password;

        @OneToOne
        @JoinColumn(referencedColumnName = "id")
        private Warehouseman warehouseman;

        public Account() {
        }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account(String login, String password, Warehouseman warehouseman) {
            this.login = login;
            this.password = password;
            this.warehouseman = warehouseman;
        }

        public Account(int id, String login, String password, Warehouseman warehouseman) {
            this.id = id;
            this.login = login;
            this.password = password;
            this.warehouseman = warehouseman;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Warehouseman getWarehouseman() {
            return warehouseman;
        }

        public void setWarehouseman(Warehouseman warehouseman) {
            this.warehouseman = warehouseman;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", warehousemen=" + warehouseman +
                    '}';
        }
}
