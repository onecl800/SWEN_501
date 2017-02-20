public class MergeSort {
	static int counter = 0;
	static int comparison = 0;
	static int swap = 0;
     
    private int[] array;
    private int[] tempMergArr;
    private int length;
 

     
    public void sort(int inputArr[]) {
    	counter++;
        this.array = inputArr;
        counter++;
        this.length = inputArr.length;
        counter++;
        this.tempMergArr = new int[length];
        counter++;
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
    	counter++;
    	comparison++;
        if (lowerIndex < higherIndex) {
        	counter++;
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            counter++;
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            counter++;
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            counter++;
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
    	
    	counter++;
        for (int i = lowerIndex; i <= higherIndex; i++) {
        	swap++;
        	counter++;
            tempMergArr[i] = array[i];

        }
        counter++;
        int i = lowerIndex;
        counter++;
        int j = middle + 1;
        counter++;
        int k = lowerIndex;
        counter++;
        comparison = comparison+2;
        while (i <= middle && j <= higherIndex) {
        	counter++;
        	comparison++;
            if (tempMergArr[i] <= tempMergArr[j]) {
            	swap++;
                counter++;
                array[k] = tempMergArr[i];
                counter++;
                i++;
            } else {
            	counter++;
            	swap++;
                array[k] = tempMergArr[j];
                counter++;
                j++;
            }
            counter++;
            k++;
        }
        counter++;
        comparison++;
        while (i <= middle) {
        	counter++;
        	swap++;
            array[k] = tempMergArr[i];
            counter++;
            k++;
            counter++;
            i++;
        }
 
    }
    
    public static void main(String a[]){
        
    	//random array
        int[] arr1 = {4, 10, 2, 9, 6, 23, 12, 34, 0, 1};
        MergeSort mms1 = new MergeSort();
        mms1.sort(arr1);
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
        MergeSort mms2 = new MergeSort();
        mms2.sort(arr2);
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
        MergeSort mms3 = new MergeSort();
        mms3.sort(arr3);
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
        MergeSort mms4 = new MergeSort();
        mms4.sort(arr4);
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
        MergeSort mms5 = new MergeSort();
        mms5.sort(arr5);
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


//See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.8qUIzjFo.dpuf
