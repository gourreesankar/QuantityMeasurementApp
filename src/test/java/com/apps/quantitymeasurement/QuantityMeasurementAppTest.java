
package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        assertEquals(new Length(1.0, Length.LengthUnit.FEET), new Length(1.0, Length.LengthUnit.FEET));
    }

    @Test
    public void testInchesEquality() {
        assertEquals(new Length(1.0, Length.LengthUnit.INCHES), new Length(1.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void testFeetInchesComparison() {
        assertEquals(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void testFeetInequality() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.FEET), new Length(2.0, Length.LengthUnit.FEET));
    }

    @Test
    public void testInchesInequality() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.INCHES), new Length(2.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void testCrossUnitInequality() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.FEET), new Length(1.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void testMultipleFeetComparison() {
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), new Length(24.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void yardEquals36Inches() {
        assertEquals(new Length(1.0, Length.LengthUnit.YARDS), new Length(36.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        assertEquals(new Length(100.0, Length.LengthUnit.CENTIMETERS), new Length(39.3701, Length.LengthUnit.INCHES));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), new Length(1.0, Length.LengthUnit.YARDS));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        assertEquals(new Length(30.48, Length.LengthUnit.CENTIMETERS), new Length(1.0, Length.LengthUnit.FEET));
    }

    @Test
    public void yardNotEqualToInches() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.YARDS), new Length(1.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l1);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.YARDS), null);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
        Length l3 = new Length(36.0, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
        assertEquals(l2, l3);
        assertEquals(l1, l3);
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        assertNotEquals(new Length(1.0, Length.LengthUnit.YARDS), new Length(2.0, Length.LengthUnit.YARDS));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
            1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES));
    }

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(new Length(2.0, Length.LengthUnit.YARDS), Length.LengthUnit.INCHES);
        assertEquals(new Length(72.0, Length.LengthUnit.INCHES), result);
    }

     @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length result = new Length(1.0, Length.LengthUnit.FEET).add(new Length(2.0, Length.LengthUnit.FEET));
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Length result = new Length(6.0, Length.LengthUnit.INCHES).add(new Length(6.0, Length.LengthUnit.INCHES));
        assertEquals(new Length(12.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Length result = new Length(12.0, Length.LengthUnit.INCHES).add(new Length(1.0, Length.LengthUnit.FEET));
        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        Length result = new Length(1.0, Length.LengthUnit.YARDS).add(new Length(3.0, Length.LengthUnit.FEET));
        assertEquals(new Length(2.0, Length.LengthUnit.YARDS), result);
    }

    @Test
    public void testAddition_WithZero() {
        Length result = new Length(5.0, Length.LengthUnit.FEET).add(new Length(0.0, Length.LengthUnit.INCHES));
        assertEquals(new Length(5.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NegativeValues() {
        Length result = new Length(5.0, Length.LengthUnit.FEET).add(new Length(-2.0, Length.LengthUnit.FEET));
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NullSecondOperand() {
        assertThrows(IllegalArgumentException.class, () ->
            new Length(1.0, Length.LengthUnit.FEET).add(null));
    }
}
