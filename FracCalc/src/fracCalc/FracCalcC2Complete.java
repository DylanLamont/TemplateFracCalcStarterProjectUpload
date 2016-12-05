//package fracCalc;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class FracCalc {
//
//    public static void main(String[] args) 
//    {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Hello and welcome to the fraction calculator, please enter your equation");
//        String equation = input.nextLine();
//        if (!equation.equals("quit")){
//        	System.out.println(produceAnswer(equation));
//        	while (!equation.equals("quit")){
//                System.out.println("Please enter your equation.");
//                equation = input.nextLine();
//                System.out.println(produceAnswer(equation));
//        	}
//        }
//    	
//    	// TODO: Read the input from the user and call produceAnswer with an equation
//
//   }
////    
//    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
//    // This function takes a String 'input' and produces the result
//    //
//    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
//    //      e.g. input ==> "1/2 + 3/4"
//    //        
//    // The function should return the result of the fraction after it has been calculated
//    //      e.g. return ==> "1_1/4"
//    public static String produceAnswer(String input)
//    { 
//        // TODO: Implement this function to produce the solution to the input
//    	String[] splitEquation = input.split(" ");
//        String operand1 = splitEquation[0];
//        String operator = splitEquation[1];
//        String operand2 = splitEquation[2];
//        String[] operand1Composition = operandSplitter(operand1);
//        String[] operand2Composition = operandSplitter(operand2);
//        if (operand1Composition[2].equals("0") || operand2Composition[2].equals("0")){
//        	return("Do not enter an equation where a denominator is 0");
//        } 
//        
//        return ("whole:" + operand2Composition[0] + " numerator:" + operand2Composition[1] + " denominator:" + operand2Composition[2]);
//    }
//    
//    public static String[] operandSplitter (String inputOperand){
//    	String[] numberArr = new String[3];
//    	if (inputOperand.indexOf("_") == -1 && inputOperand.indexOf("/") == -1){
//    		if (inputOperand.indexOf("-") == 0){
//    			numberArr[0] = inputOperand.substring(1);
//    		}else{
//    			numberArr[0] = inputOperand;
//    		}
//    		numberArr[1] = "0";
//    		numberArr[2] = "1";
//    	}else if(inputOperand.indexOf("_") == -1 && inputOperand.indexOf("/") > -1){
//    		numberArr[0] = "0";
//    		String[] fractionSplit = inputOperand.split("/");
//    		numberArr[1] = fractionSplit[0];
//    		numberArr[2] = fractionSplit[1];
//        } else if(inputOperand.indexOf("/") == -1 && inputOperand.indexOf("_") > -1){
//    		String[] wholeNumSplit = inputOperand.split("_");
//    		numberArr[0] = wholeNumSplit[0];
//    		numberArr[1] = "0";
//    		numberArr[2] = "1";
//    	}else{	
//    		String[] wholeNumSplit = inputOperand.split("_");
//    		numberArr[0] = wholeNumSplit[0];
//    		String[] fractionSplit = wholeNumSplit[1].split("/");
//    		numberArr[1] = fractionSplit[0];
//    		numberArr[2] = fractionSplit[1];
//    	}
//    	return (numberArr);
//    	
//    	}
//
//    // TODO: Fill in the space below with any helper methods that you think you will need
//    
//    	}

