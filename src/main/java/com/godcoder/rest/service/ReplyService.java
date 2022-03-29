package com.godcoder.rest.service;
import com.godcoder.rest.model.Board;
import com.godcoder.rest.model.Reply;
import com.godcoder.rest.repository.BoardRepository;
import com.godcoder.rest.repository.ReplyRepository;
import com.godcoder.rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    public void replySave(Long boardId, Reply reply){
        Board board = boardRepository.findById(Long.valueOf(boardId)).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + boardId));

        reply.save(board);

        replyRepository.save(reply);

    }
}