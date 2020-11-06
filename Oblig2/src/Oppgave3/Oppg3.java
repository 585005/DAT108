package Oppgave3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Oppgave2.Employee;
import Oppgave2.Gender;

public class Oppg3 {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee("Anne", "Hill", Gender.NONBINARY, "Director", 2000000));
		employeeList.add(new Employee("Markus", "Diary", Gender.MALE, "Co-Director", 1500000));
		employeeList.add(new Employee("Hilde", "Gro", Gender.FEMALE, "Secretary", 300000));
		employeeList.add(new Employee("Marvin", "Halden", Gender.TWOSPIRIT, "Lawyer", 1000000));
		employeeList.add(new Employee("Guro", "Swift", Gender.GENDERNEUTRAL, "Cleaning Assistance", 99000));
		employeeList.add(new Employee("Hans", "Candy", Gender.GENDERNEUTRAL, "Child", 500));
		employeeList.add(new Employee("Luna", "Golden", Gender.FEMALE, "Dog", 40000));

//		printAll(employeeList);
//		System.out.println();

		// a
		List<String> lastname = employeeList.stream().map(p -> p.getLastname()).collect(Collectors.toList());

		// b
		long num = employeeList.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).count();

		// c
		OptionalDouble salary = employeeList.stream().filter(p -> p.getGender().equals(Gender.FEMALE))
				.mapToDouble(p -> p.getYearSalary()).average();

		// d
		List<Employee> updatedSalary = employeeList.stream().filter(p -> p.getPos().contains("Di"))
				.peek(p -> p.setYearSalary((int) (p.getYearSalary() * 1.07))).collect(Collectors.toList());

		// e
		boolean s = employeeList.stream().anyMatch(p -> p.getYearSalary() > 800000);

		// f
		employeeList.forEach(System.out::println);

		// g
		List<Employee> lowSalary = employeeList.stream().filter(p -> p.getYearSalary() < 90000)
				.collect(Collectors.toList());

		// h
		int sum = IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();

	}

	private static void printAll(List<Employee> employee) {
		for (Employee e : employee) {
			System.out.println(e);
		}
	}

}
