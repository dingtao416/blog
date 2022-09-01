package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.ResourceService;
import com.myblog.blog.entity.Resources;
import com.myblog.blog.mapper.Resourcemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class ResourceServiceimpl implements ResourceService {
 @Autowired
 private Resourcemapper resourcemapper;
    @Override
    public int savePicture(Resources resources) {
        return resourcemapper.saveResource(resources);
    }

    @Override
    public List<Resources> listResources() {
        return resourcemapper.listResources();
    }

    @Override
    public Resources getResource(Long id) {
        return resourcemapper.getResource(id);
    }

    @Override
    public int updateResource(Resources resources) {
        return resourcemapper.updateResource(resources);
    }

    @Override
    public void deleteResource(Long id) {
        resourcemapper.deleteResource(id);
    }

    @Override
    public void is_published(Long id) {
        resourcemapper.is_published(id);
    }

    @Override
    public int changePublished(boolean flage,Long id) {
        return resourcemapper.changePublished(flage,id);
    }

    @Override
    @Cacheable(value = "studyResource",key = "'studyResourceList'")      // redis缓存
    public List<Resources> getStudyResource(String studyResource) {
        return resourcemapper.getStudyResource(studyResource);
    }

    @Override
    @Cacheable(value = "pictureResource",key = "'pictureResourceList'")      // redis缓存
    public List<Resources> getPictureResource(String pictureResource) {
        return resourcemapper.getPictureResource(pictureResource);
    }

    @Override
    @Cacheable(value = "officeResource",key = "'officeResourceList'")      // redis缓存
    public List<Resources> getOfficeResource(String officeResource) {
        return resourcemapper.getOfficeResource(officeResource);
    }

    @Override
    @Cacheable(value = "recreationResource",key = "'recreationResourceList'")      // redis缓存
    public List<Resources> getRecreationResource(String recreationResource) {
        return resourcemapper.getRecreationResource(recreationResource);
    }

    @Override
    @Cacheable(value = "designResource",key = "'designResourceList'")      // redis缓存
    public List<Resources> getDesignResource(String designResource) {
        return resourcemapper.getDesignResource(designResource);
    }

    @Override
    @Cacheable(value = "searchResource",key = "'searchResourceList'")      // redis缓存
    public List<Resources> getSearchResource(String searchResource) {
        return resourcemapper.getSearchResource(searchResource);
    }

    @Override
    @Cacheable(value = "toolResource",key = "'toolResourceList'")      // redis缓存
    public List<Resources> getToolResource(String toolResource) {
        return resourcemapper.getToolResource(toolResource);
    }

    @Override
    public Integer getStudyResourceTotle(String studyResource) {
        return resourcemapper.getStudyResourceTotle(studyResource);
    }

    @Override
    public Integer getPictureResourceTotle(String pictureResource) {
        return resourcemapper.getPictureResourceTotle(pictureResource);
    }

    @Override
    public Integer getOfficeResourceTotle(String officeResource) {
        return resourcemapper.getOfficeResourceTotle(officeResource);
    }

    @Override
    public Integer getRecreationResourceTotle(String recreationResource) {
        return resourcemapper.getRecreationResourceTotle(recreationResource);
    }

    @Override
    public Integer getDesignResourceTotle(String designResource) {
        return resourcemapper.getDesignResourceTotle(designResource);
    }

    @Override
    public Integer getSearchResourceTotle(String searchResource) {
        return resourcemapper.getSearchResourceTotle(searchResource);
    }

    @Override
    public Integer getToolResourceTotle(String toolResource) {
        return resourcemapper.getToolResourceTotle(toolResource);
    }

}
