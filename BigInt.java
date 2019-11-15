//  Name:       Zaki Jefferson
//  Project:    BigInt


package Projects;

import java.util.*;


public class BigInt {

    //Instance variables for the class, a boolean for the sign and an ArrayList to store the input String
    private boolean pos = true;
    private ArrayList<String> bigInt = new ArrayList<String>(); //creating an array with the input of String

    //No argument constructor, creates a big integer of value zero
    public BigInt() {
        this.pos = true;
        //bigInt.add(Integer.toString(0));
    }

    public List<String> getDigits() {
        return bigInt;
    }

    public boolean isPositive() {
        return pos;
    }

    //public Constructor for big integers input as strings
    public BigInt(String newBigInt) {
        dealWithSign(newBigInt);
        cleanUpNumber(newBigInt);
        for (int i = 0; i < newBigInt.length(); i++) {
            bigInt.add(newBigInt.substring(i, i + 1));      //post-condition: store the numbers from right to left
        }
    }

    //Private method to deal with the sign of the incoming big integer
    private void dealWithSign(String num) {
        if (num.charAt(0) == '+' || num.charAt(0) == '-') {
            if (num.length() == 1) {
                System.out.println("Invalid value: sign only, no integer.");
                System.exit(0);
            }
            if (num.charAt(0) == '-') {
                this.pos = false;
            } else {
                this.pos = true;
            }
            num = num.substring(1);
        }
    }

    //Private method to clean up the number; remove leading zeros, check for other errors, etc
    private void cleanUpNumber(String num) {
        if (num.charAt(0) == ' ') {
            System.out.println("Invalid value: leading blank space.");
            System.exit(0);
        }
        while (num.charAt(0) == '0' && num.length() > 1) {
            num = num.substring(1);
        }
    }


    //public method that performs addition
    public BigInt add(BigInt one, BigInt two) {     //precondition: take the largest number and the smallest number. Then add the two
        BigInt result = new BigInt();
        int carryDigit = 0;
        if (one.pos && two.pos && one.bigInt.size() == two.bigInt.size()) {     //uses i as an index to retrieve each digit.
            for (int i = one.bigInt.size() - 1; i >= 0; i--) {                 //adding the right most digits first

                int v1 = Integer.parseInt(one.bigInt.get(i));   //returns the last digit of the first bigInt
                int v2 = Integer.parseInt(two.bigInt.get(i));  //returns the last digit of the second bigInt

                int addResult = v1 + v2 + carryDigit;
                carryDigit = 0;

                if (addResult > 9) {
                    carryDigit++;
                    result.bigInt.add(Integer.toString(0));     //adds 0 to the result of BigInt
                } else {
                    result.bigInt.add(Integer.toString(addResult));     //convert addResult to a String
                }                                                       //goes from being empty to having addResult
            }
        }
        Collections.reverse(result.bigInt);
        return result;           //Post-condition: add and print out the total
    }



    //Public method that performs subtraction
    public BigInt subtract(BigInt one, BigInt two) {        //precondition: document the smallest and the biggest int/ compare. Put the larger int on the top and subtract the two
        BigInt result = new BigInt();
        int carryDigit = 0;
        if (one.pos && two.pos && one.bigInt.size() == two.bigInt.size()) {     //uses i as an index to retrieve each digit
            for (int i = one.bigInt.size() - 1; i >= 0; i--) {

                int v1 = Integer.parseInt(one.bigInt.get(i));   //returns the last digit of the first bigInt
                int v2 = Integer.parseInt(two.bigInt.get(i));  //returns the last digit of the second bigInt

                int subtractResult = v1 - v2 - carryDigit;
                carryDigit = 0;

                if (subtractResult > 9) {
                    carryDigit++;
                    result.bigInt.add(Integer.toString(0));     //adds 0 to the result of BigInt
                } else {
                    result.bigInt.add(Integer.toString(subtractResult));    //convert subtractResult to a String
                }                                                          //goes from being empty to having subtractResult
            }
        }
        Collections.reverse(result.bigInt);
        return result;           //Post-condition: subtract and print out the total
    }



