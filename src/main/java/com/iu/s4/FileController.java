package com.iu.s4;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileDTO;
import com.iu.file.PhotoDTO;
import com.iu.file.PhotoService;

@Controller
@RequestMapping(value="/file/*")
public class FileController {

	@Inject
	private PhotoService photoService;
	
	@RequestMapping(value="fileDownload")
	public ModelAndView fileDownload(FileDTO fileDTO, HttpSession session) {
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File file = new File(filePath, fileDTO.getFname());

		ModelAndView mv = new ModelAndView();
		mv.addObject("oname", fileDTO.getOname());
		mv.addObject("download", file);
		mv.setViewName("filedownload");

		return mv;
	}

	@RequestMapping(value="photoUpload")
	public String photoUpload(PhotoDTO photoDTO, HttpSession session) {
		return photoService.photoUpload(photoDTO, session);
	}
}
