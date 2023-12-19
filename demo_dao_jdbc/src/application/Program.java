package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		//Com isso não expomos a implementação somente a interface
		
		System.out.println("=== TEST 1: seller findById  ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}
}