package com.woniuxy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService {
    @Autowired
    BookTypeMapper bookTypeMapper;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public List<BookType> getAll(){
        ValueOperations<String,Object> opsForValue = redisTemplate.opsForValue();
        Object booktypesDemo = opsForValue.get("booktypesDemo");
        List<BookType> booktypesList = null;

        if(booktypesDemo == null){
            System.out.println("从数据库查询");
            booktypesList = bookTypeMapper.selectList(null);
            opsForValue.set("booktypesDemo",booktypesList);
        }else {
            System.out.println("直接返回结果");
            booktypesList = (List<BookType>)booktypesDemo;
        }
        return booktypesList;
    }
}
