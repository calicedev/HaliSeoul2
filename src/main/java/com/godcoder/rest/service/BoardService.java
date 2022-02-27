package com.godcoder.rest.service;


import com.godcoder.rest.model.Board;
import com.godcoder.rest.model.User;
import com.godcoder.rest.repository.BoardRepository;
import com.godcoder.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board){
        User user = userRepository.findByUsername(username);
        board.setUser(user);
        return boardRepository.save(board);
    }
}
