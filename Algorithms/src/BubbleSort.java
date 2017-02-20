
public class BubbleSort {
	static int counter = 0;
	static int comparison = 0;
	static int swap = 0;		
	
    // logic to sort the elements
    public static void bubble_srt(int array[]) {
    	counter++;
    	int n = array.length;
    	 counter++;
        int k;
      //  counter++;
        for (int m = n; m >= 0; m--) {
        	//counter++;
            for (int i = 0; i < n - 1; i++) {
            	counter++;
                k = i + 1;
                counter++;
                comparison++;
                if (array[i] > array[k]) {
                	counter = counter+3;
                	swap++;
                    swapNumbers(i, k, array);
                }
            }
            printNumbers(array);
        }
    }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static void printNumbers(int[] input) {
          
      //  for (int i = 0; i < input.length; i++) {
      //      System.out.print(input[i] + ", ");
      //  }
      //  System.out.println("\n");
    }
  
    public static void main(String[] args) {
    	//random array 10 items
        int[] input = {4, 10, 2, 9, 6, 23, 12, 34, 0, 1};
        bubble_srt(input);
        System.out.println("Random numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //nearly sorted array 10 items
        int[] input2 = {1, 2, 4, 6, 12, 23, 9, 10, 34, 0};
        bubble_srt(input2);
        System.out.println("Nearly sorted numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //reversed array 10 items
        int[] input3 = {34, 23, 12, 10, 9, 6, 4, 2, 1, 0};
        bubble_srt(input3);
        System.out.println("Reversed numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        // array with duplicates 10 items
        int[] input4 = { 4, 9, 6, 6, 23, 12, 34, 34, 0, 1 };
        bubble_srt(input4);
        System.out.println("List with duplicate numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        // array with negative numbers 10 items
        int[] input5 = {-4, -10, -2, -9, -6, -23, -12, -34, 0, -1};
        bubble_srt(input5);
        System.out.println("Negative numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
    	
    	
    	//random array 5000 items
        int[] arrayData;
        arrayData = new int[5000];
        bubble_srt(arrayData);
        System.out.println("Random numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //nearly sorted array 5000 items
//        int[] input2 = {1, 2, 4, 6, 12, 23, 9, 10, 34, 0};
//        bubble_srt(input2);
//        System.out.println("Nearly sorted numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
//        
//        counter = 0;
//    	comparison = 0;
//    	swap = 0;
//        
//        //reversed array 5000 items
//        int[] input3 = {34, 23, 12, 10, 9, 6, 4, 2, 1, 0};
//        bubble_srt(input3);
//        System.out.println("Reversed numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
//        
//        counter = 0;
//    	comparison = 0;
//    	swap = 0;
//        
//        // array with duplicates 5000 items
//        int[] input4 = { 4, 9, 6, 6, 23, 12, 34, 34, 0, 1 };
//        bubble_srt(input4);
//        System.out.println("List with duplicate numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
//        
//        counter = 0;
//    	comparison = 0;
//    	swap = 0;
//        
//        // array with negative numbers 5000 items
//        int[] input5 = {-4, -10, -2, -9, -6, -23, -12, -34, 0, -1};
//        bubble_srt(input5);
//        System.out.println("Negative numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
//        
//        counter = 0;
//    	comparison = 0;
//    	swap = 0;

    	
    }
    
}


// See more at: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/#sthash.8Jnjj0jy.dpuf