package com.example.matetest.repository;

import com.example.matetest.model.Author;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "select a.name as name, "
            + "sum((b.soldAmount + 0.0)/b.publishedAmount)/count(b) as rate "
            + "from Author a join Book b on b.author = a "
            + "group by a.name "
            + "order by sum((b.soldAmount + 0.0)/b.publishedAmount)/count(b) desc ")
    Object[] findMostSuccessful(PageRequest pageRequest);
}
