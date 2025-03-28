package Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();

	@Test
	void test1() {
		// View 에서 요청정보 담기
		Map<String, Object> params = new HashMap();
		params.put("endPoint", "/book"); // endPoint
		params.put("serviceNo", 1); // serviceNo

		// 도서 등록 - 인자 전달
		params.put("Book_code", 21231212);
		params.put("Classification_id", 1111);
		params.put("book_author", "asdf");
		params.put("bookname", "리눅스");
		params.put("publisher", "한빛");
		params.put("isreserve", 2);

		// 요청하기
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
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

	@Test
	@Disabled
	void test5() {
	}

}
