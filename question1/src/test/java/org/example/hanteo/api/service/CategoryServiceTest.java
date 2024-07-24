package org.example.hanteo.api.service;

import org.example.hanteo.api.service.dto.BoardResponse;
import org.example.hanteo.api.service.dto.CategoryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("카테고리 식별자로 검색이 되어야 한다")
    @Test
    void getCategoryById() throws ChangeSetPersister.NotFoundException {
        //given
            //data.sql로 대체하겠습니다.
        //when
        CategoryResponse responseById = categoryService.getCategory(1L);
        CategoryResponse responseByName = categoryService.getCategory("남자");

        //then
        assertThat(responseById).isNotNull();
        assertThat(responseByName).isNotNull();

        assertThat(responseById)
                .usingRecursiveComparison()
                .isEqualTo(responseByName);
    }

    @DisplayName("검색된 결과 값은 해당 카테고리의 하위 카테고리를 모두 담고 있어야 한다.")
    @Test
    void getCategory_should_have_childCategory() throws ChangeSetPersister.NotFoundException {
        //given
        //data.sql로 대체하겠습니다.
        //when
        CategoryResponse responseByName = categoryService.getCategory("여자");

        //then
        assertThat(responseByName).isNotNull();

        assertEquals("여자", responseByName.getName());

        assertNotNull(responseByName.getChildren());
        assertEquals(1, responseByName.getChildren().size());

        // Verify board details
        assertTrue(responseByName.getChildren().get(0).getBoards().stream().anyMatch(board -> board.getName().equals("익명게시판") && board.getId() == 6));
        assertTrue(responseByName.getChildren().get(0).getBoards().stream().anyMatch(board -> board.getName().equals("공지사항") && board.getId() == 8));
        assertTrue(responseByName.getChildren().get(0).getBoards().stream().anyMatch(board -> board.getName().equals("로제") && board.getId() == 9));
    }
}
