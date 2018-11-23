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
import com.dao.impl.EasybyuserImpl;

import bin.Easybuy_user;
import bin.Page;


/**
 * Servlet implementation class EasyByServlet
 */
@WebServlet(urlPatterns = { "/EasyByServlet", "/manage/EasyByServlet"})
public class EasyByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EasyByServlet() {
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
		EasybyuserImpl easi=new EasybyuserImpl();
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
			List<Easybuy_user> list = easi.findByPage(page1);
			//System.out.println(list);
			session.setAttribute("page", page1);
			session.setAttribute("users", list);
			response.sendRedirect("user.jsp");
		} else if(org.equals("get")){
			Easybuy_user eas=new Easybuy_user();
			String userid=request.getParameter("id");
			System.out.println(userid);		
			 eas=easi.findById(userid);
			 System.out.println(eas);  
			 session.setAttribute("profile", eas);
			 response.sendRedirect("user-modify.jsp");
			
		}else if(org.equals("update")){
			String eu_user_id=request.getParameter("userName");
			String eu_user_name=request.getParameter("name");
		    String eu_password=request.getParameter("passWord");
		    int eu_sex=Integer.parseInt(request.getParameter("sex"));
		    String eu_birthday=request.getParameter("birthyear");
		    String eu_mobile=request.getParameter("mobile");
		    String eu_address=request.getParameter("address");
		    Easybuy_user eas1=new Easybuy_user(eu_user_id, eu_user_name, eu_password, eu_sex, eu_birthday, eu_mobile, eu_address);
			int row=easi.update(eas1);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('修改成功！');location.href='EasyByServlet?org=list';</script>");
			}else{
				write.println("<script>alert('修改失败！');</script>");
			}
		}else if(org.equals("del")){
			String userid=request.getParameter("id");
			System.out.println(userid);
			int row=easi.delById(userid);
			System.out.println(row);
			PrintWriter write=response.getWriter();
			if(row>0){
				write.println("<script>alert('删除成功！');location.href='EasyByServlet?org=list';</script>");
			}else{
				write.println("<script>alert('删除失败！');</script>");
			}
		}
	
	}

}
