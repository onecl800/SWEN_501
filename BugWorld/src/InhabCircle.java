import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class InhabCircle {
	private int dx;
	private int dy;
	private int radius;
	private	String name;
	
	
	//getters and setters
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setCy(int dy) {
		this.dy = dy;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//constructor
	public InhabCircle(int x, int y, int r) {
		dx = x;
		dy = y;
		radius = r;
	}
	
	public InhabCircle() {
		dx = -1;
		dy = -1;
		radius = 20;
	}
	public static void main(String[] args) {

	}
}
