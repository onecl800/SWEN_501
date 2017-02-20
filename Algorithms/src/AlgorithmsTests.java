import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AlgorithmsTests {

	ArrayList<Integer> emptyList = new ArrayList<Integer>();
	
	
	//test empty list
	@Test
	public void testEmptyList() {
		int inOrder = 0;
		ArrayList<Integer> list = emptyList;
		
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i) < list.get(i+1)) {
				inOrder++;
			}
		}
		assertEquals(inOrder, list.size()-1);
	}

}


//testing that sorting algorithm has put list in order
//test empty list
//test duplicate values
//test elements in/out of order - ascending and descending
//test randomly generated lists
//test negative numbers