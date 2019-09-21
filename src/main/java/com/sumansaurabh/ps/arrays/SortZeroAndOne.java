package com.sumansaurabh.ps.arrays;

import com.sumansaurabh.ps.Utils;

public class SortZeroAndOne {

    public static void sortUsingReplacement(int[] arr){
        int length = arr.length;

        int countOfZero = 0;
        //count no of zeros
        for(int i = 0; i < length ; i++){
            if(arr[i] == 0){
                countOfZero = countOfZero + 1;
            }
        }

        for(int i = 0; i < countOfZero; i++){
            arr[i] = 0;
        }

        for(int i = countOfZero ; i < length ; i++){
            arr[i] = 1 ;
        }
    }

    public static void sortUsingTwoPointers(int[] arr){
        int left = 0 , right = arr.length - 1;

        for(int i = 0; i < arr.length; i++){
            //swap the value and increment the pointer
            if(left == right){
                break;
            }
            if( arr[left] == 0 && arr[right] == 0){
                    left++;
            }else if( arr[left] == 0 && arr[right] == 1){
                left++;
                right--;
            }else if(arr[left] == 1 && arr[right] == 1){
                right--;
            }else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }


        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        sortUsingTwoPointers(arr);
        Utils.printArray(arr);
    }
}
