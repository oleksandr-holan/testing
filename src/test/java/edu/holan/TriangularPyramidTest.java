package edu.holan;

import static org.junit.Assert.*;
/*
    @author joert
    @project lab2
    @since 06.04.2025 - 17.36
*/

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangularPyramidTest {

    private static final double DELTA = 1e-10;

    @Test
    public void whenCalculateBaseAreaWithEdges4_4_4_thenReturn6_928() {
        TriangularPyramid pyramid = new TriangularPyramid(4.0, 4.0, 4.0, 6.0);
        double expectedArea = (Math.sqrt(3) / 4) * Math.pow(4.0, 2);
        assertEquals(expectedArea, pyramid.calculateBaseArea(), DELTA);
    }

    @Test
    public void whenCalculateVolumeWithEdges3_3_3AndHeight9_thenReturn13_856() {
        TriangularPyramid pyramid = new TriangularPyramid(3.0, 3.0, 3.0, 9.0);
        double baseArea = (Math.sqrt(3) / 4) * Math.pow(3.0, 2);
        double expectedVolume = (1.0/3.0) * baseArea * 9.0;
        assertEquals(expectedVolume, pyramid.calculateVolume(), DELTA);
    }

    @Test
    public void whenCalculateLateralEdgeHeightWithEdges5_5_5AndHeight8_thenReturnCorrectHeight() {
        TriangularPyramid pyramid = new TriangularPyramid(5.0, 5.0, 5.0, 8.0);
        // For an equilateral triangle base
        double inradius = 5.0 / (2 * Math.sqrt(3));
        double expectedHeight = Math.sqrt(Math.pow(8.0, 2) + Math.pow(inradius, 2));
        assertEquals(expectedHeight, pyramid.calculateLateralEdgeHeight(), DELTA);
    }

    @Test
    public void whenCalculateTotalSurfaceAreaWithEdges6_6_6AndHeight10_thenReturnCorrectArea() {
        TriangularPyramid pyramid = new TriangularPyramid(6.0, 6.0, 6.0, 10.0);
        double baseArea = pyramid.calculateBaseArea();
        // For an equilateral triangle, all lateral faces are equal
        double lateralArea = 3 * 0.5 * 6.0 * 10.0;
        double expectedTotalArea = baseArea + lateralArea;
        assertEquals(expectedTotalArea, pyramid.calculateTotalSurfaceArea(), DELTA);
    }

    @Test
    public void whenCheckingRegularityWithEdges7_7_7_thenReturnTrue() {
        TriangularPyramid pyramid = new TriangularPyramid(7.0, 7.0, 7.0, 12.0);
        assertTrue(pyramid.isRegular());
    }

    @Test
    public void whenCheckingRegularityWithEdges7_8_9_thenReturnFalse() {
        TriangularPyramid pyramid = new TriangularPyramid(7.0, 8.0, 9.0, 12.0);
        assertFalse(pyramid.isRegular());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreatingWithNegativeEdgeMinus2_5_6_thenExceptionThrown() {
        new TriangularPyramid(-2.0, 5.0, 6.0, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreatingWithInvalidTriangleEdges1_2_10_thenExceptionThrown() {
        new TriangularPyramid(1.0, 2.0, 10.0, 5.0);
    }
}