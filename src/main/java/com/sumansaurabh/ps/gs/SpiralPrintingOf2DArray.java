package com.sumansaurabh.ps.gs;

import com.sumansaurabh.ps.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpiralPrintingOf2DArray {

    static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0){
            return result;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd){

            for(int i = columnBegin ; i <= columnEnd ; i++){
                result.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++){
                result.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            if(rowBegin <= rowEnd){
                for(int i = columnEnd; i >= columnBegin; i--){
                    result.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if(columnBegin <= columnEnd){
                for(int i = rowEnd; i >=rowBegin; i--){
                    result.add(matrix[i][columnEnd]);
                }
            }

            columnBegin++;
        }

        return result;
    }


    public static void main(String[] args) {
        int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
        List<Integer> values = spiralOrder(a);
        values.forEach(value -> {
            System.out.println(value);
        });
    }
}
