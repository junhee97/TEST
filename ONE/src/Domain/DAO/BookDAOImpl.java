package Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Domain.DTO.BookDTO;

public class BookDAOImpl implements BookDAO {

	// dB Attr
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String id = "system";
	private String pw = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	// 싱글톤 패턴
	private static BookDAO instance;

	private BookDAOImpl() throws Exception {
		System.out.println("[DAO] BookDAOImpl init...");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("BookDAOImpl DB Connection Success");
	}

	public static BookDAO getInstance() throws Exception {
		if (instance == null)
			instance = new BookDAOImpl();
		return instance;
	}

	// CRUD
	@Override
	public int insert(BookDTO bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement("insert into booktbl values(?,?,?,?,?,?)");
			pstmt.setInt(1, bookDto.getBook_code());
			pstmt.setInt(2, bookDto.getClassification_id());
			pstmt.setString(3, bookDto.getBook_author());
			pstmt.setString(4, bookDto.getBook_name());
			pstmt.setString(5, bookDto.getPublisher());
			pstmt.setInt(6, bookDto.getIsreserve());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int update(BookDTO bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement(
					"update booktbl set classification_id = ?, book_author = ?, book_name = ?, publisher = ?, isreserve = ? where book_code = ?");
			pstmt.setInt(1, bookDto.getClassification_id());
			pstmt.setString(2, bookDto.getBook_author());
			pstmt.setString(3, bookDto.getBook_name());
			pstmt.setString(4, bookDto.getPublisher());
			pstmt.setInt(5, bookDto.getIsreserve());
			pstmt.setInt(6, bookDto.getBook_code());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's UPDATE SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public int delete(BookDTO bookDto) throws Exception {
		try {
			pstmt = conn.prepareStatement("delete from booktbl where book_code =?");
			pstmt.setInt(1, bookDto.getBook_code());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's DELETE SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
		}
	}

	// 단건 조회
	@Override
	public BookDTO select(BookDTO bookDto) {
		return null;
	}

	// 다건 조회
	@Override
	public List<BookDTO> selectAll() {
		return null;
	}

}
