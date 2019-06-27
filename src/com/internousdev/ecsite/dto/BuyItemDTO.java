//DAOが受け取ったDBからの値を格納

package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	public int id;
	public String itemName;
	public String itemPrice;

//Actionクラスに呼び出され値をgetでActionに渡す
	public String getItemName(){
		return itemName;
	}
//DAOクラスに呼び出され受け取った値をsetで格納
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
}
