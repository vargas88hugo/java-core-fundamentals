package com.chapter6.interfaces;

import java.util.*;

/**
 * This program demonstrates the use of Comparable Interface
 * @author 	Hugo Vargas
 * @version	2019-12-27
 */
public class EmployeeSortTest {

	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry Cracker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);
		
		Arrays.sort(staff);
		
		for (Employee e : staff)
		{
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
		}
	}

}
