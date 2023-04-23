package actividadClase;

public abstract class Connector implements GraphicElement, Clickable {
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
