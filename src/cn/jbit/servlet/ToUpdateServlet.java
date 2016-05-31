package cn.jbit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jbit.db.BaseDao;
import cn.jbit.entity.Emp;

/**
 * @author 任锯东
 * @date 2016-3-12 上午11:43:16
 */
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//获取数据
			id = request.getParameter("id");
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="select * from emps where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(id));
			Emp emp=null;
			rs = pstmt.executeQuery();
			while(rs.next()){
				emp=new Emp(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			}
			request.getSession().setAttribute("emp", emp);
			String sql1="select distinct love from emps";
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			List<String> strings=new ArrayList<String>();
			String string=null;
			while(rs.next()){
				string = rs.getString(1);
				strings.add(string);
			}
			request.getSession().setAttribute("str", strings);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
	}
}
