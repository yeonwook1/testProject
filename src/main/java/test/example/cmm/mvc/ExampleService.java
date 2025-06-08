package test.example.cmm.mvc;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
	private static final Logger log = LoggerFactory.getLogger(ExampleService.class);

    @Autowired
    private SqlSessionTemplate sqlSession;
      
    protected void printQueryId(String queryId) {
        if(log.isDebugEnabled()){
            log.debug("\t QueryId  \t:  " + queryId);
        }
    }
      
    public List<Map<String, Object>> getData(String queryId) {
    	printQueryId(queryId);
         return sqlSession.selectList(queryId);
    }
  
    public Map<String, Object> getBoardItem(String queryId, Map<String, Object> params) {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
		
	}
    
	public int save(String queryId, Map<String, Object> params) throws Exception {
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
}
