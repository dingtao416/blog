package com.myblog.blog.Service;

import com.myblog.blog.entity.Tag;

import java.util.List;

public interface TagService {
    int savetag(Tag tag);
    void  delettag(Integer id);
    void updatetag(Tag tag);
    Tag gettagByid(Integer id);
    List<Tag> getAlltag();
}
