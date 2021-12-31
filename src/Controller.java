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

        System.out.println("\nTěžnice bodů X: "+ Points_calculations.weightingPointsX(objects));
        System.out.println("Těžnice bodů Y: "+ Points_calculations.weightingPointsY(objects));
        System.out.println("Těžnice bodů Z: "+ Points_calculations.weightingPointsZ(objects));
        System.out.println("Celková hmostnost působící na těžiště: "+ Points_calculations.totalWeight(objects));
        System.out.println(
                "Celková vzdálenost těžiště od počátku: "
                + Points_calculations.totalLength(Points_calculations.weightingPointsX(objects)
                , Points_calculations.weightingPointsY(objects)
                , Points_calculations.weightingPointsZ(objects)));

       // Points_Sorter.quickSort(objects, 0, objects.length-1);
       // Points_Sorter.printArray(objects, objects.length);

    }
}
