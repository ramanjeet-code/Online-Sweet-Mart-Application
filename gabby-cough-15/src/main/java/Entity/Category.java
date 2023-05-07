package Entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "categories")
public class Category {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id")
  private Integer categoryId;
  
  @Column(name = "name")
  private String name;
  
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> products = new ArrayList<>();

public Category(String name, List<Product> products) {
	this.name = name;
	this.products = products;
}

public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}
  
  // constructors, getters, setters, etc.
}
