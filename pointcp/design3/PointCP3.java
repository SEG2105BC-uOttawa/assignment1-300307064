package design3;

import design5.PointCP5;

/**
 * Polar coordinates
 */

public class PointCP3 extends PointCP5 {
    public PointCP3(char typeCoord, double x, double y) {        
        super(typeCoord, x, y);
    }

    public PointCP3 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();
    
        return new PointCP3('C',
          (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
          (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y)
        );
    }

    public String toString() {
        return "Stored as " + (getTypeCoord() == 'C' ? "Cartesian  (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
