import java.util.Arrays;

public class Gop_mang {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9};
        int[] arr3 = new int[arr1.length + arr2.length];
        int k = 0;
        for (int j : arr1) {
            arr3[k] = j;
            k++;
        }
        for (int i : arr2) {
            arr3[k] = i;
            k++;
        }
        System.out.print(Arrays.toString(arr3));
    }
}
