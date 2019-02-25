// This class can be used to store rational numbers: numbers that can be
// expressed as a/b where a and b are integers and b is not 0.

public class RationalNumber {
    private int numerator;
    private int denominator;

    // constructs 0
    public RationalNumber() {
        this(0, 1);
    }

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // returns a string representation of the object
    public String toString() {
        if (denominator == 1) {
            return "" + numerator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    // returns true if this object equals the other
    public boolean equals(Object o) {
        if (o instanceof RationalNumber) {
            RationalNumber other = (RationalNumber) o;
            return numerator == other.numerator
                && denominator == other.denominator;
        } else {
            return false;
        }
    }

    public RationalNumber add(RationalNumber other) {
        int n = numerator * other.denominator + other.numerator * denominator;
        int d = denominator * other.denominator;
        return new RationalNumber(n, d);
    }

    public RationalNumber subtract(RationalNumber other) {
        int n = numerator * other.denominator - other.numerator * denominator;
        int d = denominator * other.denominator;
        return new RationalNumber(n, d);
    }

    // eliminates any common factors and ensures that denominator > 0
    private void reduce() {
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // returns the greatest common divisor of x and y
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}