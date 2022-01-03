public class Points_Sorter_From_CoG {

    static void swap(Points[] obj, int index1, int index2) {
        Points temp = obj[index1];
        obj[index1] = obj[index2];
        obj[index2] = temp;
    }

    static int partition(Points[] obj, int low, int high) {

        double real_x, real_y, real_z;
        real_x = obj[high].getX() - Points_Calculations.weightingPointsX(obj);
        real_y = obj[high].getY() - Points_Calculations.weightingPointsY(obj);
        real_z = obj[high].getZ() - Points_Calculations.weightingPointsZ(obj);

        double pivot = Points_Calculations.totalLength(real_x, real_y, real_z);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            double real_x_m, real_y_m, real_z_m;
            real_x_m = obj[j].getX() - Points_Calculations.weightingPointsX(obj);
            real_y_m = obj[j].getY() - Points_Calculations.weightingPointsY(obj);
            real_z_m = obj[j].getZ() - Points_Calculations.weightingPointsZ(obj);

            if (Points_Calculations.totalLength(real_x_m, real_y_m, real_z_m) < pivot) {
                i++;
                swap(obj, i, j);
            }
        }
        swap(obj, i + 1, high);
        return (i + 1);
    }

    static void printArray(Points[] obj, int size) {
        double total;
        for (int i = 0; i < size; i++) {

            double real_x_m, real_y_m, real_z_m;
            real_x_m = obj[i].getX() - Points_Calculations.weightingPointsX(obj);
            real_y_m = obj[i].getY() - Points_Calculations.weightingPointsY(obj);
            real_z_m = obj[i].getZ() - Points_Calculations.weightingPointsZ(obj);

            total = Points_Calculations.totalLength(real_x_m, real_y_m, real_z_m);
            System.out.println(
                    "x - " + obj[i].getX()
                            + ", y - " + obj[i].getY()
                            + ", z - " + obj[i].getZ()
                            + ", weight - " + obj[i].getW()
                            + ", total length from cog- " + total);
        }
        System.out.println();
    }

    static void quickSort(Points[] obj, int low, int high) {
        if (low < high) {
            int pi = partition(obj, low, high);

            quickSort(obj, low, pi - 1);
            quickSort(obj, pi + 1, high);
        }
    }
}
