public class Points {

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public double getW() { return w; }

    private double x,y,z,w;


    Points(double x_real, double y_real, double z_real, double weight_real){
        x = x_real;
        y = y_real;
        z = z_real;
        w = weight_real;
    }
    public void showData(){
        double total = x + y + z;
        System.out.println(
                "x - "+ x
                + ", y - " + y
                + ", z - "+ z
                + ", weight - " + w
                + ", total length - " + total);
    }
}
