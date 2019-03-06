package com.almostman.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.almostman.base.Book;
import com.almostman.base.DB;



public class TestClass {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DB.getConn();
		String sql = "select * from book";
		pstmt = DB.getPstmt(conn, sql);
		
		ResultSet set = pstmt.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		
		new AutoWise<Book>().getObject("com.almostman.base.Book", books, set);
		
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
	
	

	
}
