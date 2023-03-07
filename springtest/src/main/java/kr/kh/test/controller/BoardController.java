package kr.kh.test.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.BoardService;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;


@Controller
public class BoardController {

	@Autowired
	 HttpServletRequest request;
	
	@Autowired
	BoardService boardService;
	
	
	String contextPath ="/test";


	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView BoardInsertPOST(ModelAndView mv, BoardVO board, HttpSession session) {
		MemberVO user =(MemberVO)session.getAttribute("user");
		ArrayList<BoardTypeVO> typeList = boardService.getBoardType(user);
		mv.addObject("typeList",typeList);
		mv.setViewName("/board/insert");
		
		return mv;
	}

	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public ModelAndView BoardInsertMsg(ModelAndView mv, BoardVO board, HttpSession session, MultipartFile files) {
		MemberVO user =(MemberVO)session.getAttribute("user");
		String msg ="";
	if(	boardService.insertBoard(board, user, files)
			//	&& boardService.uploadFile(file)
				) {
			msg="작성에 성공했습니다.";
		}else {
			msg="작성에 실패했습니다.";
		}
			mv.addObject("msg",msg);
			mv.addObject("url","/board/lnsert");
			
		mv.setViewName("/common/message");
		
		return mv;
	}
}
	
