package cn.jbit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jbit.db.BaseDao;

/**
 * @author 任锯东
 * @date 2016-3-12 上午11:43:38
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String iphone;
	private String age;
	private String love;
	private String email;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private int i;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			id = request.getParameter("id");
			name = request.getParameter("name");
			iphone = request.getParameter("iphone");
			age = request.getParameter("age");
			love = request.getParameter("love");
			email = request.getParameter("email");
			//打开连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="update emps set name=?,iphone=?,age=?,love=?,email=? where id=?";
			//创建一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setLong(2,Long.parseLong(iphone));
			pstmt.setInt(3,Integer.parseInt(age));
			pstmt.setString(4, love);
			pstmt.setString(5, email);
			pstmt.setInt(6,Integer.parseInt(id));
			i = pstmt.executeUpdate();
			if(i>0){
				request.getRequestDispatcher("List").forward(request, response);
			}else{
				response.sendRedirect("ToUpdate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, pstmt, null);
		}
	}
}
