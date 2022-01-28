package sse3305;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookBill_Test {
	BookBill b = new BookBill();
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    
    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }   
    
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    
    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }   		

	@Test
	void Procedure1() {		
		String b1 =BookBill.calculate(0, 0);
		String b2 =BookBill.calculate(11, 0);
		
		Assertions.assertEquals("invalided number", b1);
		Assertions.assertEquals("invalided number", b2);
	}
	/*Verify the day (invalid)*/
	@Test
	void Procedure2() {
		String b1 =BookBill.calculate(5, 0);		
		
		Assertions.assertEquals("Please input right days", b1);
	}
	/*Verify the book number and day (valid)*/
	@Test
	void Procedure3() {
		
		String b1 =BookBill.calculate(5, 3);
		String b2 =BookBill.calculate(5, 5);
		String b3 =BookBill.calculate(5, 10);
		String b4 =BookBill.calculate(5, 18);
		
		Assertions.assertEquals("You need pay 10.0deposit£¬total 23.5RM", b1);
		Assertions.assertEquals("You need pay 20.0deposit£¬total 67.5RM", b2);
		Assertions.assertEquals("You need pay 30.0deposit£¬total 175.0RM", b3);
		Assertions.assertEquals("You need pay 100.0deposit£¬total 631.0RM", b4);
	}
	@Test
	void main() {
		provideInput("0");
		provideInput("11");
		provideInput("5 0");
		provideInput("5 3");
		provideInput("5 5");
		provideInput("5 10");
		provideInput("5 18");
		b.main(null);
	}
}
