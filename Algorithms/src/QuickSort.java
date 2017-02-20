 
public class QuickSort {
	static int counter = 0;
	static int comparison = 0;
	static int swap = 0;
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
        
    	comparison = comparison+2;
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        counter++;
        this.array = inputArr;
        counter++;
        length = inputArr.length;
        counter++;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
        counter++;
        int i = lowerIndex;
        counter++;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        counter++;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        counter++;
        comparison++;
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
        	counter++;
        	comparison++;
            while (array[i] < pivot) {
            	counter++;
                i++;
            }
            counter++;
            comparison++;
            while (array[j] > pivot) {
            	counter++;
                j--;
            }
            comparison++;
            if (i <= j) {
            	swap++;
            	counter++;
                exchangeNumbers(i, j);
                //move index to next position on both sides
                counter = counter+2;
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
       	counter++;
        comparison++;
        if (lowerIndex < j) {
        	counter++;
            quickSort(lowerIndex, j);
            counter++;
        	comparison++;
        }
        if (i < higherIndex) {
        	counter++;
            quickSort(i, higherIndex);
        }
    }
 
    private void exchangeNumbers(int i, int j) {
    	counter++;
        int temp = array[i];
        swap++;
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
         
        QuickSort sorter = new QuickSort();
        
//        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
//        sorter.sort(input);
//        for(int i:input){
//            System.out.print(i);
//            System.out.print(" ");
//        }
        
      //random array
        int[] arr1 = {4, 10, 2, 9, 6, 23, 12, 34, 0, 1};
        sorter.sort(arr1);
        for(int i:arr1){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("Random numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //nearly sorted array
        int[] arr2 = {1, 2, 4, 6, 12, 23, 9, 10, 34, 0};
        sorter.sort(arr2);
        for(int i:arr2) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("Nearly sorted  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
        //reversed array
        int[] arr3 = {34, 23, 12, 10, 9, 6, 4, 2, 1, 0};
        sorter.sort(arr3);
        for(int i:arr3) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("Reversed numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;

        //array with duplicates
        int[] arr4 = {4, 9, 6, 6, 23, 12, 34, 34, 0, 1 };
        sorter.sort(arr4);
        for(int i:arr4) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("With duplicate numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
       //array with negative numbers
        int[] arr5 = {-4, -10, -2, -9, -6, -23, -12, -34, 0, -1};
        sorter.sort(arr5);
        for(int i:arr5) {
        	System.out.print(i);
        	System.out.print(", ");
        }
        System.out.println("With negative numbers  Counter: "  + counter  + " Comparisons: " + comparison + " swap: " + swap);
        
        counter = 0;
    	comparison = 0;
    	swap = 0;
        
    }
}
// See more at: http://www.java2novice.com/java-sorting-algorithms/quick-sort/#sthash.oHBtB39x.dpuf