import java.util.Scanner;
class PiCalculator {
    private double piValue;
    public PiCalculator(int terms) {
        calculatePi(terms);
    }
    private void calculatePi(int terms) {
        piValue = 0.0;

        for (int i = 0; i < terms; i++) {
            if (i % 2 == 0)
                piValue += 4.0 / (2 * i + 1);
            else
                piValue -= 4.0 / (2 * i + 1);
        }
    }
    public void displayPi() {
        System.out.println("\nPublic Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + piValue);
    }
    protected void displayPrecision(int terms) {
        System.out.println("\nProtected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + terms + " terms");
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + ...)");
    }
    public void showPrivateData() {
        System.out.println("\nPrivate Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + piValue);
    }
}
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Pi Calculator using Access Specifiers ===");

        System.out.print("\nEnter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();
        System.out.println("\nCalculating Pi using Leibniz Series...");
        PiCalculator obj = new PiCalculator(terms);
        obj.displayPi();          
        obj.displayPrecision(terms); 
        obj.showPrivateData();    
        sc.close();
    }
}
