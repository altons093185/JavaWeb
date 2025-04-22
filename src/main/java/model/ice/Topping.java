package model.ice;

import java.util.Arrays;
import java.util.List;

public class Topping {
	private List<String> toppings; // 配料集合
	private static final int TOPPING_PRICE = 10;
	
	//constructor
	public Topping(String[] toppingArray) {
		this.toppings = (toppingArray == null) ? null : Arrays.asList(toppingArray);
	}
	
	
	//getter
	public List<String> getToppings() {
		return toppings;
	}
	
	//method
	// 計算配料總金額
	public int calculateToppingPrice() {
		return (toppings == null) ? 0 : toppings.size() * TOPPING_PRICE;
	}
	
}
