package lab_3;

import java.util.*;
public class ArraySumAndTreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Просимо у користувача ввести розмір масиву
        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();

        // Користувач вводить елементи масива заданого раніше
        int[] arr = new int[n];
        System.out.print("Введіть елемент масиву: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Рахуємо суму елементів масиву
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("Сума масиву: " + sum);

        // Створюємо TreeMap для масиву
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(i, arr[i]);
        }

        // Додаємо ключ пару на мапу
        treeMap.put(n, sum);
        System.out.println("Додаємо ключ пару на мапу: " + n + " -> " + sum);

        // Видаляємо ключ пару з мапи
        int removeKey = 2;
        int removedValue = treeMap.remove(removeKey);
        System.out.println("Видаляємо ключ пару з мапи: " + removeKey + " -> " + removedValue);

        // Перевіряємо наявність ключа пари на мапі
        int checkKey = 1;
        boolean containsKey = treeMap.containsKey(checkKey);
        System.out.println("Map має ключ " + checkKey + ": " + containsKey);

        // Шукаємо значення, пов’язане з заданим ключем
        int findKey = 3;
        int value = treeMap.get(findKey);
        System.out.println("Значення повязане з ключем " + findKey + ": " + value);

        // Виводимо всі ключі та значення на мапі
        System.out.println("Усі ключі та значення на мапі: ");
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Створення ситуації для NullPointerException і її обробка
        try {
            String str = null;
            System.out.println("Довжина рядка: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Перехоплено NullPointerException: " + e.getMessage());
            System.out.println("У цьому коді ми зробили змінну рядка str рівну null, а потім намагалися викликати метод length() на цій змінній, що викликає помилку NullPointerException. NullPointerException виникає, коли намагаємося викликати метод на змінній, яка має значення null");
        }
    }
}
