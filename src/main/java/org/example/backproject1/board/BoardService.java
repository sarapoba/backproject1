package org.example.backproject1.board;

import lombok.RequiredArgsConstructor;
import org.example.backproject1.board.model.Board;
import org.example.backproject1.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public List<BoardDto.Read> list() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto.Read> dtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardDto.Read dto = BoardDto.Read.builder()
            .idx(board.getIdx())
                    .title(board.getTitle())
                    .contents(board.getContents())
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }
}

