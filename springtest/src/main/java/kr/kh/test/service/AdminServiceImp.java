package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeListAll() {
		final int adminAuthority= 9; // 관리자 권한
		return boardDao.selectBoardTypeList(adminAuthority);
	}

	@Override
	public boolean addBoardType(BoardTypeVO btVO) {		
		if(!checkBoardType(btVO)) return false;		
		int res = boardDao.insertBoardType(btVO);
		return res != 0;
	}

	@Override
	public boolean updateBoardType(BoardTypeVO bt) {
		if(!checkBoardType(bt)) return false;	
		if(bt.getBt_num() <1) return false;
		int res =boardDao.updateBoardType(bt);		
		return res != 0;
	}
	
	private boolean checkBoardType(BoardTypeVO bt) {
		if(bt == null) return false;
		if(bt.getBt_type()==null) return false;
		if(!(bt.getBt_type().equals("일반")) && !(bt.getBt_type().equals("이미지"))) return false;
		if(bt.getBt_r_authority() != 0 && bt.getBt_r_authority() != 1 && bt.getBt_r_authority() != 9) return false;
		if(bt.getBt_w_authority() != 1  && bt.getBt_w_authority() != 9) return false;
		if(bt.getBt_name()==null || bt.getBt_name().trim().length()==0) return false;
		BoardTypeVO dbBt = boardDao.duplicateBoardType(bt.getBt_name());
		if(dbBt!=null && bt.getBt_num() != dbBt.getBt_num()) return false;
		
		return true;
	}

	@Override
	public boolean deleteBoardType(BoardTypeVO bt) {
		if(bt==null) return false;
		if(bt.getBt_num() <1) return false;
		int res= boardDao.deleteBoardType(bt.getBt_num());
		
		return res>0;
	}
}
