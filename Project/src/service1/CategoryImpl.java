package service1;

import java.util.List;

import com.dao.impl.EasycategoryImpl;

import bin.Easybuy_category;
import bin.Page;
import service.CategoryI;

public class CategoryImpl implements CategoryI{
     EasycategoryImpl easyi=new  EasycategoryImpl();
	@Override
	public List<Easybuy_category> findCategoryByParent(Page page) {
		List<Easybuy_category> list=easyi.findCategoryByParent(page);
		for(Easybuy_category cate:list){
			List<Easybuy_category> categorys=easyi.findCategoryByParentId(cate.getEpc_id());
			cate.setCategorys(categorys);
		}
		return list;
	}

	@Override
	public List<Easybuy_category> findCategoryByParentId(int epc_ip) {
		// TODO Auto-generated method stub
		List<Easybuy_category> list=easyi.findCategoryByParentId(epc_ip);
		return list;
	}

	@Override
	public int countPage() {
		int row=easyi.countPage();
		return row;
	}

	@Override
	public int updateCategory(Easybuy_category category) {
		 int row=easyi.updateCategory(category);
		return row;
	}

	@Override
	public int delCategory(int epc_id) {
		// TODO Auto-generated method stub
		int row=easyi.delCategory(epc_id);
		return row;
	}

	@Override
	public int addCategory(Easybuy_category category) {
		int row=easyi.addCategory(category);
		return row;
	}

	@Override
	public Easybuy_category findById(int epc_id) {
		// TODO Auto-generated method stub
		Easybuy_category cate=easyi.findById(epc_id);
		return cate;
	}

}
