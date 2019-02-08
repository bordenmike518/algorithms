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
package lib;

public class Rational {
    public int numerator;
    public int denominator;
    public Rational (int numerator, int denominator) {
        assert denominator != 0: "Denominator cannot be zero.";
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return this.gcd(b, a % b);
    }
    
    private int lcm(int a, int b) {
        return (a * b) / this.gcd(a, b);
    }
    
    private void reduce() {
        int m = this.gcd(this.numerator, this.denominator);
        this.numerator /= m;
        this.denominator /= m;
    }
    
    public void add(Rational b) {
        int m = this.lcm(this.denominator, b.denominator);
        int adm = m / this.denominator;
        int bdm = m / b.denominator;
        int an = this.numerator * adm;
        int bn = b.numerator * bdm;
        this.numerator = an + bn;
        this.denominator = m;
        this.reduce();
    }
    
    public void sub(Rational b) {
        Rational negb = new Rational(-b.numerator, b.denominator);
        this.add(negb);
    }
    
    public void mult(Rational b) {
        int num = this.numerator * b.numerator;
        this.denominator = this.denominator * b.denominator;
        this.numerator = num;
        this.reduce();
    }
    
    public void div(Rational b) {
        Rational invb = new Rational(b.denominator, b.numerator);
        this.mult(invb);
    }
    
    public void print() {
        System.out.println("Num: " + this.numerator + ", Den: " + this.denominator);
    }
}
