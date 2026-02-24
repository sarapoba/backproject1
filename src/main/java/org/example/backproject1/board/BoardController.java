package org.example.backproject1.board;

import lombok.RequiredArgsConstructor;
import org.example.backproject1.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5174")
public class BoardController {
    private final BoardService boardService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody BoardDto.Reg dto){
        boardService.register(dto);
        return ResponseEntity.ok("게시글이 성공적으로 등록");

    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable int idx){
        BoardDto.Res dto = boardService.read(idx);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
    List<BoardDto.Read> dto = boardService.list();
    return ResponseEntity.ok(dto);
    }

}
