package edu.holan;

/*
    @author joert
    @project lab2
    @since 06.04.2025 - 17.28
*/

import java.util.Objects;

public class TriangularPyramid {
    private final double baseEdge1;
    private final double baseEdge2;
    private final double baseEdge3;
    private final double height;

    public TriangularPyramid(double baseEdge1, double baseEdge2, double baseEdge3, double height) {
        if (baseEdge1 <= 0 || baseEdge2 <= 0 || baseEdge3 <= 0 || height <= 0) {
            throw new IllegalArgumentException("Pyramid dimensions must be positive");
        }

        // Check if the triangle inequality is satisfied
        if (baseEdge1 + baseEdge2 <= baseEdge3 ||
                baseEdge1 + baseEdge3 <= baseEdge2 ||
                baseEdge2 + baseEdge3 <= baseEdge1) {
            throw new IllegalArgumentException("The three edges must be able to form a triangle");
        }

        this.baseEdge1 = baseEdge1;
        this.baseEdge2 = baseEdge2;
        this.baseEdge3 = baseEdge3;
        this.height = height;
    }

    // For a regular triangular pyramid (all base edges are equal)
    public TriangularPyramid(double baseEdgeLength, double height) {
        this(baseEdgeLength, baseEdgeLength, baseEdgeLength, height);
    }

    public double calculateBaseArea() {
        // Using Heron's formula to calculate the area of any triangle
        double s = (baseEdge1 + baseEdge2 + baseEdge3) / 2.0;
        return Math.sqrt(s * (s - baseEdge1) * (s - baseEdge2) * (s - baseEdge3));
    }

    public double calculateVolume() {
        return (1.0/3.0) * calculateBaseArea() * height;
    }

    public double calculateLateralEdgeHeight() {
        // This is more complex for non-regular triangular pyramids
        // For simplicity, we'll calculate it for the case when the height
        // falls on the centroid of the base triangle
        double baseArea = calculateBaseArea();
        double perimeter = baseEdge1 + baseEdge2 + baseEdge3;
        double inradius = 2 * baseArea / perimeter;
        return Math.sqrt(Math.pow(height, 2) + Math.pow(inradius, 2));
    }

    public double calculateTotalSurfaceArea() {
        double baseArea = calculateBaseArea();

        // Calculate the lateral faces areas
        double lateralArea1 = calculateTriangleArea(baseEdge1, height);
        double lateralArea2 = calculateTriangleArea(baseEdge2, height);
        double lateralArea3 = calculateTriangleArea(baseEdge3, height);

        return baseArea + lateralArea1 + lateralArea2 + lateralArea3;
    }

    private double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public boolean isRegular() {
        double epsilon = 1e-10;
        return Math.abs(baseEdge1 - baseEdge2) < epsilon &&
                Math.abs(baseEdge2 - baseEdge3) < epsilon &&
                Math.abs(baseEdge1 - baseEdge3) < epsilon;
    }

    public double getBaseEdge1() {
        return baseEdge1;
    }

    public double getBaseEdge2() {
        return baseEdge2;
    }

    public double getBaseEdge3() {
        return baseEdge3;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TriangularPyramid that = (TriangularPyramid) o;
        return Double.compare(baseEdge1, that.baseEdge1) == 0 && Double.compare(baseEdge2, that.baseEdge2) == 0 && Double.compare(baseEdge3, that.baseEdge3) == 0 && Double.compare(height, that.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseEdge1, baseEdge2, baseEdge3, height);
    }

    @Override
    public String toString() {
        return "TriangularPyramid{" +
                "baseEdge1=" + baseEdge1 +
                ", baseEdge2=" + baseEdge2 +
                ", baseEdge3=" + baseEdge3 +
                ", height=" + height +
                '}';
    }
}