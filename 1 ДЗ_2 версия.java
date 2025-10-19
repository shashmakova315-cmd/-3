import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Выводим информацию о поддерживаемых операциях
        System.out.println("Консольный калькулятор");
        System.out.println("Поддерживаемые операции: +, -, *, /, ^, // (целочисленное деление), % (остаток от деления)");
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
                    System.out.println("Неверное выражение. Введите выражение в формате: число операция число");
                    continue;
                }

                double num1 = parseDouble(parts[0]); // Получаем первое число
                String operation = parts[1]; // Получаем операцию
                double num2 = parseDouble(parts[2]); // Получаем второе число

                // Выполняем операцию и выводим результат
                double result = calculate(num1, operation, num2);
                System.out.println("Результат: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Пожалуйста, введите число.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Выводим сообщение об ошибке, например, о делении на ноль
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Функция для преобразования строки в double с обработкой исключений
    private static double parseDouble(String str) {
        try {
            return Double.parseDouble(str.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат числа: " + str);
        }
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
                    throw new IllegalArgumentException("Ошибка: деление на 0.");
                }
                return divide(num1, num2);
            case "//":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Ошибка: деление на 0.");
                }
                return integerDivide(num1, num2);
            case "^":
                return power(num1, num2);
            case "%":
                return modulo(num1, num2);
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция: " + operation);
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
        return Math.floor(a / b);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double modulo(double a, double b) {
        return a % b;
    }
}