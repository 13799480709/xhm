package field;

import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.*
import javax.swing.JPanel;
//import  javax.swing.*
import cell.Cell;
/*
 * 1.给常量GRID_SIZE赋值为16，表示每一个Cell的尺寸为16像素。有Field型属性theField。
 * 2.在构造器中，把传进来的每一个field赋值给theField
 * 3.View继承了JPanel，覆盖draw方法，在draw方法中用一个双层遍历for循环，get到theField的每个值，判断其不为空后调用cell的draw
 * 方法。draw的横纵坐标，为所在行列乘以GRID_SIZE。
 * 
 */
public class View extends JPanel {
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE =16;
	private Field theField;
	
	public View(Field field) {
		theField = field;
	}
	//记录了创建的field
	
	@Override
	//继承自Jpanel类的函数，是Java图形库中用来表示一块画面的类
	public void paint(Graphics g) {
		super.paint(g);
		//继承自父类Jpanel
		for(int row = 0;row<theField.getHeight();row++) {
			for(int col=0; col<theField.getWidth();col++) {
				Cell cell = theField.get(row, col);
				//两层循环，从field里面得到了每一个cell
				if(cell!=null) {
					cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);
				}//如果这个cell是存在的，就draw这个cell
			}
		}
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1,theField.getHeight()*GRID_SIZE+1);
		
	}
	
	public static void main(String args) {
//		Field field = new Field(10,10);
//		for(int row = 0; row<field.getHeight();row++) {
//			for(int col=0; col<field.getWidth();col++) {
//				field.place(row, col, new Cell());
//			}
//		}
//		View view = new View(field);
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.setTitle("Cells");
//		frame.add(view);
//		frame.pack();
//		frame.setVisible(true);
		
	}
}
