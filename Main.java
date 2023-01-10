import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String str = calc(string);
        System.out.print(str);
        in.close();
    }
    public static String calc(String input){
        
        String[] nums = input.split(" ");
        if(nums.length != 3){
            throw new NullPointerException("Too much");
        }
        if(!nums[1].equals("+") && !nums[1].equals("-") && !nums[1].equals("*") && !nums[1].equals("/")){
            throw new NullPointerException("Not an operation");
        }
        int op1 = 0, op2 = 0;
        int rome = 0, rome2 = 0;
        int res = 0;
        if(nums[0].equals("1")){
            op1 = 1;
        }
        else if(nums[0].equals("2")){
            op1 = 2;
        }
        else if(nums[0].equals("3")){
            op1 = 3;
        }
        else if(nums[0].equals("4")){
            op1 = 4;
        }
        else if(nums[0].equals("5")){
            op1 = 5;
        }
        else if(nums[0].equals("6")){
            op1 = 6;
        }
        else if(nums[0].equals("7")){
            op1 = 7;
        }
        else if(nums[0].equals("8")){
            op1 = 8;
        }
        else if(nums[0].equals("9")){
            op1 = 9;
        }
        else if(nums[0].equals("10")){
            op1 = 10;
        }
        else if(nums[0].equals("I")){
            op1 = 1;
            rome = 1;
        }
        else if(nums[0].equals("II")){
            op1 = 2;
            rome = 1;
        }
        else if(nums[0].equals("III")){
            op1 = 3;
            rome = 1;
        }
        else if(nums[0].equals("IV")){
            op1 = 4;
            rome = 1;
        }
        else if(nums[0].equals("V")){
            op1 = 5;
            rome = 1;
        }
        else if(nums[0].equals("VI")){
            op1 = 6;
            rome = 1;
        }
        else if(nums[0].equals("VII")){
            op1 = 7;
            rome = 1;
        }
        else if(nums[0].equals("VIII")){
            op1 = 8;
            rome = 1;
        }
        else if(nums[0].equals("IX")){
            op1 = 9;
            rome = 1;
        }
        else if(nums[0].equals("X")){
            op1 = 10;
            rome = 1;
        }
        else{
            throw new NullPointerException("First operand is not valuable");
        }
    
        if(nums[2].equals("1")){
            op2 = 1;
        }
        else if(nums[2].equals("2")){
            op2 = 2;
        }
        else if(nums[2].equals("3")){
            op2 = 3;
        }
        else if(nums[2].equals("4")){
            op2 = 4;
        }
        else if(nums[2].equals("5")){
            op2 = 5;
        }
        else if(nums[2].equals("6")){
            op2 = 6;
        }
        else if(nums[2].equals("7")){
            op2 = 7;
        }
        else if(nums[2].equals("8")){
            op2 = 8;
        }
        else if(nums[2].equals("9")){
            op2 = 9;
        }
        else if(nums[2].equals("10")){
            op2 = 10;
        }
        else if(nums[2].equals("I")){
            op2 = 1;
            rome2 = 1;
        }
        else if(nums[2].equals("II")){
            op2 = 2;
            rome2 = 1;
        }
        else if(nums[2].equals("III")){
            op2 = 3;
            rome2 = 1;
        }
        else if(nums[2].equals("IV")){
            op2 = 4;
            rome2 = 1;
        }
        else if(nums[2].equals("V")){
            op2 = 5;
            rome2 = 1;
        }
        else if(nums[2].equals("VI")){
            op2 = 6;
            rome2 = 1;
        }
        else if(nums[2].equals("VII")){
            op2 = 7;
            rome2 = 1;
        }
        else if(nums[2].equals("VIII")){
            op2 = 8;
            rome2 = 1;
        }
        else if(nums[2].equals("IX")){
            op2 = 9;
            rome2 = 1;
        }
        else if(nums[2].equals("X")){
            op2 = 10;
            rome2 = 1;
        }
        else{
            throw new NullPointerException("Second operand is not valuable");
        }
        if( rome != rome2){
            throw new NullPointerException("Operands are not comparable");
        }
        if(nums[1].equals("+")){
            res = op1 + op2;
        }
        if(nums[1].equals("-")){
            res = op1 - op2;
        }
        if(nums[1].equals("*")){
            res = op1 * op2;
        }
        if(nums[1].equals("/")){
            res = op1 / op2;
        }
        if(rome == 0){
            String str1 = "" + res;
            return str1;
        }
        if(rome == 1){
            if(res < 1){
                throw new NullPointerException("Result mus be more than 1");
            }
            String str2 = arabicToRoman(res);
            return str2;
        }
        return "";
    }
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
    
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
    
        int i = 0;
        StringBuilder sb = new StringBuilder();
    
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
    
        return sb.toString();
    }
    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10), 
        XL(40), L(50), XC(90), C(100), 
        CD(400), D(500), CM(900), M(1000);
    
        private int value;
    
        RomanNumeral(int value) {
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }
        
        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
              .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
              .collect(Collectors.toList());
        }
    }
}