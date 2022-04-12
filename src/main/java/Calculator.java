import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Calculator {
	private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {

    }

    public static void main(String[] args) {
    	
        int ip;
        int intInp;
        double dbInp;
        Calculator calculator = new Calculator();
        Scanner inputRead = new Scanner(System.in);
        
        System.out.println("Options:");
        System.out.println("1. Square root");
        System.out.println("2. Factorial");
        System.out.println("3. Natual logarithm");
        System.out.println("4. Raise to power");
        System.out.println("Press any other key to exit");
        
        while(true){
            System.out.println("Enter choice:");        
            try {
                ip = inputRead.nextInt();
                // inputRead.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("Exiting...");
                inputRead.close();
                System.out.println("bye bye!");
                return;
            }

            switch(ip) {
                case 1:
                    try{
                        System.out.println("Option chosen: Square root");
                        System.out.println("Enter the number: ");
                        dbInp = inputRead.nextDouble();
                        // inputRead.nextLine();
                        System.out.println(calculator.squareRoot(dbInp));
                        break;
                    } catch(InputMismatchException e) {
                        // log here
                    	logger.error("Invalid input, entered value is not of type Double");
                        return;
                    }

                case 2:
                    try {
                        System.out.println("Option chosen: Factorial");
                        System.out.println("Enter the number: ");
                        intInp = inputRead.nextInt();
                        // inputRead.nextLine();
                        System.out.println(calculator.factorial(intInp));
                        break;
                    } catch(InputMismatchException e) {
                        // log here
                    	logger.error("Invalid input, entered value is not of type Integer");
                        return;
                    }

                case 3:
                    try {
                        System.out.println("Option chosen: Natural Logarithm");
                        System.out.println("Enter the number: ");
                        dbInp = inputRead.nextDouble();
                        // inputRead.nextLine();
                        System.out.println(calculator.naturalLog(dbInp));
                        break;
                    } catch(InputMismatchException e) {
                        // log here
                    	logger.error("Invalid input, entered value is not of type Integer");
                        return;
                    } 

                case 4:
                    try {
                        System.out.println("Option chosen: Power");
                        System.out.println("Enter the base: ");
                        double base, power;
                        base = inputRead.nextInt();
                        // inputRead.nextLine();
                        System.out.println("Enter the power: ");
                        power = inputRead.nextInt();
                        // inputRead.nextLine();
                        System.out.println(calculator.power(base, power));
                        break;
                    } catch(InputMismatchException e) {
                        // log here
                    	logger.error("Invalid input(s), entered value(s) are not of type Double");
                        return;
                    }

                default:
                    System.out.println("Exiting...");
                    inputRead.close();
                    System.out.println("bye bye!");
                    return;
            }

        }
    }
    
    // functions
    public double squareRoot(double num) {
        double ans = Math.sqrt(num);
        logger.info("[Square root function result for input "+num+"]: "+ans);
        return ans;
    }
    public int factorialHelper(int num) {
    	if(num==0) return 1;
    	return num*factorialHelper(num-1);
    }
    public int factorial(int num) {
        int ans = factorialHelper(num);
        logger.info("[Factorial function result for input "+num+"]: "+ans);
        return ans;
    } 
    public double naturalLog(double num) {
        double ans = Math.log(num);
        logger.info("[Natural log function result for input "+num+"]: "+ans);
        return ans;
    }
    public double power(double base, double power){
        double ans = Math.pow(base, power);
        logger.info("[Power function result for inputs "+base+", "+power+"]: "+ans);
        return ans;
    }

}