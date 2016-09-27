package com.watermark;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sunnylinner on 2016/9/26.
 * 创建图片缓存对象
 * 创建java绘图工具
 * 使用绘图工具对象将原图绘制到缓存图片对象
 * 使用绘图工具对象将水印（文字图片）绘制到缓存图片
 * 创建图片编码工具类
 * 使用图像编码工具类，输出缓存图像到目标文件
 */
public class TextMarkService implements MarkService{

    @Override
    public String watermark(File image, String imageFileName,
                            String uploadPath, String realUploadPath) {
        String logoFileName = "logo_" + imageFileName;
        OutputStream os =null;

        try {
            Image image1 = ImageIO.read(image);

            int width = image1.getWidth(null);
            int height = image1.getHeight(null);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bufferedImage.createGraphics();

            g.drawImage(image1, 0, 0, width, height, null);
            g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
            g.setColor(FONT_COLOR);

            int width1 = FONT_SIZE*getTextLength(MARK_TEXT);
            int height1 = FONT_SIZE;

            int widthDiff = width - width1;
            int heightDiff = height - height1;

            int x = X;
            int y = Y;

            if (x > widthDiff){
                x = widthDiff;
            }

            if (x > heightDiff){
                y = heightDiff;
            }

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));

            g.drawString(MARK_TEXT, x, y + FONT_SIZE);
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

    private int getTextLength(String text){
        int length = text.length();

        for(int i = 0; i < text.length(); i++){
            String s = String.valueOf(text.charAt(i));
            if (s.getBytes().length > 1){
                length++;
            }
        }

        length = length%2==0 ? length/2: length/2+1;
        return length;
    }
}
