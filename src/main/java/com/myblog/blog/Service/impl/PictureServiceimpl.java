package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.PictureService;
import com.myblog.blog.entity.Picture;
import com.myblog.blog.mapper.Picturemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PictureServiceimpl implements PictureService {
    @Autowired
    private Picturemapper picturemapper;
    @Override
    public List<Picture> listPicture() {
        return  picturemapper.listPicture();
    }

    @Override
    public int savePicture(Picture picture) {
        return picturemapper.savePicture(picture);
    }

    @Override
    public Picture getPicture(Long id) {
        return picturemapper.getPicture(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        return picturemapper.updatePicture(picture);
    }

    @Override
    public int deletePicture(Long id) {
        return picturemapper.deletePicture(id);
    }
}
