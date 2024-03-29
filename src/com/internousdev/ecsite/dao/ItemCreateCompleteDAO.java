package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	//DBに接続して、時刻を入れるDateUtilを呼び出す
	//商品情報をDBに格納する為のSQL文を書く
	//createItemにItemCreateCompleteActionからの情報を格納
	//PreparedStatementでDBにcreateItem(商品情報)と登録時刻を格納

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO item_info_transaction (item_name,item_price,item_stock,insert_date) VALUES(?,?,?,?)";

	public void createItem(String itemName,String itemPrice,String itemStock) throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemPrice);
			preparedStatement.setString(3, itemStock);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
}
