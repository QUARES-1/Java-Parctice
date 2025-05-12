import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class XMLSalesFormatter implements SalesFormatter {
    static XMLSalesFormatter singletonInstance = new XMLSalesFormatter();

    static public XMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private XMLSalesFormatter() {

    }

    public String formatSales(Sales sales) {
        String XMLSalesString = "";
        String NEWLINE = System.getProperty("line.separator");
        XMLSalesString += "<Sales>" + NEWLINE;
        for (Order order : sales) {
            XMLSalesString += "  <Order total =\"" + order.getTotalCost() + "\">" + NEWLINE;
            for (OrderItem item : order) {
                XMLSalesString += "    <OrderItem Quantity=\"" + item.getQuantity() + "\"" +
                        "price=\"" + item.getProduct().getPrice() + "\">" +
                        item.getProduct().getCode() + "</OrderItem>" + NEWLINE;
            }
            XMLSalesString += "  </Order>" + NEWLINE;
        }
        XMLSalesString += "</Sales>" + NEWLINE;
        return XMLSalesString;
    }
}

