package org.example.backproject1.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder // 객체를 생성할 때 빌더 패턴을 사용할 수 있게 해줍니다. (예: Board.builder().title("제목").build())
@Getter // 모든 필드의 Getter 메서드를 자동으로 생성해줍니다. (예: getIdx(), getTitle())
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동 생성합니다.
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동 생성합니다. (JPA 엔티티는 기본 생성자가 필수입니다)
@Entity // 이 클래스가 데이터베이스의 테이블과 매핑되는 JPA 엔티티임을 명시합니다.
public class Board {

    @Id // 이 필드가 테이블의 기본키(Primary Key, PK)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 값을 데이터베이스가 자동으로 1씩 증가시키도록 설정합니다. (MySQL의 AUTO_INCREMENT)
    private Long idx; // 게시글 고유 번호

    private String title; // 게시글 제목

    private String contents; // 게시글 내용
}
