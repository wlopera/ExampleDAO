package com.wlopera.service;

import java.util.List;

import com.wlopera.dao.ProductDAO;
import com.wlopera.dao.ProductDaoImpl;
import com.wlopera.model.Product;

public class ProductServiceImpl implements ProductService {
	protected ProductDAO productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	/**
	 * Crear producto en Base de Datos (BD)
	 * @param product Producto a generar
	 * @return true/false
	 */
	public boolean createProduct(Product product) throws Exception{
		return productDao.createProduct(product);
	}

	/**
	 * Modificar producto en BD
	 * @param product Producto a modificar
	 * @return true/false
	 */
	public boolean updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}

	/**
	 * Borrar producto en BD
	 * @param idProduct: Identificador del producto a eliminar
	 * @return true/false
	 */
	public boolean deleteProduct(Integer idProduct) throws Exception {
		return productDao.deleteProduct(idProduct);	}

	/**
	 * Consultar todos los productos de BD
	 * @return Lista de productos
	 */
	public List<Product> readALLProduct() throws Exception {
		return productDao.readALLProduct();
	}

	/**
	 * Consultar todos los productos de BD
	 * @param idProduct: Identificador del producto a consultar
	 * @return Lista de productos
	 */
	public Product readProductById(Integer idProduct) throws Exception {
		return productDao.readProductById(idProduct);
	}

}
