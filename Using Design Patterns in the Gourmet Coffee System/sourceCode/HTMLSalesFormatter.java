public class HTMLSalesFormatter implements SalesFormatter
{
    static HTMLSalesFormatter singletonInstance = new HTMLSalesFormatter();

    static public HTMLSalesFormatter getSingletonInstance(){
        return singletonInstance = new HTMLSalesFormatter();
    }

    private HTMLSalesFormatter(){

    }

    public String formatSales(Sales sales){
        String formatSalesString = "";
        String NEWLINE = System.getProperty("line.separator");
        formatSalesString += "<html>" + NEWLINE +
                "  <body>" + NEWLINE +
                "    <center><h2>Orders<>h2></center>" + NEWLINE;
        for(Order order : sales){
            formatSalesString += "    <hr>" + NEWLINE +
                    "    <h4>Total = " + order.getTotalCost() + "</h4>" + NEWLINE;
            for(OrderItem item : order) formatSalesString += "      <p>" + NEWLINE +
                    "        <b>code:</b> " + item.getProduct().getCode() + "<br>" + NEWLINE +
                    "        <b>quality:</b> " + item.getQuantity() + "<br>" + NEWLINE +
                    "        <b>price:</b> " + item.getValue() + "<br>" + NEWLINE +
                    "      </p>" + NEWLINE;
        }
        formatSalesString += "  </body>" + NEWLINE +
                "</html>";
        return formatSalesString;
    }
}
