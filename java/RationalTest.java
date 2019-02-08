/*
Author  : Micahel Borden
Date    : Feb 7, 2019
Update  : Feb 7, 2019

Purpose : Implement a class, named Rational, for reduced-form rational numbers. 
The class has two member variables, named numerator and denominator, and 
provides member functions for the following arithmetic operations: addition,
subtraction, multiplication, and division. A rational number is in the reduced
form if the greatest common divisor of the numerator and the denominator is 1.
*/
import lib.Rational;

class RationalTest {
    public static void main(String[] args) {
        // Test cases
        Rational a = new Rational(2, 3);
        Rational b = new Rational(4, 5);
        // Testing
        a.add(b);
        assert a.numerator == 22 && a.denominator == 15: "Rational class fail";
        a.sub(b);
        assert a.numerator == 2 && a.denominator == 3: "Rational class fail";
        a.mult(b);
        assert a.numerator == 8 && a.denominator == 15: "Rational class fail";
        a.div(b);
        assert a.numerator == 2 && a.denominator == 3: "Rational class fail";
        System.out.println("Rational Class : Pass");
    }
}
