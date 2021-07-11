package Fractal;

public class Main {

    public static void main(String[] args) {

        Fractal m = new Mandelbrot(1200,1200,300);
        m.save(); //Saves the image as png
        m.show(); //Shows the image in swing gui

        //Fractal j = new Julia(1200,1200,300);
        //j.save();
        //j.show();
    }

}
