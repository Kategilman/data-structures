import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.lang.Math;

//setting up overall class
public class HoughImage {
   //set up attributes-width,height,pixelcolors
    private int width;
    private int height;
    private int[][] pixelcolors;

    //set up contructor for attributes 
	public HoughImage (int width, int height){
        this.width = width;
        this.height = height;
        this.pixelcolors = new int[width][height];
    
    }
    
    public HoughImage(String fileName) throws IOException{
        BufferedImage inputImage = ImageIO.read(new File(fileName));
        this.width = inputImage.getWidth();
        this.height = inputImage.getHeight();
        this.pixelcolors = new int[this.width][this.height];
            for(int i=0; i<this.width;i++){
                for(int j=0; j<this.height;j++){
                    int rgbValue = inputImage.getRGB(i,j);
            rgbValue = ((rgbValue & 0xFF0000) >>> 16)+ ((rgbValue & 0xFF00) >>> 8) + (rgbValue & 0xFF);
            this.pixelcolors[i][j] = rgbValue;
                }
             }
            }
    
//setting up accessors 
	public int getValue(int row, int col){
        return this.pixelcolors[row][col];

    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public boolean setValue(int row, int col, int value){
       this.pixelcolors[row][col] = value;
        if (row<this.width&&col<this.height&&row>=0&&col>=0){
            return true;
        }
            return false;

    }
   
    public int getMax(){
        int currentMax = 0;
        for(int i=0; i<this.width;i++){
            for(int j=0; j<this.height;j++){
                if (this.pixelcolors[i][j]>currentMax){
                    currentMax=this.pixelcolors[i][j];
                }
            }
        }
        return currentMax;
    }

    public boolean contrast(int row, int col, int minContrast){
        if(row<this.width&&col<this.height&&row>=0&&col>=0){
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(row+i<this.width&&col+j<this.height&&row+i>=0&&col+j>=0){
                        int surrPixels = this.pixelcolors[row+i][col+j];
                        int diffPixels = (surrPixels-this.pixelcolors[row][col]);
                        if(diffPixels<minContrast){
                            return false;
                        }
                    }
                
                }
            }
            return true;
        }
        return false;
    }

    public boolean accumulate(int row, int col, int delta){
        if (row<width&&col<this.height&&row>=0&&col>=0){
            this.pixelcolors[row][col]+=delta;
            return true;
        }
            return false;
         }
    
    public void writeImage(String fileName) throws IOException{
        BufferedImage outputImage = new 
        BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        for(int i=0; i<this.width;i++){
            for(int j=0; j<this.height;j++){
                int normVal= (Math.round(this.pixelcolors[i][j] * 255 / getMax()));
                outputImage.setRGB(i, j, (normVal<< 16)| (normVal << 8) | 0xFF | 0xFF000000);
        }

    }
        ImageIO.write(outputImage, "PNG", new File(fileName));

    }
}
