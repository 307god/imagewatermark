package com.watermark;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunnylinner on 2016/9/25.
 */
public class WaterMarkAction extends ActionSupport{

    private File[] image;
    private String[] imageFileName;
    private String uploadPath;
    private List<PicInfo> picInfo = new ArrayList<PicInfo>();

    public String watermark() throws Exception{

        String realUploadPath = ServletActionContext.getServletContext().getRealPath(uploadPath);

        if (image != null && image.length > 0){
            for (int i = 0; i < image.length; i++){
                PicInfo pi = new PicInfo();

                pi.setImageURL(
                        new UploadService().uploadImage(image[i], imageFileName[i], uploadPath, realUploadPath)
                );

                pi.setImageURL(
                        new TextMarkService().watermark(image[i], imageFileName[i], uploadPath, realUploadPath)
                );

                pi.setImageURL(
                        new ImageMarkService().watermark(image[i], imageFileName[i], uploadPath, realUploadPath)
                );

                pi.setImageURL(
                        new MoreTextMarkService().watermark(image[i], imageFileName[i], uploadPath, realUploadPath)
                );

                pi.setImageURL(
                        new MoreImageMarkService().watermark(image[i], imageFileName[i], uploadPath, realUploadPath)
                );

                picInfo.add(pi);
            }
        }



        return SUCCESS;
    }

    public File[] getImage() {
        return image;
    }

    public void setImage(File[] image) {
        this.image = image;
    }

    public String[] getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String[] imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public List<PicInfo> getPicInfo() {
        return picInfo;
    }

    public void setPicInfo(List<PicInfo> picInfo) {
        this.picInfo = picInfo;
    }
}
