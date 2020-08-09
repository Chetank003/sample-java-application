package com.coreJava.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class MainClass {
	static Scanner in = new Scanner(System.in);
	//method to initiate mysql connection
	private static Statement Connection() {
		Statement state = null;
		Connection connection = null;
		try {
			//initialize connection variable
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","root");
			state = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;     //statement variable to pass a query through this connection
	}

	public static void main(String[] args) {
		boolean choice = true;
		System.out.println("**********Sports database setup**********");
		
		try {
			//Drop any previous table if exists
			MainClass.Connection().executeUpdate("DROP TABLE IF EXISTS SPORT;");
			//create new SPORT table
			MainClass.Connection().executeUpdate("CREATE TABLE IF NOT EXISTS SPORT(SL_NO INT UNIQUE AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(20), NUM_OF_PLAYERS INT, TYPE_OF_SPORT VARCHAR(10) );");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Could not create Sport table in database");
		}
		
		
		
		while(choice) {
			int option;
				
			System.out.println("\nPlease select the required option :");
			System.out.println("1. Add Sport to the database.\n2. Display existing list of sport.\n3. Exit.");
			option = in.nextInt();
			switch(option) {
			case 1 : addSport();
					break;
			
			case 2 : viewSportsList();
					break;
					
			default : choice = false;
					break;
			}
		}
		System.out.println();
		System.out.println("**********Sports database setup terminated**********");
	}

	//displays the data in Sport table
	private static void viewSportsList() {
		ResultSet set = null;
		try {
			set = MainClass.Connection().executeQuery("SELECT * FROM SPORT");
			System.out.println(" NAME_OF_SPORT\t NUMBER_OF_PLAYERS\t TYPE_OF_SPORT");
			while(set.next()) 
				System.out.println(set.getString("NAME")+"\t\t"+set.getString("NUM_OF_PLAYERS")+"\t\t "+set.getString("TYPE_OF_SPORT"));
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Error occured while printing Sport table");
		}
	}

	//add sport data to the Sport table
	private static void addSport() {
		System.out.println("Please enter the following details of the Sport to be added :");
		System.out.println("Enter \"C\" if the sport is played in circular field or \"R\" if played in Rectangular one.");
		String fieldType = in.next();
		
		if(fieldType.equalsIgnoreCase("R")) {
			//Creating Rectangular class object
			Rectangular rSport = new Rectangular();
			
			//Getting the details of the sport
			System.out.print("Name of the Sport : ");
			String name = in.next();
			rSport.setNameOfSport(name);
			System.out.println();
			
			System.out.print("Number of players in the Sport : ");
			int nplayers = in.nextInt();
			rSport.setNumberOfPlayers(nplayers);
			System.out.println();
			
			System.out.print("Type of the Sport(Indoor/Outdoor) : ");
			String type = in.next();
			rSport.setTypeOfSport(type);
			System.out.println();
			
			//Inserting the Sport data into database
			try {
				MainClass.Connection().executeUpdate("INSERT INTO SPORT(NAME , NUM_OF_PLAYERS , TYPE_OF_SPORT ) VALUES (' "+rSport.getNameOfSport()+" ',' "+rSport.getNumberOfPlayers()+" ',' "+rSport.getTypeOfSport()+" ' );");
				System.out.println("Sport data succesfully entered into database!!");
			} catch (SQLException e) {
				System.out.println("Could not enter Sport details into database!!");
			}
			
			//Calculating Area and Perimeter of the field
			System.out.println("Please enter the following to calculate Area and perimeter of the field :");
			System.out.print("Length of the field : ");
			rSport.length = in.nextDouble();
			System.out.println();
			
			System.out.print("Breadth of the field : ");
			rSport.breadth = in.nextDouble();
			System.out.println();
			
			rSport.area();
			rSport.perimeter();
		}
		else if(fieldType.equalsIgnoreCase("C")) {
			//Creating Circular class object
			Circular cSport = new Circular();
			
			//Getting the details of the sport
			System.out.print("Name of the Sport : ");
			String name = in.next();
			cSport.setNameOfSport(name);
			System.out.println();
			
			System.out.print("Number of players in the Sport : ");
			int nplayers = in.nextInt();
			cSport.setNumberOfPlayers(nplayers);
			System.out.println();
			
			System.out.print("Type of the Sport(Indoor/Outdoor) : ");
			String type = in.next();
			cSport.setTypeOfSport(type);
			System.out.println();
			
			//Inserting the Sport into database
			try {
				MainClass.Connection().executeUpdate("INSERT INTO SPORT(NAME , NUM_OF_PLAYERS , TYPE_OF_SPORT ) VALUES (' "+cSport.getNameOfSport()+" ',' "+cSport.getNumberOfPlayers()+" ',' "+cSport.getTypeOfSport()+" ' );");
				System.out.println("Sport data succesfully entered into database!!");
			} catch (SQLException e) {
				System.out.println("Could not enter Sport details into database!!");
			}
			
			//Calculating Area and Perimeter(Circumference) of the field
			System.out.println("Please enter the following to calculate Area and perimeter(Circumference) of the field :");
			System.out.print("Radius of the field : ");
			cSport.radius = in.nextDouble();
			System.out.println();
			
			cSport.area();
			cSport.perimeter();
		}
		else {
			System.out.println("Please enter valid choice for the field type involved in the sport");
		}
		
	}

}
