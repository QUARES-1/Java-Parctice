import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader
{
    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");

        if (tokenizer.countTokens() != 4) throw new DataFormatException(line);

        try{
            String type = tokenizer.nextToken();
            return new Product(tokenizer.nextToken(), tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken()));
        }
        catch (NumberFormatException e){
            throw new DataFormatException(line);
        }
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");

        if (tokenizer.countTokens() != 10) throw new DataFormatException(line);

        try {
            String type = tokenizer.nextToken();
            return new Coffee(tokenizer.nextToken(), tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
        }
        catch (NumberFormatException e){
            throw new DataFormatException(line);
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer tokenizer = new StringTokenizer(line, "_");

        if (tokenizer.countTokens() != 7) throw new DataFormatException(line);

        try {
            String type = tokenizer.nextToken();
            return new CoffeeBrewer(tokenizer.nextToken(), tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
        }
        catch (NumberFormatException e){
            throw new DataFormatException(line);
        }
    }

    public Catalog loadCatalog(String filename) throws FileNotFoundException, DataFormatException, IOException {
        if(!new java.io.File(filename).exists()) throw new FileNotFoundException(filename);
        try( BufferedReader reader = new BufferedReader(new FileReader(filename)); )
        {
            String line = reader.readLine();
            Catalog catalog = new Catalog();
            while(line != null){
                if (line.startsWith("Product")) catalog.addProduct(readProduct(line));
                else if(line.startsWith("Coffee")) catalog.addProduct(readCoffee(line));
                else if(line.startsWith("Brewer")) catalog.addProduct(readCoffeeBrewer(line));
                else throw new DataFormatException(line);
                line = reader.readLine();
            }
            return catalog;
        }
    }
}
