package pl.warehouse.models;

import lombok.Getter;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;

public enum Role {
    USER ("USER"),
    ADMIN ("ADMIN");
    String role;
    Role(String role) {
        this.role=role;
    }

}
