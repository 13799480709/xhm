
/**
 * 稿费收入税率是20%
 */
public class RoyaltyIncome extends Income {

	// TODO
	public RoyaltyIncome(double income) {
		super(income);
	}
	public double getTax() {
		return income*0.2;
	}

}
