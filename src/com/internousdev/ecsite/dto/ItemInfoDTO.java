package com.internousdev.ecsite.dto;

public class ItemInfoDTO {

	private String itemName;
	private String itemPrice;
	private String itemStock;

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock = itemStock;
	}
}