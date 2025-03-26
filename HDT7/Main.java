package HDT7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductBST productBST = new ProductBST();
        String csvFilePath = "path/to/your/csv/file.csv"; // Reemplaza con la ruta de tu archivo CSV
        productBST.loadFromCSV(csvFilePath);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el SKU del producto a buscar:");
        String sku = scanner.nextLine();

        Product product = productBST.findBestPriceBySKU(sku);
        if (product != null) {
            System.out.println("Producto encontrado:");
            System.out.println("SKU: " + product.getSku());
            System.out.println("Precio Retail: $" + product.getPriceRetail());
            System.out.println("Precio Actual (mejor precio): $" + product.getPriceCurrent());
            System.out.println("Nombre del Producto: " + product.getProductName());
            System.out.println("Categoría: " + product.getCategory());
        } else {
            System.out.println("No se encontró un producto con el SKU: " + sku);
        }
        scanner.close();
    }
}