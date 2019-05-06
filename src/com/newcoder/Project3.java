package com.newcoder;

import java.util.ArrayList;
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
//例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
//针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
//{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
// public ArrayList<Integer> maxInWindows(int [] num, int size)
public class Project3 {
    public int getMax(int [] num){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            if(max<num[i])
                max=num[i];
        }
        return max;
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> returnNum=new ArrayList<>();
        if(size==0)
            return returnNum;
        for(int i=0;i<num.length;i++){
            if (i + size > num.length)
                break;
            int [] subNum=new int[size];
            for(int j=i;j<i+size;j++){
               subNum[j-i]=num[j];
            }
            returnNum.add(getMax(subNum));
        }
        return returnNum;
    }
    public static void main(String [] args){
        Project3 project3=new Project3();
        int []num={3,2,1,4};
        ArrayList<Integer> returnNum=project3.maxInWindows(num,2);
        for(int j=0;j<returnNum.size();j++){
            System.out.print(returnNum.get(j)+" ");
        }
    }
}
