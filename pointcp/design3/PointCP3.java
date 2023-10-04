package design3;

import design5.PointCP5;

/**
 * Polar coordinates
 */

public class PointCP3 extends PointCP5 {
    public PointCP3(double x, double y) {        
        super('C', x, y);
    }

    public PointCP3 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
    
        return new PointCP3(
          (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
          (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y)
        );
    }

    public String toString() {
        return "Stored as " + (getTypeCoord() == 'C' ? "Cartesian  (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
