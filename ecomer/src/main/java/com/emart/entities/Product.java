package com.emart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

    private int p_Id;
    private String p_Name;
    private float p_Price;
    private String p_Image;
    private boolean p_Prime;
    private boolean p_Promotion;

    /**
     * Default constructor.
     */
    public Product() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param p_Id        The product ID.
     * @param p_Name      The product name.
     * @param p_Price     The product price.
     * @param p_Image     The product image.
     * @param p_Prime     The product prime status.
     * @param p_Promotion The product promotion status.
     */
    public Product(int p_Id, String p_Name, float p_Price, String p_Image, boolean p_Prime, boolean p_Promotion) {
        super();
        this.p_Id = p_Id;
        this.p_Name = p_Name;
        this.p_Price = p_Price;
        this.p_Image = p_Image;
        this.p_Prime = p_Prime;
        this.p_Promotion = p_Promotion;
    }

    /**
     * Get the product ID.
     *
     * @return The product ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getP_Id() {
        return p_Id;
    }

    /**
     * Set the product ID.
     *
     * @param p_Id The product ID to set.
     */
    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    /**
     * Get the product name.
     *
     * @return The product name.
     */
    public String getP_Name() {
        return p_Name;
    }

    /**
     * Set the product name.
     *
     * @param p_Name The product name to set.
     */
    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    /**
     * Get the product price.
     *
     * @return The product price.
     */
    public float getP_Price() {
        return p_Price;
    }

    /**
     * Set the product price.
     *
     * @param p_Price The product price to set.
     */
    public void setP_Price(float p_Price) {
        this.p_Price = p_Price;
    }

    /**
     * Get the product image.
     *
     * @return The product image.
     */
    public String getP_Image() {
        return p_Image;
    }

    /**
     * Set the product image.
     *
     * @param p_Image The product image to set.
     */
    public void setP_Image(String p_Image) {
        this.p_Image = p_Image;
    }

    /**
     * Check if the product is marked as prime.
     *
     * @return true if the product is marked as prime, false otherwise.
     */
    public boolean getP_Prime() {
        return p_Prime;
    }

    /**
     * Set the prime status of the product.
     *
     * @param p_Prime The prime status to set.
     */
    public void setP_Prime(boolean p_Prime) {
        this.p_Prime = p_Prime;
    }

    /**
     * Check if the product is on promotion.
     *
     * @return true if the product is on promotion, false otherwise.
     */
    public boolean getP_Promotion() {
        return p_Promotion;
    }

    /**
     * Set the promotion status of the product.
     *
     * @param p_Promotion The promotion status to set.
     */
    public void setP_Promotion(boolean p_Promotion) {
        this.p_Promotion = p_Promotion;
    }

    @Override
    public String toString() {
        return "Product [p_Id=" + p_Id + ", p_Name=" + p_Name + ", p_Price=" + p_Price + ", p_Image=" + p_Image
                + ", p_Prime=" + p_Prime + ", p_Promotion=" + p_Promotion + "]";
    }

}
