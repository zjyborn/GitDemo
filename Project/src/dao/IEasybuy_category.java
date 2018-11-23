package dao;

import java.util.List;

import bin.Easybuy_category;
import bin.Page;

/*
 * 
 * 接口
 * */
public interface IEasybuy_category {
	//查询一级分类
  public List<Easybuy_category> findCategoryByParent(Page page);

  public List<Easybuy_category> findCategoryByParentId(int epc_ip);
  //分类总条数
  public int countPage();
  //修改
  public int updateCategory(Easybuy_category category);
  //删除
  public int delCategory(int epc_id);
  //添加
  public int addCategory(Easybuy_category category);
  
  public Easybuy_category findById(int epc_id);

  public List<Easybuy_category> findCategoryByParent();

}
