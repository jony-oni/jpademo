package org.hjh.jpademo2.service;

import org.hjh.jpademo2.domain.Board;
import org.hjh.jpademo2.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    Board getBoard(Long bno);
    void saveBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long bno);

}
