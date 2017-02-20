public class SelectionSort {
	static int counter = 0;
	static int comparison = 0;
	static int swap = 0;
 
    public static int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++) {
        	counter++;
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
            	counter++;
            	comparison++;
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            swap++;
            counter = counter+3;
        }
        
        return arr;
        
    }
     
    public static void main(String a[]){
         
//        int[] arr0 = {10,34,2,56,7,67,88,42};
//        int[] arra = doSelectionSort(arr0);
//        for(int i:arra){
//            System.out.print(i);
//            System.out.print(", ");
//        }
//        System.out.println(counter + " " + comparison + " " + swap);
        
      //random array
        int[] arr1 = {4, 10, 2, 9, 6, 23, 12, 34, 0, 1};
        int[] arr2 = doSelectionSort(arr1);
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
        int[] arr4 = doSelectionSort(arr3);
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
        int[] arr6 = doSelectionSort(arr5);
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
        int[] arr8 = doSelectionSort(arr7);
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
        int[] arr10 = doSelectionSort(arr9);
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
// See more at: http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.snSkMpIk.dpuf