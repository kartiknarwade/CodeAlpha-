## Strategic Game Suite

### Code
```java
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        int user = 0, comp = 0;
        Scanner sc = new Scanner(System.in); // Initialize Scanner outside the loop

        for (int i = 0; i < 3; i++) {
            Random r = new Random();
            int compInput = r.nextInt(3) + 1; // Adjusted to get a value between 1 and 3

            System.out.print("Enter Your choice (1 = Rock, 2 = Paper, 3 = Scissor): ");
            int userInput = sc.nextInt();
            
            // Check for valid user input
            if (userInput < 1 || userInput > 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                i--; // Decrement i to repeat the iteration
                continue; // Skip to the next iteration
            }

            if (compInput == userInput) {
                System.out.println("Match Draw");
            } else if ((compInput == 1 && userInput == 3) || (compInput == 2 && userInput == 1) || (compInput == 3 && userInput == 2)) {
                System.out.print("Computer Wins, ");
                comp++;
            } else {
                System.out.print("You Win, ");
                user++;
            }
            System.out.println("Because Computer chose: " + compInput + " and You chose: " + userInput + "\n");
        }
        
        sc.close(); // Close the Scanner object after the loop

        System.out.println("Final Result: ");
        if (user < comp) {
            System.out.println("Computer wins this Game!!");
        } else if (user > comp) {
            System.out.println("You win this Game!!");
        } else {
            System.out.println("Match Draw");
        }
    }
}

```
