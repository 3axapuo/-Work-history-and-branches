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
}