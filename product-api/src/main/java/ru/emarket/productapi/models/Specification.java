package ru.emarket.productapi.models;

public class Specification {
    private Long id;
    private String name;
    private String description;
    private String unit;

    public Specification(Long id, String name, String description, String unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
    }

    public Specification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
