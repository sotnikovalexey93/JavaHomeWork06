// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.

// Создать множество ноутбуков.

// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:

// 1 - ОЗУ

// 2 - Объём ЖД

// 3 - Операционная система

// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// =============================================================================================================

// Поля класса "Ноутбук":

// производитель (manufacturer)
// модель (model)
// цена (price)
// объём оперативной памяти (ram)
// объём жесткого диска (hdd)
// операционная система (os)
// цвет (color)
// диагональ (screenSize)
// Методы класса "Ноутбук":

// конструктор с параметрами, инициализирующий поля класса
// геттеры и сеттеры для всех полей класса
// toString(), возвращающий строковое представление объекта класса
// Реализация в Java:

import java.util.ArrayList; import java.util.HashMap; import java.util.List; import java.util.Map; import java.util.Scanner;

public class Laptop { private String manufacturer; private String model; private double price; private int ram; private int hdd; private String os; private String color; private double screenSize;

public Laptop(String manufacturer, String model, double price, int ram, int hdd, String os, String color, double screenSize) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.price = price;
    this.ram = ram;
    this.hdd = hdd;
    this.os = os;
    this.color = color;
    this.screenSize = screenSize;
}

public String getManufacturer() {
    return manufacturer;
}

public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
}

public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

public int getRam() {
    return ram;
}

public void setRam(int ram) {
    this.ram = ram;
}

public int getHdd() {
    return hdd;
}

public void setHdd(int hdd) {
    this.hdd = hdd;
}

public String getOs() {
    return os;
}

public void setOs(String os) {
    this.os = os;
}

public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}

public double getScreenSize() {
    return screenSize;
}

public void setScreenSize(double screenSize) {
    this.screenSize = screenSize;
}

@Override
public String toString() {
    return "Manufacturer: " + manufacturer + "\n" +
           "Model: " + model + "\n" +
           "Price: " + price + " USD\n" +
           "RAM: " + ram + " GB\n" +
           "HDD: " + hdd + " GB\n" +
           "Operating System: " + os + "\n" +
           "Color: " + color + "\n" +
           "Screen Size: " + screenSize + " inches\n";
}

public static void main(String[] args) {
    List<Laptop> laptops = new ArrayList<>();
    laptops.add(new Laptop("Dell", "Inspiron 15", 700.0, 8, 1000, "Windows 10", "Black", 15.6));
    laptops.add(new Laptop("HP", "Pavilion 14", 800.0, 16, 512, "Windows 10", "Silver", 14.0));
    laptops.add(new Laptop("Apple", "Macbook Pro", 1200.0, 16, 512, "macOS", "Space Gray", 13.3));
    laptops.add(new Laptop("Asus", "Vivobook S15", 600.0, 12, 256, "Windows 10", "Gold", 15.6));

    Scanner scanner = new Scanner(System.in);
    Map<String, Object> filters = new HashMap<>();

    System.out.println("Please choose the filters you want to apply:");
    System.out.println("1 - RAM");
    System.out.println("2 - HDD");
    System.out.println("3 - Operating System");
    System.out.println("4 - Color");
    System.out.print("Choice: ");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            System.out.print("Minimum RAM: ");
            int minRam = scanner.nextInt();
            filters.put("Ram", minRam);
            laptops = filterByRam(laptops, minRam);
            break;
        case 2:
            System.out.print("Minimum HDD: ");
            int minHdd = scanner.nextInt();
            filters.put("Hdd", minHdd);
            laptops = filterByHdd(laptops, minHdd);
            break;
        case 3:
            System.out.print("Operating System: ");
            String os = scanner.next();
            filters.put("Os", os);
            laptops = filterByOs(laptops, os);
            break;
        case 4:
            System.out.print("Color: ");
            String color = scanner.next();
            filters.put("Color", color);
            laptops = filterByColor(laptops, color);
            break;
        default:
            System.out.println("Invalid choice");
            return;
    }

    System.out.println("Filtered laptops:");
    for (Laptop laptop : laptops) {
        System.out.print(laptop);
    }

    System.out.println("Filters applied:");
    for (Map.Entry<String, Object> entry : filters.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

private static List<Laptop> filterByRam(List<Laptop> laptops, int minRam) {
    List<Laptop> filteredLaptops = new ArrayList<>();
    for (Laptop laptop : laptops) {
        if (laptop.getRam() >= minRam) {
            filteredLaptops.add(laptop);
        }
    }
    return filteredLaptops;
}

private static List<Laptop> filterByHdd(List<Laptop> laptops, int minHdd) {
    List<Laptop> filteredLaptops = new ArrayList<>();
    for (Laptop laptop : laptops) {
        if (laptop.getHdd() >= minHdd) {
            filteredLaptops.add(laptop);
        }
    }
    return filteredLaptops;
}

private static List<Laptop> filterByOs(List<Laptop> laptops, String os) {
    List<Laptop> filteredLaptops = new ArrayList<>();
    for (Laptop laptop : laptops) {
        if (laptop.getOs().equalsIgnoreCase(os)) {
            filteredLaptops.add(laptop);
        }
    }
    return filteredLaptops;
}

private static List<Laptop> filterByColor(List<Laptop> laptops, String color) {
    List<Laptop> filteredLaptops = new ArrayList<>();
    for (Laptop laptop : laptops) {
        if (laptop.getColor().equalsIgnoreCase(color)) {
            filteredLaptops.add(laptop);
        }
    }
    return filteredLaptops;
}
}