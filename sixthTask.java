import java.util.*;

class TelephoneSubscriberCollection {
    private String fullName;
    private String address;
    private String phoneNumber;
    private int month;
    private int year;
    private int minutes;
    private double costPerMinute;

    public TelephoneSubscriberCollection(String fullName, String address, String phoneNumber, int month, int year) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.month = month;
        this.year = year;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getCostPerMinute() {
        return costPerMinute;
    }

    public void setCostPerMinute(double costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    // Метод для вычисления общей стоимости
    public double calculateTotalCost() {
        return minutes * costPerMinute;
    }

    @Override
    public String toString() {
        return String.format("Абонент: %s\nАдрес: %s\nТелефон: %s\nДата: %02d/%d\nКоличество минут: %d\nСтоимость за минуту: %.2f\nОбщая стоимость: %.2f",
                fullName, address, phoneNumber, month, year, minutes, costPerMinute, calculateTotalCost());
    }
}


public class sixthTask {
    public static void main(String[] args) {
        List<TelephoneSubscriberCollection> subscribers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить абонента");
            System.out.println("2. Показать всех абонентов");
            System.out.println("3. Отсортировать абонентов по имени");
            System.out.println("4. Отсортировать абонентов по количеству минут");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Добавление абонента
                    System.out.print("Введите ФИО: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Введите адрес: ");
                    String address = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Введите месяц: ");
                    int month = scanner.nextInt();
                    System.out.print("Введите год: ");
                    int year = scanner.nextInt();
                    System.out.print("Введите количество минут: ");
                    int minutes = scanner.nextInt();
                    System.out.print("Введите стоимость за минуту: ");
                    double costPerMinute = scanner.nextDouble();
                    scanner.nextLine();

                    TelephoneSubscriberCollection newSubscriber = new TelephoneSubscriberCollection(fullName, address, phoneNumber, month, year);
                    newSubscriber.setMinutes(minutes);
                    newSubscriber.setCostPerMinute(costPerMinute);
                    subscribers.add(newSubscriber);
                    System.out.println("Абонент успешно добавлен!");
                    break;

                case 2:
                    // Показать всех абонентов
                    System.out.println("Список абонентов:");
                    for (TelephoneSubscriberCollection subscriber : subscribers) {
                        System.out.println(subscriber);
                        System.out.println("----------------------------");
                    }
                    break;

                case 3:
                    // Сортировка по имени
                    subscribers.sort(Comparator.comparing(TelephoneSubscriberCollection::getFullName));
                    System.out.println("Абоненты отсортированы по имени.");
                    break;

                case 4:
                    // Сортировка по количеству минут
                    subscribers.sort(Comparator.comparingInt(TelephoneSubscriberCollection::getMinutes));
                    System.out.println("Абоненты отсортированы по количеству минут.");
                    break;

                case 0:
                    // Выход из программы
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("----------------------------");
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    System.out.println("----------------------------");
            }
        }
    }
}
