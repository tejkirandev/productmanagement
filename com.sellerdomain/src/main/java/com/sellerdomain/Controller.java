package com.sellerdomain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","Root");
		return connection;
	}
	public int Insert(Product product) throws ClassNotFoundException, SQLException {
		Connection connection=getconnection();
		PreparedStatement preparestatement=connection.prepareStatement("insert into product values(?,?,?,?)");
		preparestatement.setInt(1,product.getId());
		preparestatement.setString(2,product.getName());
		preparestatement.setString(3,product.getDescription());
		preparestatement.setInt(4, product.getPrice());
		int count=preparestatement.executeUpdate();
		return count;
	} 
	public int update(Product product) throws ClassNotFoundException, SQLException
	{
		Connection connection=getconnection();
		PreparedStatement preparestatement=connection.prepareStatement("update product set name=? where id=?");
		preparestatement.setString(1, product.getName());
		preparestatement.setInt(2, product.getId());
		int count=preparestatement.executeUpdate();
		return count;
	}
	public int deleteData(Product product) throws SQLException, ClassNotFoundException
	{
		Connection connection=getconnection();
		PreparedStatement preparestatement=connection.prepareStatement("delete from product where id=?");
		preparestatement.setInt(1, product.getId());
		int count=preparestatement.executeUpdate();
		return count;
	}
}
