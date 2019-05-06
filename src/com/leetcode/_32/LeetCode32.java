package com.leetcode._32;

class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1)
            return 0;
        boolean [][] p =new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            for(int j=0;j<s.length();j++)
                p[i][j]=false;
        int start_index=0;
        int end_index=0;
        for(int j=1;j<s.length();j=j+2){
            int k=j;
            for(int i=0;i<s.length()-j;i++,k++){
                if(k-i==1&&s.charAt(i)=='('&&s.charAt(k)==')')
                    p[i][k]=true;
                if((k-1>=i+1&&p[i+1][k-1]&&s.charAt(i)=='('&&s.charAt(k)==')'))
                    p[i][k]=true;
                int m=1;
                while(k-(m<<1)>=i){
                    if(p[i][k-(m<<1)]&&p[k-(m<<1)+1][k]){
                        p[i][k]=true;
                        break;
                    }
                    m++;
                }
                m=1;
                while(i+(m<<1)<=k){
                    if(p[i+(m<<1)][k]&&p[i][i+(m<<1)-1]){
                        p[i][k]=true;
                        break;
                    }
                    m++;
                }
                if(p[i][k]){
                    start_index=i;
                    end_index=k;
                }
            }
        }
        return (end_index-start_index+1)%2==0?end_index-start_index+1:0;
    }
}