package kr.manamana.select.util;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	public static String uploadFile(String uploadPath, String originalName, byte[] fileDate) throws Exception {
		UUID uuid = UUID.randomUUID(); // 겹치지 않는 값을 자동으로 만들어주는 클래스
		String saveName = uuid.toString() + "_" + originalName; // 유일한이름 만들기
		File target = new File(uploadPath, saveName); // 파일 객체 생성
		FileCopyUtils.copy(fileDate, target); // 파일 저장
		logger.info("uploadFile : {}/{}", uploadPath, saveName);
		return saveName;
	}
}
