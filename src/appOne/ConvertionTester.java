package appOne;

public class ConvertionTester 
{
	public static void main(String[] args)
	{
	Conversion tester = new Conversion();
	int x = 200;
	String binary = tester.convertDecimalToBinary(x);
	String test = Integer.toBinaryString(x);
	
	// BINARY TO DECIMAL
	String converted = tester.convertBinaryToDecimal(binary);
	
	System.out.println("Convreted: " + binary);
	System.out.println("Check with library: " + test);
	
	System.out.println("Back to decimal: "+ converted);
	}
}
