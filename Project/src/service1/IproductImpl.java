package service1;

import java.util.List;

import com.dao.impl.EasycategoryImpl;

import bin.Easybuy_category;
import bin.Easybuy_product;
import bin.Page;
import service.ProductI;

public class IproductImpl implements ProductI{
	IproductImpl ipro=new IproductImpl();
	 EasycategoryImpl easyi=new  EasycategoryImpl();
	@Override
	public List<Easybuy_product> findAllProduct(Page page) {
		// TODO Auto-generated method stub
		return ipro.findAllProduct(page);
	}

	@Override
	public Easybuy_product findById(int ep_id) {
		Easybuy_product ep=ipro.findById(ep_id);
		Easybuy_category category=easyi.findById(ep.getEpc_child_id());
		ep.setCategory(category);
		return ep;
	}

	@Override
	public int update(Easybuy_product product) {
		 
		return ipro.update(product);
	}

	@Override
	public int addProduct(Easybuy_product product) {
		// TODO Auto-generated method stub
		return ipro.addProduct(product);
	}

	@Override
	public int deleteProduct(int ep_id) {
		// TODO Auto-generated method stub
		return ipro.deleteProduct(ep_id);
	}

	@Override
	public int countPage() {
		// TODO Auto-generated method stub
		return ipro.countPage();
	}

	@Override
	public List<Easybuy_product> getAllProduct() {
		// TODO Auto-generated method stub
		return ipro.getAllProduct();
	}

}
