
public class ControlCircles {
	float dx  = -1;
	float dy = -1;
	int radius = 10;
	
	//getters and setters
	public float getDx() {
		return dx;
	}
	public void setDx(float dx) {
		this.dx = dx;
	}
	public float getDy() {
		return dy;
	}
	public void setDy(float dy) {
		this.dy = dy;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	//constructor
	public ControlCircles(float x, float y, int radius) {
		this.setDx(x);
		this.setDy(y);
		radius = 10;
	}
}
