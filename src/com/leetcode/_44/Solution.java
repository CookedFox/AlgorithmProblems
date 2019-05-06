package com.leetcode._44;

public class Solution {

    public static void main(String[] args){

        String str = "acc";
        String reg = "a?c";
        boolean [][] matrix = new boolean[reg.length()+1][str.length()+1];
        for(int i=0;i<matrix.length;i++)
            matrix[i][0]=false;
        for(int i=0;i<matrix[0].length;i++)
            matrix[0][i]=false;
        matrix[0][0] = true;
        for(int i=1;i<matrix.length;i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(reg.charAt(i-1)!='*'&&reg.charAt(i-1)!='?')
                    matrix[i][j]=matrix[i-1][j-1]&&reg.charAt(i-1)==str.charAt(j-1);
                else if(reg.charAt(i-1)=='*')
                   matrix[i][j]=matrix[i-1][j]||matrix[i][j-1]||matrix[i-1][j-1];
                else
                    matrix[i][j]=matrix[i-1][j-1];
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(matrix[reg.length()][str.length()]);
    }
}
