/**
 * Interface: Contrato de persistencia. Modelo CRUD para productos
 *            CRUD: create/read/update/delete
 */
package com.wlopera.service;

import java.util.List;

import com.wlopera.model.Product;

public interface ProductService {

	/**
	 * Crear producto en Base de Datos (BD)
	 * @param product Producto a generar
	 * @return true/false
	 */
	public boolean createProduct(Product product) throws Exception;
	
	/**
	 * Modificar producto en BD
	 * @param product Producto a modificar
	 * @return true/false
	 */
	public boolean updateProduct(Product product) throws Exception;
	
	/**
	 * Borrar producto en BD
	 * @param idProduct: Identificador del producto a eliminar
	 * @return true/false
	 */
	public boolean deleteProduct(Integer idProduct) throws Exception;
	
	/**
	 * Consultar todos los productos de BD
	 * @return Lista de productos
	 */
	public List<Product> readALLProduct() throws Exception;

	/**
	 * Consultar todos los productos de BD
	 * @param idProduct: Identificador del producto a consultar
	 * @return Lista de productos
	 */
	public Product readProductById(Integer idProduct) throws Exception;
	
}
