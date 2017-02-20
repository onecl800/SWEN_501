package animate;

public class Pair {

	int x;
	int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return pairToNum(x, y);
	}
	
	@Override
	public boolean equals(Object o) {
		return x==((Pair)o).x && y==((Pair)o).y;
	}
	
	public int pairToNum(int x, int y){
		int a = inverseF(x);
		int b = inverseF(y);
		return cantor(a, b);
	}
	
	public int inverseF(int a){
		return a>=0 ? 2*a : ((-2)*(a))-1;
	}
	
	public int cantor(int x, int y){
		int n  = (int) ((0.5)*(x + y)*(x + y + 1))+y;
		return n;
	}
}
