package com.dtproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Supplier 
{
	
	@Id
	@GeneratedValue
    private int sId;
	
    private String sName;
    
    @ManyToMany (cascade=CascadeType.ALL,targetEntity=Product.class)
    private List<Product> product;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public List<Product> getProduct(){
	
		return product;
	}
	
	public void setProduct(List<Product> product){
		this.product=product;
	}
    
}
