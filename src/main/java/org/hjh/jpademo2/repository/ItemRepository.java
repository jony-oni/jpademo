package org.hjh.jpademo2.repository;

import org.hjh.jpademo2.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
