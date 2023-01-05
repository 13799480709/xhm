package animal;

import java.util.ArrayList;

import field.Location;

public abstract class Animal {
	private  int ageLimit;
	private int breedableAge;
	private int age;
	private boolean isAlive =true;
	//构造函数
	public Animal(int ageLimit,int breedableAge) {
		this.ageLimit =ageLimit;
		this.breedableAge =breedableAge;
	}
	//获得年龄
	protected int getAge() {
		return age;
	}
	//获得寿命百分比
	protected double getAgePercent() {
		return (double)age /ageLimit;
	}
	
	public abstract Animal breed();
	
	public void grow() {
		age++;
		if(age > ageLimit)
			die();
	}
	public void die() {
		isAlive= false;
	}
	public boolean isAlive() {
		return isAlive;
	}
	//生育能力
	public boolean isBreedable() {
		return (age > breedableAge);
	}
	//周围空白格并移动
	public Location move(Location[] freeAdj) {
		Location ret= null;
		if (freeAdj.length>0 && Math.random()<0.02) {
			ret = freeAdj[(int)(Math.random()*freeAdj.length)];
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return " "+age+":"+(isAlive?"live":"dead");
	}
	//被吃掉
	public Animal feed(ArrayList<Animal> neighbour) {
		return null;
	}
	//增加寿命
	public void longerlife(int addage) {
		ageLimit+=addage;
	}
}
