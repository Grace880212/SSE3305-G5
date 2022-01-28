package sse3305;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class Testpro {
	ChangePassword re=new ChangePassword();
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
	void procedure02001(){
		provideInput("2046807 13579246 13579246");
		ChangePassword.main(null);
		String change=ChangePassword.Change("2046807", "13579", "13579");
		Assertions.assertEquals("Modify the success", change);
		
		String change1=ChangePassword.Change("2046807", "135792", "135792");
		Assertions.assertEquals("Modify the success", change1);
		
		String change2=ChangePassword.Change("2046807", "1357924", "1357924");
		Assertions.assertEquals("Modify the success", change2);
		
		String change3=ChangePassword.Change("2046807", "13579246", "13579246");
		Assertions.assertEquals("Modify the success", change3);
		
		String change4=ChangePassword.Change("2046807", "135792466", "135792466");
		Assertions.assertEquals("Modify the success", change4);
		
		String change5=ChangePassword.Change("2046807", "1357924666", "1357924666");
		Assertions.assertEquals("Modify the success", change5);
		
		String change6=ChangePassword.Change("2046807", "13579246666", "13579246666");
		Assertions.assertEquals("Modify the success", change6);
		
		String change7=ChangePassword.Change("2046807", "135792466666", "135792466666");
		Assertions.assertEquals("Modify the success", change7);
		
		String change8=ChangePassword.Change("2046807", "1357924666666", "1357924666666");
		Assertions.assertEquals("Modify the success", change8);
		
		String change9=ChangePassword.Change("2046807", "13579246666666", "13579246666666");
		Assertions.assertEquals("Modify the success", change9);
		
	}
	@Test
	void  procedure02002(){
		String change=ChangePassword.Change("2046807", "1234", "1234");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change);
		
		String change1=ChangePassword.Change("2046899", "1234", "1234");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change1);
		
		String change2=ChangePassword.Change("2046899", "1234", "1246");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change2);
		
		String change3=ChangePassword.Change("2046807", "1234", "1246");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change3);
		
		String change4=ChangePassword.Change("2046807", "1234561234567891", "1234561234567891");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change4);
		
		String change5=ChangePassword.Change("2046899", "1234561234567891", "1234561234567899");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change5);
		
		String change6=ChangePassword.Change("2046807", "1234561234567891", "1234561234567899");
		Assertions.assertEquals("The password cannot be less than 5 characters or more than 14 characters", change6);
		
		String change7=ChangePassword.Change("13579246", "13579246", "13579246");
		Assertions.assertEquals("Please enter a password that does not match the original password Please try again", change7);
		
		String change8=ChangePassword.Change("2046807", "13579246", "13599246");
		Assertions.assertEquals("The two passwords are inconsistent", change8);
	}	
}
