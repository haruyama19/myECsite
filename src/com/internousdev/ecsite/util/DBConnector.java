package com.internousdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

//MySQLにログインするフィールド
//接続に必要な情報を設定する
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite02";
	private static String user = "root";
	private static String password = "mysql";

//接続を初期化する
	public Connection getConnection(){
		Connection con = null;

//新たにログインする
		try{
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);

//クラスが無い時のエラー表示
		}catch(ClassNotFoundException e){
			e.printStackTrace();
//SQL文のエラー表示
		}catch(SQLException e){
			e.printStackTrace();
		}
//MySQLに接続できたか情報を渡す
		return con;
	}
}
