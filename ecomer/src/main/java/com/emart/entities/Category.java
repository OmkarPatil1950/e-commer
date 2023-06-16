package com.emart.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

    private int category_Id;
    private String category_Name;
    private int parentcategory_Id;
    private String category_Img_Path;
    private boolean flag;
    private Set<Product> cat_Id;

    
    /**
     * Default constructor for the Category class.
     */
    public Category() {
        super();
    }
    /**
     * Parameterized constructor for the Category class.
     *
     * @param category_Id         The category ID.
     * @param category_Name       The category name.
     * @param parentcategory_Id   The parent category ID.
     * @param category_Img_Path   The image path for the category.
     * @param flag                The flag indicating the category status.
     * @param cat_Id              The set of products associated with the category.
     */
    public Category(int category_Id, String category_Name, int parentcategory_Id, String category_Img_Path,
            boolean flag, Set<Product> cat_Id) {
        super();
        this.category_Id = category_Id;
        this.category_Name = category_Name;
        this.parentcategory_Id = parentcategory_Id;
        this.category_Img_Path = category_Img_Path;
        this.flag = flag;
        this.cat_Id = cat_Id;
    }

    /**
     * Get the category ID.
     *
     * @return The category ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCategory_Id() {
        return category_Id;
    }

    /**
     * Set the category ID.
     *
     * @param category_Id The category ID to set.
     */
    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }

    /**
     * Get the category name.
     *
     * @return The category name.
     */
    public String getCategory_Name() {
        return category_Name;
    }

    /**
     * Set the category name.
     *
     * @param category_Name The category name to set.
     */
    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    /**
     * Get the parent category ID.
     *
     * @return The parent category ID.
     */
    public int getParentcategory_Id() {
        return parentcategory_Id;
    }

    /**
     * Set the parent category ID.
     *
     * @param parentcategory_Id The parent category ID to set.
     */
    public void setParentcategory_Id(int parentcategory_Id) {
        this.parentcategory_Id = parentcategory_Id;
    }

    /**
     * Get the category image path.
     *
     * @return The category image path.
     */
    public String getCategory_Img_Path() {
        return category_Img_Path;
    }

    /**
     * Set the category image path.
     *
     * @param category_Img_Path The category image path to set.
     */
    public void setCategory_Img_Path(String category_Img_Path) {
        this.category_Img_Path = category_Img_Path;
    }

    /**
     * Check if the category is flagged.
     *
     * @return True if flagged, false otherwise.
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Set the flag for the category.
     *
     * @param flag The flag value to set.
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Get the set of products associated with the category.
     *
     * @return The set of products.
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_Id", referencedColumnName = "category_Id")
    public Set<Product> getCat_Id() {
        return cat_Id;
    }

    /**
     * Set the set of products associated with the category.
     *
     * @param cat_Id The set of products to set.
     */
    public void setCat_Id(Set<Product> cat_Id) {
        this.cat_Id = cat_Id;
    }

    @Override
    public String toString() {
        return "Category [category_Id=" + category_Id + ", category_Name=" + category_Name + ", parentcategory_Id="
                + parentcategory_Id + ", category_Img_Path=" + category_Img_Path + ", flag=" + flag + ", cat_Id="
                + cat_Id + "]";
    }
}
