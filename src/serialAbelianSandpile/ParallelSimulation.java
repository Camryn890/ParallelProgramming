package serialAbelianSandpile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class ParallelSimulation extends RecursiveAction{

    private int rows,columns;
    private int[][] grid;

    private int[][] updateGrid;
    int up;
    int down;
    int left;

    int right;


    // create grid from serial
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

    @Override
    protected void compute()
    {
        if(up < 3 && down < 3 && left < 3 && right < 3)
        {
            System.out.print("done");
        }

        else
        {
         //ParallelSimulation point = new ParallelSimulation(point.up,point,down, point.left,point.right);
        }
    }



    // grid to image from serial
    void gridToImage(String fileName) throws IOException {
        BufferedImage dstImage =
                new BufferedImage(rows, columns, BufferedImage.TYPE_INT_ARGB);
        //integer values from 0 to 255.
        int a=0;
        int g=0;//green
        int b=0;//blue
        int r=0;//red

        for( int i=0; i<rows; i++ ) {
            for( int j=0; j<columns; j++ ) {
                g=0;//green
                b=0;//blue
                r=0;//red

                switch (grid[i][j]) {
                    case 0:
                        break;
                    case 1:
                        g=255;
                        break;
                    case 2:
                        b=255;
                        break;
                    case 3:
                        r = 255;
                        break;
                    default:
                        break;

                }
                // Set destination pixel to mean
                // Re-assemble destination pixel.
                int dpixel = (0xff000000)
                        | (a << 24)
                        | (r << 16)
                        | (g<< 8)
                        | b;
                dstImage.setRGB(i, j, dpixel); //write it out


            }}

        File dstFile = new File(fileName);
        ImageIO.write(dstImage, "png", dstFile);
    }

}
