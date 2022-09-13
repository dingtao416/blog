package com.myblog.blog.Service;

import com.myblog.blog.entity.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);
    void  deleteTag(Integer id);
    int updateTag(Tag tag);
    Tag getTagById(Integer id);
    List<Tag> getAllTag();
    Tag getTagByName(String name);
    List<Tag> findUseTag(String ids);

    List<Tag> getBlogTag();

    int FindNumOfTypes();
    int deleteByBlogId(Integer id);
}
