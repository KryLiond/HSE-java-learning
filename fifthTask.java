  class TelephoneSubscriber  {
    private String fullName;
    private String address;
    private String phoneNumber;
    private int month;
    private int year;
    private int minutes;
    private double costPerMinute;

    public TelephoneSubscriber (String fullName, String address, String phoneNumber, int month, int year) {
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

public class fifthTask {
    public static void main(String[] args) {
        TelephoneSubscriber subscriber = new TelephoneSubscriber("Абобьев Олег Разумовский", "г. Нижние Серги, ул. Победы, д. 33", "8 300 145 21 40", 10, 2024);

        subscriber.setMinutes(100);
        subscriber.setCostPerMinute(1.75);

        System.out.println(subscriber);
    }
}
