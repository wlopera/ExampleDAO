import java.util.List;

import com.wlopera.model.Product;
import com.wlopera.service.ProductService;
import com.wlopera.service.ProductServiceImpl;

public class TestApp {

	public static void main(String[] arg) {
		new TestApp().run();
	}

	public void run() {
		
		try {
			ProductService service = new ProductServiceImpl();
			
			// Test create Product
			Product product = new Product("Ajo", 150.00);
			service.createProduct(product);
			
			// test Consultar productos
			List<Product> products = service.readALLProduct();
			for(Product productActual : products) {
				System.out.println("Producto: " +  productActual.toString());	
			}
			
			// Obtener el max y/o ultimo registro generado
			Integer max = getMaxProduct(products);
			
			// test Consultar ultimo producto x ID gnerado
			System.out.println("Consulta producto pod ID-> " + max + ": " + service.readProductById(max).toString());
			
			// Borrar ultimo registro generado
			service.deleteProduct(max);
			
			System.out.println("Producto creado satisfactoriamente");
			
		} catch (Exception e) {
			System.out.println("Error: procesando base de datos: " + e.getMessage());
		}

	}

	// Permite obtener el maximo identificador
	private Integer getMaxProduct(List<Product> products) {
		Integer max = 0;
		for (Product product : products) {
			if (max < product.getId()) {
				max = product.getId();
			}
		}
		return max;
	}

}
