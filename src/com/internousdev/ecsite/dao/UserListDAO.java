package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public List<UserInfoDTO> getUserInfoList() throws SQLException{
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM login_user_transaction ORDER BY id";

	try{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()){
			UserInfoDTO dto = new UserInfoDTO();
			dto.setLoginId(resultSet.getString("login_id"));
			dto.setLoginPassword(resultSet.getString("login_pass"));
			dto.setUserName(resultSet.getString("user_name"));
			userInfoDTOList.add(dto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		connection.close();
	}
	return userInfoDTOList;
	}
}
