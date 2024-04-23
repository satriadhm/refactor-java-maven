package lib;


public class TaxFunction {

	public static final int BASE_INCOME_TAX_THRESHOLD = 54000000;
	public static final int BASE_INSURANCE_THRESHOLD = 4500000;
	public static final int CHILD_ALLOWANCE_PER_CHILD = 1500000;
	public static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {
		int tax = 0;

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 months working per year");
		}

		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}

		if (isMarried) {
			tax = (int) Math.round(TAX_RATE * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking)
					- deductible - (BASE_INCOME_TAX_THRESHOLD + BASE_INSURANCE_THRESHOLD
							+ (numberOfChildren * CHILD_ALLOWANCE_PER_CHILD))));
		} else {
			tax = (int) Math.round(TAX_RATE * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking)
					- deductible - BASE_INCOME_TAX_THRESHOLD));
		}

		if (tax < 0) {
			return 0;
		} else {
			return tax;
		}
	}
}