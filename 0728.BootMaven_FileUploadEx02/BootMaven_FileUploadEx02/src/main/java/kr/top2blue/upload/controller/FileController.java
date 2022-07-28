package kr.top2blue.upload.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.top2blue.upload.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	// application.properties에 등록된 파일의 경로를 가져온다.
	@Value("${spring.servlet.multipart.location}")
	String filePath;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {
		LocalDateTime today = LocalDateTime.now();
		model.addAttribute("today", today.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		return "index";
	}

	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}

	@PostMapping("/upload")
	// 업로드하는 파일들을 MultipartFile 형태의 파라미터로 전달된다.
	public String upload(@RequestParam MultipartFile[] uploadfile, Model model)
			throws IllegalStateException, IOException {
		List<FileVO> list = new ArrayList<>();
		for (MultipartFile file : uploadfile) {
			if (!file.isEmpty()) {
				// UUID를 이용해 unique한 파일 이름을 만들어준다.
				FileVO vo = new FileVO(UUID.randomUUID().toString(), file.getOriginalFilename(), file.getContentType());
				list.add(vo);

				File newFileName = new File(filePath + vo.getUuid() + "_" + vo.getFileName());
				// 전달된 내용을 실제 물리적인 파일로 저장해준다.
				file.transferTo(newFileName);
				
			}
		}
		model.addAttribute("files", list);
		return "result";
	}


	@GetMapping("/download")
	public ResponseEntity<Resource> download(@ModelAttribute FileVO vo) throws IOException {
		// Path path = Paths.get(filePath + "/" + vo.getUuid() + "_" + vo.getFileName());
		String newFileName = filePath + vo.getUuid() + "_" + vo.getFileName();
		Path path = Paths.get(newFileName);
		log.info("파일 절대 경로(download) : " + path.toString());
		String contentType = Files.probeContentType(path);
		// header를 통해서 다운로드 되는 파일의 정보를 설정한다.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(vo.getFileName(), StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);

		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
}
