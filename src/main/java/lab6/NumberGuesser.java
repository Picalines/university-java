package lab6;

import javax.swing.*;
import java.util.Random;

public class NumberGuesser {
    public static void main(String[] args) {
        int numberToGuess = new Random().nextInt(21);

        for (int i = 1; i <= 3; i++) {
            String numberInput = JOptionPane.showInputDialog(
                "Угадайте число от 0 до 20! [Попытка " + i + "/3]"
            );

            if (numberInput == null) {
                return;
            }

            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(numberInput);
                if (parsedNumber < 0 || parsedNumber > 20) {
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Введено некорректное число! Введите новое.");
                i--;
                continue;
            }

            if (parsedNumber < numberToGuess) {
                JOptionPane.showMessageDialog(null, "Это число слишком маленькое!");
            }
            else if (parsedNumber > numberToGuess) {
                JOptionPane.showMessageDialog(null, "Это число слишком большое!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Вы угадали!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Вы не смогли угадать число " + numberToGuess);
    }
}
