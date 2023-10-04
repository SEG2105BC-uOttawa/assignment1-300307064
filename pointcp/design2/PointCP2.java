package design2;

import design1.PointCP;

/**
 * Polar coordinates
 */

public class PointCP2 {
    private double rho;
    private double theta;

    public PointCP2(double rho, double theta) {
        this.rho = rho;
        this.theta = theta;
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }

    public double getX() {
        return Math.cos(Math.toRadians(theta)) * rho;
    }

    public double getY() {
        return Math.sin(Math.toRadians(theta)) * rho;
    }

    public void convertStorageToCartesian() {
        double temp = getX();
        theta = getY();
        rho = temp;
    }

    public double getDistance(PointCP pointB) {
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public PointCP rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
    
        return new PointCP(
          'C',
          (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
          (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y)
        );
    }

    public String toString() {
        return "Stored as " + "Polar [" + getRho() + ", " + getTheta() + "]" + "\n";
    }
}
