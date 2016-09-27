package com.watermark;

import java.awt.*;
import java.io.File;

/**
 * Created by sunnylinner on 2016/9/26.
 */
public interface MarkService {
    public static final String MARK_TEXT = "慕课网";

    public static final String FONT_NAME = "微软雅黑";
    public static final int FONT_STYLE = Font.BOLD;
    public static final int FONT_SIZE = 120;
    public static final Color FONT_COLOR = Color.BLACK;

    public static final int X = 10;
    public static final int Y = 10;

    public static final float ALPHA = 0.3F;

    public static final String LOGO = "logo.jpg";

    public static final int XMOVE=150;
    public static final int YMOVE=200;

    public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath);
}