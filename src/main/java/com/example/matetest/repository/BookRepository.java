package com.example.matetest.repository;

import com.example.matetest.dto.response.SuccessfulBookResponseDto;
import com.example.matetest.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Name(String name);

    Book findFirstByOrderBySoldAmountDesc();

    Book findFirstByOrderByPublishedAmountDesc();

    List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderBySoldAmountDesc(String title);

    List<Book> findAllByAuthor_NameContainingIgnoreCaseOrderByPublishedAmountDesc(String title);

    @Query(value = "select new com.example.matetest.dto.response.SuccessfulBookResponseDto(b) "
            + "from Book b join Author a on a.id = b.author.id where a.name like :name "
            + "order by (b.soldAmount + 0.0)/b.publishedAmount desc ")
    List<SuccessfulBookResponseDto> findAllByAuthor_NameOrderByRate(String name);
}
