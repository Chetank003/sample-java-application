package com.coreJava.assignment;

public class Circular extends Sports {
	
	double radius;
	
	void area() {
		double area =  Math.PI * radius * radius;
		System.out.println("Area of "+getNameOfSport()+" field is : "+area);
	}

	void perimeter() {
		double perimeter =  2 * Math.PI * radius;
		System.out.println("Perimeter(Circumference) of "+getNameOfSport()+" field is : "+perimeter);
	}

}
