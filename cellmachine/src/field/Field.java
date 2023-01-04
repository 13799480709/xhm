package field;

import java.util.ArrayList;

import cell.Cell;
/*
 * 1.有2个整数型属性width和height，一个Cell型的二维数组field。
 * 2.在构造器中把width和height传入field中作为数组行列长度
 * 3.getWidth方法和getHeight方法用于属性width和height的值
 * 4.place方法把参数中的一个Cell传进参数中的行与列在field中的位置
 * 5.get方法通过参数中的row和col得到field[row][col]
 * 6.getNeighbor方法传进row和col两个整数，用一个ArrayList来接收邻居。遍历field[row][col]周围（row-1），（row+2）和（col-1），（col+2），并add进arrayList
 *
 */
public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	//创建一个关于棋盘上使用cell的二维数组
	
	public Field(int width,int height) {
		this.width=width;
		this.height=height;
		field = new Cell[height][width];
	}
	//创建一个Field构造器
	public int getWidth() {
		return width;
	}//获得棋盘宽度
	public int getHeight() {
		return height;
	}//获得棋盘高度
	public Cell place(int row,int col,Cell o) {
		Cell ret = field[row][col];
		field[row][col]=o;
		return ret;
	}
	//place（）函数，需要放入cell时放进棋盘
	public Cell get(int row,int col) {
		return field[row][col];
	}
	//get（）函数，需要得到某个位置时，返回坐标
	public Cell[] getNeighbor(int row,int col) {
		ArrayList<Cell> list = new ArrayList<>();
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				int r =row+i;
				int c=col+j;
				if(r>-1&&r<height && c> -1&& c<width&& !(r==row&&c==col)) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);
	}
}
