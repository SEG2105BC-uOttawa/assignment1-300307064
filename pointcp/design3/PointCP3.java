package design3;

/**
 * Polar coordinates
 */

public class PointCP3 {
    private char typeCoord;
    private double x;
    private double y;

    public PointCP3(char typeCoord, double x, double y) {
        if (typeCoord != 'C' || typeCoord != 'P') throw new IllegalArgumentException();
        
        this.x = x;
        this.y = y;
        this.typeCoord = typeCoord;
    }

    public double getX() {
        return (typeCoord == 'C') ? x : (Math.cos(Math.toRadians(y)) * x);
      }
    
      public double getY() {
        return (typeCoord == 'C') ? y : (Math.sin(Math.toRadians(y)) * x);
      }
    
      public double getRho() {
        return (typeCoord == 'P') ? x : (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
      }
    
      public double getTheta() {
        return (typeCoord == 'P') ? y : (Math.toDegrees(Math.atan2(y, x)));
      }

    public void convertStorageToCartesian() {
        if (typeCoord != 'C') {
            double temp = getX();
            y = getY();
            x = temp;
      
            typeCoord = 'C';
          }
    }

    public void convertStorageToPolar() {
        if (typeCoord != 'P') {
            double temp = getRho();
            y = getTheta();
            x = temp;
      
            typeCoord = 'P';
          }
    }

    public double getDistance(PointCP3 pointB) {
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
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
        return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
