package actividadClase;

import java.awt.*;
import java.util.*;



public abstract class  Tile implements GraphicElement, Clickable{
	
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean selected;
	private boolean locket;
	
	
	
	
	public Tile(int x, int y, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}




	public int getX() {
		return x;
	}




	public int getY() {
		return y;
	}




	public int getHeight() {
		return height;
	}




	public int getWidt() {
		return width;
	}
	public abstract void  paint(Graphics g);
	

	public boolean isSelected() {
		return selected;
		
	}
	public boolean isLocket() {
		return locket;
		
	}
	public void setSelected(boolean isLocket) {
		
	}
	public void setLocket(boolean isSelected) {
		
	}
	
	
	
	
	
	
	
	
	


}
