public class Points_Sorter_From_Beggining {

    static void swap(Points[] obj, int index1, int index2) {
        Points temp = obj[index1];
        obj[index1] = obj[index2];
        obj[index2] = temp;
    }

    static int partition(Points[] obj, int low, int high) {

        double pivot = Points_Calculations.totalLength(obj[high].getX(), obj[high].getY(), obj[high].getZ());
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (Points_Calculations.totalLength(obj[j].getX(), obj[j].getY(), obj[j].getZ()) < pivot) {
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
            total = obj[i].getX() + obj[i].getY() + obj[i].getZ();
            System.out.println(
                    "x - " + obj[i].getX()
                            + ", y - " + obj[i].getY()
                            + ", z - " + obj[i].getZ()
                            + ", weight - " + obj[i].getW()
                            + ", total length - " + total);
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
