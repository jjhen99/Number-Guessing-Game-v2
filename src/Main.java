import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * 100) +1;
        //System.out.println(computerNumber);
        int userAnswer = 0;

        int guessCount = 1;

        int maxCount = 10;

        while (userAnswer != computerNumber) {

            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100.\nYou have " + maxCount + " guesses left." , "Guessing Game",3);

            if(response == null){
                JOptionPane.showMessageDialog(null, "Thanks for playing!","Guessing Game",3);
                break;
            }

             try{  userAnswer = Integer.parseInt(response);
                 JOptionPane.showMessageDialog(null,"" + determineGuess(userAnswer, computerNumber, guessCount));
                 guessCount++;
                 maxCount--;}
             catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Your input was invalid, enter a number","Guessing Game",3);
            }





            if (maxCount == 0) {
                JOptionPane.showMessageDialog(null, "You have ran out of guesses\n Game Over!", "Guessing Game",3);
                break;
            }

        }

    }

    public static String determineGuess(int userAnswer, int computerNumber, int guessCount){

        if (userAnswer < 0 || userAnswer > 100) {
            return "Your guess is invalid";
        }

        else if (userAnswer == computerNumber){
            return "Correct!\nTotal Guesses: " + guessCount;
        }

        else if (userAnswer > computerNumber){
            return "Your guess is too high, try again.\nCurrent guess count: " + guessCount;
        }

        else if (userAnswer < computerNumber){
            return "Your guess is too low, try again.\nCurrent guess count: "+ guessCount;
        }


        else{
            return "Your guess is incorrect.\nCurrent guess count: "+ guessCount;
        }
    }
}


