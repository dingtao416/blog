package com.myblog.blog.Service;

import com.myblog.blog.entity.Picture;

import java.util.List;

public interface PictureService {
    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    int updatePicture(Picture picture);

    //删除照片
    int deletePicture(Long id);
}
