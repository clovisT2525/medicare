package service;

import java.util.HashMap;
import java.util.Map;


import constant.Queries;
import model.Medicine;
import model.Offer;
import model.Seller;
import model.Tag;
import java.sql.*;

public class Database {

	public Map<Integer, Medicine> getAllMedicines() {
		Map<Integer, Medicine> medicineMap = new HashMap<Integer,Medicine>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(Queries.GET_ALL_MEDICINES);  
			while(rs.next()) {
				medicineMap.put(rs.getInt(1), new Medicine(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getBoolean(8),rs.getString(9)));
			}
			con.close();  
			} catch(Exception e) {
				System.out.println(e);
			}    
		return medicineMap;
	}

	public Map<Integer, Tag> getAllTags() {
		Map<Integer, Tag> tagMap = new HashMap<Integer,Tag>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(Queries.GET_ALL_TAGS);  
			while(rs.next()) {
				tagMap.put(rs.getInt(1), new Tag(rs.getInt(1), rs.getString(2)));  				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    
		return tagMap;
	}

	public Map<Integer, Seller> getAllSellers() {
		Map<Integer, Seller> sellerMap = new HashMap<Integer,Seller>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(Queries.GET_ALL_SELLERS);  
			while(rs.next()) {
				sellerMap.put(rs.getInt(1), new Seller(rs.getInt(1), rs.getString(2)));  				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    
		return sellerMap;
	}

	public Map<Integer, Offer> getAllOffers() {
		Map<Integer, Offer> offerMap = new HashMap<Integer,Offer>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(Queries.GET_ALL_OFFERS);  
			while(rs.next()) {
				offerMap.put(rs.getInt(1), new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3)));  				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    
		return offerMap;
	}
	
	//0->not a valid user
	//1->normal user
	//2->admin
	public int verifyLogin(String username, String password) {
		int userStatus = 0;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.VERIFY_LOGIN);  
			stmt.setString(1,username);
			stmt.setString(2, password);
			
			ResultSet rs=stmt.executeQuery();  
			if(rs.next()) {
				userStatus = 1;
				if(rs.getBoolean(1)==true) {
					userStatus=2;
				}				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    
		return userStatus;
	}

	public boolean addUser(String username, String password) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.INSERT_USER);  
			stmt.setString(1,username);
			stmt.setString(2, password);
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	public boolean addMedicine(Medicine medicine) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.INSERT_MEDICINE);  
			stmt.setString(1,medicine.getName());
			stmt.setString(2, medicine.getDescription());
			stmt.setInt(3, medicine.getSellerId());
			stmt.setInt(4, medicine.getPrice());
			stmt.setInt(5, medicine.getOfferId());
			stmt.setInt(6, medicine.getTagId());
			stmt.setBoolean(7, medicine.isActive());
			stmt.setString(8, medicine.getImageUrl());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	public boolean addTag(Tag tag) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.INSERT_TAG);  
			stmt.setString(1,tag.getName());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	public boolean addOffer(Offer offer) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.INSERT_OFFER);  
			stmt.setString(1,offer.getName());
			stmt.setInt(2,offer.getValueInDiscount());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	public boolean addSeller(Seller seller) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.INSERT_SELLER);  
			stmt.setString(1,seller.getName());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	public boolean editMedicine(Medicine medicine) {
		boolean isSuccess = false;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/medicare","ostl","ostl");  
			PreparedStatement stmt=con.prepareStatement(Queries.EDIT_MEDICINE);  
			stmt.setString(1,medicine.getName());
			stmt.setString(2, medicine.getDescription());
			stmt.setInt(3, medicine.getSellerId());
			stmt.setInt(4, medicine.getPrice());
			stmt.setInt(5, medicine.getOfferId());
			stmt.setInt(6, medicine.getTagId());
			stmt.setBoolean(7, medicine.isActive());
			stmt.setString(8, medicine.getImageUrl());
			stmt.setInt(9, medicine.getId());
			
			int result = stmt.executeUpdate();
			if(result > 0) {
				isSuccess=true;				
			}
			con.close();  
			} catch(Exception e){ 
				System.out.println(e);
			}    		
		return isSuccess;
	}

	
}
