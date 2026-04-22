public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Length l1 = new Length(1.0, "feet");
        Length l2 = new Length(1.0, "feet");

        System.out.println("=== Quantity Measurement App ===");
        System.out.println("Are 1 feet and 1 feet equal? " + l1.equals(l2));
    }
}