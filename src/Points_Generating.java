
import java.util.*;

public class Points_Generating {

    static int min = 0, max = 5;

    static Scanner sc = new Scanner(System.in);
    static Random rn = new Random();

    static int inputted = 0;

    public static void generatePoints(Points[] obj) {

        for (int i = inputted; i < obj.length; i++) {
            Points point = new Points(
                    rn.nextDouble(min, max)
                    ,rn.nextDouble(min, max)
                    ,rn.nextDouble(min, max)
                    ,rn.nextDouble(min, max));
            obj[i] = point;
        }
    }

    public static void inputPoints(Points[] obj){
        do{
            System.out.println("BOD:");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double z = sc.nextDouble();
            double w = sc.nextDouble();
            System.out.println("------------------");

            if (x == 0 && y == 0 && z == 0 && w == 0){
                System.out.println("Dobrá! Dogeneruji zbytek pole automaticky!");
                generatePoints(obj);
                Text_Controlls.filled(obj);
                break;
            } else {
            Points point = new Points(x, y, z, w);
            obj[inputted] = point;
            inputted++;
            }
        } while(true);
    }

    public static void writePoints(Points[] obj){
        for (Points points : obj) {
            points.showData();
        }
    }

    static void changePoint(Points[] obj, int index){
        double input;
        System.out.println("Zaměnit bod X bodu za: ");
        input = sc.nextDouble();
        obj[index].setX(input);
        System.out.println("Zaměnit bod Y bodu za: ");
        input = sc.nextDouble();
        obj[index].setY(input);
        System.out.println("Zaměnit bod Z bodu za: ");
        input = sc.nextDouble();
        obj[index].setZ(input);
        System.out.println("Zaměnit váhu bodu za: ");
        input = sc.nextDouble();
        obj[index].setW(input);
        obj[index].showData();
    }
}
