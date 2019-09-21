package com.sumansaurabh.ps.arrays;

public class SecondSmallestElementInArray {

    static int findSecondSmallest(int arr[]){

        int first , second, length ;

        length = arr.length;

        if(length < 2 ){
            return -1;
        }

        first  = second = Integer.MAX_VALUE;

        for(int i = 0; i < length ; i++){

            if(arr[i] < first){
                second = first;
                first = arr[i];
            }

            if(arr[i] < second && arr[i] > first){
                second = arr[i];
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int arr[] = {12, 13, 1, 10, 34, 1};
        int secondSmallest = findSecondSmallest(arr);
        System.out.println("Second smallest element in array : " + secondSmallest);
    }
}
