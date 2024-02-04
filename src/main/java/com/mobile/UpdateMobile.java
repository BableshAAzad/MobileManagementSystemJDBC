package com.mobile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateMobile")
public class UpdateMobile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
			PreparedStatement pstm = con.prepareStatement("select * from mobile where msno=?");
			int msno = Integer.parseInt(req.getParameter("msno"));
			pstm.setInt(1, msno);
			ResultSet rs = pstm.executeQuery();
			req.setAttribute("existingMob", rs);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateMobileData.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
