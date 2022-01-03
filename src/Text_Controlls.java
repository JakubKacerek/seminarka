import java.util.*;

public class Text_Controlls {
    static Scanner sc = new Scanner(System.in);

    static void Empty(Points[] objects) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Volby: ");
        System.out.println("      - Automaticky naplnit pole body - \"generate\"");
        System.out.println("      - Ukončit program - \"end\"");
        System.out.println("----------------------------------------------------------------------------");
        String input = sc.nextLine();
        switch (input) {
            case "generate" -> {
                System.out.println("Vyplňuji pole body.");
                Points_Generating.generatePoints(objects);
                System.out.println("Chcete vypsat všechny vygenerované body? A/N");
                input = sc.nextLine();
                if (input.equals("A")) {
                    Points_Generating.writePoints(objects);
                    filled(objects);
                } else {
                    filled(objects);
                }
                filled(objects);
            }
            case "end" -> end();
        }
    }

    static void filled(Points[] objects) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Volby - Seřadit body lze vzdálenosti od počátku - \"beg\"");
        System.out.println("      - Seřadit body lze vzdálenosti od těžiště - \"cog\"");
        System.out.println("      - Zobrazit data o těžišti - \"show\"");
        System.out.println("      - Změnit data některého bodu - \"change\"");
        System.out.println("      - Vymazat existující data - \"delete\"");
        System.out.println("      - Ukončit program - \"end\"");
        System.out.println("----------------------------------------------------------------------------");
        String input = sc.nextLine();
        switch (input) {
            case "beg" -> {
                Points_Sorter_From_Beggining.quickSort(objects, 0, objects.length - 1);
                System.out.println("Chcete seřazené body vypsat? A/N");
                input = sc.nextLine();
                if (input.equals("A")) {
                    Points_Sorter_From_Beggining.printArray(objects, objects.length);
                    filled(objects);
                } else {
                    filled(objects);
                }
            }
            case "cog" -> {
                Points_Sorter_From_CoG.quickSort(objects, 0, objects.length - 1);
                System.out.println("Chcete seřazené body vypsat? A/N");
                input = sc.nextLine();
                if (input.equals("A")) {
                    Points_Sorter_From_CoG.printArray(objects, objects.length);
                    filled(objects);
                } else {
                    filled(objects);
                }
            }
            case "show" -> {
                showCoG(objects);
                filled(objects);
            }
            case "change" -> {
                System.out.println("Zadej číslo jakého bodu chceš měnit: ");
                int index = sc.nextInt();
                Points_Generating.changePoint(objects, index);
                filled(objects);
            }
            case "delete" -> {
                delete(objects);
                Empty(objects);
            }
            case "end" -> end();
        }
    }

    static void showCoG(Points[] objects) {
        System.out.println("\nTěžnice bodů X: " + Points_Calculations.weightingPointsX(objects));
        System.out.println("Těžnice bodů Y: " + Points_Calculations.weightingPointsY(objects));
        System.out.println("Těžnice bodů Z: " + Points_Calculations.weightingPointsZ(objects));
        System.out.println("Celková hmostnost působící na těžiště: " + Points_Calculations.totalWeight(objects));
        System.out.println(
                "Celková vzdálenost těžiště od počátku: "
                        + Points_Calculations.totalLength(Points_Calculations.weightingPointsX(objects)
                        , Points_Calculations.weightingPointsY(objects)
                        , Points_Calculations.weightingPointsZ(objects)));
        System.out.println();
    }

    static void delete(Points[] objects){
        Arrays.fill(objects, null);
    }

    static void end() {
        System.exit(0);
    }

}
