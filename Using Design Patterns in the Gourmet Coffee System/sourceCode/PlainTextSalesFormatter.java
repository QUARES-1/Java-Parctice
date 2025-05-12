public class PlainTextSalesFormatter implements SalesFormatter
{
    static PlainTextSalesFormatter singletonInstance = new PlainTextSalesFormatter();

    static public PlainTextSalesFormatter getSingletonInstance(){
        return singletonInstance;
    }

    private PlainTextSalesFormatter(){

    }

    public String formatSales(Sales sales){
        int numberOfOrders = 1;

        String formatSalesString = "";
        String NEW_LINE = System.getProperty("line.separator");

        for(Order order : sales) {
            formatSalesString += "------------------------" + NEW_LINE;
            formatSalesString += "Order " + numberOfOrders + NEW_LINE + NEW_LINE;

            for(OrderItem item : order) formatSalesString += item.toString() + NEW_LINE;
            formatSalesString += NEW_LINE;
            formatSalesString += "Total " + order.getTotalCost() + NEW_LINE;
            numberOfOrders++;
        }
        return formatSalesString;
    }
}
