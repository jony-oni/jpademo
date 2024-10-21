package org.hjh.jpademo2.repository;

import org.hjh.jpademo2.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
