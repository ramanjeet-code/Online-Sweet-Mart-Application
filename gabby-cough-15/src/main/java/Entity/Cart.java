package Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    
    @Column(nullable = false)
    private double grandTotal;
    
    @Column(nullable = false)
    private int productCount;
    
    @Column(nullable = false)
    private double total;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> listProduct;

	public Cart(double grandTotal, int productCount, double total, List<Product> listProduct) {
		this.grandTotal = grandTotal;
		this.productCount = productCount;
		this.total = total;
		this.listProduct = listProduct;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
    
    // constructors, getters, and setters
}
