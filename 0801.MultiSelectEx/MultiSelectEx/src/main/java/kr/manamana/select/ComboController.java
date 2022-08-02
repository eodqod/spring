package kr.manamana.select;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.manamana.select.util.JsonUtil;
import kr.manamana.select.util.JsonUtil2;
import kr.manamana.select.vo.AreaVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ComboController {

	private static final Logger logger = LoggerFactory.getLogger(ComboController.class);

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String area(Model model) {
		List<AreaVO> list1 = JsonUtil2.readJson("202004Sido.json");
		model.addAttribute("list1", list1);
		List<AreaVO> list2 = JsonUtil2.readJson("202004Gugun.json", list1.get(0).getId());
		model.addAttribute("list2", list2);
		List<AreaVO> list3 = JsonUtil2.readJson("202004DongEupMyeon.json", list2.get(0).getId());
		model.addAttribute("list3", list3);
		return "select2";
	}
	@RequestMapping(value = "/select/{id}")
	@ResponseBody
	public List<AreaVO> areaid(@PathVariable("id") String id) {
		if (id == null || id.trim().length() == 0)
			id = "11";
		List<AreaVO> list = JsonUtil.readIdAear("202004Gugun.json", id);
		return list;
	}
	@RequestMapping(value = "/select2/{id}")
	@ResponseBody
	public List<AreaVO> areaid2(@PathVariable("id") String id) {
		if (id == null || id.trim().length() == 0)
			id = "11680";
		List<AreaVO> list = JsonUtil.readIdAear2("202004DongEupMyeon.json", id);
		return list;
	}
}
