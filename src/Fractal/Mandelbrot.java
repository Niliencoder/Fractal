package Fractal;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends Fractal{

    public Mandelbrot(int width, int height, int threshold, double colorOffset){
        super(width, height, "Mandelbrot");
        BufferedImage image = getImage();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                double zx = 0; //Real
                double zy = 0; //Imaginary
                double cx = (x-(width/2.0))*4.0/width;
                double cy = (y-(height/2.0))*4.0/height;
                int k = 0;

                while (k < threshold && zx*zx+zy*zy <= 4){
                    double tmp = zx*zx - zy*zy + cx;
                    zy = 2*zy*zx + cy;
                    zx = tmp;
                    k++;
                }

                if(k < threshold){
                    double ratio = (double) k/threshold;
                    ratio = (ratio + colorOffset)%1;

                    //int red = (int) (ratio*255);
                    //int blue = (int) ((1-ratio)*255);
                    //image.setRGB(x, y, new Color(red,0,blue).getRGB());
                    image.setRGB(x ,y, Color.HSBtoRGB((float) ratio, 0.9f,1));
                }else{
                    image.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }

    }

}
