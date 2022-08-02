public class SalesManager {
    protected long[] sales; // массив продаж

    public SalesManager(long[] sales) { //конструктор менеджера по продажам
        this.sales = sales;
    }

    public long max() {
        long max = -1;
        for (long sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }
    //Добавьте расчёт обрезанного среднего - это среднее количество продаж среди всех продаж,
    //за исключением самой максимальной и самой минимальной.
    public int average() {
        long max = sales[0]; // максимальное значание
        long min = sales[0]; // минимальное значание
        long avarage = 0; // среднее значание
        for (int i = 0; i < sales.length; i++) {
            avarage = avarage + sales[i];
            if (sales[i] > max) { // ищем максимальное значание
                max = sales[i]; // записываем максимальное значение
            }
            if (sales[i] < min) { // ищем минимальное значание
                min = sales[i]; // записываем минимальное значание
            }
        }
        return (int) ((avarage - max - min) / (sales.length - 2));
    }
}