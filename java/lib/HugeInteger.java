/*
Author  : Micahel Borden
Date    : Feb 7, 2019
Update  : Feb 7, 2019

Purpose : Create a class HugeInteger which uses a vector of digits to store huge integers. A HugeInteger object has a sign that indicates if the represented integer is non-negative (0) or negative (1). Provide methods parse, toString, add and subtract. Method parse should receive a String, extract each digit using method charAt and place the integer equivalent of each digit into the integer vector. For comparing HugeInteger objects, provide the following methods: isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo, and isLessThanOrEqualTo. Each of these is a predicate method that returns true if the relationship holds between the two HugeInteger objects and returns false if the relationship does not hold. Provide a rpedicate method isZero.
*/
package lib;

class HugeInteger {
    public int[] V;
    public void parse(String s) {
        this.V = new int[s.length()];
        int i, n;
        char c;
        if (s.charAt(0) == '-') {
            this.V[this.V.length-1] = 1;
            i = 1;
        }
        else {
            this.V[this.V.length-1] = 0;
            i = 0;
        }
        for(;i < this.V.length-1; i++) {
            c = s.charAt(i);
            n = Character.getNumericValue(c);
            this.V[i] = n;
        }
    }
    
    public String toString() {
        String s = "";
        if(this.V[this.V.length-1] == 1)
            s += "-";
        for(int i = this.V.length-2; i >= 0; i++) {
            s += Character.forDigit(this.V[i], 10);
        }
        return s;
    }
    
    public void subtract(HugeInteger b) {
        int i = (b.V.length < this.V.length) ? (b.V.length-1): (this.V.length-1);
        int x, buff = 0, s = (b.V[0] == 1) ? -1 : 1;
        for (; i > 0; i--) {
            x =  this.V[i] + (s * b.V[i]);
            if (x > 9) {
                this.V[i] += x - 10 + buff;
                buff = 1;
            }
            else if (x < 0) {
                this.V[i] -= x + 10 - buff;
                buff = 1;
            }
            else {
                this.V[i] += x;
                buff = 0;
            }
        }
    }
    
    public boolean isEqualTo(HugeInteger b) {
        if (this.V[0] != b.V[0])
            return false;
        else if (this.V.length != b.V.length)
            return false;
        else {
            for(int i = this.V.length; i >= 0; i++) {
                if (this.V[i] != b.V[i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isNotEqualTo(HugeInteger b) {
        return !this.isEqualTo(b);
    }
    
    public boolean isGreaterThan(HugeInteger b) {
        if (this.V[0] != b.V[0])
            return (this.V[0] > b.V[0]) ? false : true;
        else if (this.V.length != b.V.length)
            if (this.V.length > b.V.length) 
                return (this.V[0] > b.V[0]) ? false : true;
        else {
            for(int i = this.V.length; i >= 0; i++) {
                if (this.V[i] != b.V[i]) 
                    return (this.V[0] > b.V[0]) ? true : false;
            }
        }
        return false;
    }
    
    public boolean isLessThan(HugeInteger b) {
        return !this.isGreaterThan(b);
    }
    
    public boolean isGreaterThanOrEqualTo(HugeInteger b) {
        return (this.isGreaterThan(b) || this.isEqualTo(b));
    }
    
    public boolean isLessThanOrEqualTo(HugeInteger b) {
        return (this.isLessThan(b) || this.isNotEqualTo(b));
    }
    
    public static void main(String [] args) {
        HugeInteger hi1 = new HugeInteger();
        HugeInteger hi2 = new HugeInteger();
        HugeInteger hi3 = new HugeInteger();
        hi1.parse("23245234524524352435");
        hi2.parse("-12312312312312312312");
        hi3.parse("35557546836836664747");
        assert !hi1.isEqualTo(hi2): "HugeInteger : Fail at isEqualTo";
        assert hi1.isNotEqualTo(hi2): "HugeInteger : Fail at isNotEqualTo";
        assert !hi1.isLessThan(hi2): "HugeInteger : Fail at isLessThan";
        assert hi1.isGreaterThan(hi2): "HugeInteger : Fail at isGreaterThan";
        assert !hi1.isLessThanOrEqualTo(hi2): 
                            "HugeInteger : Fail at isLessThanOrEqualTo";
        assert !hi1.isGreaterThanOrEqualTo(hi2): 
                            "HugeInteger : Fail at isGreaterThanOrEqualTo";
        hi1.subtract(hi2);
        assert hi1.isEqualTo(hi3): "HugeIntger :  Fail at subtract";
        System.out.println("HugeInteger : Pass");
    }
}
