package animate;

import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

	byte state;
	byte futureState;
	Neighbourhood neighbourhood;
	int gridRow;
	int gridColumn;

	public Cell(int length, int width, byte state, byte fS, Neighbourhood n, int gridX, int gridY) {
		super(width, length);
		this.state = state;
		this.futureState = fS;
		this.neighbourhood = n;
		this.gridRow = gridX;
		this.gridColumn = gridY;
	}

	public int getGridX() {
		return gridRow;
	}

	public void setGridX(int gridX) {
		this.gridRow = gridX;
	}

	public int getGridY() {
		return gridColumn;
	}

	public void setGridY(int gridY) {
		this.gridColumn = gridY;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public byte getFutureState() {
		return futureState;
	}

	public void setFutureState(byte futureState) {
		this.futureState = futureState;
	}

	public Neighbourhood getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(Neighbourhood neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	
	public boolean checkNhd(Cell c, Neighbourhood n){
		int s = 0;
		
		if(n.getUpperLeft()!= null) s=s+((int) n.getUpperLeft().getState());
		if(n.getUpperMiddle()!= null) s=s+((int) n.getUpperMiddle().getState());
		if(n.getUpperRight()!= null) s=s+((int) n.getUpperRight().getState());
		if(n.getMiddleLeft()!= null) s=s+((int) n.getMiddleLeft().getState());
		if(n.getMiddleRight()!= null) s=s+((int) n.getMiddleRight().getState());
		if(n.getBottomLeft()!= null) s=s+((int) n.getBottomLeft().getState());
		if(n.getBottomMiddle()!= null) s=s+((int) n.getBottomMiddle().getState());
		if(n.getBottomRight()!= null)s=s+((int) n.getBottomRight().getState());
		
		if((s==2 && c.getState()== (byte) 1) || s==3) return true;
		return false;
		
	}

}
