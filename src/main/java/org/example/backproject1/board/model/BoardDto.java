package org.example.backproject1.board.model;

import lombok.*;

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
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Read{
        private int idx;
        private String title;
        private String contents;
    }
}
