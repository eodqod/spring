package kr.manamana.select;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import kr.manamana.select.util.JsonUtil;
import kr.manamana.select.util.UploadFileUtils;
import kr.manamana.select.vo.AreaVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		List<AreaVO> list = JsonUtil.readJson("area.json");
		model.addAttribute("list", list);
		List<AreaVO> list2 = JsonUtil.readAear("area.json");
		model.addAttribute("list2", list2);
		List<AreaVO> list3 = JsonUtil.readIdAear("area.json", list2.get(8).getId());
		model.addAttribute("list3", list3);
		return "home";
	}

	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public String area(Model model) {
		List<AreaVO> list1 = JsonUtil.readAear("area.json");
		model.addAttribute("list1", list1);
		List<AreaVO> list2 = JsonUtil.readIdAear("area.json", list1.get(0).getId());
		model.addAttribute("list2", list2);
		List<AreaVO> list3 = JsonUtil.readIdAear2("area.json", list2.get(0).getId());
		model.addAttribute("list3", list3);
		return "select";
	}

	@RequestMapping(value = "/area/{id}")
	@ResponseBody
	public List<AreaVO> areaid(@PathVariable("id") String id) {
		if (id == null || id.trim().length() == 0)
			id = "11";
		List<AreaVO> list = JsonUtil.readIdAear("area.json", id);
		return list;
	}
	
	@RequestMapping(value = "/area2/{id}")
	@ResponseBody
	public List<AreaVO> areaid2(@PathVariable("id") String id) {
		if (id == null || id.trim().length() == 0)
			id = "11680";
		List<AreaVO> list = JsonUtil.readIdAear2("area.json", id);
		return list;
	}

	@RequestMapping(value = "/ckeditorV4")
	public String ckeditorV4(Model model) {
		return "ckeditorV4";
	}

	@RequestMapping(value = "/ckeditorV5")
	public String ckeditorV5(Model model) {
		return "ckeditorV5";
	}

	@RequestMapping(value = "/ckeditorV4Upload")
	public String ckeditorV4Upload(Model model) {
		return "ckeditorV4Upload";
	}
	@RequestMapping(value = "/ckeditorV4UploadOk")
	public String ckeditorV4UploadOk(@RequestParam String editor1, Model model) {
		model.addAttribute("editor1", editor1);
		return "ckeditorV4UploadOk";
	}

	@RequestMapping(value = "/ckeditorV5Upload")
	public String ckeditorV5Upload(Model model) {
		return "ckeditorV5Upload";
	}
	@RequestMapping(value = "/ckeditor5UploadOk")
	public String ckeditorV5UploadOk(@RequestParam String editor1, Model model) {
		model.addAttribute("editor1", editor1);
		return "ckeditorV5UploadOk";
	}

	
	@RequestMapping(value = "/ckeditor/upload4", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upload4(HttpServletRequest request, @RequestParam MultipartFile upload){
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();

		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("upload");
		String saveFileName="";
		logger.debug("실제 경로 : " + realPath);
		//파일 이름 가져오기
        try {
           	if(upload!=null && upload.getSize()>0) {
	        	String fileName = upload.getOriginalFilename();
				byte[] bytes = upload.getBytes();
				saveFileName = UploadFileUtils.uploadFile(realPath, fileName, bytes);
				// 값 리턴
				map.put("uploaded","1"); // 성공
				map.put("filename",fileName); // 원본파일명
				// 저장 URL
				map.put("url", request.getContextPath() +File.separator + "upload" + File.separator + saveFileName);
				// 반드시 json으로 출력
				return gson.toJson(map);
           	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        map.put("uploaded","0"); // 실패
		map.put("filename","");
		map.put("url","");
		return gson.toJson(map);
	}
	
	@RequestMapping(value = "/ckeditor/upload5", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upload5(HttpServletRequest request, @RequestParam MultipartFile upload){
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		
		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("upload");
		String saveFileName="";
		logger.debug("실제 경로 : " + realPath);
		//파일 이름 가져오기
		try {
			if(upload!=null && upload.getSize()>0) {
				String fileName = upload.getOriginalFilename();
				byte[] bytes = upload.getBytes();
				saveFileName = UploadFileUtils.uploadFile(realPath, fileName, bytes);
				// 값 리턴
				map.put("uploaded",true); // 성공
				// 저장 URL
				map.put("url", request.getContextPath() +File.separator + "upload" + File.separator + saveFileName);
				// 반드시 json으로 출력
				return gson.toJson(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("uploaded",false); // 실패
		map.put("error","{\"message\":\"업로드 실패\"}");
		return gson.toJson(map);
	}
}
