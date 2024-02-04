package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteMobile")
public class DeleteMob extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  int msno = Integer.parseInt(req.getParameter("msno"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			PreparedStatement pstm = con.prepareStatement("delete from mobile where msno=?");
			pstm.setInt(1, msno);
			int rowUp = pstm.executeUpdate();
			PrintWriter out = resp.getWriter();
			out.print("<h1>" + rowUp + " record deleted...!!!</h1>");
			out.print("<br><br>");
			out.print("<h1><a href='DisplayMobile'>Back Page</a></h1>");
			out.print("<br><br>");
			out.print("<h1><a href='index.jsp'>Home Page</a></h1>");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
