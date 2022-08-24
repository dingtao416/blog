package com.myblog.blog.mapper;

import com.myblog.blog.entity.Comment;
import com.myblog.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Tagmapper {

    int  savetag(Tag tag);
    void  delettag(Integer id);
    void updatetag(Tag tag);
    Tag gettagByid(Integer id);
    List<Tag> getAlltag();

}
