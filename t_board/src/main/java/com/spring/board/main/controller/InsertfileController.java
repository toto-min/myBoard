package com.spring.board.main.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertfileController {
	private static String Path = "file:///C:/Temp";
	
	@RequestMapping("/preview")
	public void preview(@RequestParam("artNum") int artNum, @RequestParam("file") String file, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		
		OutputStream stream = response.getOutputStream();
		
		String route = Path+"/"+artNum+"/"+file;
		
		URL url = new URL(route);
		
		InputStream inStream = url.openStream();
		
		FileCopyUtils.copy(inStream, stream);
	}
}
