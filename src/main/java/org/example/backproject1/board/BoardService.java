package org.example.backproject1.board;

import lombok.RequiredArgsConstructor;
import org.example.backproject1.board.model.Board;
import org.example.backproject1.board.model.BoardDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.Reg dto){
        Board board = Board.builder()
                .title(dto.getTitle())
                .contents(dto.getContents())
                .build();

        boardRepository.save(board);
    }

}

