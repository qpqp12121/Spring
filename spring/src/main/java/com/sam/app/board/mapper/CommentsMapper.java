package com.sam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sam.app.board.service.CommentsVO;

@Mapper
public interface CommentsMapper {
	 public void insertComments(CommentsVO vo);
	 public void updateComments(CommentsVO vo);	 
	 public void deleteComments(CommentsVO vo);
	 public List<CommentsVO> getCommentsList(CommentsVO vo);
	 public CommentsVO getComments(CommentsVO vo);
}
