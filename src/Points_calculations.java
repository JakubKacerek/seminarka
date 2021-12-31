public class Points_calculations {

    static double weightingPointsX(Points[] objects){
        double weightedPointX = 0;
        for (Points object : objects) {
            double temp = object.getX() * object.getW();
            weightedPointX += temp;
        }
        weightedPointX /= objects.length;
        return weightedPointX;
    }

    static double weightingPointsY(Points[] objects){
        double weightedPointY = 0;
        for (Points object : objects) {
            double temp = object.getY() * object.getW();
            weightedPointY += temp;
        }
        weightedPointY /= objects.length;
        return weightedPointY;
    }

    static double weightingPointsZ(Points[] objects){
        double weightedPointZ = 0;
        for (Points object : objects) {
            double temp = object.getZ() * object.getW();
            weightedPointZ += temp;
        }
        weightedPointZ /= objects.length;
        return weightedPointZ;
    }

    static double totalWeight(Points[] objects){
        double totalWeight = 0;
        for (Points object : objects) {
            totalWeight += object.getW();
        }
        return totalWeight;
    }

    static double hypotenuseCalc(double num1, double num2){
        double temp = Math.pow(num1, 2) + Math.pow(num2, 2);
        return Math.sqrt(temp);
    }

    static double totalLength(double x, double y, double z){
        return hypotenuseCalc(hypotenuseCalc(x, y), z);
    }

}
