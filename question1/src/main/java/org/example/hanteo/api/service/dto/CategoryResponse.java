package org.example.hanteo.api.service.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.hanteo.domain.category.Category;
import org.example.hanteo.domain.board.Board;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Builder
public class CategoryResponse {
    private String name;
    @Builder.Default
    private List<ChildCategory> children = new ArrayList<>();

    @Getter
    @Builder
    @Slf4j
    public static class ChildCategory {
        private String name;
        @Builder.Default
        private List<BoardResponse> boards = new ArrayList<>();

        private static ChildCategory of(Category category) {
            return ChildCategory.builder()
                    .name(category.getName())
                    .boards(category.getBoards().stream()
                            .sorted(Comparator.comparing(Board::getId))
                            .map(BoardResponse::of).toList())
                    .build();
        }
    }

    public static CategoryResponse of(Category category){
        return CategoryResponse.builder()
                .name(category.getName())
                .children(category.getChildren().stream()
                        .sorted(Comparator.comparing(Category::getId))
                        .map(ChildCategory::of).toList())
                .build();
    }

}
