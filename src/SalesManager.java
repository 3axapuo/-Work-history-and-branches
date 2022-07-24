public class SalesManager {
    protected int[] sales; // массив продаж

    public SalesManager(int[] sales) { //конструктор менеджера по продажам
        this.sales = sales;
    }

    public int max() {
        int max = -1;
        for (int sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }
}