package lib;

public class Compensation {
    
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

    public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

    public void setMonthlySalary(int salary) {
        this.monthlySalary = salary;
    }

    public int getMonthlySalary() {
        return this.monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return this.otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return this.annualDeductible;
    }

}
