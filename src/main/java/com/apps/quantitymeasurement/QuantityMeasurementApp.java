package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1,
                                                       double value2, Length.LengthUnit unit2) {
        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        boolean result = l1.equals(l2);
        System.out.println("Are " + value1 + " " + unit1 + " and " + value2 + " " + unit2 + " equal? " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Quantity Measurement App ===");
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS, 2.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(2.0, Length.LengthUnit.CENTIMETERS, 2.0, Length.LengthUnit.CENTIMETERS);
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS, 0.393701, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS, 1.0, Length.LengthUnit.FEET);
    }
}
