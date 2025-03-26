package HDT7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductBSTTest {

    @Test
    public void testInsert() {
        ProductBST productBST = new ProductBST();
        Product product = new Product("5001252387", 999.00, 999.00,
                "17.2-cu ft Counter-depth Bottom-Freezer Refrigerator", "Refrigerators");
        productBST.insert(product); // Insertar directamente
        Product found = productBST.findBestPriceBySKU("5001252387");
        assertNotNull(found);
        assertEquals("5001252387", found.getSku());
    }

    @Test
    public void testSearchBySKU() {
        ProductBST productBST = new ProductBST();
        Product product = new Product("5001252387", 999.00, 999.00,
                "17.2-cu ft Counter-depth Bottom-Freezer Refrigerator", "Refrigerators");
        productBST.insert(product); // Insertar directamente
        Product found = productBST.findBestPriceBySKU("5001252387");
        assertNotNull(found);
        assertEquals("Refrigerators", found.getCategory());
        assertEquals(999.00, found.getPriceCurrent());

        Product notFound = productBST.findBestPriceBySKU("0000000000");
        assertNull(notFound);
    }
}