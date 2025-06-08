package test.example.cmm.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import test.example.cmm.util.CommomUtil;
/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService;

	@RequestMapping("/**") 
	public ModelAndView doPage(HttpServletRequest request) throws Exception { 
		String uri = CommomUtil.parseString(request.getRequestURI().substring(1)), page = "";
		uri = CommomUtil.parseString(uri, "index");
		
		switch(uri) {
		case "index":
			page = "/index";
			break;
		case "error":
			page = "/error";
			break;
		default:
			page = "task/"+uri;
			break;
		}
		ModelAndView mv = new ModelAndView(page);
		return mv; 
	  }
	  
	@RequestMapping(value = "/testList.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Map<String, Object>> openBoardList() throws Exception{ 
		List list = commonService.getData();
		return list;
	}
	
	@RequestMapping(value = "/insert.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertTest(@RequestParam Map<String, Object> dataMap, Model model) throws Exception{
		//저장처리
		int n = 0;
		n = commonService.saveData(dataMap);
		//0이상이면 
		return n > 0 ? "/index" : "/error";
	}
	
	/*	@RequestMapping(value = "/boardItem.do", method = {RequestMethod.GET, RequestMethod.POST})
		@ResponseBody
		public String itemTest(@RequestParam Map<String, Object> resultMap, Model model) throws Exception{
			List list = commonService.getBoardItem(resultMap);
			
			 model.addAttribute("dataList", list);
			
			return "/boardSave";
		}
	*/	
	@RequestMapping(value = "/boardItem.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> itemTest1(@RequestParam Map<String, Object> resultMap) throws Exception{
		Map<String, Object> map = commonService.getBoardItem(resultMap);
		System.out.println(map);
		return map;
	}
	
	
}