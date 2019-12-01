package amst.g1.labsec.models;

import java.util.Date;

public class Device {

    private String name;
    private String brand;
    private String model;
    private String borrower;
    private Date returnDate;

    public Device() {}

    public Device(String name, String brand, String model, String borrower, Date returnDate) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.borrower = borrower;
        this.returnDate = returnDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", borrower='" + borrower + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
