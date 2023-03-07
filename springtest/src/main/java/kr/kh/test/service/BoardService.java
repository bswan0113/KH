package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile files);


	ArrayList<BoardTypeVO> getBoardType(MemberVO user);


}