    //method that performs multiplication
    private BigInt multiply(BigInt one, BigInt two) {       //precondition: format the largest and the smallest input and multiply
        BigInt result = new BigInt();
        int carryDigit = 1;
        if (one.pos && two.pos && one.bigInt.size() == two.bigInt.size()) {     //uses i as an index to retrieve each digit
            for (int i = one.bigInt.size() - 1; i >= 0; i--) {

                int v1 = Integer.parseInt(one.bigInt.get(i));       //returns the last digit of the first bigInt
                int v2 = Integer.parseInt(two.bigInt.get(i));       //returns the last digit of the second bigInt

                int multiplyResult = v1 * v2 * carryDigit;
                carryDigit = 1;

                if (multiplyResult > 9) {
                    carryDigit++;
                    result.bigInt.add(Integer.toString(0));     //adds 0 to the result of BigInt
                } else {
                    result.bigInt.add(Integer.toString(multiplyResult));    //convert multiplyResult to a String
                }                                                          //goes from being empty to having multiplyResult
            }
        }
        Collections.reverse(result.bigInt);
        return result;           //Post-condition: multiply and print out the total
    }


    //method that performs division
    private BigInt divideBy(BigInt one, BigInt two) {       //take the two ints and divide them
        BigInt result = new BigInt();
        int carryDigit = 1;
        if (one.pos && two.pos && one.bigInt.size() == two.bigInt.size()) {     //uses i as an index to retrieve each digit
            for (int i = one.bigInt.size() - 1; i >= 0; i--) {

                int v1 = Integer.parseInt(one.bigInt.get(i));   //returns the last digit of the first bigInt
                int v2 = Integer.parseInt(two.bigInt.get(i));  //returns the last digit of the second bigInt

                int divideResult = v1 / v2 / carryDigit;
                carryDigit = 1;

                if (divideResult > 9) {
                    carryDigit++;
                    result.bigInt.add(Integer.toString(0));     //adds 0 to the result of BigInt
                } else {
                    result.bigInt.add(Integer.toString(divideResult));      //convert divideResult to a String
                }                                                          //goes from being empty to having divideResult
            }
        }
        Collections.reverse(result.bigInt);
        return result;           //Post-condition: divide and print out the total
    }


    //method that performs modulus
    private BigInt modulus(BigInt one, BigInt two) {
        BigInt result = new BigInt();
        int carryDigit = 0;
        if (one.pos && two.pos && one.bigInt.size() == two.bigInt.size()) {     //uses i as an index to retrieve each digit
            for (int i = one.bigInt.size() - 1; i >= 0; i--) {

                int v1 = Integer.parseInt(one.bigInt.get(i));       //returns the last digit of the first bigInt
                int v2 = Integer.parseInt(two.bigInt.get(i));      //returns the last digit of the second bigInt

                int modResult = v1 % v2 % carryDigit;
                carryDigit = 0;

                if (modResult > 9) {
                    carryDigit++;
                    result.bigInt.add(Integer.toString(0));
                } else {
                    result.bigInt.add(Integer.toString(modResult));
                }
            }
        }
        Collections.reverse(result.bigInt);
        return result;           //Post-condition: mod and print out the total
    }

    //toString method
    public String toString() {
        String answer = "";
        for (int i = 0; i < bigInt.size(); i++) {
            answer = answer + bigInt.get(i);
        }
        if (!pos) {
            answer = "-" + answer;
        }
        return answer;
    }


