package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int oN = sc.nextInt();
        int lN = sc.nextInt();
        int i = 0;
        double[] arr = new double[oN];
        while (i<oN){
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println(String.format("%.2f", answer(arr,oN,lN)));
    }

    public static double answer(double[] arr,int oN,int lN){
        int length = arr.length-1;
        Arrays.sort(arr);
        if(oN>=lN){
            if(arr[length]/lN>arr[arr.length-lN]){
                if(arr[length]/lN>arr[arr.length-lN]){
                    return arr[length]/lN;
                }
                return arr[length]/lN;
            }
            return arr[arr.length-lN];
        }else {
            int count = 0;
            for(int i = 0;i<=length;i++){
                count = (int) (arr[i]/arr[0] + count);
            }
            if(count == lN){
                return arr[0];
            }
            double num = lN-oN+1;
            return arr[length]/num;
        }
    }

}
