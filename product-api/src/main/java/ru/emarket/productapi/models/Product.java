package ru.emarket.productapi.models;

public class Product {
    private Long id;
    private String brand;
    private String model;
    private String itemNumber;
    private String description;
    private Long categoryId;

    public Product() {
    }

    public Product(Long id, String brand, String model, String itemNumber, String description, Long categoryId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.itemNumber = itemNumber;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
