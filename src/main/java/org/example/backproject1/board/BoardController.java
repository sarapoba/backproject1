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

    @PutMapping("/update/{idx}")
    public ResponseEntity update(@PathVariable long idx, @RequestBody BoardDto.Modify dto){
        boardService.update(idx, dto);

        return ResponseEntity.ok("게시글 수정이 완료되었습니다.");
    }

    @DeleteMapping("/delete/{idx}")
    public ResponseEntity delete(@PathVariable long idx){
        boardService.delete(idx);

        return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다");
    }
}
