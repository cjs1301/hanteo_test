package org.example.hanteo.api.service.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.hanteo.domain.board.Board;

@Getter
@Builder
public class BoardResponse {
    private Long id;
    private String name;
    public static BoardResponse of(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .name(board.getName())
                .build();
    }
}
