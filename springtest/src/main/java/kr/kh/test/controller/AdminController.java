package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.service.MemberService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;	

	@Autowired
	 HttpServletRequest request;
	
	
	String contextPath ="/test";

	@RequestMapping(value = "/admin/board/type/list")
	public ModelAndView adminBoardTypeList(ModelAndView mv) {
		ArrayList<BoardTypeVO> boardTypeList = adminService.getBoardTypeListAll();
		mv.addObject("btList",boardTypeList);
		mv.setViewName("/admin/BoardTypeList");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/insert", method=RequestMethod.POST)
	public ModelAndView adminBoardTypeListPost(ModelAndView mv, BoardTypeVO btVO, HttpServletResponse response) {
		boolean isAdd = adminService.addBoardType(btVO);
		
		
		if(isAdd) {
			MessageUtils.alertAndMovePage(response,"등록에 성공했습니다.", contextPath,"/admin/board/type/list");
		}else {
			MessageUtils.alertAndMovePage(response,"등록에 실패했습니다.", contextPath,"/admin/board/type/list");
			
		}
		
		
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/update", method=RequestMethod.POST)
	public ModelAndView updateBoardTypeListPost(ModelAndView mv, BoardTypeVO bt, HttpServletResponse response, HttpServletRequest request) {
		boolean isAdd = adminService.updateBoardType(bt);
		
		
		if(isAdd) {
			MessageUtils.alertAndMovePage(response,"수정에 성공했습니다.", contextPath,"/admin/board/type/list");
		}else {
			MessageUtils.alertAndMovePage(response,"수정에 실패했습니다.", contextPath,"/admin/board/type/list");
			
		}
		
		
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/delete", method=RequestMethod.GET)
	public ModelAndView deleteBoardTypeListPost(ModelAndView mv, BoardTypeVO bt, HttpServletResponse response, HttpServletRequest request) {
		boolean isAdd = adminService.deleteBoardType(bt);
		
		
		if(isAdd) {
			MessageUtils.alertAndMovePage(response,"삭제에 성공했습니다.", contextPath,"/admin/board/type/list");
		}else {
			MessageUtils.alertAndMovePage(response,"삭제에 실패했습니다.", contextPath,"/admin/board/type/list");
			
		}
		
		
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
}
	
