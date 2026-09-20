package session_one_topics.class_problems;
import java.util.Scanner;
import java.util.Random;
public class rock_paper_scissors_game {
    public static void main(String[]args){
        String[] choices = {"rock", "paper", "scissors"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter rock, paper, or scissors: ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        int randomIndex = random.nextInt(3);
        String computerChoice = choices[randomIndex];

        System.out.println("Computer chose: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a draw!");
        }
        else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                        (userChoice.equals("scissors") && computerChoice.equals("paper")))
        {
            System.out.println("Congratulations, you win!");
        }
        else{
            System.out.println("Computer wins!");
        }
        scanner.close();
    }
}
