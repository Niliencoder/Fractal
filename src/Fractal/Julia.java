package Fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Julia extends Fractal{

    public Julia(int width, int height, int threshold, double colorOffset, double cx, double cy){
        super(width, height, "Julia");
        BufferedImage image = getImage();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                double zx = (x-(width/2.0))*4.0/width; //Real
                double zy = (y-(height/2.0))*4.0/height; //Imaginary
                //double cx = -0.7;
                //double cy = 0.27015;
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

    public void animate(){
        JFrame frame = new JFrame("Fractal - " + getName());
        frame.setSize(getImage().getWidth(), getImage().getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel label = new JLabel(new ImageIcon(getImage()));

        frame.add(label);

        frame.setVisible(true);

        for(double i = 0; i < 2*Math.PI; i+=0.01){
            double cx = 0.7885 * Math.cos(i);
            double cy = 0.7885 * Math.sin(i);
            label.setIcon(new ImageIcon(new Julia(1200, 1200, 200,0.5, cx, cy).getImage()));
            frame.revalidate();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Done");
    }

}
