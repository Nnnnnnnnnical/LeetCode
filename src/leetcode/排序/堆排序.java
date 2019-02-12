package leetcode.排序;

public class 堆排序 {
    public static void main(String[] args) {

        int[] arr = {1, 5, 6, 8, 7, 2, 3, 4, 9};

        HeapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void HeapSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, n);
        }
        for (int i = n; i > 0; i--) {
            swap(arr, i);
            heapAdjust(arr, 0, i - 1);
        }
    }

    public static void heapAdjust(int[] arr, int parent, int length) {
        int temp = arr[parent];
        for (int i = parent * 2 + 1; i <= length; i = i * 2 + 1) {
            if (arr[i] < arr[i + 1] && i < length) {
                i++;
            }
            if (temp > arr[i]) {
                break;
            }

            arr[parent] = arr[i];
            parent = i;
        }
        arr[parent] = temp;

    }


    public static void swap(int[] arr, int i) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }
}