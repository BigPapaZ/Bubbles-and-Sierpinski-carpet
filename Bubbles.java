package zrandhawHWK5;


import java.util.Arrays;

public class Bubbles
{
    public static final int [][]  values = {{2, 6, 1, 3, 4, 8, 4, 6},
                                            {0, 3, 2, 9, 8, 4, 2, 1},
                                            {1, 2, 1, 0, 1, 6, 5, 8},
                                            {3, 9, 6, 2, 1, 1, 1, 2},
                                            {0, 3, 1, 2, 4, 4, 3, 1},
                                            {1, 3, 2, 1, 1, 1, 3, 6},
                                            {4, 9, 9, 9, 9, 9, 9, 4},
                                            {9, 8, 7, 6, 5, 4, 3, 2}};
    /*
    public static int bubbleMoney(int row, int col)
    {
        if(row<0||col<0||col>7){return 0;}
        else if (row==0){return values[row][col];}
        else{int x=values[row][col]+bubbleMoney(row-1,col-1);int y=values[row][col]+bubbleMoney(row-1,col+1);if(x>y)return x;else return y;}}
    */  
    
    public static int bubbleMoney(int row, int col)
    {
        if(row<0||col<0||col>7){return 0;}
        int[][] memo=new int[row+1][8];
        /*
        for (int[] r: memo)
        {Arrays.fill(r, -1);System.out.println(Arrays.toString(r));}
        */
        return memoHelper(row,col,memo);
    }
    public static int memoHelper(int row, int col, int[][] memo)
    {
        if(row<0||col<0||col>7){return 0;}
        else if (row==0){return values[row][col];}
        else
        {
            if(memo[row][col]>=0)
            {
                System.out.println("Greater then 0");
                return memo[row][col];
            }
            else
            {
                System.out.println("Less then 0");
                int x=values[row][col]+memoHelper(row-1,col-1,memo);
                int y=values[row][col]+memoHelper(row-1,col+1,memo);
                if(x>y){memo[row][col]=x;return x;}
                else {memo[row][col]=y;return y;}
            }
        }
    }
    
    
    public static void main(String [] args)
    {
        System.out.println(bubbleMoney(6,3));
    }
}