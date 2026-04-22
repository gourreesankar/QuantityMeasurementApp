public class Length {
    private double value;
    private String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean equals(Length other) {
        return this.toFeet() == other.toFeet();
    }

    private double toFeet() {
        if (unit.equals("feet")) return value;
        return value;
    }
}