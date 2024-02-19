package ru.emarket.productapi.models;

public class SpecificationToProduct {
    private Long id;
    private Long productId;
    private Long specificationValueId;

    public SpecificationToProduct(Long id, Long productId, Long specificationValueId) {
        this.id = id;
        this.productId = productId;
        this.specificationValueId = specificationValueId;
    }

    public SpecificationToProduct() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSpecificationValueId() {
        return specificationValueId;
    }

    public void setSpecificationValueId(Long specificationValueId) {
        this.specificationValueId = specificationValueId;
    }
}
