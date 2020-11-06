package Oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("10", "1", "20", "110", "21", "12");

		Comparator<String> sort = (a, b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b));

		Collections.sort(list, sort);
		System.out.println(list);

	}

}
