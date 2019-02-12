package leetcode.排序;

public class 快排 {

    public static void main(String[] args){
        int[] array = {2,5,5,7,43,87,3,1};
        quickSort(array,0,array.length-1);
        for(int s:array){
            System.out.println(s);
        }
    }

    public static void quickSort(int[] array,int low,int high){
        if(low<high){
            int partition = partition(array,low,high);
            quickSort(array,low,partition-1);
            quickSort(array,partition+1,high);
        }
    }

    public static int partition(int[] array,int low,int high){
        while(low<high){
            while (low<high && array[low]<=array[high]){
                high--;
            }
            swap(array,low,high);
            while (low<high && array[high]>=array[low]){
                low++;
            }
            swap(array,low,high);
        }
        return low;
    }

    public static void swap(int[] array,int low,int high){
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

}
