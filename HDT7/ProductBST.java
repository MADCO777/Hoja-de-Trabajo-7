package HDT7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que maneja un árbol binario de búsqueda para productos.
 */
public class ProductBST {
    private BinarySearchTree<Product> bst;

    /**
     * Crea un nuevo árbol para guardar productos.
     */
    public ProductBST() {
        this.bst = new BinarySearchTree<>();
    }

    /**
     * Carga productos desde un archivo CSV al árbol.
     * @param filePath la ruta del archivo CSV
     */
    public void loadFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) { // Revisar que haya datos suficientes
                    String category = data[0];
                    String sku = data[6];
                    double priceRetail = Double.parseDouble(data[9].isEmpty() ? "0" : data[9]);
                    double priceCurrent = Double.parseDouble(data[10].isEmpty() ? "0" : data[10]);
                    String productName = data[19];
                    Product product = new Product(sku, priceRetail, priceCurrent, productName, category);
                    bst.insert(product); // Meter el producto al árbol
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Mostrar error si algo falla
        }
    }

    /**
     * Agrega un producto al árbol.
     * @param product el producto a guardar
     */
    public void insert(Product product) {
        bst.insert(product); // Solo lo pasa al árbol
    }

    /**
     * Busca un producto por su SKU en el árbol.
     * <p>
     * Este metodo es el corazón del programa porque usa el BST para encontrar rápido un producto.
     * Crea un producto temporal con el SKU dado y lo busca en el árbol. Si lo encuentra,
     * devuelve el producto completo con todos sus datos.
     * </p>
     * @param sku el SKU del producto a buscar
     * @return el producto encontrado o null si no está
     */
    public Product findBestPriceBySKU(String sku) {
        // Hacer un producto falso solo con el SKU para buscar
        Product dummyProduct = new Product(sku, 0, 0, "", "");
        // Buscar en el árbol y devolver lo que encuentre
        return bst.search(dummyProduct);
    }
}