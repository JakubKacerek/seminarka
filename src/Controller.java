import java.util.*;

public class Controller {

    public static Points[] objects = new Points[1000];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        for (int i = 0; i < 1000; i ++){
            Points point = new Points(
                      rn.nextDouble(0,5)
                    , rn.nextDouble(0,5)
                    , rn.nextDouble(0,5)
                    , rn.nextDouble(0,5));
            point.showData();
            objects[i] = point;
        }

        System.out.println("\nTěžnice bodů X: "+ weightingPointsX());
        System.out.println("Těžnice bodů Y: "+ weightingPointsY());
        System.out.println("Těžnice bodů Z: "+ weightingPointsZ());
        System.out.println("Celková hmostnost působící na těžiště: "+ totalWeight());

        Points_Sorter.quickSort(objects, 0, objects.length-1);
        Points_Sorter.printArray(objects, objects.length);

    }

    static double weightingPointsX(){
        double weightedPointX = 0;
        for (int i = 0; i < objects.length; i++){
            double temp = objects[i].getX() * objects[i].getW();
            weightedPointX += temp;
        }
        weightedPointX /= objects.length;
        return weightedPointX;
    }

    static double weightingPointsY(){
        double weightedPointY = 0;
        for (int i = 0; i < objects.length; i++){
            double temp = objects[i].getY() * objects[i].getW();
            weightedPointY += temp;
        }
        weightedPointY /= objects.length;
        return weightedPointY;
    }

    static double weightingPointsZ(){
        double weightedPointZ = 0;
        for (int i = 0; i < objects.length; i++){
            double temp = objects[i].getZ() * objects[i].getW();
            weightedPointZ += temp;
        }
        weightedPointZ /= objects.length;
        return weightedPointZ;
    }

    static double totalWeight(){
        double totalWeight = 0;
        for (int i = 0; i < objects.length; i++){
            totalWeight += objects[i].getW();
        }
        return totalWeight;
    }
}
