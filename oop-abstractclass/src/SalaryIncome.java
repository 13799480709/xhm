
public class SalaryIncome extends Income {

	// TODO
	public SalaryIncome(double income) {
		super(income);
	}
	public double getTax() {
		return (income-5000)*0.2;
	}

}
