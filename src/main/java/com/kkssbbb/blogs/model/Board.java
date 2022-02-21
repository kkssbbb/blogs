package com.kkssbbb.blogs.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_incremet
    private int id;

    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Lob//데용량 데이터
    private  String content; //썸머노트 라이브러리 사용해서 대용량데이터를 사용해야하는@Lob사용

    @ManyToOne // = Many : bord , One=User로 한명의 유자가 여러게의 게시글을쓸수있다는 뜻
    @JoinColumn(name="userId")
    private User user; //

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //mappedBy : 연관관계의 주인이아니다.(FK(외래키)가아니라는 소리로 db에 컬럼을 만들지 ㅁ마세요라는 뜻)
    private List<Reply> reply ;   // Reply클래스의  (mappedBy = "board") 를 폴링키로 사용

    @CreationTimestamp
    private Timestamp createDate;
}