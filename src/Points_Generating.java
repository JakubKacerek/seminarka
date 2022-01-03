
import java.util.*;

public class Points_Generating {

    static Scanner sc = new Scanner(System.in);
    static Random rn = new Random();

    public static void generatePoints(Points[] obj) {

        for (int i = 0; i < obj.length; i++) {
            Points point = new Points(
                    rn.nextDouble(0, 5)
                    , rn.nextDouble(0, 5)
                    , rn.nextDouble(0, 5)
                    , rn.nextDouble(0, 5));
            obj[i] = point;
        }
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
        System.out.println("Zaměnit bod Y bodu za: ");
        input = sc.nextDouble();
        obj[index].setZ(input);
        System.out.println("Zaměnit váhu bodu za: ");
        input = sc.nextDouble();
        obj[index].setW(input);
        obj[index].showData();
        Text_Controlls.filled(obj);
    }
}
