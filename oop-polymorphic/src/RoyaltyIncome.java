
/**
 * 稿费收入税率是20%
 */
public class RoyaltyIncome extends Income {
	// TODO
	public RoyaltyIncome(double income) {
		super(income);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getTax() {
		return income*0.2;
	}

}
