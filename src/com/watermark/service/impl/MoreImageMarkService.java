package com.watermark.service.impl;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.watermark.service.MarkService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sunnylinner on 2016/9/27.
 */
public class MoreImageMarkService implements MarkService {

    @Override
    public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath) {
        String logoFileName = "logo_" + imageFileName;
        OutputStream os =null;

        String logoPath = realUploadPath + "/" + LOGO;

        try {
            Image image1 = ImageIO.read(image);

            int width = image1.getWidth(null);
            int height = image1.getHeight(null);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bufferedImage.createGraphics();

            g.drawImage(image1, 0, 0, width, height, null);

            File logo = new File(logoPath);
            Image imageLogo = ImageIO.read(logo);

            int width1 = imageLogo.getWidth(null);
            int height1 = imageLogo.getHeight(null);

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

            g.rotate(Math.toRadians(30), bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);

            int x = -width/2;
            int y = -height/2;

            while (x < width*1.5){
                while (y < height*1.5){
                    g.drawImage(imageLogo, x, y, null);

                    y +=height1 + YMOVE;
                }
                x += width1 + XMOVE;
                y = -height/2;
            }

            g.dispose();

            os = new FileOutputStream(realUploadPath + "/" + logoFileName);
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            en.encode(bufferedImage);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return uploadPath + "/" + logoFileName;
    }
}
