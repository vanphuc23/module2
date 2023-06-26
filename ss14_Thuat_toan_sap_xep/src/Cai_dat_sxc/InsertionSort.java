package Cai_dat_sxc;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key=array[i];
            int j;
            for (j = i-1; j >= 0 && array[j] > key; j--) {
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr={12,2,8,5};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
