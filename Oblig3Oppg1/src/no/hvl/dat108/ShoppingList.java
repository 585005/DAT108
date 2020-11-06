package no.hvl.dat108;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

	private List<String> items = new ArrayList<>();

	public void addItem(String item) {

		logInUtil.escapeHtml(item); // escape from html char
		items.add(item);
	}

	public void deleteItem(String delete) {
		for (String s : items) {
			if (s.contains(delete)) {// when the delete button value/id is set in doGet, the value will be the name
										// of the item
				items.remove(s);
				break;
			}
		}
	}

	public List<String> getItems() {
		return items;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}
