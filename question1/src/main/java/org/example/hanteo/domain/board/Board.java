package org.example.hanteo.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.hanteo.domain.category.Category;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, columnDefinition = "varchar(255) comment '게시판 명'")
    private String name;

}
