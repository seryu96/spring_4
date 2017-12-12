package com.iu.s4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {

	@Inject
	private QnaService qnaService; 

	@RequestMapping(value="qnaList")
	public ModelAndView list(ListData listData) {
		ModelAndView mv = new ModelAndView();
		try {
			mv = qnaService.selectList(listData);
			mv.setViewName("board/boardList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(value="qnaView")
	public String view(Model model, int num) {
		BoardDTO qnaDTO = null;
		try {
			qnaDTO = qnaService.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("board", "qna");
		model.addAttribute("view", qnaDTO);

		return "board/boardView";
	}

	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}

	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(RedirectAttributes ra, QnaDTO boardDTO) {
		String message = "작성에 실패하였습니다.";
		try {
			int result = qnaService.insert(boardDTO);
			if(result > 0)
				message = "작성에 성공하였습니다.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);

		return "redirect:./qnaList";
	}

	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num) {
		BoardDTO boardDTO = null;
		try {
			boardDTO = qnaService.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "qna");

		return "board/boardUpdate";
	}

	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(RedirectAttributes ra, QnaDTO boardDTO) {
		String message = "수정에 실패하였습니다.";
		try {
			int result = qnaService.update(boardDTO);
			if(result > 0)
				message = "수정에 성공하였습니다.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);

		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaDelete")
	public String delete(RedirectAttributes ra, int num) {
		String message = "삭제에 실패하였습니다.";
		try {
			int result = qnaService.delete(num);
			if(result > 0)
				message = "삭제에 성공하였습니다.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);
		return "redirect:./qnaList";
	}
}
