package pl.warehouse.models;

public enum Position {
    DRIVER ("DRIVER"),
    HELPER ("HELPER"),
    MANAGER ("MANAGER"),
    PACKER("PACKER");
    String positon;
    Position(String postion) {
        this.positon=postion;
    }
}
