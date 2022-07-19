package com.exam.exspring.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceImpl implements ReplyService {
 @Autowired
 private ReplyDao replyDao;
@Override
public int insertReply (ReplyVo vo) {
    	return replyDao.insertReply(vo);}
@Override
public List<ReplyVo> selectReplyList(int repBbsNo) {
	// TODO Auto-generated method stub
	return replyDao.selectReplyList(repBbsNo);
}

}
