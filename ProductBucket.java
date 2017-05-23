import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Calculates the sum of given products.
 */
public class ProductBucket {

    /**
     * Represents a product with a price.
     */
    /**
     * @author mini
     *
     */
    /**
     * @author mini
     *
     */
    /**
     * @author mini
     *
     */
    protected enum Product {
        APPLE(1, "Apple", 10),
        BANANA(2, "Banana", 10),
        MANGO(3, "Cherry", 10),
        PINEAPPLE(4, "Mango", 10),
        CHERRY(5, "Orange", 10);

        protected double price;
      
        protected int productNumber;

        protected String productName;

        private Product(int productNumber, String productName, double price) {
            this.price = price;
            this.productNumber = productNumber;
            this.productName = productName;
        }
//method for showing up values using productNumber
        public static Product getByNumber(int number) {
            for (Product product : values()) {
                if (product.productNumber == number) {
                    return product;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return productNumber + " - " + productName + " - " + String.format("\u20B9%.2f", price);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Map for storing Items with quantity
        Map<String, Integer> ItemList = new HashMap<>();
        try {
            double sum = 0.0d;
           
            int input = -1;
           String key;
           int value = 0;
            while (input != 0) {
    //showing up data
            	System.out.println("Please make your choice: ");
                for (Product product : Product.values()) {
                    System.out.println(product);
                    
                }
                System.out.println("0 - Quit and show sum");
//enter user input by selecting productNumber
                input = readNumberInput(scanner);

                if (input == 0) {
                    break;
                }

                if (input != -1) {
                    Product product = Product.getByNumber(input);

                    if (product == null) {
                        System.out.println("The entered product number was not correct. Please try again.");
                    } else {
                        System.out.println("Enter quantity of product [" + product.productName + "]:");
                       

                    //   If there is already product in the bucket ,add previous value with new one
                        if(ItemList.containsKey(product.productName))
                        {
                        	for (Entry<String,Integer > entry : ItemList.entrySet()) {
                                 key=entry.getKey();
                                 value=entry.getValue();
                        	}
                                input = readNumberInput(scanner);
                                value +=input;
                              //  System.out.println("inputnew"+value);
                                ItemList.put(product.productName,value);
          	
                        }
                        //else add productNmae with quantity
                        else
                        {  	 
                        	 input = readNumberInput(scanner);
                            ItemList.put(product.productName,input);

                        }
                        //calculate total sum
                        if (input > 0) {
                              sum += product.price * input;

                        }
                    }
                }
            }
            System.out.println("Your Selected Item and quantiy:"+ItemList);
            System.out.println("Total sum of Bucket is: " + String.format("\u20B9%.2f", sum));
        } finally {
            scanner.close();
        }
    }

    /**
     * Reads a number from a scanner instance and catches erroneous input.
     * 
     * @param scanner
     * @return
     */
    private static int readNumberInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            String inputString = scanner.next();
            System.out.println("Input [" + inputString + "] was not correct. Please choose a number.");
            return -1;
        }
    }
}

