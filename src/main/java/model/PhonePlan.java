package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import model.CoffeeForm.CoffeeRule;

public class PhonePlan {

	private Double minutes;
	private Double GB;

	private static final List<PhoneContract> contracts = new ArrayList<>();

	static {
		// 初始化規則
		contracts.add(new PhoneContract("商務型", 1499, (minutes, GB) -> minutes > 1000 || GB > 50));
		contracts.add(new PhoneContract("一般用戶型", 660, (minutes, GB) -> minutes > 500 && GB > 10));
		contracts.add(new PhoneContract("長輩節省型", 200, (minutes, GB) -> minutes < 200 && GB < 1));

	}

	// inner class
	public static class PhoneContract {
		private String type;
		private int price;
		private BiPredicate<Double, Double> condition;

		// constructor
		public PhoneContract(String type, int price, BiPredicate<Double, Double> condition) {
			this.type = type;
			this.price = price;
			this.condition = condition;

		}
		
		public boolean matches(Double minutes, Double GB) {
			return condition.test(minutes, GB);
		}
		
		public String getResult() {
			return type + ": $" + price;
		}

	}

	public PhonePlan(Double minutes, Double GB) {
		this.minutes = minutes;
		this.GB = GB;
	}
	
	// 推薦方案
		public String getContracts() {
			return contracts.stream()
						.filter(contracts -> contracts.matches(minutes, GB))
						.findFirst()
						.map(PhoneContract::getResult)
						.orElse("無適合方案");
		}
		
		public Double getMinutes() {
			return minutes;
		}
		
		public Double getGb() {
			return GB;
		}

}
