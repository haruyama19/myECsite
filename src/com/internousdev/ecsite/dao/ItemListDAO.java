package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO{

	//DBに接続する

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//ListのgetItemInfoList(窓口)をつくる
	//itemInfoDTOList(新しいList)をつくる
	//SQL文でDBのitem_info_transaction(商品情報)をidの昇順で呼び出す
	//結果をResultSetに代入
	//DBの情報(RssultSet)から情報をString型で取り出しdtoに格納
	//dtoをitemInfoDTOListに格納

	public List<ItemInfoDTO> getItemInfoList() throws SQLException{
		List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();

		String sql = "SELECT * FROM item_info_transaction ORDER BY id";

	try{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			ItemInfoDTO dto = new ItemInfoDTO();
			dto.setItemName(resultSet.getString("item_name"));
			dto.setItemPrice(resultSet.getString("item_price"));
			dto.setItemStock(resultSet.getString("item_stock"));
			itemInfoDTOList.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
	return itemInfoDTOList;
	}
}