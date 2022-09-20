package com.example.study.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.study.vo.EmpVO;

@Mapper
public interface EmpMapper2 {

	// 조회
	public List<EmpVO> selectAllEmp();
	// 생성
	public int insertEmp(EmpVO vo);
	// 수정
	public int updateEmp(EmpVO vo);
	// 삭제
	public int deleteEmp(int empno);
	
	// 조회(JOIN 포함)
	public List<Map<String, Object>> selectAllDept();
}
