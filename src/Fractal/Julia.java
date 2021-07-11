package Fractal;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Julia extends Fractal{

    public Julia(int width, int height, int threshold){
        super(width, height, "Julia");
        BufferedImage image = getImage();

        double offset = 0.5;

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){

                double zx = (x-(width/2.0))*4.0/width; //Real
                double zy = (y-(height/2.0))*4.0/height; //Imaginary
                double cx = -0.7;
                double cy = 0.27015;
                int k = 0;

                while (k < threshold && zx*zx+zy*zy <= 4){
                    double tmp = zx*zx - zy*zy + cx;
                    zy = 2*zy*zx + cy;
                    zx = tmp;
                    k++;
                }

                if(k < threshold){
                    double ratio = (double) k/threshold;
                    ratio = (ratio + offset)%1;

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
