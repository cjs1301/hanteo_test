package org.example.hanteo.domain.category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.hanteo.domain.board.Board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, unique = true, columnDefinition = "varchar(255) comment '카테고리 명'")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_relation", joinColumns = @JoinColumn(name = "parent_idx"), inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<Category> children = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "board_id"))
    private List<Board> boards = new ArrayList<>();
}

