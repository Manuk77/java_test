package org.example;

public class SortingMethods {
    /**
     * this method swaps the two given values
     * @param arr
     * @param indexOfVal1
     * @param indexOfVal2
     */
    public void swap (int[] arr, int indexOfVal1, int indexOfVal2) {
        arr[indexOfVal1] = arr[indexOfVal1] ^ arr[indexOfVal2] ^ (arr[indexOfVal2] = arr[indexOfVal1]);
    }

    /**
     * this method sorts the given array :)
     * in this method we use swap() method to change the two values places
     * @param arr
     */
    public int[] babbleSort (int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if  (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

        return arr;
    }

    /**
     * this method sorts the given arr :)
     * in this method we use swap() method to change the two values places
     * @param arr
     */
    public int[] selectionSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    /**
     * this method calculates and finds out were is the pivots place in the array and places there
     * in this method we use swap() method to change the two values place
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return pivotIndex
     */

    public int partition (int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int count = 0;
        for (int i = startIndex + 1; i <= endIndex; ++i){
            if (arr[i] <= pivot){
                count++;
            }
        }
        int pivotIndex = startIndex + count;
        swap(arr, startIndex, pivotIndex);

        int i = startIndex, j = endIndex;
        while (i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivot){
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < pivotIndex && j > pivotIndex){
                swap(arr, i, j);
            }
        }
        return pivotIndex;

    }

    /**
     * this is a recursive method  for sorting the given array
     * it calls the partition() method
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public void quickSort (int[] arr, int startIndex, int endIndex) {
        if(startIndex >= endIndex) return;

        int p = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, p - 1);
        quickSort(arr, p + 1, endIndex);
    }

    /**
     * this method sorts the given arr :)
     * @param arr
     */
    public int[] insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            //moves elements which are greater than key one position ahead
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    /**
     * sorts the given array
     * @param arr
     * @param left
     * @param middle
     * @param right
     */
    public void sort(int[] arr, int left, int middle, int right){
        //new array for the left side of division of original array
        int[] leftArr = new int[middle - left + 1];

        //new array for the right side of division of original array
        int[] rightArr = new int[right - middle];

        //left side sets to the new array
        for (int i = 0; i < leftArr.length; ++i) {
            leftArr[i] = arr[i];
        }

        //right side sets to the new array
        for(int i = 0, j = leftArr.length; i < rightArr.length; ++i) { //the right arr starts from where left array ends
            rightArr[i] = arr[j];
            j++;
        }

        int i = 0, j = 0;
        int k = left;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * this method is recursive method
     * which divides the given array for two equal pisses and then calls itself
     * for the left side and the right side:
     * when dividing ids over it calls sort() method for sorting every step of recursion
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int[] arr, int left, int right){
       if(left < right){
           int middle = left + (right - left) / 2;

           mergeSort(arr, left, middle);
           mergeSort(arr, middle + 1, right);

           sort(arr, left, middle, right);
       }

    }

    static int count = 0;

    /**
     * this method prints "durs vochmek chi mnacel :)" to m^n time(time complexity is O(m^n))
     * @param m
     * @param n
     */
    public  void nthRecursion(int m, int n){

        if(n > 0){
            for(int i = 0; i < m; ++i) {
                nthRecursion(m, n - 1);
            }

        } else {
                count++;
                System.out.println("count - > " + count + " durs vochmek chi mnace :)");
            return;
        }

    }

    /**
     * this method prints the given array
     * @param arr
     */
    public void printArr (int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
