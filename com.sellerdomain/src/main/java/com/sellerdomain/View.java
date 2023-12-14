package com.sellerdomain;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Controller con=new Controller();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("Enter 1 to insert \n Enter 2 to update \n Enter 3 to delete \n");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter the id :");
				int id=sc.nextInt();
				System.out.println("Enter the name :");
				String name=sc.next();
				System.out.println("Enter the Description :");
				String description=sc.next();
				System.out.println("Enter the price :");
				int price=sc.nextInt();
				Product product=new Product(id,name,description,price);
				int count=con.Insert(product);
				if(count>0) {
					System.out.println("Data inserted Sucessfully");
				}else {
					System.out.println("Data not inserted");
				}
				break;
			case 2:
				System.out.println("Enter the id to updated: ");
				int idtoUpdate=sc.nextInt();
				System.out.println("what name to be updated");
				String updatedname=sc.next();
				Product product1=new Product();
				product1.setId(idtoUpdate);
				product1.setName(updatedname);
				int count1=con.update(product1);
				if(count1>0) {
					System.out.println("Data updated Sucessfully");
				}else {
					System.out.println("Data not updated");
				}
				break;
			case 3:
				System.out.println("Enter the id to deleted: ");
				int idtoDelete=sc.nextInt();
				Product productDelete=new Product();
				productDelete.setId(idtoDelete);
				int c=con.deleteData(productDelete);
				if(c>0) {
					System.out.println("Data deleted Sucessfully");
				}else {
					System.out.println("Data not deleted");
				}
				break;
			
			default:
				break;
				
				
			}
		}
		sc.close();
	}
}
