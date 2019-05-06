package com.newcoder;//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
//每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
//例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

//计算四连通可达的所有块数
public class Project1 {
    private static int count=0;
    private static boolean [][] temp;
    private static int m;
    private static int n;
    public static void init(){
       temp=new boolean[m][n];
    }
    public static void aux(int k,int x,int y){
        //当前块已被访问或者越界
        if (x<0||y<0||x>=m||y>=n||temp[x][y])
            return;
        //计算数位和
        String t=x+""+y;
        int result=0;
        for(int i=0;i<t.length();i++){
            String e=t.charAt(i)+"";
            result+=Integer.parseInt(e);
        }
        temp[x][y]=true;
        //如果数位和大于预定值，显然该块不可达。反之可达
        if(result<=k) {
            count++;
            System.out.println(x+""+y);
        }
        else
            return;
        //可达的最后一块显然是无法向四个方向扩展，借此判断结束
        if((x-1<0||temp[x-1][y])&&(y-1<0||temp[x][y-1])&&(x+1>=m||temp[x+1][y])&&(y+1>=n||temp[x][y+1])) {
            System.out.print("finish");
            return;
        }
        //向四个方向扩展
        aux(k,x+1,y);
        aux(k,x,y+1);
        aux(k,x-1,y);
        aux(k,x,y-1);
    }
    public static void main(String[] args){
        m=10;
        n=10;
        init();
        aux(5,0,0);
        System.out.print(count);
    }
}
