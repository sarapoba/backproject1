package org.example.backproject1.board.model;

import lombok.*;

import java.util.List;

public class BoardDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Reg{
        private String title;
        private String contents;
    }

    @Getter
    @Setter
    @NoArgsConstructor   // 이걸 넣어줄려면
    @AllArgsConstructor  // 얘 까지 넣어줘야함
    @Builder
    public static class Res {
        private long idx;
        private String title;
        private String contents;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Read{
        private long idx;
        private String title;
        private String contents;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Modify {
        private String title;
        private String contents;
    }

}
