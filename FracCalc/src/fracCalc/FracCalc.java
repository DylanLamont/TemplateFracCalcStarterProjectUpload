/*
 * Fraction Calculator
 * 
 * Dylan Lamont period 2, December 2, 2016
 */

package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello and welcome to the fraction calculator, please enter your equation");
        String equation = input.nextLine();
        if (!equation.equals("quit")){
        	System.out.println(produceAnswer(equation));
        	while (!equation.equals("quit")){
                System.out.println("Please enter your equation.");
                equation = input.nextLine();
                System.out.println(produceAnswer(equation));
        	}
        }
    	
    	// TODO: Read the input from the user and call produceAnswer with an equation

   }
//    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)			//Produce answer runs the main process of the calculation. It will call other methods in order to decide (upon conditionals) which method is called.
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] splitEquation = input.split(" ");
        String operand1 = splitEquation[0];
        String operator = splitEquation[1];
        String operand2 = splitEquation[2];
        int[] operand1Composition = operandSplitter(operand1);
        int[] operand2Composition = operandSplitter(operand2);

        if (operator.equals("-") || operator.equals("+")){					//Test to call additive methods
        	int[] returnAnswer = addSubFraction(operand1Composition, operand2Composition, operator);
            return(reduceFrac(returnAnswer));
        } else if (operator.equals("*")){									//Test to find product from mult method
        	int[] returnAnswer = multiplyFraction(operand1Composition, operand2Composition);
        	return(reduceFrac(returnAnswer));
        }else if (operator.equals("/")){									//Conditional to see if divide method needed
        	int[] returnAnswer = divideFraction(operand1Composition, operand2Composition);
        	return(reduceFrac(returnAnswer));
        } else{
        	return("ERROR");							//Error Handling: more than two operators or odd formation does not run
        }
    }    
    
    
    public static int[] operandSplitter (String inputOperand){
    	String[] operandStringBreakdown = new String[3];
    	if (inputOperand.indexOf("_") == -1 && inputOperand.indexOf("/") == -1){				//Case for a number without fraction portion, i.e. 1
    		operandStringBreakdown[0] = inputOperand;
    		operandStringBreakdown[1] = "0";
    		operandStringBreakdown[2] = "1";
    	}else if(inputOperand.indexOf("_") == -1 && inputOperand.indexOf("/") > -1){			//Case of splitting for operand with only a fraction, no whole number, i.e. 3/7
    		operandStringBreakdown[0] = "0";
    		String[] fractionSplit = inputOperand.split("/");
    		operandStringBreakdown[1] = fractionSplit[0];
    		operandStringBreakdown[2] = fractionSplit[1];
        } else if(inputOperand.indexOf("/") == -1 && inputOperand.indexOf("_") > -1){			//Case for only whole number, i.e. 4_ +
    		String[] wholeNumSplit = inputOperand.split("_");
    		operandStringBreakdown[0] = wholeNumSplit[0];
    		operandStringBreakdown[1] = "0";
    		operandStringBreakdown[2] = "1";
    	}else{																	//Case for whole number and fraction operand i.e. 3_6/7	
    		String[] wholeNumSplit = inputOperand.split("_");
    		operandStringBreakdown[0] = wholeNumSplit[0];
    		String[] fractionSplit = wholeNumSplit[1].split("/");
    		operandStringBreakdown[1] = fractionSplit[0];
    		operandStringBreakdown[2] = fractionSplit[1];
    	}
    	/*
    	 * Next portion is used to be able to find the right procedure to turn the different configurations into a improoper fraction with a correct sign
    	 * 
    	 */
    	int[] returnIntArray = new int[2];
    	if (inputOperand.indexOf("-") > -1 && inputOperand.indexOf("_") > -1){					//Case to turn to improper with negative whole number
    		returnIntArray[0] = ((Integer.parseInt(operandStringBreakdown[0]) * Integer.parseInt(operandStringBreakdown[2])) - Integer.parseInt(operandStringBreakdown[1]) );
    	}
    	else if (inputOperand.indexOf("-") > -1 && inputOperand.indexOf("_") == -1){			//Case and used for fractions with no whole number, but has a negative numerator
    		returnIntArray[0] = Integer.parseInt(operandStringBreakdown[1]);					
    		if (inputOperand.indexOf("/") == -1){										
    			returnIntArray[0] = Integer.parseInt(operandStringBreakdown[0]);
    		}
    	}
    	else{
    	returnIntArray[0] = (Integer.parseInt(operandStringBreakdown[1]) + (Integer.parseInt(operandStringBreakdown[0]) * Integer.parseInt(operandStringBreakdown[2])));
    	}
    	returnIntArray[1] = Integer.parseInt(operandStringBreakdown[2]);
    	return (returnIntArray);
    	
  }
    
    
    
    public static int[] addSubFraction (int[] operand1, int[] operand2, String operator){
    	int[] sumFrac = new int[2];
    	if (operand1[1] == operand2[1]){					//Case if similar denominators
    		sumFrac[0] = operand1[0] + operand2[0];
    		sumFrac[1] = operand1[1];
    	} else{												//Case if need to find common denominator
    		sumFrac[1] = operand1[1] * operand2[1];
    		operand1[0] *= operand2[1];
    		operand2[0] *= operand1[1];
    	}
    	
    	if (operator.equals("+")){							//Addition portion
    		sumFrac[0] = operand1[0] + operand2[0];
    	}else{												//Subtraction portion
    		sumFrac[0] = operand1[0]  - operand2[0];
    	}
    	return (sumFrac);
    }

    
    
    public static int[] multiplyFraction (int[] operand1, int[]operand2 ){
    	int[] productFrac = new int[2];
    	productFrac[0] = operand1[0] * operand2[0];
    	productFrac[1] = operand1[1] * operand2[1];
    	return (productFrac);											//Answer simply is numerators multiplied together and denominators multiplied together 
    }
    
    public static int[] divideFraction (int[] operand1, int[] operand2){
    	int reciprocalTempInt = operand2[0];
    	operand2[0] = operand2[1];
    	operand2[1] = reciprocalTempInt;								//Find Reciprocal and call multiply with reciprocal as second operand
    	int[] quocientFrac = multiplyFraction(operand1, operand2);
    	return (quocientFrac);
    }
    
    
    public static String reduceFrac (int[] result){
    	 int gcf = gcf(result[0], result[1]);
    	 result[0] /= gcf;
    	 result[1] /= gcf;
    	 String answer = toMixedNum(result[0], result[1]);
    	 return (answer);
    	 
    }
    
    
	public static int gcf (int num1, int num2){				//finds the greatest common factor of the two numbers
		if (num1 <0 && num2 <0){						//solution to error if both negative, the max does not work
			num1 *= -1;
			num2 *= -1;
		}
		int loopVar = Math.max(num1, num2);
		if (num1 == num2){
			return(num1);
		}
		for (;loopVar > 0; loopVar--){
			if (num1 % loopVar == 0 && num2 % loopVar ==0){
				return (loopVar);
			}
		}
		return(1);
	}

	public static String toMixedNum (int numerator, int denominator){			// Method used to turn the improper fraction into a mixed fraction
		if (denominator == 0){
			return ("ERROR");													//Error Handling - zero in denominator
		}
		int wholeNum = numerator/denominator;
		int fracNum = numerator % denominator;
		if (fracNum == 0){
			return (wholeNum + "");
		}
		if(wholeNum<0 && fracNum<0){					//Cases to find how to organize the negatives
			fracNum *= -1;
		} if(fracNum <0 && denominator < 0){
			fracNum *= -1;
			denominator *= -1;
		} if (wholeNum<0 && denominator<0){
			denominator *= -1;
		}if (denominator<0 && numerator>0){
			denominator *= -1;
			fracNum *= -1;
		}
		
		if(wholeNum==0){
			return (fracNum + "/" + denominator );
		}
		return (wholeNum + "_" + fracNum + "/" + denominator);
	}
}


