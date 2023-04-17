// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2. Создать множество ноутбуков.
// 3. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ex_1 {
    public static void main(String[] args) {

        Notebook n1 = new Notebook("Apple", 16, 512, "MacOs", "silver");
        Notebook n2 = new Notebook("Dell", 8, 256, "Windows", "black");
        Notebook n3 = new Notebook("Asus", 4, 128, "Linux", "white");
        Notebook n4 = new Notebook("Lenovo", 8, 512, "Windows", "black");
        Notebook n5 = new Notebook("Apple", 32, 1024, "MacOs", "silver");
        ArrayList<Notebook> list = new ArrayList<>(Arrays.asList(n1, n2, n3, n4, n5));

        choiseNotebook(list, filter());
    }

    public static HashMap<String, Object> filter() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Object> custom = new HashMap<String, Object>();
        custom.put("ram", 0);
        custom.put("hdd", 0);
        custom.put("os", "");
        custom.put("color", "");
        System.out.println("\nПриступаем к подбору оптимальной модели ноутбука");
        while (true) {
            System.out.println("\n1. Объем RAM");
            System.out.println("2. Объем HDD");
            System.out.println("3. OS");
            System.out.println("4. Цвет");
            System.out.println("0. Завершить подбор и вывести подходящую модель ");
            System.out.println("Введите цифру, соответствующую необходимому критерию: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nВведите минимальный объем RAM: ");
                    int ram = sc.nextInt();
                    custom.put("ram", ram);
                    break;

                case 2:
                    System.out.println("\nВведите минимальный объем HDD: ");
                    int hdd = sc.nextInt();
                    custom.put("hdd", hdd);
                    break;

                case 3:
                    System.out.println("\nВыберите OS из списка\n");
                    System.out.println("1. Windows");
                    System.out.println("2. Linux");
                    System.out.println("3. MacOs");
                    System.out.println("Введите цифру, соответствующую необходимому критерию: ");
                    int choiceOs = sc.nextInt();
                    switch (choiceOs) {
                        case 1:
                            custom.put("os", "Windows");
                            break;
                        case 2:
                            custom.put("os", "Linux");
                            break;
                        case 3:
                            custom.put("os", "MacOs");
                            break;
                        default:
                            System.out.println("Ошибка выбора");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("\nВыберите цвет из списка\n");
                    System.out.println("1. Серебряный");
                    System.out.println("2. Белый");
                    System.out.println("3. Черный");
                    System.out.println("Введите цифру, соответствующую необходимому критерию: ");
                    int choiceColor = sc.nextInt();
                    switch (choiceColor) {
                        case 1:
                            custom.put("color", "silver");
                            break;
                        case 2:
                            custom.put("color", "white");
                            break;
                        case 3:
                            custom.put("color", "black");
                            break;
                        default:
                            System.out.println("Ошибка выбора");
                            break;
                    }
                    break;

                case 0:
                    sc.close();
                    return custom;

                default:
                    System.out.println("Ошибка выбора");
                    break;
            }

        }

    }

    public static void choiseNotebook(ArrayList<Notebook> list, HashMap<String, Object> filter) {
        ArrayList<Notebook> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRam() >= (Integer) filter.get("ram") &&
                    list.get(i).getHdd() >= (Integer) filter.get("hdd") &&
                    (list.get(i).getOs().equals((String) filter.get("os"))
                            || filter.get("os").equals(""))
                    &&
                    (list.get(i).getColor().equals((String) filter.get("color"))
                            || filter.get("color").equals(""))) {
                result.add(list.get(i));
            }
        }
        if (result.size() == 0)
            System.out.println("Ноутбук под ваши параметры не найден.");
        else {
            System.out.println("\nПод ваши параметры подойдут следующие ноутбуки:");
            for (int index = 0; index < result.size(); index++) {
                System.out.println(result.get(index));
            }
        }

    }
}