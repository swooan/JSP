package org.comstudy21.model;

import java.util.ArrayList;

public class ShopDao {

	private static ArrayList<Product> pList = new ArrayList<>();
	static { 
		pList.add(new Product(1, "Sonata", 2500));
		pList.add(new Product(2, "Grandeur", 3800));
		pList.add(new Product(3, "SM6", 4000));
		pList.add(new Product(4, "K7", 4200));
		pList.add(new Product(5, "520d", 5300));
		pList.add(new Product(6, "E500", 5500));
		pList.add(new Product(7, "A5", 5000));
	}
	
	public ArrayList<Product> selectAll() {
		return pList;
	}
	
	public Product selectByIdx(Product dto) {
		int idx = pList.indexOf(dto);
		if(idx != -1) {
			return pList.get(idx);
		}
		else {
			return null;
		}
	}
	
	public static void test(String[] args) {
		ShopDao dao = new ShopDao();
		Product p = dao.selectByIdx(new Product(2, null, 0));
		System.out.println(p);
	}
	
}
