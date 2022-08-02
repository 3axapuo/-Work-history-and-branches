import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Хлеб", "Яблоки", "Молоко"}; // создание массива продукты.
        String[] addBasket; // добавить в корзину
        int[] mainBasket = new int[products.length]; // количество продуктов = список продуктов
        int[] prices = {100, 200, 300}; // создание массива цен.
        int sumProducts = 0; // итоговая суммы чека

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 1; i < products.length + 1; i++) { // Выводим список товаров и их цены.
            System.out.println(i + ". " + products[i - 1] + " " + prices[i - 1] + "руб/шт.");
        }
        while (true) {
            System.out.println("Выберите товар и количество или введите `end` ");
            String input = scanner.nextLine();
            if ("end".equals(input)) break; // выходим в случае набора текста end
            addBasket = input.split(" "); // создаем массив, кладем туда строки раздельно до и после пробела
            if (Integer.parseInt(addBasket[0]) > (products.length)) { // если выбранный товар больше списка товаров то
                System.out.println("Такого товара не существует!");
            } else {
                mainBasket[(Integer.parseInt(addBasket[0]) - 1)] += Integer.parseInt(addBasket[1]); // записываем в массив выбранный товар
            }
        }

        System.out.println("Ваша корзина составляет: ");
        for (int i = 1; i < products.length + 1; i++) { // Выводим список выбранных товаров и их цены.
            if (mainBasket[i - 1] != 0) {
                System.out.println(i + ". " + products[i - 1] + " - " + mainBasket[i - 1] + "шт., по " +
                        prices[i - 1] + "руб/шт., на общую сумму: " + (mainBasket[i - 1] * prices[i - 1]));
            }
            sumProducts += mainBasket[i - 1] * prices[i - 1]; //общая сумма, выбранный товар умножаем на цену
        }
        System.out.println("Итого: " + sumProducts);
        scanner.close();

        // ДЕМОНСТРАЦИЯ работы класса SalesManager
        SalesManager salesManager = new SalesManager(Arrays.stream(mainBasket.clone()).asLongStream().toArray()); // клонируем набранную корзину, ghb массив с int в long
        System.out.println("Максимальное количество проданного одного товара в корзине " + salesManager.max());
    }
} // class Main