    //*Main Method*//
    public void main(String[] args) {


            BigInt b1;
            BigInt b2;
            BigInt b3;
            b1 = new BigInt("-0");
            b2 = new BigInt("+0");
            b3 = add(b1,b2);
            System.out.println("1) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b1 = new BigInt("1");
            b2 = new BigInt("1");
            b3 = add(b1,b2);
            System.out.println("\n2) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-1");
            b2 = new BigInt("1");
            b3 = add(b1,b2);
            System.out.println("\n3) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("1");
            b2 = new BigInt("-1");
            b3 = add(b1,b2);
            System.out.println("\n4) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-1");
            b2 = new BigInt("-1");
            b3 = add(b1,b2);
            System.out.println("\n5) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("+1");
            b2 = new BigInt("+1");
            b3 = add(b1,b2);
            System.out.println("\n6) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-100");
            b2 = new BigInt("100");
            b3 = add(b1,b2);
            System.out.println("\n7) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("100");
            b2 = new BigInt("-100");
            b3 = add(b1,b2);
            System.out.println("\n8) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-100");
            b2 = new BigInt("-100");
            b3 = add(b1,b2);
            System.out.println("\n9) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("100");
            b2 = new BigInt("100");
            b3 = add(b1,b2);
            System.out.println("\n10) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("200");
            b2 = new BigInt("-0");
            b3 = add(b1,b2);
            System.out.println("\n11) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            //b3 = divideBy(b1,b2);
            //System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            //b3 = modulus(b1,b2
        //);
            //System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-200");
            b2 = new BigInt("-0");
            b3 = add(b1,b2);
            System.out.println("\n12) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            //b3 = divideBy(b1,b2);
            //System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            //b3 = modulus(b1,b2
        //);
            //System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-0");
            b2 = new BigInt("200");
            b3 = add(b1,b2);
            System.out.println("\n13) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-0");
            b2 = new BigInt("-200");
            b3 = add(b1,b2);
            System.out.println("\n14) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("37");
            b2 = new BigInt("26");
            b3 = add(b1,b2);
            System.out.println("\n15) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-37");
            b2 = new BigInt("26");
            b3 = add(b1,b2);
            System.out.println("\n16) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("37");
            b2 = new BigInt("-26");
            b3 = add(b1,b2);
            System.out.println("\n17) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-37");
            b2 = new BigInt("-26");
            b3 = add(b1,b2);
            System.out.println("\n18) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-200111111111111111199999999");
            b2 = new BigInt("3333333333333388888888888888888888555555555555555555555555");
            b3 = add(b1,b2);
            System.out.println("\n19) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("66666666666666666666677777777777777777777711111111111111111200");
            b2 = new BigInt("-3333333333333333333344444444444");
            b3 = add(b1,b2);
            System.out.println("\n20) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-66666666666666666666677777777777777777777711111111111111111200");
            b2 = new BigInt("-333333");
            b3 = add(b1,b2);
            System.out.println("\n21) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("6666666");
            b2 = new BigInt("3333333333333333333344444444444444444444455555555555555550");
            b3 = add(b1,b2);
            System.out.println("\n22) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("1111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b2 = new BigInt("99999999999999999999999999999888888888888888888888888888888881111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b3 = add(b1,b2);
            System.out.println("\n23) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-1111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b2 = new BigInt("99999999999999999999999999999888888888888888888888888888888881111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b3 = add(b1,b2);
            System.out.println("\n24) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("1111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b2 = new BigInt("-99999999999999999999999999999888888888888888888888888888888881111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b3 = add(b1,b2);
            System.out.println("\n25) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
            b1 = new BigInt("-1111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b2 = new BigInt("-99999999999999999999999999999888888888888888888888888888888881111111111111111111111111111111122222222222222222222222222222222222333333333333333333333333333333334444444444444444444444444");
            b3 = add(b1,b2);
            System.out.println("\n26) sum b3 is " + b1 +" + " + b2 + " = " + b3);
            b3 = subtract(b1,b2);
            System.out.println("difference b3 is " + b1 +" - " + b2 + " = " + b3);
            b3 = multiply(b1,b2);
            System.out.println("product b3 is " + b1 +" * " + b2 + " = " + b3);
            b3 = divideBy(b1,b2);
            System.out.println("quotient b3 is " + b1 +" / " + b2 + " = " + b3);
            b3 = modulus(b1,b2);
            System.out.println("modulus b3 is " + b1 +" mod " + b2 + " = " + b3);
    }
}
