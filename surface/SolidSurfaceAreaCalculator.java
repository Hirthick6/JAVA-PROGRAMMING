
import java.util.Scanner;

class Solid {
    public double calculateSurfaceArea() {
        return 0; // Base class method, overridden by subclasses
    }
}

class Cube extends Solid {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * side * side; // Surface area of a cube: 6a^2
    }
}

class Cylinder extends Solid {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height); // Surface area of a cylinder: 2*pi*r*(r+h)
    }
}

class Cone extends Solid {
    private double radius;
    private double slantHeight;

    public Cone(double radius, double slantHeight) {
        this.radius = radius;
        this.slantHeight = slantHeight;
    }

    @Override
    public double calculateSurfaceArea() {
        return Math.PI * radius * slantHeight; // Surface area of a cone: pi*r*l (l is slant height)
    }
}

class Sphere extends Solid {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius; // Surface area of a sphere: 4*pi*r^2
    }
}



public class SolidSurfaceAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side length of the cube: ");
        double cubeSide = scanner.nextDouble();
        Cube cube = new Cube(cubeSide);

        System.out.print("Enter radius of the cylinder: ");
        double cylinderRadius = scanner.nextDouble();
        System.out.print("Enter height of the cylinder: ");
        double cylinderHeight = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);

        System.out.print("Enter radius of the cone: ");
        double coneRadius = scanner.nextDouble();
        System.out.print("Enter slant height of the cone: ");
        double coneSlantHeight = scanner.nextDouble();
        Cone cone = new Cone(coneRadius, coneSlantHeight);

        System.out.print("Enter radius of the sphere: ");
        double sphereRadius = scanner.nextDouble();
        Sphere sphere = new Sphere(sphereRadius);

        scanner.close();

        System.out.println("Surface Area of Cube: " + cube.calculateSurfaceArea());
        System.out.println("Surface Area of Cylinder: " + cylinder.calculateSurfaceArea());
        System.out.println("Surface Area of Cone: " + cone.calculateSurfaceArea());
        System.out.println("Surface Area of Sphere: " + sphere.calculateSurfaceArea());
    }
}
