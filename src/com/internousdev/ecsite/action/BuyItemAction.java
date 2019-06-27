package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;
	private int count;
	private String pay;

	public String execute(){

		//結果をSUCCESSにする(buyItemConfirmJSP)
		//sessionのcount(key)にcount(購入個数)を値で入れる
		//countとbuyItem_priceをsessionからString型で取り出し、更にint型に変換してintCountとintPriceに代入
		//sessionのtotal_price(key)にintCount(購入個数)×intPrice(値段)を格納

		//pay(支払い方法)のvalueと1が同じだったら現金払いをpaymentに代入してsessionのpay(key)に格納
		//1以外のときはクレジットカードを格納

		String result = SUCCESS;

		session.put("count", count);

		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount * intPrice);

		String payment;
		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay",payment);
		}else{
			payment = "クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}
	public void setCount(int count){
		this.count = count;
	}
	public void setPay(String pay){
		this.pay = pay;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
