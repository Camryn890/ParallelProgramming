package serialAbelianSandpile;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class ParallelSimulation extends Thread{

    private int rows,columns;
    private int[][] grid;

    private int[][] updateGrid;
    int up;
    int down;
    int left;

    int right;


    public ParallelSimulation(int w, int h) {
        rows = w+2; //for the "sink" border
        columns = h+2; //for the "sink" border
        grid = new int[this.rows][this.columns];
        updateGrid=new int[this.rows][this.columns];
        /* grid  initialization */
        for(int i=0; i<this.rows; i++ ) {
            for( int j=0; j<this.columns; j++ ) {
                grid[i][j]=0;
                updateGrid[i][j]=0;
            }
        }
    }
    ParallelSimulation(int up, int down, int left, int right)
    {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    protected void compute()
    {
        if(up < 3 && down < 3 && left < 3 && right < 3)
        {
            System.out.print("done");
        }

        else
        {
         ParallelSimulation point = new ParallelSimulation(point.up,point,down, point.left,point.right);
        }
    }

}
