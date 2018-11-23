package service;

import java.util.List;

import bin.Easybuy_product;
import bin.Page;

public interface ProductI {
	 public List<Easybuy_product> findAllProduct(Page page);
	 
	 public Easybuy_product findById(int ep_id);
	 //修改
	 public int update(Easybuy_product product);
	 //添加
	 public int addProduct(Easybuy_product product);
	 
	 public int deleteProduct(int ep_id);
	 
	 public int countPage();
	 
	 public List<Easybuy_product> getAllProduct();
}
