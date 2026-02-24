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

    public BoardDto.Res read(long idx){
        Board board = boardRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 번호의 게시글이 없습니다."));
        return BoardDto.Res.builder()
                .idx(board.getIdx())
                .title(board.getTitle())
                .contents(board.getContents())
                .build();
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

