package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO{

	//	DBに接続する
	//	deleteItemList(窓口)をつくる
	//	SQL文でitem_info_transaction(商品情報)の中身を削除する記述
	//	resultに0を代入して、結果をresultに代入する

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int deleteItemList() throws SQLException{

		String sql = "DELETE FROM item_info_transaction";
		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}
}