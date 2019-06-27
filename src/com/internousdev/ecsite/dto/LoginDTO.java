//DAOが受け取ったDBからの値を格納

package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	private String adminFlg;

//Actionクラスに呼び出され値をgetでActionに渡す
	public String getLoginId(){
		return loginId;
	}
//DAOクラスに呼び出され受け取った値をsetで格納
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}
	public String getAdminFlg(){
		return adminFlg;
	}
	public void setAdminFlg(String adminFlg){
		this.adminFlg = adminFlg;
	}

}
