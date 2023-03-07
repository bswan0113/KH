package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectBoardTypeList(@Param("authority")int adminAuthority);

	BoardTypeVO duplicateBoardType(@Param("bt_name")String bt_name);

	int insertBoardType(@Param("btVO")BoardTypeVO btVO);


	int updateBoardType(@Param("bt")BoardTypeVO bt);

	int deleteBoardType(@Param("bt_num")int bt_num);

	int insertBoard(@Param("bo")BoardVO board);

}
