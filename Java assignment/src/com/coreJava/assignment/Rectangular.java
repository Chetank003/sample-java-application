package com.coreJava.assignment;

public class Rectangular extends Sports {
	
	double length;
	double breadth;
	
	void area() {
		double area =  length * breadth;
		System.out.println("Area of "+getNameOfSport()+" field is : "+area);
	}

	void perimeter() {
		double perimeter =  2 * (length + breadth);
		System.out.println("Perimeter of "+getNameOfSport()+" field is : "+perimeter);
	}

}
