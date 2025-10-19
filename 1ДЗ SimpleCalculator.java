import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выводим информацию о поддерживаемых операциях
        System.out.println("Консальный калькулятор");
        System.out.println("Поддерживаемые операции: +, -, *, /, ^");
        System.out.println("Введите выражение с пробелом, в формате: число операция число (например, 2 + 3)");
        System.out.println("Для выхода введите 'exit'");

        // Основной цикл программы
        while (true) {
            System.out.println("Введите выражение:");
            String input = scanner.nextLine();

            // Проверяем команду выхода
            if (input.equals("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            // Обрабатываем выражение
            try {
                String[] parts = input.split(" "); // Разделяем строку на части (число, операция, число)
                if (parts.length != 3) {
                    System.out.println("Неверное выражение. Введите еще раз:");
                    continue;
                }

                double num1 = Double.parseDouble(parts[0].replace(",", ".")); // Получаем первое число и меняем запятую на точку для корректной работы с double
                String operation = parts[1]; // Получаем операцию
                double num2 = Double.parseDouble(parts[2].replace(",", ".")); // Получаем второе число и меняем запятую на точку для корректной работы с double

                // Выполняем операцию и выводим результат
                double result = calculate(num1, operation, num2);
                System.out.println("Результат: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Введите еще раз:");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Выводим сообщение об ошибке, например, о делении на ноль
            } catch (Exception e) {
                System.out.println("Неверное выражение. Введите еще раз:");
            }
        }

        scanner.close();
    }

    // Функция для проверки корректности выражения
    public static boolean isValidExpression(String expression) {
        // Проверяем что выражение не пустое
        return !expression.isEmpty();
    }
        // Функция для выполнения вычислений
    public static double calculate(double num1, String operation, double num2) {
        switch (operation) {
            case "+":
                return sum(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Ошибка - деление на 0.");
                }
                return divide(num1, num2);
            case "//":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Ошибка - деление на 0.");
                }
                return integerDivide(num1, num2);
            case "^":
                return power(num1, num2);
            case "%":
                return modulo(num1, num2);
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция.");
        }
    }

    // Функции для выполнения операций
    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double integerDivide(double a, double b) {
       return (int) (a / b);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double modulo(double a, double b) {
        return a % b;
    }
}