package com.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

public class AddMobile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mmodel = req.getParameter("mmodel");
		String mprice = req.getParameter("mprice");
		String mbrand = req.getParameter("mbrand");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("insert mobile(mmodel, mprice, mbrand) values(?,?,?)");
			pstmt.setString(1, mmodel);
			pstmt.setString(2, mprice);
			pstmt.setString(3, mbrand);
			int rowEffected = pstmt.executeUpdate();
			con.close();
			PrintWriter out = resp.getWriter();
			out.print("<h1>" + rowEffected + " record is added </h1>");
			out.print("<br><br>");
			out.print("<h2><a href=\"index.jsp\">Home Page</a></h2>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
