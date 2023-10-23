import java.io.*;
import java.util.*;

class Box{
    int i;
    int j;
    Box pre;
    public Box(int i1, int j1){
        i = i1;
        j = j1;
        pre = null;
    }
}

class MazeClass{
    final int MaxSize = 6;
    int[][] mg;
    int m, n;
    Queue <Box> qu;
    public MazeClass(int m1, int n1){
        m = m1;
        n = n1;
        mg = new int[MaxSize][MaxSize];
        qu = new LinkedList<Box>();
    }
    public void Setmg(int[][] a){
        for(int i = 0; i<m; i++)
        for(int j = 0; j<n; j++)
        mg[i][j] = a[i][j];
    }
    public void disppath(Box p){
        Box[] path = new Box[20];
        int cnt = 0;
        while(p!= null){
            path[cnt] = p;
            cnt++;
            p = p.pre;
        }
        for(int k=cnt-1; k>=0; k--)
            System.out.println("(" + path[k].i + "," + path[k].j + ")");
    }
    boolean mgpath(int xi, int yi, int xe, int ye){
        int i, j, i1 = 0, j1 = 0;
        Box b, b1;
        b = new Box(xi, yi);
        qu.offer(b);
        mg[xi][yi] = -1;
        while(!qu.isEmpty()){
            b = qu.poll();
            if(b.i == xe && b.j == ye){
                disppath(b);
                return true;
            }
            i = b.i; j = b.j;
            for(int di = 0; di < 4; di++){
                switch(di){
                    case 0: i1 = i -1; j1 = j; break;
                    case 1: i1 = i; j1 = j + 1; break;
                    case 2: i1 = i + 1; j1 = j; break;
                    case 3: i1 = i; j1 = j - 1; break;
                }
                if(i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && mg[i1][j1] == 0){
                    b1 = new Box(i1, j1);
                    b1.pre = b;
                    qu.offer(b1);
                    mg[i1][j1] = -1;
                }
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args){
        Scanner fin = new Scanner(System.in);
        MazeClass mz = new MazeClass(5, 5);
        int[][] a = new int[5][5];
        for(int i = 0; i < 5; i++)
        for(int j = 0; j < 5; j++)
        a[i][j] = fin.nextInt();
        mz.Setmg(a);
        mz.mgpath(0, 0, 4, 4);
    }
}
