package dao;

import java.util.List;

import bin.Easybuy_user;
import bin.Page;

public interface EasybyUser {
	//分页查找所有用户
   public List<Easybuy_user> findByPage(Page page);
   //通过id查找某个用户。
   public Easybuy_user findById(String user_id);
   //删除
   public int delById(String user_id);
   //修改
   public int update(Easybuy_user user);
   public int countPage();
}
