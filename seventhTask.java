import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
}

public class seventhTask {
    public static void main(String[] args) {
        PaymentList paymentList = new PaymentList();

        paymentList.addPayment(new InternationalCalls("Антонов", "Кирилл", "Вернедубович", "ул. Алексеевская, д. 23", "Москва", "1234567890",
                "Китай", "Тайбэй", 10, 5.0, 10, 2021));
        paymentList.addPayment(new CityCalls("Данателло", "Борис", "Черепашкович", "ул. Канализационная, д. 0", "Санкт-Петербург", "0987654321",
                "Стандарт", 15, 30.0, 10, 2022));
        paymentList.addPayment(new InternetConnection("Киркоров", "Филипп", "Королев", "ул. Звездная, д. 3", "Самара", "1122334455",
                "Оптоволокно", 100.0, 500.0, 10, 2024));

        System.out.println("Список абонентских оплат (по фамилии):");
        paymentList.sortByLastName();
        paymentList.printPayments();

        System.out.println("\nСписок абонентских оплат (по сумме оплаты):");
        paymentList.sortByTotalPayment();
        paymentList.printPayments();
    }


}
