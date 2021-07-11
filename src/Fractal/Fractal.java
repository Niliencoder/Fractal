package Fractal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Fractal {

    private final BufferedImage image;
    private final String name;

    public Fractal(int width, int height, String name){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.name = name;
    }

    public void save(String filename){
        File file = new File(filename + ".png");
        try {
            ImageIO.write(image, "png", file);
            System.out.println("Saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        File file = new File(name + ".png");
        try {
            ImageIO.write(image, "png", file);
            System.out.println("Saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void show(){
        if(image.getWidth() > 1200 || image.getHeight() > 1200) {
            System.err.println("Image to big to show!");
            return;
        }

        JFrame frame = new JFrame("Fractal - " + getName());
        frame.setSize(image.getWidth(), image.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(new JLabel(new ImageIcon(image)));

        frame.setVisible(true);
    }

}
