package design3;

public class PointCP3 {
    private double xOrRho, yOrTheta;
    private char typeCoord;

    public PointCP3(char typeCoord, double xOrRho, double yOrTheta) {
        if (typeCoord != 'C' && typeCoord != 'P') throw new IllegalArgumentException();

        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        this.typeCoord = typeCoord;
    }

    public char getTypeCoord() {
        return typeCoord;
    }

    public double getX() {
        return (typeCoord == 'C') ? xOrRho : (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }
    
    public double getY() {
        return (typeCoord == 'C') ? yOrTheta : (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }
    
    public double getRho() {
        return (typeCoord == 'P') ? xOrRho : (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }
    
    public double getTheta() {
        return (typeCoord == 'P') ? yOrTheta : (Math.toDegrees(Math.atan2(yOrTheta, xOrRho)));
    }

    public void convertStorageToCartesian() {
        if (typeCoord != 'C') {
            double temp = getX();
            yOrTheta = getY();
            xOrRho = temp;
      
            typeCoord = 'C';
          }
    }

    public void convertStorageToPolar() {
        if (typeCoord != 'P') {
            double temp = getRho();
            yOrTheta = getTheta();
            xOrRho = temp;
      
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
        return "Stored as " + (typeCoord == 'C' ? "Cartesian (" + getX() + ", " + getY() + ")" : "Polar [" + getRho() + ", " + getTheta() + "]") + "\n";
    }
}
