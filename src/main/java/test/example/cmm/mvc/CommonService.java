package test.example.cmm.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommonService extends ExampleService{

	public List<Map<String, Object>> getData() throws Exception {
		return getData("sample.selectBoardList");
	}
	
	public Map<String, Object> getBoardItem(Map<String, Object> param) throws Exception {
		return getBoardItem("sample.BoardItem", param);
	}
	
	public int saveData(Map<String, Object> param) throws Exception {
		return save("sample.BoardInsert", param);
	}
	
}
