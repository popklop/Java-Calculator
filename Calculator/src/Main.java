import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean hasResult = false;

        while (true) {
            if (!hasResult) {
                System.out.print("Введите первое число (или C для сброса, s для выхода): ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("s")) {
                    break;
                }
                if (input.equalsIgnoreCase("c")) {
                    result = 0;
                    hasResult = false;
                    continue;
                }
                try {
                    result = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: некорректное число.");
                    continue;
                }
            } else {
                System.out.println("Текущий результат: " + result);
                System.out.print("Введите операцию (+, -, *, /) или C для сброса, s для выхода: ");
            }

            String opInput = scanner.next();
            if (opInput.equalsIgnoreCase("s")) {
                break;
            }
            if (opInput.equalsIgnoreCase("c")) {
                result = 0;
                hasResult = false;
                continue;
            }

            char operation = opInput.charAt(0);

            System.out.print("Введите второе число: ");
            String secondInput = scanner.next();
            if (secondInput.equalsIgnoreCase("s")) {
                break;
            }
            if (secondInput.equalsIgnoreCase("c")) {
                result = 0;
                hasResult = false;
                continue;
            }

            double operand;
            try {
                operand = Double.parseDouble(secondInput);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректное число.");
                continue;
            }

            boolean valid = true;
            switch (operation) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '*':
                    result *= operand;
                    break;
                case '/':
                    if (operand == 0) {
                        System.out.println("Ошибка: деление на ноль.");
                        valid = false;
                    } else {
                        result /= operand;
                    }
                    break;
                default:
                    System.out.println("Ошибка: неподдерживаемая операция.");
                    valid = false;
            }

            if (valid) {
                System.out.println("Результат: " + result);
                hasResult = true;
            }
        }

        scanner.close();
    }
}