package cell;

import java.awt.Graphics;


/*
 * 1.返回布尔值的属性alive，用isAlive方法获取；
 * 2.die方法把alive属性设置为false；
 * 3.reborn方法把alive属性设置为true；
 * 4.draw方法传入画笔g、x坐标、y坐标、尺寸size，先drawRect，判断属性alive为真后再fillRect，默认颜色为黑色。
 */
public class Cell {
	
	private boolean alive=false;
	
	public boolean isAlive() {
		return alive;
	}
	public void die() {
		alive=false;
	}
	public void reborn() {
		alive = true;
	}
	public void draw(Graphics g,int x,int y,int size) {
		g.drawRect(x,y,size,size);
		//把细胞画上方框
		if(alive) {
			g.fillRect(x,y,size,size);
			//如果改细胞是活着的状态，则将该方框填起来（在棋盘中为黑色）
		}
	}

}
