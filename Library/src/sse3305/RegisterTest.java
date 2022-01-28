package sse3305;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterTest {
	 Register re=new Register();
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    
    @BeforeEach
    public void setUpOutput() {
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
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }     
    
	@Test
	void register(){
		provideInput("Alic 12345 12345");
		re.main(null);
		String register1=Register.register("Alic", "12345", "12345");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register1);
		
		String register2=Register.register("Alic", "123456", "123456");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register2);
		
		String register3=Register.register("Alic", "1234567891234", "1234567891234");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register3);
		
		String register4=Register.register("Alic", "12345678912345", "12345678912345");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register4);
		
		String register5=Register.register("Eadan", "12345", "12345");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register5);
		
		String register6=Register.register("Eadan", "123456", "123456");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register6);
		
		String register7=Register.register("Eadan", "1234567891234", "1234567891234");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register7);
		
		String register8=Register.register("Eadan", "12345678912345", "12345678912345");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register8);
	
		String register9=Register.register("Veasna", "12345", "12345");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register9);
		
		String register10=Register.register("Veasna", "123456", "123456");
		Assertions.assertEquals("Registration successful! Please remember the user name and password", register10);

	}
	
	@Test
	void register1(){
		provideInput("Alic 12345 12345");
		re.main(null);
		String register1=Register.register("Ali", "1234", "1234");
		Assertions.assertEquals("The username cannot contain less than 4 characters", register1);
		
		String register2=Register.register("Alice", "123456789012345", "123456789012345");
		Assertions.assertEquals("The password contains a maximum of 14 characters", register2);
		
		String register3=Register.register("Alicer", "1234567", "1234567890125");
		Assertions.assertEquals("The two passwords are inconsistent£¡", register3);
		
		String register4=Register.register("Alicers", "1234", "2345");
		Assertions.assertEquals("The password must contain at least 5 characters", register4);
		
		String register5=Register.register("Alicerse", "123456789012345", "2345");
		Assertions.assertEquals("The password contains a maximum of 14 characters", register5);
		
		String register6=Register.register("Alic", "1234567890", "2345");
		Assertions.assertEquals("The two passwords are inconsistent£¡", register6);
		
		String register7=Register.register("Ali", "1234567890", "2345");
		Assertions.assertEquals("The username cannot contain less than 4 characters", register7);
		
		String register8=Register.register("Alic", "123456789012345", "123456789012345");
		Assertions.assertEquals("The password contains a maximum of 14 characters", register8);
		
		String register9=Register.register("Ali", "123456789012345", "223456789012345");
		Assertions.assertEquals("The username cannot contain less than 4 characters", register9);
	}
}
