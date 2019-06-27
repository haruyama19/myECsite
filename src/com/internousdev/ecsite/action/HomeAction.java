package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	public String execute(){

		//結果をloginにする(loginJSP)

		//sessionにlogin_user_id(key)があったら(ログインしていたら)
		//BuyItemDAO(商品情報をDBから取得するクラス)とBuyItemDTO(DBの情報を格納するクラス)を呼び出して
		//sessionに商品情報を格納して、結果をSUCCESS(buyItemJSP)にする

		String result = "login";

		if(session.containsKey("login_user_id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}
}