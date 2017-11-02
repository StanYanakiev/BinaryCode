package appOne;

/**
 * Binary android app conversions
 * September 28, 2017
 * @author STANISLAV
 */
public class Conversion 
{
	/**
	 * Decimal to Binary
	 * @param number the decimal number to convert
	 * to 2's complement binary
	 * @return a String representation of the converted number to preserve the 0's
	 */
	public String convertDecimalToBinary(double number)
	{
		System.out.println("Trying to Convert:  " + number);
		
		if (number < 0)
		{
			String toReturn = negativeConvert(number);
			return "1" + toReturn;
		}
		else if (number > 0)
		{
			return "0" + positiveConvert(number);
		}
		
		return "0000";
	}
	
	/**
	 * Returns a string representation of a positive number in binary
	 * @param number a positive number
	 * @return the number in binary
	 */
	public String positiveConvert(double number)
	{
		//Test The Number To Convert
		//To hold the converted number in binary
		String binary = "";
		
		//Set to arbitrary values
		int result = -1;
		int remainder = -1;
		
		while (result != 0)
		{
			//Divide the number by 2 and take the remainder
			result = (int) Math.floor(number/2);
			remainder = (int) number % 2;
			
			//Append the remainder to the front
			binary = Integer.toString(remainder) + binary;
			
			number = result;
		}
		return binary;
	}
	
	public String invert(String number)
	{
		String invert = "";
		//int numberInt = (int) number;
		//String numberStr = Integer.toString(numberInt);
		
		for(int i = 0; i < number.length(); i++)
		{
			if(number.substring(i, i + 1).equals("0"))
			{
				invert += "1";
			}
			else
				invert += "0";
		}
		return invert;
	}
	
	public String twosComplement(String invertedNumber)
	{
		int add = 1;
		int carry = 0;
		String binary = "";
		
		//Starts at the end
		for(int i = invertedNumber.length() - 1; i >= 0; i--)
		{
			int tmp = Integer.parseInt(invertedNumber.substring(i, i + 1));
			carry = tmp + add;
			
			if(carry == 2)
			{
				carry = 1;
				binary = binary + "0";
			}
			else if(carry == 1)
			{
				binary = binary + "1";
				add = 0;
			}
			else
			{
				binary = binary + carry;
				add = 0;
			}
		}
		
		//Reverse the String
		String converted = "";
		for(int i = binary.length() - 1; i >= 0; i--)
		{
			converted += binary.substring(i, i + 1);
		}
		
		return converted;
	}
	
	public String negativeConvert(double number)
	{
		double numberAbs = Math.abs(number);
		String intoPosBinary = positiveConvert(numberAbs);
		String invert = invert(intoPosBinary);
		String converted = twosComplement(invert);
		return converted;
	}
	
	//-------------------------------
	//-------------------------------
	//-------------------------------
	//-------------------------------
	//-------------------------------
	//--------BINARY-TO-DECIMAL------
	//-------------------------------
	//-------------------------------
	//-------------------------------
	//-------------------------------
	
	public String convertBinaryToDecimal(String number)
	{
	
		if(number.substring(0, 1).equals("1"))
		{
			String negative = negativeBinaryToDecimal(number);
			return negative;
		}
		else if(number.substring(0, 1).equals("0"))
		{
			String positive = positiveBinaryToDecimal(number);
			return positive;
		}
		else
			return "N/A";
		
	}
	
	public String positiveBinaryToDecimal(String positive)
	{
		int powerOf = 0;
		int sum = 0;
		String noSign = positive.substring(1);
		
		for(int i = noSign.length() -1; i >= 0; i--)
		{
			if (noSign.substring(i, i + 1).equals("1"))
			{
				sum += Math.pow(2, powerOf);
				powerOf++;
			}
			else
			{
				powerOf++;
			}
		}
		String sumString = Integer.toString(sum);
		return sumString;
	}
	
	public String negativeBinaryToDecimal(String negative)
	{
		String invert = invert(negative);
		String twosC = twosComplement(invert);
		String toConvert = positiveBinaryToDecimal(twosC);
		
		return "-" + toConvert;
	}

}
