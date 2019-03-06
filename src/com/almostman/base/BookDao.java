package com.almostman.base;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;





public class BookDao {

	public void insert (Book book){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DB.getConn();
			String sql = "insert into book values(null, ?, ?, ?, ?, ?)";
			pstmt = DB.getPstmt(conn, sql);
			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPress());
			pstmt.setTimestamp(4, new Timestamp(book.getPressTime().getTime()));
			pstmt.setString(5, book.getIntroduction());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Book b = new Book();
		b.setName("死灰我走不错的111");
		b.setAuthor("崔军11");
		b.setPress("长江文化11");
		b.setPressTime(new Date());
		b.setIntroduction("猜猜看啊11");
		
		new BookDao().insert(b);
	}
}
