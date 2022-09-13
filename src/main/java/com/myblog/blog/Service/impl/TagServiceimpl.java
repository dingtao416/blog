package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.TagService;
import com.myblog.blog.entity.Tag;
import com.myblog.blog.mapper.Tagmapper;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceimpl implements TagService {
    @Autowired
    private  Tagmapper tagmapper;
    @Override
    public int saveTag(Tag tag) {
        return tagmapper.saveTag(tag);
    }

    @Override
    public void deleteTag(Integer id) {
        tagmapper.deleteTag(id);
    }
    @SneakyThrows
    @Override
    public int updateTag(Tag tag) {

        return tagmapper.updateTag(tag);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagmapper.getTagById(id);
    }

    @Override
    public List<Tag> getAllTag(){
        return tagmapper.getAllTags();
    }

    @Override
    public Tag getTagByName(String name) {
        return tagmapper.getTagByName(name);
    }

    @Override
    public List<Tag> findUseTag(String ids) {
        List<Integer> list = convetList(ids);
        List<Tag> useTags = tagmapper.findUseTags(list);
        return useTags;
    }
    public List<Integer> convetList(String ids)
    {
        List<Integer> l=new ArrayList<>();
        if(!"".equals(ids) && ids !=null)
        {
            String [] idArray=ids.split(",");
            for(int i=0;i<idArray.length;i++)
            {
                l.add(Integer.parseInt(idArray[i]));
            }
        }
        return  l;
    }

    @Override
    public List<Tag> getBlogTag() {
        return tagmapper.getBlogTag();
    }

    @Override
    public int FindNumOfTypes() {
        return tagmapper.FindNumOfTypes();
    }

    @Override
    public int deleteByBlogId(Integer id) {
        return tagmapper.deleteByBlogId(id);
    }
}
