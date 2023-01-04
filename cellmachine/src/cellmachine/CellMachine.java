package cellmachine;

import javax.swing.JFrame;

import cell.Cell;
import field.Field;
import field.View;
//这三类都是在其他包里的，需要先import进来


/*
 * 1.类中只有main一个方法，制造了一个field对象，对各类的数据进行操作。
 * 2.用一个双层for循环，用place往field中放进一个个Cell元素。
 * 3.用一个双层for循环，用get取出field的每一个元素，并进行Math.abs < 0.2的判断，即有1/5的几率抽中某个细胞重生。
 * 4.CellMachine继承了JFrame，对JFrame进行常规的设置（setDefaultCloseOperation setResizable setTitle setVisible等），把field传入View中，field和view在cellmachine中发生了联系。
 * 5.用一个三层for循环，先通过规定循环的总次数，再取出field的每一个细胞。如果该细胞为活细胞，对它周围活着的邻居进行数量统计，数量 <2 或者数量 >3，则对该cell调用die方法。如果该细胞为死细胞，对它周围活着的邻居进行数量统计，数量 =3，则对该细胞调用reborn方法。
 * 6.用一个线程，设置每运行一次休眠200毫秒。
 */
public class CellMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Field field = new Field(30,30);
		//new一个新的30*30的棋盘对象
		for(int row=0;row<field.getHeight();row++) {
			for(int col=0;col<field.getWidth();col++) {
				field.place(row, col, new Cell());
			}
		}
		//两层循环，遍历棋盘上的每一个位置，在每一个坐标对应的位置创造一个新的细胞Cell（）
		for(int row=0;row<field.getHeight();row++) {
			for(int col=0;col<field.getWidth();col++) {
				Cell cell = field.get(row,col);
				if(Math.random()<0.2) {
					cell.reborn();   //细胞重生
				}//这里用了random随机在0-1之间，也就是棋盘上每一个细胞有1/5的重生概率
			}
		}
		//两层循环，遍历棋盘上的每个细胞，给细胞自动机初始化，给整个棋盘的细胞随机重生
		
		View view = new View(field);
		//new一个新的view对象，并告诉她field
		JFrame frame = new JFrame();
		//new一个新的JFrame对象，JFrame类的用处是创造一个JAVA窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//获得一个默认的关闭操作，当我们点击红叉时可以正常的关闭程序
		frame.setResizable(false);
		//窗口的大小不可以改变
		frame.setTitle("Cells");
		//设置标题
		frame.add(view);
		//把刚刚新建的view对象加进去
		frame.pack();
		//让它自己决定大小
		frame.setVisible(true);
		//创建窗口
		//以上这一块代码目的是创建一个细胞自动机运行的窗口
		
		for (int i=0; i<1000;i++) {
			//循环一千次细胞自动机的步骤
			for(int row=0;row<field.getHeight();row++) {
				for(int col=0;col<field.getWidth();col++) {
					//两次循环，遍历所有棋盘上的细胞
					Cell cell= field.get(row, col);
					//得到细胞的位置
					Cell[] neighbor = field.getNeighbor(row, col);
					//找到某个细胞的周围的邻居
					int numOflive=0;
					//初始化活着的邻居数量为0
					for(Cell c: neighbor) {
						if(c.isAlive()) {
							numOflive++;
							
						}
						//检查这个细胞的全部邻居，当发现一个邻居是isAlive（）的，也就是活着的，活着的邻居数量
					}
					System.out.print("["+row+"]["+col+"]:");
					//输出坐标
					System.out.print(cell.isAlive()?"live":"dead");
					//输出细胞当前状态
					System.out.println(":"+numOflive+"-->");
					//输出活着的邻居状态和细胞的下个状态（即将转变）
					if(cell.isAlive()) {
						if(numOflive<2||numOflive >3) {
							cell.die();
							System.out.println("die");
						}
						//检查活着的邻居数量，如果是<2活着>3的情况，该细胞死亡
					}else if(numOflive == 3) {
						cell.reborn();
						System.out.println("reborn");
					}
					//检查活着的邻居数量，如果是=3的情况，该细胞重生
					System.out.println();
							
				}
			}
			System.out.println("UPDATE");
			frame.repaint();
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
