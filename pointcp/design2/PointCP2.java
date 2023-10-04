package design2;

import design5.PointCP5;

/**
 * Polar coordinates
 */

public class PointCP2 extends PointCP5 {
    public PointCP2(char typeCoord, double rho, double theta) {
        super(typeCoord, rho, theta);
    }

    public PointCP2 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        double newX = (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y);
        double newY = (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y);

        double newXToRho = Math.sqrt(Math.pow(newX, 2) + Math.pow(newY, 2));
        double newYToTheta = Math.toDegrees(Math.atan2(newY, newX));
    
        return new PointCP2('P', newXToRho, newYToTheta);
    }

    public String toString() {
        return "Stored as " + (getTypeCoord() == 'C' ? "Cartesian (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
