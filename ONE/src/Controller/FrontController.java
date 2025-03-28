package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	// 컨트롤러 저장 자료구조("/endPoint" : 컨트롤러 객체)
	private Map<String, Controller> map = new HashMap();

	// 싱글톤
	private static FrontController instance;

	private FrontController() {
		System.out.println("[FC] FrontController init..!");
		init();
	}

	public static FrontController getInstance() {
		if (instance == null)
			instance = new FrontController();
		return instance;
	}

	// 초기화
	private void init() {
		// 도서 요청 API
		map.put("/book", new BookController());
	}

	// View 로 부터 전달하는 요청 처리
	public Map<String, Object> execute(Map<String, Object> params) {

		System.out.println("[FC] execute invoke...");
		String endPoint = (String) params.get("endPoint"); // 사용자의 요청EP를 확인
		Controller controller = map.get(endPoint); // 요청사항을 처리할 SubController
		return controller.execute(params);
	}

}
