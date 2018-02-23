package com.dtproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	
	private int pid;
	
	private String pName;
	private int pQuantity;
	private float pPrice;
	private String pDescription;
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Category.class)
	@JoinColumn(name="productId",referencedColumnName="cId")
	Category category;
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public MultipartFile getpFile() {
		return pFile;
	}

	public void setpFile(MultipartFile pFile) {
		this.pFile = pFile;
	}

	public Category getCategory() {
		return category;
	}

	private String imgName;
	
	@Transient
	private MultipartFile pFile;

	
	
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName){
		this.imgName=imgName;
		
	}

	public void setCategory(Category category2) {
		// TODO Auto-generated method stub
		
	}
}
