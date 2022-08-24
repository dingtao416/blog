package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.TagService;
import com.myblog.blog.entity.Tag;
import com.myblog.blog.mapper.Tagmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class TagServiceimpl implements TagService {
@Autowired
    private  Tagmapper tagmapper;
    @Transactional
    @Override
    public int savetag(Tag tag) {
         tagmapper.savetag(tag);
        return 0;
    }

    @Override
    public void delettag(Integer id) {
     tagmapper.delettag(id);
    }
    @Transactional
    @Override
    public void updatetag(Tag tag) {
    tagmapper.updatetag(tag);
    }

    @Override
    public Tag gettagByid(Integer id) {
        return tagmapper.gettagByid(id);
    }

    @Override
    public List<Tag> getAlltag() {
       return tagmapper.getAlltag();
    }
}
