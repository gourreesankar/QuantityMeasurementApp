cat > src/test/java/com/apps/quantitymeasurement/QuantityMeasurementAppTest.java << 'EOF'
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);
        assertNotEquals(feet1, null);
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(1.0);
        assertNotEquals(feet1, "1.0");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(1.0);
        assertEquals(feet1, feet1);
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);
        assertEquals(inch1, inch2);
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);
        assertNotEquals(inch1, inch2);
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inch1 = new Inches(1.0);
        assertNotEquals(inch1, null);
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inch1 = new Inches(1.0);
        assertNotEquals(inch1, "1.0");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inch1 = new Inches(1.0);
        assertEquals(inch1, inch1);
    }
}
