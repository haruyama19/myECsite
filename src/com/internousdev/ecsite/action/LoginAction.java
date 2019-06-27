package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){

		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);

//ユーザーが入力した値とDTOから持ってきた値が一致するか確認する
//一致した場合はresultがSUCCESSになる
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			if((((LoginDTO) session.get("loginUser")).getAdminFlg() != null)
					&& (((LoginDTO) session.get("loginUser")).getAdminFlg().equals("1"))){
						result = "admin";
					}else{
						result = SUCCESS;
						BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//ログイン認証が成功した場合、
//次の画面で商品情報が必要なため、商品情報を取得する
						session.put("login_user_id",loginDTO.getLoginId());
						session.put("id",buyItemDTO.getId());
						session.put("buyItem_name", buyItemDTO.getItemName());
						session.put("buyItem_price",buyItemDTO.getItemPrice());
					}
		}
		return result;
	}
//getterは次画面に値を引き渡すサイトの場合必要
	public String getLoginUserId(){
		return loginUserId;
	}
//setterでJSPでユーザーが入力した値がそれぞれのフィールド変数に格納される
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
