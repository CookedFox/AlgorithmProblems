package com.leetcode._763;


import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> a;
        int[] indexs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (i - 1 >= 0 && j < indexs[i - 1])
                        indexs[i] = indexs[i - 1];
                    else
                        indexs[i] = j;
                }
            }
        }

        for (int i = 0; i < indexs.length; i++) {
            System.out.print(indexs[i] + " ");
        }
        System.out.println();

        for(int i=0;i<indexs.length;i++){
            int j=i;
            while(indexs[j]!=j){
                indexs[j]=indexs[indexs[j]];
                j=indexs[j];
            }
            indexs[i]=j;
        }

        for(int i=0;i<indexs.length;i++){
            System.out.print(indexs[i]+" ");
        }

        int count=0;
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<indexs.length;i++){
            if(i-1>=0&&indexs[i-1]!=indexs[i]){
                list.add(count);
                count=1;
            }
            else
                count++;
            if(i==indexs.length-1)
                list.add(count);
        }
        return list;
    }
    public static void main(String[] args){
        Solution solution =new Solution();
        System.out.println(solution.partitionLabels("qiejxqfnqceocmy").toString());
    }
}
