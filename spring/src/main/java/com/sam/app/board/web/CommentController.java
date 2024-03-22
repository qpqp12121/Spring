package com.sam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.app.board.service.CommentsService;
import com.sam.app.board.service.CommentsVO;

@Controller
public class CommentController {

	@Autowired CommentsService commentService;

	//댓글추가
	@RequestMapping("/insertComments")
	@ResponseBody 
	public CommentsVO insertComments(CommentsVO vo) {
		commentService.insertComments(vo);
		return commentService.getComments(vo);
	}
	//수정
	@RequestMapping("/updateComments")
	@ResponseBody 
	public CommentsVO updateComments(CommentsVO vo) {
		commentService.updateComments(vo);
		return commentService.getComments(vo);
	}	
	//삭제
	@RequestMapping("/deleteComments")
	@ResponseBody 
	public CommentsVO deleteComments(CommentsVO vo) {
		commentService.deleteComments(vo);
		return vo;
	}	
	//목록
	@RequestMapping("/getCommentsList")
	@ResponseBody 
	public List<CommentsVO> getCommentsList(CommentsVO vo) {
		return commentService.getCommentsList(vo);
	}	
	//단건
	@RequestMapping("/getComments")
	@ResponseBody 
	public CommentsVO getComments(CommentsVO vo) {
		return commentService.getComments(vo);
	}	
}
