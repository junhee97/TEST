package Domain.Service;

import Domain.DAO.BookDAO;
import Domain.DAO.BookDAOImpl;
import Domain.DTO.BookDTO;

public class BookService {

	//
	private BookDAO bookDao;

	// 싱글톤
	private static BookService instance;

	private BookService() throws Exception {
		bookDao = BookDAOImpl.getInstance();
		System.out.println("[SERVICE] BookService init...");
	}

	public static BookService getInstance() throws Exception {
		if (instance == null)
			instance = new BookService();
		return instance;
	}

	// 도서 등록
	public boolean bookRegistration(BookDTO bookDto) throws Exception {
		return bookDao.insert(bookDto) > 0;
	}

	// 도서 조회

	// 도서 수정
	public boolean bookUpdate(BookDTO bookDto) throws Exception {
		return bookDao.update(bookDto) > 0;
	}

	// 도서 삭제
	public boolean bookDelete(BookDTO bookDto) throws Exception {
		return bookDao.delete(bookDto) > 0;
	}

}
