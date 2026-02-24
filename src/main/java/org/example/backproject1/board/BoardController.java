package org.example.backproject1.board;

import lombok.RequiredArgsConstructor;
import org.example.backproject1.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BoardController {
    private final BoardService boardService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody BoardDto.Reg dto){
        boardService.register(dto);
        return ResponseEntity.ok("게시글이 성공적으로 등록");

    }
}
