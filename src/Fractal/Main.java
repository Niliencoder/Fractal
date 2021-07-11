package Fractal;

public class Main {

    public static void main(String[] args) {

        Fractal f = new Mandelbrot(1200,1200,300);
        //f.save();
        f.show();

        f = new Julia(1200,1200,300);
        //f.save();
        f.show();
    }

}
