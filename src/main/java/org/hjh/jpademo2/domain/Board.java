package org.hjh.jpademo2.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,length = 1024)
    private String content;
    @Column(nullable = false,length = 50)
    private String writer;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date postdate;
    @ColumnDefault("0")
    private int visitcount;

}
