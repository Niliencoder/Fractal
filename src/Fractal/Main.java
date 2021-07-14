package Fractal;

public class Main {

    public static void main(String[] args) {

        Fractal m = new Mandelbrot(1200,1200,200, 0.5);
        //m.save(); //Saves the image as png
        //m.show(); //Shows the image in swing gui

        Julia j = new Julia(1200,1200,200, 0.5, 0, 0);
        //j.save();
        j.animate();
    }

}
