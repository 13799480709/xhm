package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
//		int balance=0;
//		while(true)
//		{
//			System.out.print("请投币：");
//			int amount=in.nextInt();
//			balance =balance + amount;
//			if( balance >= 10)
//			{
//				//打印车票
//				System.out.println("*****************");
//				System.out.println("*Java城际铁路专线*");
//				System.out.println("*  无指定座位票  *");
//				System.out.println("*  票价： 10元  *");
//				System.out.println("*****************");
//				//计算并打印找零
//				System.out.println("找零："+(balance-10));
//				balance=0;
//			}
//		
//		}
//		System.out.print("请输入一个数：");
//		int number=in.nextInt();
//		int count=0;
//		do 
//		{
//			number=number/10;
//			count=count+1;
//			System.out.println("number:"+number+";count:"+count);
//
//		}while(number>0);
//		System.out.println("该数为"+count+"位数");
		
		int number=(int)(Math.random()*100+1);  //[0,100)-->[0,100)-->[1,100]
		int a;
		int count =0 ;
		do
		{
			a=in.nextInt();
			count+=1;
			if(a>number)
			{
				System.out.println("偏大");
				
			}
			else if(a<number)
			{
				System.out.println("偏小");
			}
		}while(a!=number);
		System.out.println("恭喜你猜对了，你猜了"+count+"次");
	
	}

}
