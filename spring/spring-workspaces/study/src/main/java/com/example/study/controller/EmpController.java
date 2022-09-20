package com.example.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.mapper.EmpMapper;
import com.example.study.vo.DeptVO;
import com.example.study.vo.EmpVO;



// @RestController는 결과값을 json으로 보여준다.
@RestController
@CrossOrigin
public class EmpController {
	
	//@Autowired Spring에서 객체를 관리(생성과 소멸을 담당하겠다.)해주겠다.
	@Autowired
	EmpMapper empMapper;
	
	/* 
	 * @ : 어노테이션
	 * Get : 조회하다
	 * Mapping : URL을 매핑(==연결)하다.
	 * /emp : URL 주소
	 */
	@GetMapping("/emp")
	public List<EmpVO> callAllEmp() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		EmpVO smith = new EmpVO(); // VO 클래스 생성
		smith.setEmpno(7369);
		smith.setEname("SMITH");
		smith.setJob("CLERK");
		smith.setHiredate("1980-12-17");
		smith.setSal(800);
		list.add(smith); //list에 smith 추가
		
		// list에 ALLEN 추가하기
		EmpVO allen = new EmpVO(); // VO 클래스 생성
		allen.setEmpno(7499);
		allen.setEname("ALLEN");
		allen.setJob("SALESMAN");
		allen.setHiredate("1981-02-20");
		allen.setSal(1600);
		list.add(allen); //list에 allen 추가
		
		return list;
	}
		
	@GetMapping("/emp/{empno}")
	public EmpVO callAllEmp(@PathVariable int empno) {
		List<EmpVO> list = new ArrayList<EmpVO>();
		
		EmpVO smith = new EmpVO(); // VO 클래스 생성
		smith.setEmpno(7369);
		smith.setEname("SMITH");
		smith.setJob("CLERK");
		smith.setHiredate("1980-12-17");
		smith.setSal(800);
		list.add(smith); //list에 smith 추가
		
		// list에 ALLEN 추가하기
		EmpVO allen = new EmpVO(); // VO 클래스 생성
		allen.setEmpno(7499);
		allen.setEname("ALLEN");
		allen.setJob("SALESMAN");
		allen.setHiredate("1981-02-20");
		allen.setSal(1600);
		list.add(allen); //list에 allen 추가
	
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i).getEmpno(); // list add한 deptno를 불러온다.
			if(x == empno) { //x가 URL로 받아온 deptno와 같다면!
				return list.get(i); // 부서번호 일치 deptno calss return!
			}
		}
		//Arraylist, HashMap 공부
		
		return null;
	}
	
	@GetMapping("/dept")
	public List<DeptVO> callDeptAll() {
		List<DeptVO> list = new ArrayList<DeptVO>();
		
		DeptVO dept1 = new DeptVO();
		dept1.setDeptno(10);
		dept1.setDname("ACCOUNTING");
		dept1.setLoc("NEW YORK");
		list.add(dept1);
		
		DeptVO dept2 = new DeptVO();
		dept2.setDeptno(20);
		dept2.setDname("RESEARCH");
		dept2.setLoc("DALLAS");
		list.add(dept2);
		
		DeptVO dept3 = new DeptVO();
		dept3.setDeptno(30);
		dept3.setDname("SALES");
		dept3.setLoc("CHICAGO");
		list.add(dept3);
		
		DeptVO dept4 = new DeptVO();
		dept4.setDeptno(40);
		dept4.setDname("OPERATIONS");
		dept4.setLoc("BOSTON");
		list.add(dept4);
		
		return list;
		
	}
	
	// @PathVariable을 이용해서 URL에 있는 데이터를 받아올 수 있다.
	// ex) localhost:8080/dept/300 => 300이라는 데이터를 파라미터로 받는다.
	@GetMapping("/dept/{deptno}")
	public DeptVO callDeptNo(@PathVariable int deptno) {
		List<DeptVO> list = new ArrayList<DeptVO>();
		
		DeptVO dept1 = new DeptVO();
		dept1.setDeptno(10);
		dept1.setDname("ACCOUNTING");
		dept1.setLoc("NEW YORK");
		list.add(dept1);
		
		DeptVO dept2 = new DeptVO();
		dept2.setDeptno(20);
		dept2.setDname("RESEARCH");
		dept2.setLoc("DALLAS");
		list.add(dept2);
		
		DeptVO dept3 = new DeptVO();
		dept3.setDeptno(30);
		dept3.setDname("SALES");
		dept3.setLoc("CHICAGO");
		list.add(dept3);
		
		DeptVO dept4 = new DeptVO();
		dept4.setDeptno(40);
		dept4.setDname("OPERATIONS");
		dept4.setLoc("BOSTON");
		list.add(dept4);
		
		System.out.println("부서번호는 "+deptno);
		
		for(int i=0; i<list.size(); i++) {
			int x = list.get(i).getDeptno(); // list add한 deptno를 불러온다.
			if(x == deptno) { //x가 URL로 받아온 deptno와 같다면!
				return list.get(i); // 부서번호 일치 deptno calss return!
			}
		}
		//Arraylist, HashMap 공부
		
		return null;
	}
	
	
