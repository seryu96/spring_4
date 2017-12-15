package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Inject
	private NoticeService noticeService;

	@RequestMapping(value = "noticeList")
	public ModelAndView list(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv = noticeService.selectList(listData);
		mv.setViewName("board/boardList");
		
		/*
		if(mv != null)
			throw new NullPointerException();		
		*/
		return mv;
	}

	@RequestMapping(value = "noticeView")
	public String view(int num, Model model) throws Exception {
		BoardDTO noticeDTO = null;
		noticeDTO = noticeService.selectOne(num);
		model.addAttribute("view", noticeDTO);
		model.addAttribute("board", "notice");

		return "board/boardView";
	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String write(Model model) throws Exception {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String write(RedirectAttributes ra, NoticeDTO boardDTO, HttpSession session) throws Exception {
		String message = "작성에 실패하였습니다.";
		int result = noticeService.insert(boardDTO, session);
		if (result > 0)
			message = "작성에 성공하였습니다.";
		ra.addFlashAttribute("message", message);

		return "redirect:./noticeList";
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		BoardDTO boardDTO = null;
		boardDTO = noticeService.selectOne(num);
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String update(RedirectAttributes ra, NoticeDTO boardDTO) throws Exception {
		String message = "수정에 실패하였습니다.";
		int result = noticeService.update(boardDTO);
		if (result > 0)
			message = "수정에 성공하였습니다.";
		ra.addFlashAttribute("message", message);

		return "redirect:./noticeList";
	}

	@RequestMapping(value = "noticeDelete")
	public String delete(RedirectAttributes ra, int num) throws Exception {
		String message = "삭제에 실패하였습니다.";
		int result = noticeService.delete(num);
		if (result > 0)
			message = "삭제에 성공하였습니다.";
		ra.addFlashAttribute("message", message);

		return "redirect:./noticeList";
	}
}
