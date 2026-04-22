package com.apps.quantitymeasurement;

public class Length {
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return Math.round(value * unit.getConversionFactor() * 100000.0) / 100000.0;
    }

    private boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Length that = (Length) o;
        return this.compare(that);
    }

    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        return Math.round((lengthInInches / targetUnit.getConversionFactor()) * 100000.0) / 100000.0;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = this.value * this.unit.getConversionFactor();
        double convertedValue = convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new Length(convertedValue, targetUnit);
    }

    public Length add(Length thatLength) {
        if (thatLength == null) throw new IllegalArgumentException("Length cannot be null");
        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, this.unit);
        return new Length(resultValue, this.unit);
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public static void main(String[] args) {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("1 foot + 12 inches = " + l1.add(l2));

        Length l3 = new Length(1.0, LengthUnit.YARDS);
        Length l4 = new Length(3.0, LengthUnit.FEET);
        System.out.println("1 yard + 3 feet = " + l3.add(l4));
    }
}
