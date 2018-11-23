package servlet1;

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
import bin.Easybuy_category;
import bin.Page;
import service1.CategoryImpl;

/**
 * Servlet implementation class EasyCateServlet
 */
@WebServlet(urlPatterns = { "/EasyCateServlet", "/manage/EasyCateServlet"})
public class EasyCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EasyCateServlet() {
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
		CategoryImpl cate=new CategoryImpl();
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
			int count = cate.countPage();// 总数量
			page1.setCountpagesize(count); // 总数量
			List<Easybuy_category> list = cate.findCategoryByParent(page1);
			//System.out.println(list);
			session.setAttribute("page", page1);
			session.setAttribute("categ", list);
			response.sendRedirect("productClass.jsp");
		} else if(org.equals("get")){
			int userid=Integer.parseInt(request.getParameter("id"));
			//System.out.println(userid);
			Easybuy_category eas=cate.findById(userid);
			 System.out.println(eas); 
			 session.setAttribute("profile", eas);
			 response.sendRedirect("product-modify.jsp");
			
		}else if(org.equals("update")){//修改
		    int epc_id=Integer.parseInt(request.getParameter("epc_id"));
		    String epc_name=request.getParameter("birthyear");
		    int epc_parent_id=Integer.parseInt(request.getParameter("epc_parent_id"));	
		    Easybuy_category categ=new Easybuy_category(epc_id, epc_name, epc_parent_id);
			int row=cate.updateCategory(categ);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('修改成功！');location.href='EasyCateServlet?org=list';</script>");
			}else{
				write.println("<script>alert('修改失败！');</script>");
			}
		}else if(org.equals("del")){
			 int epc_id=Integer.parseInt(request.getParameter("epc_id"));
			int row=cate.delCategory(epc_id);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('删除成功！');location.href='EasyCateServlet?org=list';</script>");
			}else{
				write.println("<script>alert('删除失败！');</script>");
			}
		}
	
	}

}

