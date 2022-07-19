package com.exam.exspring.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.exspring.member.MemberVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	
	@RequestMapping(path = "/reply/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ReplyVo> list(int repBbsNo){
		List<ReplyVo> list = replyService.selectReplyList(repBbsNo);
		return list;
	}
		
	

	@RequestMapping(path = "/reply/add.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> add(ReplyVo vo, HttpSession session)// 파라미터이름과 같은 변수를 선언하면 값들이 전달된다. 하나하나의 파라미터값을 입력해도 되지만 
                                                      //	그게 다 속해있는 ReplyVo로 적어도 가능하다.

	{
		MemberVo memVo = (MemberVo) session.getAttribute("loginUser");
		vo.setRepWriter(memVo.getMemId());
		// 데이터베이스 댓글 추가(insert)
		int num = replyService.insertReply(vo);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("no", num);
		
		return map;
		
//		String jsonStr= "";
//		ObjectMapper mapper = new ObjectMapper();// JAVA객체 <-> JSON문자열 변환 담당
//		try {
//			jsonStr = mapper.writeValueAsString(map);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // JAVA객체 -> JSON문자열 변환
//
//		return jsonStr; // "{ \"no\":" + num + "}";
	}
}
