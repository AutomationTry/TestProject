package Demo;

public class ExceptionHandlingDemo {
	public static void main(String[] args) {
		try {
			demo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void demo() throws Exception {
		/*try {
			System.out.println("Hello World!");
			int i = 1/0;
			System.out.println("Completed");
			
			}
			
			catch(Exception exc) {
				System.out.println("Inside catch block");
				System.out.println("Message is : "+exc.getMessage());
				System.out.println("Cause is : "+exc.getCause());
				exc.printStackTrace();
				
			}
			
			finally {
				System.out.println("Inside finally block");
			}*/
		System.out.println ("Hello World!");
		throw new ArithmeticException("Not valid operation");
		//int i = 1/0;
		//System.out.println("Completed");
	}

}
