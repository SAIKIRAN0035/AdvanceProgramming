import java.util.Random;
import java.util.Scanner;

class G{
    private int sc;// The secret number to guess
    private int pg;// To keep track of the previous guess
    private int no;// To count the number of tries

    public G() {
        Random random = new Random();
// Generate a random secret number between 20 and 10,000,000
        this.sc = random.nextInt(10000000 - 20 + 1) + 20;
   System.out.println("score:"+ sc);
        this.pg = -1; // Initialize the previous guess to a value that won't be guessed initially
        this.no = 0; // Initialize the number of tries to 0
    }

    public boolean mG(int val) {
        this.no++; // Increment the number of tries for each guess

        if (val == this.sc) {
            System.out.println(this.sc + " YOU GUESSED IT in " + this.no + " steps!");
            return true; // The guess is correct; exit the loop
        } else if (val > this.sc) {
            System.out.println(val + " is too large");
        } else {
            System.out.println(val + " is too small");
        }

        // Check if the user is guessing the same value consecutively
        if (val == this.pg) {
            System.out.println("You again made the same guess. Still, that counts as one attempt.");
        }

        this.pg = val; // Update the previous guess
        return false;  // The guess is incorrect; continue the loop
    }
}

public class gs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        G g1 = new G(); // Create an instance of the game

        System.out.println("The Guessing Game is here; welcome!");
        System.out.println("Enter a number between 20 and 10,000,000.");

        while (true) {
            System.out.print("Make a guessing number here: ");
            int val = scanner.nextInt();

            if (g1.mG(val)) {
                break; // Exit the loop when the correct guess is made
            }
        }

        scanner.close(); // Close the scanner when the game is finished
    }
}
