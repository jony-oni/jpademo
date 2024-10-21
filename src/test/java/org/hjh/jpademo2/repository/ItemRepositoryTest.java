package org.hjh.jpademo2.repository;

import lombok.extern.log4j.Log4j2;
import org.hjh.jpademo2.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;
    @Test
    public void testInsert() {
        Item item = new Item();
        item.setItemNn("Banana");
        item.setItemDetail("Good");
        item.setPrice(3200);
        item.setStockNumber(11);
        itemRepository.save(item);
    }
    @Test
    public void findAllTest(){
        List<Item> items = itemRepository.findAll();
        for(Item item : items){
            log.info(item.toString());
        }
    }
    @Test
    public void updateTest(){
        Item item = itemRepository.findById(1l).get();
        item.setItemNn("Mango");
        item.setPrice(5000);
        item.setStockNumber(15);
        log.info(item.toString());
    }
}
