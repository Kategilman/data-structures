import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//import jdk.javadoc.internal.tool.resources.javadoc;

import java.lang.Math;

//setting up overall class of HoughImage 
public class HoughImage {
    private int width;
    private int height;
    private int[][] pixelcolors;
    public HoughImage (int width, int height){
        this.width = width;
        this.height = height;
        this.pixelcolors = new int[width][height];
    }
    //second constructor, setting up empty buffered image file with width and height 
    public HoughImage(String fileName) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(fileName));
        this.width = inputImage.getWidth();
        this.height = inputImage.getHeight();
        this.pixelcolors = new int[this.width][this.height];
            for(int i=0; i<this.height;i++){
                for(int j=0; j<this.width;j++){
                    int rgbValue = inputImage.getRGB(j,i);
                    rgbValue = ((rgbValue & 0xFF0000) >>> 16) + ((rgbValue & 0xFF00) >>> 8) + (rgbValue & 0xFF);
                    this.pixelcolors[j][i]=rgbValue;
                }
            }
    }
//setting up accessors of getValue, getWidth, and getHeight
    public int getValue(int row, int col){
        return this.pixelcolors[row][col];
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    //first boolean setting value as long as the row and col exist 
    public boolean setValue(int row, int col, int value){
        if (row < width && col < height && row >= 0 && col >= 0){
            this.pixelcolors[row][col] = value;
            return true;
        }
            return false;
    }
    //finding the Max of pixel colors index
    public int getMax(){
        int currentMax = this.pixelcolors[0][0];
        for(int i=0; i<this.height;i++){
            for(int j=0; j<this.width;j++){
                int currentValue = this.pixelcolors[j][i];
                //System.out.println(currentValue);
                if (currentValue>currentMax){
                    currentMax=currentValue;
                }
            }
        }
        return currentMax;
    }
    //making sure that  all of the indexes of pixel colors are less than the minContrast
    public boolean contrast(int row, int col, int minContrast){
        if(row < width-1 && col < height-1 && row>0 && col>0){
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(row+i < width && col+j < height && row+i >= 0 && col+j >= 0){
                        int surrPixels = this.pixelcolors[row+i][col+j];
                        int diffPixels = Math.abs(this.pixelcolors[row][col]-surrPixels);
                        if(diffPixels>=minContrast){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    //adding delta to each index of pixel colors 
    public boolean accumulate(int row, int col, int delta){
        if (row<width&&col<height&&row>=0&&col>=0){
            this.pixelcolors[row][col]+=delta;
            return true;
        }
            return false;
         }
    //writing the Image using for loops and bringing in setRGB 
    public void writeImage(String fileName) throws IOException{
       BufferedImage outputImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        //HoughImage img = new HoughImage(fileName);
        int n = getMax();
        System.out.println(n);
        for(int i=0; i<this.height;i++){
            for(int j=0; j<this.width;j++){
                // System.out.println(this.pixelcolors[i][j]);
                int normVal= (int)(Math.round((this.pixelcolors[j][i]) * 255 / n));
                //outputImage.setRGB(j,i,normVal);
                outputImage.setRGB(j, i, (normVal<< 16)| (normVal << 8) | 0xFF | 0xFF000000);
            }
        }
        ImageIO.write(outputImage, "PNG", new File(fileName));
    }

}















