package thuat_toan_tim_kiem_nhi_phan_su_dung_de_quy;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right, int value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        while (right > left) {
            int mid = (right + left) / 2;
            if (array[mid] > value) {
                right = mid - 1;
            } else if (array[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 3, 1, 7, 5};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 6));
    }
}
