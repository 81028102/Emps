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
 * @date 2016-3-12 上午11:20:50
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method 在stub
		try {
			//将emp放入List集合中去
			List<Emp> list=new ArrayList<Emp>();
			//打开数据库连接
			conn = BaseDao.getConnection();
			//sql语句
			String sql="select * from emps";
			//返回一个prepareStatement对象
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Emp(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
			}
			request.getSession().setAttribute("list",list);
			request.getRequestDispatcher("List.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			BaseDao.closeAll(conn, pstmt, rs);
		}
	}
}
