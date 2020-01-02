import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Craps {

    private Dice diceOne = new Dice();
    private Dice diceTwo = new Dice();

    private ArrayList<Integer> winningThrows = new ArrayList(Arrays.asList(7, 11));
    private ArrayList<Integer> losingThrows = new ArrayList(Arrays.asList(2, 3, 12));

    private static String THROW_AGAIN = "Throw again";
    private static String WIN = "You win";
    private static String LOSE = "You lose";

    private boolean loopActivated = false;
    private static ArrayList<String> POSITIVE_RESPONSES = new ArrayList(Arrays.asList("Y", "y"));
    private static ArrayList<String> NEGATIVE_RESPONSES = new ArrayList(Arrays.asList("N", "n"));

    public void shoot() {
        diceOne.roll();
        diceTwo.roll();
    }

    public Dice getDice1() {
        return diceOne;
    }

    public Dice getDice2() {
        return diceTwo;
    }

    public int addUpScore() {
        return diceOne.getFaceValue() + diceTwo.getFaceValue();
    }

    public String decideOutcome(int total) {
        if (winningThrows.contains(total)) {
            return WIN;
        } else if (losingThrows.contains(total)) {
            return LOSE;
        } else {
            return THROW_AGAIN;
        }
    }

    public String getResults() {
        return "Dice 1 is \" + diceOne.toString()\n" +
                "Dice 2 is \" + diceTwo.toString()\n" +
                "Total is: \" + addUpScore()\n" +
                "Result is " + decideOutcome(addUpScore());
    }

    public void playCraps() {
        loopActivated = true;
        while (loopActivated) {
            shoot();
            System.out.println(getResults());
            System.out.println("*************************");
            if (!decideOutcome(addUpScore()).equals(THROW_AGAIN)) {
                askPlayAgain();
            }
        }
    }

    private void askPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again?");
        String response = scanner.next();
        if (POSITIVE_RESPONSES.contains(response)) {
            loopActivated = true;
        } else if (NEGATIVE_RESPONSES.contains(response)) {
            loopActivated = false;
        } else {
            askPlayAgain();
        }
    }


}
