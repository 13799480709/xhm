package com.itranswarp.learnjava;

import java.util.Scanner;

/**
 * switch实现石头/剪子/布并判断胜负
 */
public class Main {

	public static void main(String[] args) {
		for(;;) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please choice:");
		System.out.println(" 1: Rock");
		System.out.println(" 2: Scissors");
		System.out.println(" 3: Paper");
		System.out.println(" 4: Exit");
		// 用户输入:
		int choice = scanner.nextInt();
		if (choice==4) break;
		// 计算机随机数 1, 2, 3:
		int random = (int)(1 + Math.random() * 3);
		System.out.printf("电脑选择%d\n",random);
		switch (choice) {
		// TODO:
		case 1:
			if(random==1) 
			{
				System.out.println("平局");
			}
			else if(random==2) {
				System.out.println("玩家赢");
			}
			else {
				System.out.println("电脑赢");
			}
			break;
		case 2:
			if(random==2) 
			{
				System.out.println("平局");
			}
			else if(random==3) {
				System.out.println("玩家赢");
			}
			else {
				System.out.println("电脑赢");
			}
			break;
		case 3:
			if(random==3) 
			{
				System.out.println("平局");
			}
			else if(random==1) {
				System.out.println("玩家赢");
			}
			else {
				System.out.println("电脑赢");
			}
			break;
		default : 
		}
		}
	}

}
