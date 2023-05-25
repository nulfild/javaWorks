package PW2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Human> peopleList = new ArrayList<>();
		peopleList.add(
			new Human(
				19,
				"Nastya",
				"Cool",
				LocalDate.of(2003, 12, 26),
				50
			)
		);
		peopleList.add(
			new Human(
				70,
				"Mike",
				"Brown",
				LocalDate.of(1953, 1, 4),
				67
			)
		);
		peopleList.add(
			new Human(
				19,
				"Nike",
				"Kun",
				LocalDate.of(2003, 12, 15),
				68
			)
		);
		peopleList.add(
			new Human(
				50,
				"Izabella",
				"Miko",
				LocalDate.of(1973, 1, 2),
				47
			)
		);

		int weightSum = peopleList
			.stream()
			.filter(human -> human.weight > human.age)
			.map(human -> {
				System.out.println(
					"After filtration: " + human
				);
				return human;
			})
			.sorted(
				Comparator
					.comparing(Human::getLastName)
					.reversed()
			)
			.map(human -> {
				System.out.println("After sorting: " + human);
				return human.weight;
			})
			.reduce((a, b) -> a + b)
			.get();

		System.out.println("All weight sum: " + weightSum);
	}
}
