package Oppgave2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Oppg2 {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee("Anne", "Hill", Gender.NONBINARY, "Director", 2000000));
		employeeList.add(new Employee("Hilde", "Gro", Gender.FEMALE, "Secretary", 300000));
		employeeList.add(new Employee("Marvin", "Halden", Gender.TWOSPIRIT, "Lawyer", 1000000));
		employeeList.add(new Employee("Guro", "Swift", Gender.GENDERNEUTRAL, "Cleaning Assistance", 99000));

		printAll(employeeList);
		System.out.println();

		// ett fast kronetillegg
		salarySettlement(employeeList, a -> a.setYearSalary(a.getYearSalary() + 5000), a -> true);

		// ett fast kronetillegg hvis gender er TWOSPIRIT
		salarySettlement(employeeList, a -> a.setYearSalary(a.getYearSalary() + 30000),
				a -> a.getGender().equals(Gender.TWOSPIRIT));

		// ett fast kronetillegg hvis du har lav lønn
		salarySettlement(employeeList, a -> a.setYearSalary(a.getYearSalary() + 500), a -> a.getYearSalary() < 100000);

		// ett fast prosenttillegg
		salarySettlement(employeeList, a -> a.setYearSalary((int) (a.getYearSalary() * 1.07)), a -> true);

		// ett fast prosenttillegg hvis du har lav lønn
		salarySettlement(employeeList, a -> a.setYearSalary((int) (a.getYearSalary() * 1.07)),
				a -> a.getYearSalary() < 100000);

	}

	private static void salarySettlement(List<Employee> employeeList, Function<Employee, Integer> function,
			Predicate<Employee> predicate) {
		for (Employee e : employeeList) {

			if (predicate.test(e)) {

				function.apply(e);

				System.out.println(
						"Employee with name " + e.getFirstname() + " " + e.getLastname() + " had year salary updated");
			}
		}
	}

	private static void printAll(List<Employee> employee) {
		for (Employee e : employee) {
			System.out.println(e);
		}
	}

}
