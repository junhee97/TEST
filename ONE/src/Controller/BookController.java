package Controller;

import java.util.HashMap;
import java.util.Map;

import Domain.DTO.BookDTO;
import Domain.Service.BookService;

public class BookController implements Controller {

	// BookService 연결
	private BookService bookService;

	Map<String, Object> response;

	public BookController() {
		try {
			bookService = BookService.getInstance();
		} catch (Exception e) {
			exceptionHandler(e);
		}
	}

	// C(1) R(select 2, selectAll 3) U(4) D(5)
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute Invoke..!");

		// 00
		response = new HashMap();
		Integer serviceNo = (Integer) params.get("serviceNo");

		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유요하지 않은 서비스 요청입니다.");
			return response;
		}

		try {
			switch (serviceNo) {
			case 1: // C - 도서 등록
				System.out.println("[SC] 도서 등록 요청 확인");
				// 01 파라미터 받기
				int Book_code = (params.get("Book_code") != null) ? (int) params.get("Book_code") : null;
				int Classification_id = (params.get("Classification_id") != null)
						? (int) params.get("Classification_id")
						: null;
				String book_author = (params.get("book_author") != null) ? (String) params.get("book_author") : null;
				String book_name = (params.get("book_name") != null) ? (String) params.get("book_name") : null;
				String publisher = (params.get("publisher") != null) ? (String) params.get("publisher") : null;
				int isreserve = (params.get("isreserve") != null) ? (int) params.get("isreserve") : null;
				BookDTO bookDto = new BookDTO(Book_code, Classification_id, book_author, book_name, publisher,
						isreserve);
				// 02 유효성 검증(Data Validation)
				boolean isOk = isValid(bookDto);
				System.out.println("[No-1 도서등록] : 유효성 검증 확인 : " + isOk);
				if (!isOk) {
					response.put("status", false);
					return response;
				}
				// 03 관련 서비스 실행
				boolean isSuccess = bookService.bookRegistration(bookDto);
				// 04 뷰로 이동(or 내용전달)
				if (isSuccess) {
					response.put("status", isSuccess);
					response.put("message", "도서 등록 성공!");
				}
				break;
			case 2: // R - 도서 조회(select)
				System.out.println("[SC] 도서 조회 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			case 3: // R - 도서 조회(selectAll)
				System.out.println("[SC] 도서 조회 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			case 4: // U - 도서 수정
				System.out.println("[SC] 도서 수정 요청 확인");
				// 01 파라미터 받기
				// 02 유효성 검증(Data Validation)
				// 03 관련 서비스 실행
				// 04 뷰로 이동(or 내용전달)
				break;
			case 5: // D - 도서 삭제
				System.out.println("[SC] 도서 삭제 요청 확인");
				// 01 파라미터 받기
//				int Book_code = (params.get("Book_code") != null) ? (int) params.get("Book_code") : null;
//				int Classification_id = (params.get("Classification_id") != null)
//						? (int) params.get("Classification_id")
//						: null;
//				String book_author = (params.get("book_author") != null) ? (String) params.get("book_author") : null;
//				String book_name = (params.get("book_name") != null) ? (String) params.get("book_name") : null;
//				String publisher = (params.get("publisher") != null) ? (String) params.get("publisher") : null;
//				int isreserve = (params.get("isreserve") != null) ? (int) params.get("isreserve") : null;
//				BookDTO bookDto = new BookDTO(Book_code, Classification_id, book_author, book_name, publisher,
//						isreserve);
//				// 02 유효성 검증(Data Validation)
//				boolean isOk = isValid(bookDto);
//				System.out.println("[No-1 도서등록] : 유효성 검증 확인 : " + isOk);
//				if (!isOk) {
//					response.put("status", false);
//					return response;
//				}
//				// 02 유효성 검증(Data Validation)
//				// 03 관련 서비스 실행
//				boolean isSuccess = bookService.bookDelete(bookDto);
//				// 04 뷰로 이동(or 내용전달)
//				if (isSuccess) {
//					response.put("status", isSuccess);
//					response.put("message", "도서 삭제 성공!");
//				}
//				break;
//			default:
				System.out.println("[SC] 잘못된 서비스번호 요청 확인");
				response.put("status", false);
				response.put("message", "잘못된 서비스번호 요청입니다.");

			}
		} catch (Exception e) {
			exceptionHandler(e);
		}
		return response;
	}

	// 유효성 검사 함수
	private boolean isValid(BookDTO bookDto) {
		if (bookDto.getBook_code() == 0 || String.valueOf(bookDto.getBook_code()).length() != 8) {
			response.put("error", "Book_code의 길이는 8글자 입니다.");
			return false;
		}
		return true;
	}

	// 예외처리 함수
	public Map<String, Object> exceptionHandler(Exception e) {

		if (response == null)
			response = new HashMap();

		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("exception", e);

		return response;
	}
}
