package com.wlopera.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wlopera.connection.ConnectionDataSource;
import com.wlopera.model.Product;

public class ProductDaoImpl implements ProductDAO {
	protected ConnectionDataSource connectionDataSource;
	
	public ProductDaoImpl() {
		connectionDataSource = new ConnectionDataSource();
	}
	
	/**
	 * Crear producto en Base de Datos (BD)
	 * @param product Producto a generar
	 * @return true/false
	 */
	public boolean createProduct(Product product) throws Exception{
		String sql="INSERT INTO product (nombre, cantidad) values ('"+product.getName()+"','"+product.getQuantity()+"')";
		return processQuery(sql);
	}

	/**
	 * Modificar producto en BD
	 * @param product Producto a modificar
	 * @return true/false
	 */
	public boolean updateProduct(Product product) throws Exception {
		String sql="UPDATE product SET nombre='"+product.getName()+"', cantidad='"+product.getQuantity()+"'" +" WHERE id="+product.getId();
		return processQuery(sql);
	}

	/**
	 * Borrar producto en BD
	 * @param idProduct: Identificador del producto a eliminar
	 * @return true/false
	 */
	public boolean deleteProduct(Integer idProduct) throws Exception {
		String sql="DELETE FROM product WHERE id="+idProduct;		
		return processQuery(sql);
	}

	/**
	 * Consultar todos los productos de BD
	 * @return Lista de productos
	 */
	public List<Product> readALLProduct() throws Exception{
		return readProduct("SELECT * FROM product ORDER BY id");		
	}

	/**
	 * Consultar todos los productos de BD
	 * @param idProduct: Identificador del producto a consultar
	 * @return Lista de productos
	 */
	public Product readProductById(Integer idProduct) throws Exception {
		List<Product> products =  readProduct("SELECT * FROM product WHERE id = " + idProduct);
		return products.get(0);
	}

	// Procesar create-update-delete 
	private boolean processQuery(String sql) throws Exception {
		Connection connect= null;
		Statement stm= null;
				
		try {
			connect=connectionDataSource.getConnection();
			stm = connect.createStatement();
			stm.execute(sql);
			return true;
		} catch (Exception e) {
			System.out.println("Error: Clase processQuery, transaccion base de datos");
			e.printStackTrace();
			throw e;
		} finally { 
		   try {
		      if (null != connect) {
				  stm.close();
		    	  connect.close();
		      }
		   } catch (Exception e) {
			  System.out.println("Error: Cerrado conexion de base de datos");
		      e.printStackTrace();
		   }
		}	
	}
	
	// Permite la consulta de productos de base de datos
	private List<Product> readProduct(String sql) throws Exception {
		Connection connect =null;
		Statement stm= null;
		ResultSet rs=null;
		
		List<Product> products= new ArrayList<Product>();
		
		try {			
			connect= connectionDataSource.getConnection();
			stm=connect.createStatement();
			rs=stm.executeQuery(sql);
			Product product;
			while (rs.next()) {
				product =new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getFloat(3));
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println("Error: Clase readProduct, método consultar todos productos");
			e.printStackTrace();
		} finally { 
		   try {
		      if (null != connect) {
					stm.close();
					rs.close();
					connect.close();
		      }
		   } catch (Exception e) {
			   System.out.println("Error: Cerrado conexion de base de datos");
		      e.printStackTrace();
		   }
		}	
		
		return products;
	}
	
}
