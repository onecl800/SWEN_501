package animate;

public class Neighbourhood {
	Cell upperLeft;
	Cell upperMiddle;
	Cell upperRight;
	Cell middleLeft;
	Cell middleRight;
	Cell bottomLeft;
	Cell bottomMiddle;
	Cell bottomRight;
	

	public Neighbourhood(Cell ul, Cell um, Cell ur, Cell ml, Cell mr, Cell bl, Cell bm, Cell br){
		this.upperLeft = ul;
		this.upperMiddle = um;
		this.upperRight = ur;
		this.middleLeft = ml;
		this.middleRight = mr;
		this.bottomLeft = bl;
		this.bottomMiddle = bm;
		this.bottomRight = br;
	}


	public Cell getUpperLeft() {
		return upperLeft;
	}


	public void setUpperLeft(Cell upperLeft) {
		this.upperLeft = upperLeft;
	}


	public Cell getUpperMiddle() {
		return upperMiddle;
	}


	public void setUpperMiddle(Cell upperMiddle) {
		this.upperMiddle = upperMiddle;
	}


	public Cell getUpperRight() {
		return upperRight;
	}


	public void setUpperRight(Cell upperRight) {
		this.upperRight = upperRight;
	}


	public Cell getMiddleLeft() {
		return middleLeft;
	}


	public void setMiddleLeft(Cell middleLeft) {
		this.middleLeft = middleLeft;
	}


	public Cell getMiddleRight() {
		return middleRight;
	}


	public void setMiddleRight(Cell middleRight) {
		this.middleRight = middleRight;
	}


	public Cell getBottomLeft() {
		return bottomLeft;
	}


	public void setBottomLeft(Cell bottomLeft) {
		this.bottomLeft = bottomLeft;
	}


	public Cell getBottomMiddle() {
		return bottomMiddle;
	}


	public void setBottomMiddle(Cell bottomMiddle) {
		this.bottomMiddle = bottomMiddle;
	}


	public Cell getBottomRight() {
		return bottomRight;
	}


	public void setBottomRight(Cell bottomRight) {
		this.bottomRight = bottomRight;
	}
}
