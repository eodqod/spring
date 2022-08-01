package kr.human.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.human.boot.vo.PersonVO;

@RestController
@RequestMapping("/api/")
public class SampleController {

    @RequestMapping(method = RequestMethod.GET, value = "/text", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sample(@RequestParam(defaultValue = "한사람", required = false) String param) {
        return "Hello " + param;
    }

    @RequestMapping(method = RequestMethod.GET, value = "person.txt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String personText() {
    	return new PersonVO("한사람", 23, false).toString();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "person.json", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO personJson() {
    	return new PersonVO("한사람", 23, false);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "person.xml",produces = MediaType.APPLICATION_XML_VALUE)
    public PersonVO personXML() {
		return new PersonVO("한사람", 23, false);
    }
}