package com.emart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTDETAILS")
public class ProductDetails {

    private int productDetail_Id;
    private String p_Description;
    private Product product;

    /**
     * Parameterized constructor.
     *
     * @param productDetail_Id The product detail ID.
     * @param p_Description    The product description.
     * @param product          The associated product.
     */
    public ProductDetails(int productDetail_Id, String p_Description, Product product) {
        super();
        this.productDetail_Id = productDetail_Id;
        this.p_Description = p_Description;
        this.product = product;
    }

    /**
     * Default constructor.
     */
    public ProductDetails() {
        super();
    }

    /**
     * Get the product detail ID.
     *
     * @return The product detail ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductDetail_Id() {
        return productDetail_Id;
    }

    /**
     * Set the product detail ID.
     *
     * @param productDetail_Id The product detail ID to set.
     */
    public void setProductDetail_Id(int productDetail_Id) {
        this.productDetail_Id = productDetail_Id;
    }

    /**
     * Get the product description.
     *
     * @return The product description.
     */
    public String getP_Description() {
        return p_Description;
    }

    /**
     * Set the product description.
     *
     * @param p_Description The product description to set.
     */
    public void setP_Description(String p_Description) {
        this.p_Description = p_Description;
    }

    /**
     * Get the associated product.
     *
     * @return The associated product.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p_Id")
    public Product getProduct() {
        return product;
    }

    /**
     * Set the associated product.
     *
     * @param product The product to set.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetails [productDetail_Id=" + productDetail_Id + ", p_Description=" + p_Description
                + ", product=" + product + "]";
    }

}
