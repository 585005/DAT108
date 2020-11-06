package Oppgave1;

import java.util.function.BiFunction;

public class Oppg1b {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> sumFunction = (a, b) -> a + b;
		BiFunction<Integer, Integer, Integer> biggestFunction = (a, b) -> {
			if (a > b) {
				return a;
			} else
				return b;
		};
		BiFunction<Integer, Integer, Integer> diffFunction = (a, b) -> a - b;

		int sum = calculate(12, 13, sumFunction);
		int biggest = calculate(-5, 3, biggestFunction);
		int diff = calculate(54, 45, diffFunction);

		System.out.println("Summen av 12 og 13 er: " + sum);
		System.out.println("Det største tallet av -5 og 3 er: " + biggest);
		System.out.println("Differansen mellom 54 og 45 er: " + diff);

	}

	public static int calculate(int a, int b, BiFunction<Integer, Integer, Integer> sumFunction) {
		return sumFunction.apply(a, b);

	}
}
