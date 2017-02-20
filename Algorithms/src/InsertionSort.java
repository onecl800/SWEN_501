public class InsertionSort {
	static int counter = 0;
	static int comparison = 0;
	static int swap = 0;
	
    public static int[] doInsertionSort(int[] input){
    	
    	counter++;
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
            	counter++;
            	comparison++;
                if(input[j] < input[j-1]){
                	counter++;
                	swap++;
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    
    public static void main(String a[]){
    	
    	//random array
        int[] arr1 = {4, 10, 2, 9, 6, 23, 12, 34, 0, 1};
        int[] arr2 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("Random numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;

        
        //nearly sorted array
        int[] arr3 = {1, 2, 4, 6, 12, 23, 9, 10, 34, 0};
        int[] arr4 = doInsertionSort(arr3);
        for(int i:arr4) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("Nearly sorted  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //reversed array
        int[] arr5 = {34, 23, 12, 10, 9, 6, 4, 2, 1, 0};
        int[] arr6 = doInsertionSort(arr5);
        for(int i:arr6) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("Reversed numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;

        //array with duplicates
        int[] arr7 = {4, 9, 6, 6, 23, 12, 34, 34, 0, 1 };
        int[] arr8 = doInsertionSort(arr7);
        for(int i:arr8) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("With duplicate numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
       //array with negative numbers
        int[] arr9 = {-4, -10, -2, -9, -6, -23, -12, -34, 0, -1};
        int[] arr10 = doInsertionSort(arr9);
        for(int i:arr10) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("With negative numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
    }
  
}


//See more at: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.mddiQO0U.dpuf
