// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering"
// and is issued under the open-source license found at
// http://www.site.uottawa.ca/school/research/lloseng/

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format. It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 * 
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */

package design1;

public class PointCP {
  /**
   * contain C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with
   */
  private char typeCoord;

  /**
   * contain the current value of X or RHO depending
   * on the type of coordinates
   */
  private double xOrRho;

  /**
   * contain the current value of Y or THETA value depending
   * on the type of coordinates
   */
  private double yOrTheta;

  /**
   * construct a coordinate object, with a type identifier
   */
  public PointCP(char type, double xOrRho, double yOrTheta) {
    if (type != 'C' && type != 'P') {
      throw new IllegalArgumentException();
    }

    this.xOrRho = xOrRho;
    this.yOrTheta = yOrTheta;
    this.typeCoord = type;
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

  /**
   * convert cartesian coordinates to polar coordinates
   */
  public void convertStorageToPolar() {
    if (typeCoord != 'P') {
      // calculate RHO and THETA
      double temp = getRho();
      yOrTheta = getTheta();
      xOrRho = temp;

      typeCoord = 'P'; // change coord type identifier
    }
  }

  /**
   * convert polar coordinates to polar coordinates
   */
  public void convertStorageToCartesian() {
    if (typeCoord != 'C') {
      // calculate X and Y
      double temp = getX();
      yOrTheta = getY();
      xOrRho = temp;

      typeCoord = 'C'; // change coord type identifier
    }
  }

  /**
   * calculate the distance in between two points using the Pythagorean theorem
   * C^2 = A^2 + B^2
   * not needed until E2.30
   * @return the distance between two points
   */
  public double getDistance(PointCP pointB) {
    // obtain differences in X and Y, sign is not important
    // as these values will be squared later
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();

    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * rotate the specified point by the specified number of degrees
   * not required until E2.30
   * @return the rotated image of the original point
   */
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
    return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + getX() + "," + getY() + ")" : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}