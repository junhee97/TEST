package Tests.DAO;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.DAO.BookDAO;
import Domain.DAO.BookDAOImpl;
import Domain.DTO.BookDTO;

class DAOTests {

	@Test
	@Disabled
	void test1() throws Exception {
		BookDAO bookDaoImpl = BookDAOImpl.getInstance();
		bookDaoImpl.insert(new BookDTO(1112221, 1111, "asdf", "리눅스", "한빛", 3));
	}

	@Test
	@Disabled
	void test2() throws Exception {
		BookDAO bookDaoImpl = BookDAOImpl.getInstance();
		bookDaoImpl.delete(new BookDTO(1111, 1111, "가", "나", "다", 3));
	}

	@Test
//	@Disabled
	void test3() throws Exception {
		BookDAO bookDaoImpl = BookDAOImpl.getInstance();
		bookDaoImpl.update(new BookDTO(11121, 1111, "가", "나", "다", 3));
	}

	@Test
	@Disabled
	void test4() {
	}

	@Test
	@Disabled
	void test5() {
	}

}
