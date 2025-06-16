//Create a program to calculate the profit and loss in number and percentage based on the cost price of INR 129 and the selling price of INR 191.
public class Question7 {
    public static void main(String[] args) {
        double costPrice = 129, sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;

        System.out.println("The Cost Price is INR " + costPrice +
                " and the Selling Price is INR " + sellingPrice +
                "\nThe Profit is INR " + profit +
                " and the Profit Percentage is " + profitPercent + "%");
    }
}
