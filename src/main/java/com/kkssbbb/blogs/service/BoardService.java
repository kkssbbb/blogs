package com.kkssbbb.blogs.service;

import com.kkssbbb.blogs.model.Board;
import com.kkssbbb.blogs.model.RoleType;
import com.kkssbbb.blogs.model.User;
import com.kkssbbb.blogs.repository.BoardRepository;
import com.kkssbbb.blogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service : 스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다(Ioc 가 되게끔)
@Service
public class BoardService {

    @Autowired  //DI를 해준다.
    private BoardRepository boardRepository;


    @Transactional // : 1트랜잭션 관리, 2서비스 의미 때문 :ex 한번에 두개의 트랜잭션션을 관할 수 있다
    public void 글쓰기(Board board, User user) {  //title, content
    board.setCount(0);
    board.setUser(user);
    boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void 글삭제하기(int id){

        boardRepository.deleteById(id);
    }

    }

