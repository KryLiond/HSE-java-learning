 class TelephoneSubscriber {
    // Свойства
    private String fullName;   // ФИО абонента
    private String address;    // Адрес
    private String phoneNumber; // Телефон
    private int month;         // Месяц
    private int year;          // Год
    private int minutes;       // Количество минут
    private double costPerMinute; // Стоимость за минуту

    // Конструктор
    public TelephoneSubscriber(String fullName, String address, String phoneNumber, int month, int year, int minutes, double costPerMinute) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.month = month;
        this.year = year;
        this.minutes = minutes;
        this.costPerMinute = costPerMinute;
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

    // Метод для расчета общей стоимости
    public double calculateTotalCost() {
        return minutes * costPerMinute;
    }

    // Перекрытый метод toString()
    @Override
    public String toString() {
        return String.format("Абонент: %s\nАдрес: %s\nТелефон: %s\nДата: %02d/%d\nКоличество минут: %d\nСтоимость за минуту: %.2f\nОбщая стоимость: %.2f",
                fullName, address, phoneNumber, month, year, minutes, costPerMinute, calculateTotalCost());
    }

    // Правильная сигнатура метода main
    public static void main(String[] args) {
        // Создание объекта абонента
        TelephoneSubscriber subscriber = new TelephoneSubscriber("Иванов Иван Иванович", "г. Москва, ул. Ленина, д. 5", "8-123-456-7890", 10, 2024, 150, 2.5);

        // Вывод полной информации об объекте
        System.out.println(subscriber);
    }
}
