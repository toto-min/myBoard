package com.spring.board.main.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.dto.T_boardDTO;
import com.spring.board.main.service.T_boardService;

@Controller
public class T_boardController {
	
	private static final String fileImg_REPO = "C:\\Temp";
	@Autowired
	T_boardService service;
	
	@RequestMapping("/board")
	public ModelAndView t_boardmain() throws Exception{
		ModelAndView mav = new ModelAndView("/main/boardall");
		List<T_boardDTO> dto = service.t_boardAll();
		mav.addObject("boardNum", dto);
		
		return mav;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView t_boardDetail(@RequestParam("articleNum") int articleNum) throws Exception{
		ModelAndView mav = new ModelAndView("/detail/boardDetail");
		T_boardDTO dto = new T_boardDTO();
		dto.setArticleNum(articleNum);
		
		T_boardDTO board = service.t_boardDetail(articleNum);
		
		mav.addObject("boardDetail", board);
		
		return mav;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ModelAndView insert(T_boardDTO dto, @RequestParam("imgfile") MultipartFile file) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:/board");
		
		
		/* dto.setArticleNum(service.selectvl()); */
		
		String path=fileImg_REPO+"\\"+service.selectvl();
		String origin = file.getOriginalFilename();
		
		
		
		try {
			File folder = new File(path);
			if(!folder.exists()) {
				try {
					folder.mkdir();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(!file.isEmpty() && file.getSize()!=0) {
					File testFile = new File(path+"\\"+origin);
					file.transferTo(testFile);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		dto.setImagefileName(origin);
		service.insertpage(dto);
		return mav;
		
	}
	@RequestMapping(value="/insertForm", method=RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView("/insert/inspage");
		return mav;
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteNo(@RequestParam("articleNum") int articleNum, @RequestParam("imgfile") String rootimg) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board");
		
		String path=fileImg_REPO+"\\"+articleNum;
		
		if(rootimg != null && !rootimg.equals("")) {
			 String imgfilepath = path + "\\" + rootimg;
			 
			 File file = new File(imgfilepath);
			 
			 if(file.isFile()) {
				 file.delete();
			 }
		}
		
		File filefold = new File(path);
		
		if(filefold.exists()) {
			filefold.delete();
		}
		
		
		service.deletepage(articleNum);
		return mav;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(T_boardDTO dto, @RequestParam("imgfile") MultipartFile file) throws Exception{
		ModelAndView mav = new ModelAndView("redirect:/board/detail?articleNum="+dto.getArticleNum());
		
		
		String getfile = service.imagesel(dto.getArticleNum());
		String path = fileImg_REPO + "\\" + dto.getArticleNum(); 
		String origin = file.getOriginalFilename();
		
		
		if(!origin.equals(getfile)) {
			try {
				File pathfile = new File(path + "\\" + getfile);
				if(pathfile.isFile()) {
					pathfile.delete();
				}
				if(!file.isEmpty() && file.getSize() !=0) {
					File testFile = new File(path+"\\"+origin);
					file.transferTo(testFile);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		dto.setImagefileName(origin);
		service.updatepage(dto);
		return mav;
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.POST)
	public ModelAndView updateForm(T_boardDTO dto) {
		ModelAndView mav = new ModelAndView("/update/updatepage");
		mav.addObject("boardDetail",dto);
		return mav;
	}
	
}
