package Viewer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;

public class TUI {

	private Scanner sc = new Scanner(System.in);

	private FrontController controller;

	public TUI() throws Exception {
		controller = FrontController.getInstance();
	}

	public void Menu() {
		while (true) {
			System.out.println("------ M E N U ------");
			System.out.println("1 Book_Tbl");
			System.out.println("2 Member_Tbl");
			System.out.println("3 Rental_Tbl");
			System.out.println("4 Exit");
			System.out.println("------ M E N U ------");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				Book();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(-1);
			}
		}
	}

	public void Book() {
		while (true) {
			System.out.println("------ B O O K ------");
			System.out.println("1 Insert");
			System.out.println("2 Select");
			System.out.println("3 SelectAll");
			System.out.println("4 Update");
			System.out.println("5 Delete");
			System.out.println("6 Prev");
			System.out.println("------ B O O K ------");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				BookInsert();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				Menu();
				break;
			}
		}
	}

	public void BookInsert() {
		System.out.println("--------------------------");
		System.out.println("도서 정보 입력");
		System.out.println("--------------------------");
		System.out.print("도서코드 : ");
		int Book_code = sc.nextInt();
		System.out.print("분류번호 : ");
		int Classification_id = sc.nextInt();
		System.out.print("저자 : ");
		String book_author = sc.next();
		System.out.print("책제목 : ");
		String book_name = sc.next();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		System.out.print("예약 여부 : ");
		int isreserve = sc.nextInt();

		//
		Map<String, Object> params = new HashMap();
		params.put("endPoint", "/book");
		params.put("serviceNo", 1);
		params.put("Book_code", Book_code);
		params.put("Classification_id", Classification_id);
		params.put("book_author", book_author);
		params.put("book_name", book_name);
		params.put("publisher", publisher);
		params.put("isreserve", isreserve);

		Map<String, Object> response = controller.execute(params);

		for (String key : response.keySet())
			System.out.println(key + " : " + response.keySet());
	}

}
