
/**
 * 定义抽象类Income
 */
public abstract class Income {

	// TODO
	protected double income;
	public Income(double income) {
		this.income=income;
	}
	public double getTax() {
		return income*0.1;
	}
}
