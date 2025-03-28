package Domain.DAO;

import java.util.List;

import Domain.DTO.BookDTO;

public interface BookDAO {

	// CRUD
	int insert(BookDTO bookDto) throws Exception;

	int update(BookDTO bookDto) throws Exception;

	int delete(BookDTO bookDto) throws Exception;

	// 단건 조회
	BookDTO select(BookDTO bookDto);

	// 다건 조회
	List<BookDTO> selectAll();

}