//	@GetMapping("/emp/sal/{money}")
//	public String callEmpSal(@PathVariable String money) {
//		return money;
//	}
	/*
	 * ? : 쿼리 스트링
	 * @PathVariable처럼 url에 값을 넘겨주는 방법중 하나.
	 */
	// ex) leaderboards/tier?region=kr
	@GetMapping("/leaderboards/tier")
	public String queryStringTest(@RequestParam String region, @RequestParam String page) {
		return region+", "+page;
	}
	
	//ex) board/search?writer=brian&page=10
	@GetMapping("/board/search")
	public String queryStringTest2(@RequestParam String writer, @RequestParam String page) {
		return writer+", "+page;
	}
	
	/*
	 * url에 값을 넘겨주는 방법
	 * 1. path ex) /emp/{empno}
	 * 2. ? ex) /emp?empno=3
	 * url(controller)
	 * 값을 하나 or 둘 넘길 때 path 사용
	 * 여러 값을 넘길 때 queryString 사용
	 */
	
	@GetMapping("/db/emp")
	public List<EmpVO> callDbEmp() {
		return empMapper.selectEmp();
	}
	
	@GetMapping("/db/emp/{empno}")
	public EmpVO callEmpOne(@PathVariable int empno) {
		System.out.println("사원 번호 => "+empno);
		EmpVO vo = empMapper.selectEmpOne(empno);
		if(empno==7521) { //사원번호가 7521이라면
			vo.setSal(0);
			vo.setHiredate(null);
		}
		return vo;
	}
	
	@GetMapping("/db/dept/{deptno}")
	public DeptVO callDeptOne(@PathVariable int deptno) {
		System.out.println("부서 번호 => "+deptno);
		if(deptno==10||deptno==20) {
			// return은 더 이상 아래 코드를 실행하지 않는다.
			return null;
		}
		return empMapper.selectDeptOne(deptno);
	}
	
	// EMP테이블에 사원 insert 하기
	/*
	 * GET : SELECT
	 * POST : INSERT
	 * PATCH : UPDATE
	 * DELETE : DELETE
	 * HTTP method! (시간 날 때 구글링 해보기)
	 * *HTTP method가 다르면 url경로 중복 가능
	 */
	@PostMapping("/emp")
	public int callInsertEmp(@RequestBody EmpVO vo) {
		System.out.println("사원 번호는 => "+vo.getEmpno());
		System.out.println("사원 이름은 => "+vo.getEname());
		System.out.println("사원 직책은 => "+vo.getJob());
		System.out.println("사원 급여는 => "+vo.getSal());
		System.out.println("사원 부서번호는 => "+vo.getDeptno());
		int row = empMapper.insertEmp(vo);
		return row;
	}
	
	@DeleteMapping("/emp/{empno}")
	public int callDeleteEmp(@PathVariable int empno) {
		System.out.println("사원 번호는 => "+empno);
		int row = empMapper.deleteEmp(empno);
		return row;
	}
	
	// Update는 insert랑 비슷하다. @RequestBody를 입력해 주자!
	@PatchMapping("/emp")
	public int callUpdateEmp(@RequestBody EmpVO vo) {
		System.out.println("사원 번호는 => "+vo.getEmpno());
		System.out.println("사원 보너스는 => "+vo.getComm());
		System.out.println("사원 급여는 => "+vo.getSal());
		System.out.println("사원 부서번호는 => "+vo.getDeptno());
		int row = empMapper.updateEmp(vo);
		return row;
	}
	
	// 1. 사원이름으로 검색해서 사원번호, 사원이름, 직책, 급여 조회 하기(like x)
	@GetMapping("/emp/name/{ename}")
	public List<EmpVO> callEmpName(@PathVariable String ename) {
		return empMapper.selectEmpName(ename);
	}
	
	// 2. 부서번호가 10번인 사원들 comm 100으로 update
	@PatchMapping("/emp/comm")
	public int callUpdateEmpComm(@RequestBody EmpVO vo) {
		int row = empMapper.updateEmpComm(vo);
		return row;
	}
	
	// 3. 급여가 2000 이상인 모든 사원의 번호, 이름, 직업, 입사날짜를 조회하시오.
	// 단 입사날짜는 년도만 보이게 출력하시오.
	// 쿼리스트링으로 해보기
	@GetMapping("/emp/sal2")
	public List<EmpVO> callEmpSal2(@RequestParam int sal) {
		return empMapper.selectEmpSal2(sal);
	}
	// path 방식
	@GetMapping("/emp/sal/{money}")
	public List<EmpVO> callEmpSal3(@PathVariable int money) {
		return empMapper.selectEmpSal2(money);
	}
	
	// Java의 최상위 class는 Object!
	// Object는 모든 데이터타입 형변환이 가능하다.
	@GetMapping("/emp/dname")
	public List<Map<String, Object>> callEmpDname() {
		return empMapper.selectEmpJoinDept();
	}
	
	
	@GetMapping("/emp/loc")
	public List<Map<String, Object>> callEmpLoc() {
		// 문제 사원번호, 사원이름, 부서번호, 부서이름, 부서위치를 조회하시오.
		
		return empMapper.selectEmpJoinDeptLoc();
	}
	
	
	
	
	
	
	
	
}
