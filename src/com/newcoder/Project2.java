package com.newcoder;

//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
//路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
//例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
//因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
public class Project2 {
    //matrix为输入矩阵，inputString为输入字符串，flag矩阵判断该点时否已经经过，count记录输入字符串中字符的下标
    private static char [][] matrix;
    private static String inputString="SLHECCEIDEJFGGFIE";
    private static boolean [][] flag;
    private static int count;
    //将一维字符串转换成二维字符数组
    private static void fuckyou(String str,int rows,int cols){
        matrix=new char[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                matrix[i][j]=str.charAt(i*cols+j);
    }
    //初始化flag矩阵和count
    private static void init(){
       flag=new boolean[matrix.length][matrix[0].length];
       for(int i=0;i<flag.length;i++)
           for(int j=0;j<flag[0].length;j++)
               flag[i][j]=false;
       count=0;
    }
    //如果当前二维数组中的字符和字符串中的字符匹配时，还需要判断下一个字符是否也能够匹配，如果也匹配，就修改flag矩阵对应的位置，并count自增1
    //下一个字符不匹配，就不进行自增操作。
    //紧接着进入二维数组中的下一个字符
    //如果不匹配，直接返回
    private static void aux(int start_x,int start_y,int posi_x,int posi_y){
        if(count>=inputString.length()||posi_x<0||posi_y<0||posi_x>=matrix.length||posi_y>=matrix[0].length||matrix[posi_x][posi_y]!=inputString.charAt(count)||flag[posi_x][posi_y])
            return;
        flag[posi_x][posi_y] = true;
        if(count+1<inputString.length()&&((posi_x-1>=0&&matrix[posi_x-1][posi_y]==inputString.charAt(count+1)&&!flag[posi_x-1][posi_y])||
                (posi_x+1<matrix.length&&matrix[posi_x+1][posi_y]==inputString.charAt(count+1)&&!flag[posi_x+1][posi_y])||
                (posi_y-1>=0&&matrix[posi_x][posi_y-1]==inputString.charAt(count+1)&&!flag[posi_x][posi_y-1])||
                (posi_y+1<matrix[0].length&&matrix[posi_x][posi_y+1]==inputString.charAt(count+1)&&!flag[posi_x][posi_y+1])))
        {
            System.out.println(posi_x + " " + posi_y + "str:" + inputString.charAt(count) + "  matrix:" + matrix[posi_x][posi_y]);
            count++;
        }else if(count+1==inputString.length())
            count++;
        aux(start_x,start_y,posi_x+1,posi_y);
        aux(start_x,start_y,posi_x-1,posi_y);
        aux(start_x,start_y,posi_x,posi_y+1);
        aux(start_x,start_y,posi_x,posi_y-1);
    }
    //将二维数组中的每一个元素作为开头循环的测试，直到有匹配就返回结果。
    private static boolean referee(){
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                init();
                aux(i,j,i,j);
                if(count==inputString.length())
                    return true;
            }
         return false;
    }
    public static void main(String [] args){
        fuckyou("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8);
        if(referee())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
