package com.watermark.service;

import java.io.*;

/**
 * Created by sunnylinner on 2016/9/26.
 */
public class UploadService {

    public String uploadImage(File image, String imageFileName, String uploadPath, String realUploadPath){
        InputStream is =null;
        OutputStream os = null;

        try {
            is = new FileInputStream(image);

            boolean bool = new File(realUploadPath).mkdirs();

            os = new FileOutputStream(realUploadPath + "/" + imageFileName);

            byte[] buffer = new byte[1024];
            int len = 0;

            while((len = is.read(buffer)) > 0){
                os.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return uploadPath + "/" + imageFileName;
    }
}
