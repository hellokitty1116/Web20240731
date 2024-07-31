package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUP_ID")
	private int supId;

	private String city;

	private String state;

	private String street;

	@Column(name="SUP_NAME")
	private String supName;

	private String zip;

	//bi-directional many-to-one association to Coffee
	//@OneToMany(mappedBy="supplier",  cascade = CascadeType.PERSIST )
	/*oneToMany是指一對多(同一個東西會在其他表格出現多次)
	 * 當調用方法儲存這個一(supplier)的時候,會它有關聯的實體(Coffee class)也會被一起持久化(儲存)!
	 * persist可以理解為儲存資料的意思 Cascade是連動的意思 會將對應的多也一起儲存!!! 
	 * 這種級聯操作使得在保存的同時，也可以保存其關聯的實體(類別)，而不需要先儲存這個supplier再寫一個程式儲存coffee
	 * 因為他們會一起被儲存!
	 */
	@OneToMany
	@JoinColumn(name="SUP_ID")
	private List<Coffee> coffees;

	public Supplier() {
	}

	public int getSupId() {
		return this.supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Coffee> getCoffees() {
		return this.coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	

}