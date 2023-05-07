package Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String photoPath;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Boolean available = true;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // default constructor
    public Product() {
    }

    // constructor with parameters
    public Product(String name, String photoPath, Double price, String description, Boolean available, Category category) {
        this.name = name;
        this.photoPath = photoPath;
        this.price = price;
        this.description = description;
        this.available = available;
        this.category = category;
    }
    
    // getters and setters
    // ...
    
    public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// override toString method
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", photoPath=" + photoPath + ", price=" + price
                + ", description=" + description + ", available=" + available + ", category=" + category + "]";
    }
}

