import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null)
        {
            stock.add(item);
        }
        else
        {
            System.out.println("Ese producto ya está en la tienda");
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if (product != null)
        {
            product.increaseQuantity(amount);
        }
        else
        {
            System.out.println("ERROR no existe ningun producto con ese id");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product producto = null;
        int index = 0;
        boolean encontrado = false;
        while(!encontrado && index < stock.size())
        {
            if (stock.get(index).getID()== id)
            {
                producto = stock.get(index);
                encontrado = true;
            }
            index++;
        }
        return producto ;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        int numero = 0;
        if (product != null )
        {
            numero = product.getQuantity();
        }
        return numero;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product producto: stock )
        {
            System.out.println(producto);
        }
    }

    /**
     * Metodo que imprime los detalles de los productos que esta por debajo de un numero que le pasa el usuario
     */
    public void underGivenNumberInStock(int num)
    {
        for (Product producto: stock)
        {
            if (producto.getQuantity() < num)
            {
                System.out.println(producto);
            }
        }
    }

    /**
     * Metodo que permite buscar un producto por el nombre
     */
    public Product findProduct(String name)
    {
        Product producto = null;
        int index = 0;
        boolean encontrado = false;
        while(!encontrado && index < stock.size())
        {
            if (stock.get(index).getName().equals(name))
            {
                producto = stock.get(index);
                encontrado = true;
            }
            index++;
        }
        return producto ;
    }
   
}

