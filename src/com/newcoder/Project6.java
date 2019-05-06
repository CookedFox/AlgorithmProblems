package com.newcoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
数组中有一个数字出现的次数超过数组长度的一半，
请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Project6 {

    public static  int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < array.length ; i++ ){
            Iterator<Integer> iterator = map.keySet().iterator();
            if(map.get(array[i])==null)
                map.put(array[i],1);
            else
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(array[i]==integer)
                        map.put(integer,map.get(integer)+1);
                }
        }
        System.out.print(map.toString());
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(map.get(integer)>=array.length/2)
                return integer;
        }
        return 0;
    }

    public static void main(String[] args){
        int [] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
