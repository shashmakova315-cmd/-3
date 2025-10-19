
import .util.Scanner;

// Enum для типа топлива
enum FuelType {
    GASOLINE,
    DIESEL,
    ELECTRICITY,
    HUMAN
}

// Класс для топлива
class Fuel {
    private FuelType type;
    private double volume;

    public Fuel(FuelType type, double volume) {
        this.type = type;
        this.volume = volume;
    }

    public FuelType getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public void refuel(double amount) {
        this.volume += amount;
        System.out.println("Заправлено " + amount + " единиц топлива. Текущий уровень топлива: " + this.volume);
    }

    @Override
    public String toString() {
        return "Тип топлива: " + type + ", Объем: " + volume;
    }
}

// Класс для двигателя
class Engine {
    private int power;
    private String type;

    public Engine(int power, String type) {
        this.power = power;
        this.type = type;
    }

    public void start() {
        System.out.println("Двигатель запущен (" + type + ", мощность " + power + " л.с.)");
    }

    public void stop() {
        System.out.println("Двигатель остановлен");
    }

    @Override
    public String toString() {
        return "Тип: " + type + ", Мощность: " + power + " л.с.";
    }
}

// Абстрактный класс для транспорта
abstract class Transport {
    protected Engine engine;
    protected Fuel fuel;

    public Transport(Engine engine, Fuel fuel) {
        this.engine = engine;
        this.fuel = fuel;
    }

    public abstract void move();

    public String getInfo() {
        return "Двигатель: " + engine + "\nТопливо: " + fuel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Fuel getFuel() {
        return fuel;
    }
}

// Класс для автомобиля (наследуется от Transport)
final class Car extends Transport {
    private int numberOfDoors;

    public Car(Engine engine, Fuel fuel, int numberOfDoors) {
        super(engine, fuel);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void move() {
        engine.start();
        System.out.println("Автомобиль едет по дороге.");
    }

    @Override
    public String getInfo() {
        return "Автомобиль (Количество дверей: " + numberOfDoors + ")\n" + super.getInfo();
    }
}

// Класс для самолета (наследуется от Transport)
final class Airplane extends Transport {
    private int wingspan;

    public Airplane(Engine engine, Fuel fuel, int wingspan) {
        super(engine, fuel);
        this.wingspan = wingspan;
    }

    @Override
    public void move() {
        engine.start();
        System.out.println("Самолет летит в небе.");
    }

    @Override
    public String getInfo() {
        return "Самолет (Размах крыльев: " + wingspan + " метров)\n" + super.getInfo();
    }
}

// Класс для корабля (наследуется от Transport)
final class Ship extends Transport {
    private int tonnage;

    public Ship(Engine engine, Fuel fuel, int tonnage) {
        super(engine, fuel);
        this.tonnage = tonnage;
    }

    @Override
    public void move() {
        engine.start();
        System.out.println("Корабль плывет по морю.");
    }

    @Override
    public String getInfo() {
        return "Корабль (Тоннаж: " + tonnage + " тонн)\n" + super.getInfo();
    }
}

// Класс для велосипеда (наследуется от Transport)
final class Bicycle extends Transport {
    private boolean hasBasket;

    public Bicycle(boolean hasBasket) {
        super(new Engine(1, "Ноги"), new Fuel(FuelType.HUMAN, 100)); // Велосипед использует "двигатель" ноги и "топливо" человека
        this.hasBasket = hasBasket;
    }

    @Override
    public void move() {
        System.out.println("Велосипед едет по дороге (или тротуару).");
    }

    @Override
    public String getInfo() {
        return "Велосипед (Есть корзина: " + hasBasket + ")\n" + super.getInfo();
    }
}

// Интерфейс пользователя (консольный)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание объектов
        Engine carEngine = new Engine(150, "Бензиновый");
        Fuel carFuel = new Fuel(FuelType.GASOLINE, 50);
        Car car = new Car(carEngine, carFuel, 4);

        Engine airplaneEngine = new Engine(5000, "Турбореактивный");
        Fuel airplaneFuel = new Fuel(FuelType.DIESEL, 10000);
        Airplane airplane = new Airplane(airplaneEngine, airplaneFuel, 30);

        Engine shipEngine = new Engine(2000, "Дизельный");
        Fuel shipFuel = new Fuel(FuelType.DIESEL, 50000);
        Ship ship = new Ship(shipEngine, shipFuel, 1000);

        Bicycle bicycle = new Bicycle(true);

        Transport[] transports = {car, airplane, ship, bicycle};

        while (true) {
            System.out.println("\nВыберите транспортное средство (1-4), чтобы взаимодействовать или 0, чтобы выйти:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Самолет");
            System.out.println("3. Корабль");
            System.out.println("4. Велосипед");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                break;
            }

            if (choice >= 1 && choice <= 4) {
                Transport selectedTransport = transports[choice - 1];

                System.out.println("\nДействия для " + selectedTransport.getClass().getSimpleName() + ":");
                System.out.println("1. Показать информацию");
                System.out.println("2. Двигаться");
                if (selectedTransport instanceof Car || selectedTransport instanceof Airplane || selectedTransport instanceof Ship) {
                    System.out.println("3. Заправить топливо");
                }
                System.out.println("0. Вернуться к выбору транспорта");

                int action = scanner.nextInt();
                scanner.nextLine();

                switch (action) {
                    case 1:
                        System.out.println(selectedTransport.getInfo());
                        break;
                    case 2:
                        selectedTransport.move();
                        break;
                    case 3:
                        if (selectedTransport instanceof Car || selectedTransport instanceof Airplane || selectedTransport instanceof Ship) {
                            System.out.print("Введите количество топлива для заправки: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            ((Transport) selectedTransport).getFuel().refuel(amount); // Приведение к Transport для доступа к fuel
                            break;
                        }

                    case 0:
                        break;
                    default:
                        System.out.println("Неверный выбор действия.");
                }

            } else {
                System.out.println("Неверный выбор транспорта.");
            }
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }
}
