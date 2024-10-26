import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class AbonentPayment implements Comparable<AbonentPayment> {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String city;
    private String passportData;

    public AbonentPayment(String lastName, String firstName, String patronymic, String address, String city, String passportData) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.city = city;
        this.passportData = passportData;
    }


    public String getLastName() {
        return lastName;
    }

    public String toCSV() {
        return lastName + "," + firstName + "," + patronymic + "," + address + "," + city + "," + passportData;
    }

    public static AbonentPayment fromCSV(String csv) {
        String[] fields = csv.split(",");
        return new AbonentPayment(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
    }

    @Override
    public String toString() {
        return "Абонент: " + lastName + " " + firstName + " " + patronymic + ", Адрес: " + address + ", Город: " + city + ", Паспорт: " + passportData;
    }

    @Override
    public int compareTo(AbonentPayment other) {
        return this.lastName.compareTo(other.lastName);
    }
}

class InternationalCalls extends AbonentPayment {
    private String country;
    private String cityCall;
    private int durationMinutes;
    private double price;
    private double totalPayment;
    private int month;
    private int year;

    public InternationalCalls(String lastName, String firstName, String patronymic, String address, String city, String passportData,
                              String country, String cityCall, int durationMinutes, double price, int month, int year) {
        super(lastName, firstName, patronymic, address, city, passportData);
        this.country = country;
        this.cityCall = cityCall;
        this.durationMinutes = durationMinutes;
        this.price = price;
        this.totalPayment = durationMinutes * price;
        this.month = month;
        this.year = year;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public String toCSV() {
        return super.toCSV() + "," + country + "," + cityCall + "," + durationMinutes + "," + price + "," + totalPayment + "," + month + "," + year;
    }

    public static InternationalCalls fromCSV(String csv) {
        String[] fields = csv.split(",");
        return new InternationalCalls(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                fields[6], fields[7], Integer.parseInt(fields[8]), Double.parseDouble(fields[9]),
                Integer.parseInt(fields[10]), Integer.parseInt(fields[11]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Международные звонки: Страна: " + country + ", Город: " + cityCall +
                ", Длительность: " + durationMinutes + " мин, Цена: " + price + ", Сумма: " + totalPayment +
                ", Месяц: " + month + ", Год: " + year;
    }
}

class CityCalls extends AbonentPayment {
    private String tariff;
    private int durationMinutes;
    private double totalPayment;
    private int month;
    private int year;

    public CityCalls(String lastName, String firstName, String patronymic, String address, String city, String passportData,
                     String tariff, int durationMinutes, double totalPayment, int month, int year) {
        super(lastName, firstName, patronymic, address, city, passportData);
        this.tariff = tariff;
        this.durationMinutes = durationMinutes;
        this.totalPayment = totalPayment;
        this.month = month;
        this.year = year;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public String toCSV() {
        return super.toCSV() + "," + tariff + "," + durationMinutes + "," + totalPayment + "," + month + "," + year;
    }

    public static CityCalls fromCSV(String csv) {
        String[] fields = csv.split(",");
        return new CityCalls(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                fields[6], Integer.parseInt(fields[7]), Double.parseDouble(fields[8]),
                Integer.parseInt(fields[9]), Integer.parseInt(fields[10]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Городские звонки: Тариф: " + tariff + ", Длительность: " + durationMinutes +
                " мин, Сумма: " + totalPayment + ", Месяц: " + month + ", Год: " + year;
    }
}

class InternetConnection extends AbonentPayment {
    private String connectionName;
    private double volumeProvided;
    private double totalPayment;
    private int month;
    private int year;

    public InternetConnection(String lastName, String firstName, String patronymic, String address, String city, String passportData,
                              String connectionName, double volumeProvided, double totalPayment, int month, int year) {
        super(lastName, firstName, patronymic, address, city, passportData);
        this.connectionName = connectionName;
        this.volumeProvided = volumeProvided;
        this.totalPayment = totalPayment;
        this.month = month;
        this.year = year;
    }


    public double getTotalPayment() {
        return totalPayment;
    }

    public String toCSV() {
        return super.toCSV() + "," + connectionName + "," + volumeProvided + "," + totalPayment + "," + month + "," + year;
    }

    public static InternetConnection fromCSV(String csv) {
        String[] fields = csv.split(",");
        return new InternetConnection(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
                fields[6], Double.parseDouble(fields[7]), Double.parseDouble(fields[8]),
                Integer.parseInt(fields[9]), Integer.parseInt(fields[10]));
    }

    @Override
    public String toString() {
        return super.toString() + ", Подключение к интернету: Название: " + connectionName + ", Объем: " + volumeProvided +
                " ГБ, Сумма: " + totalPayment + ", Месяц: " + month + ", Год: " + year;
    }
}

class PaymentList {
    private List<AbonentPayment> payments;

    public PaymentList() {
        payments = new ArrayList<>();
    }

    public void addPayment(AbonentPayment payment) {
        payments.add(payment);
    }

    public void printPayments() {
        for (AbonentPayment payment : payments) {
            System.out.println(payment);
        }
    }

    public void sortByLastName() {
        Collections.sort(payments);
    }

    public void sortByTotalPayment() {
        payments.sort(Comparator.comparingDouble(payment -> {
            if (payment instanceof InternationalCalls) {
                return ((InternationalCalls) payment).getTotalPayment();
            } else if (payment instanceof CityCalls) {
                return ((CityCalls) payment).getTotalPayment();
            } else if (payment instanceof InternetConnection) {
                return ((InternetConnection) payment).getTotalPayment();
            }
            return 0;
        }));
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (AbonentPayment payment : payments) {
                writer.write(payment.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            payments.clear(); // Очистить список перед загрузкой
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0) {
                    AbonentPayment payment;
                    if (fields.length == 12) {
                        payment = InternationalCalls.fromCSV(line);
                    } else if (fields.length == 11) {
                        payment = CityCalls.fromCSV(line);
                    } else if (fields.length == 10) {
                        payment = InternetConnection.fromCSV(line);
                    } else {
                        continue; // Пропустить некорректные строки
                    }
                    payments.add(payment);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class eighthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentList paymentList = new PaymentList();
        boolean running = true;

        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить абонента");
            System.out.println("2. Показать абонентов");
            System.out.println("3. Сортировать по фамилии");
            System.out.println("4. Сортировать по сумме оплаты");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Загрузить из файла");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний символ

            switch (choice) {
                case 1:
                    System.out.print("Введите тип абонента (1 - Международные, 2 - Городские, 3 - Интернет): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Считываем лишний символ
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите отчество: ");
                    String patronymic = scanner.nextLine();
                    System.out.print("Введите адрес: ");
                    String address = scanner.nextLine();
                    System.out.print("Введите город: ");
                    String city = scanner.nextLine();
                    System.out.print("Введите паспортные данные: ");
                    String passportData = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Введите страну: ");
                        String country = scanner.nextLine();
                        System.out.print("Введите город: ");
                        String cityCall = scanner.nextLine();
                        System.out.print("Введите длительность (мин): ");
                        int durationMinutes = scanner.nextInt();
                        System.out.print("Введите цену за минуту: ");
                        double price = scanner.nextDouble();
                        System.out.print("Введите месяц: ");
                        int month = scanner.nextInt();
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        paymentList.addPayment(new InternationalCalls(lastName, firstName, patronymic, address, city, passportData,
                                country, cityCall, durationMinutes, price, month, year));
                    } else if (type == 2) {
                        System.out.print("Введите тариф: ");
                        String tariff = scanner.nextLine();
                        System.out.print("Введите длительность (мин): ");
                        int durationMinutes = scanner.nextInt();
                        System.out.print("Введите сумму: ");
                        double totalPayment = scanner.nextDouble();
                        System.out.print("Введите месяц: ");
                        int month = scanner.nextInt();
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        paymentList.addPayment(new CityCalls(lastName, firstName, patronymic, address, city, passportData,
                                tariff, durationMinutes, totalPayment, month, year));
                    } else if (type == 3) {
                        System.out.print("Введите название подключения: ");
                        String connectionName = scanner.nextLine();
                        System.out.print("Введите объем (ГБ): ");
                        double volumeProvided = scanner.nextDouble();
                        System.out.print("Введите сумму: ");
                        double totalPayment = scanner.nextDouble();
                        System.out.print("Введите месяц: ");
                        int month = scanner.nextInt();
                        System.out.print("Введите год: ");
                        int year = scanner.nextInt();
                        paymentList.addPayment(new InternetConnection(lastName, firstName, patronymic, address, city, passportData,
                                connectionName, volumeProvided, totalPayment, month, year));
                    }
                    break;

                case 2:
                    paymentList.printPayments();
                    break;

                case 3:
                    paymentList.sortByLastName();
                    System.out.println("Список отсортирован по фамилии.");
                    break;

                case 4:
                    paymentList.sortByTotalPayment();
                    System.out.println("Список отсортирован по сумме оплаты.");
                    break;

                case 5:
                    System.out.print("Введите имя файла для сохранения: ");
                    String saveFileName = scanner.nextLine();
                    paymentList.saveToFile(saveFileName);
                    System.out.println("Данные сохранены в файл " + saveFileName);
                    break;

                case 6:
                    System.out.print("Введите имя файла для загрузки: ");
                    String loadFileName = scanner.nextLine();
                    paymentList.loadFromFile(loadFileName);
                    System.out.println("Данные загружены из файла " + loadFileName);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
