package lab_4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // обмеження на 2 потоки

        CustomClass customObject = new CustomClass("Tymur", 123, true);
        System.out.println("Дані перед зміною: " + customObject);

        // Використання Семафору для доступу до спільного ресурсу
        try {
            semaphore.acquire(); // забрати доступ
            changeFieldValue(customObject, "stringField", "Nadzhafov");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // повернути доступ
        }

        System.out.println("Дані після зміни: " + customObject);

        callMethod(customObject, new CustomInterface() {
            @Override
            public void customMethod() {
                System.out.println("Виклик методу з інтерфейсу");
            }
        });
    }

    private static void changeFieldValue(Object object, String fieldName, Object newValue) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void callMethod(Object object, CustomInterface customInterface) {
        try {
            Method method = customInterface.getClass().getMethod("customMethod");
            method.invoke(customInterface);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    interface CustomInterface {
        void customMethod();
    }

    static class CustomClass {
        private String stringField;
        private int intField;
        private boolean boolField;

        public CustomClass(String stringField, int intField, boolean boolField) {
            this.stringField = stringField;
            this.intField = intField;
            this.boolField = boolField;
        }

        @Override
        public String toString() {
            return "CustomClass{" +
                    "stringField='" + stringField + '\'' +
                    ", intField=" + intField +
                    ", boolField=" + boolField +
                    '}';
        }
    }
}
