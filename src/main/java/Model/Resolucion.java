package Model;

public class Resolucion {

    public Resolucion (double width, double height){

        setHeight(height);
        setWidth(width);

    }

    public double width;
    public double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
