package com.sam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.app.board.mapper.CommentsMapper;
import com.sam.app.board.service.CommentsService;
import com.sam.app.board.service.CommentsVO;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsMapper commentsMapper;
	
	public void insertComments(CommentsVO vo) {
		commentsMapper.insertComments(vo);
	}
	public void updateComments(CommentsVO vo) {
		commentsMapper.updateComments(vo);
	}
	public void deleteComments(CommentsVO vo) {
		commentsMapper.deleteComments(vo);
	}	
	public List<CommentsVO> getCommentsList(CommentsVO vo) {
		return commentsMapper.getCommentsList(vo);
	}
	public CommentsVO getComments(CommentsVO vo) {
		return commentsMapper.getComments(vo);
	}
}
