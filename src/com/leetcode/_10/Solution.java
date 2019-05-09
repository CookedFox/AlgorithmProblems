package com.leetcode._10;

public class Solution {
    public static void main(String[] args){
        String inputString="caaaaaab";
        String patternString="c*a*.";
        boolean [][] matrix = new boolean[patternString.length()+1][inputString.length()+1];
        matrix[0][0]=true;
        for(int i=1;i<matrix.length;i++){
            if(patternString.charAt(i-1)=='*')
                matrix[i][0]=matrix[i-2][0];
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(patternString.charAt(i-1)=='.')
                    matrix[i][j]=matrix[i-1][j-1];
                else if(patternString.charAt(i-1)=='*')
                    matrix[i][j]=matrix[i-1][j]||(matrix[i][j-1]
                    &&patternString.charAt(i-2)==inputString.charAt(j-1));
                else
                    matrix[i][j]=patternString.charAt(i-1)==inputString.charAt(j-1)&&matrix[i-1][j-1];
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for (int j=0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
