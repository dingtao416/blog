package com.myblog.blog.mapper;

import com.myblog.blog.entity.Comment;
import com.myblog.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Tagmapper {

    int  saveTag(Tag tag);
    int  deleteTag(Integer id);
    int updateTag(Tag tag);
    Tag getTagById(Integer id);
    List<Tag> getAllTags();
    Tag getTagByName(String name);
}
