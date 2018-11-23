package servlet1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.EasybyuserImpl;
import com.dao.impl.EasycategoryImpl;

import bin.Easybuy_category;
import bin.Easybuy_product;
import bin.Page;
import service1.IproductImpl;
import until.FileUpload;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns = { "/ProductServlet", "/manage/ProductServlet"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String org = request.getParameter("org");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IproductImpl easi=new IproductImpl();
		EasycategoryImpl ei=new EasycategoryImpl();
		if (org == null) {
			org = "list";
		}
		if (org.equals("list")) { //显示所有成员的信息
			int current = 1;
			if (request.getParameter("current") != null) {
				current = Integer.parseInt(request.getParameter("current"));
			}
			Page page1 = new Page();
			page1.setPagesize(3);// 每页的数量
			page1.setCurrentpage(current);// 当前页数
			int count = easi.countPage();// 总数量
			page1.setCountpagesize(count); // 总数量
			List<Easybuy_product> list = easi.findAllProduct(page1);
			//System.out.println(list);
			String path=request.getSession().getServletContext().getRealPath("/images/product");
			session.setAttribute("page", page1);
			session.setAttribute("path", path);
			session.setAttribute("products", list);
			response.sendRedirect("product.jsp");
		} else if(org.equals("get")){
			Easybuy_product eas=new Easybuy_product();
			int userid=Integer.parseInt(request.getParameter("id"));
			System.out.println(userid);		
			 eas=easi.findById(userid);
			 System.out.println(eas);  
			 session.setAttribute("profile", eas);
			 response.sendRedirect("product-modify.jsp");
			
		}else if(org.equals("update")){
			int ep_id=Integer.parseInt(request.getParameter("id"));
			String ep_name=request.getParameter("userName");
			String ep_description=request.getParameter("name");
		    double ep_price=Double.parseDouble(request.getParameter("id"));
		    int ep_stock=Integer.parseInt(request.getParameter("sex"));
		    int epc_id=Integer.parseInt(request.getParameter("sex"));
		    int epc_child_id=Integer.parseInt(request.getParameter("sex"));
		    String ep_file_name=request.getParameter("mobile");
		    Easybuy_product eas1=new Easybuy_product(ep_id, ep_name, ep_description, ep_price, ep_stock, epc_id, epc_child_id, ep_file_name);   
			int row=easi.update(eas1);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('修改成功！');location.href='ProductServlet?org=list';</script>");
			}else{
				write.println("<script>alert('修改失败！');</script>");
			}
		}else if(org.equals("del")){
			int userid=Integer.parseInt(request.getParameter("id"));
			System.out.println(userid);
			int row=easi.deleteProduct(userid);
			System.out.println(row);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('删除成功！');location.href='ProductServlet?org=list';</script>");
			}else{
				write.println("<script>alert('删除失败！');</script>");
			}
		}else if(org.equals("add")){
			List<Easybuy_category> category=ei.findCategoryByParent();
			 session.setAttribute("category", category);
			 response.sendRedirect("product-add.jsp");
		}else if(org.equals("save")){
			  String ep_name=request.getParameter("productName");
			  String ep_description=request.getParameter("productDetail");
			  double ep_price=Double.parseDouble(request.getParameter("productPrice"));
			  int ep_stock=Integer.parseInt(request.getParameter("productNumber"));//库存
			  int epc_id=Integer.parseInt(request.getParameter("parentId"));			  
			  String ep_file_name=request.getParameter("photo");
			  File file = new File(ep_file_name);				
				String path = request.getSession().getServletContext().getRealPath("/images/product");
				FileUpload.upload(path,ep_file_name);			
				Easybuy_product product = new Easybuy_product(ep_name, ep_description, ep_price, ep_stock, epc_id, file.getName());
				int temp = easi.addProduct(product);
				PrintWriter writer=response.getWriter();
				if(temp>0) {
					writer.println("<script>alert('添加成功！');location.href='easybuy_ProductServlet?org=list';</script>");
				}else {
					writer.println("<script>alert('添加失败！');</script>");
				}  		 
		}
	   
	}

}
