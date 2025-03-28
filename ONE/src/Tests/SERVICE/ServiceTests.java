package Tests.SERVICE;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.DTO.BookDTO;
import Domain.Service.BookService;

class ServiceTests {

	@Test
//	@Disabled
	void test1() throws Exception {
		BookService bookService = BookService.getInstance();
		bookService.bookRegistration(new BookDTO(1111, 1111, "asdf", "리눅스", "한빛", 3));
	}

	@Test
	@Disabled
	void test2() {
	}

	@Test
	@Disabled
	void test3() {
	}

	@Test
	@Disabled
	void test4() {
	}

}
