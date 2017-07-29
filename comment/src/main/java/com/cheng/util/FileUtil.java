package com.cheng.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 * Created by cheng on 2017/7/22.
 */

public class FileUtil {

    /**
     * 将MultipartFile保存到指定的路径下
     *
     * @param file     Spring的MultipartFile对象
     * @param savePath 保存路径
     * @return 保存的文件名，当返回NULL时保存失败
     * @throws IOException
     */
    public static String save(MultipartFile file, String savePath) throws IOException {
        if (file != null && file.getSize() > 0) {
            File fileFolder = new File(savePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            File saveFile = getFile(savePath, file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile.getName();
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 是否删除成：true-删除成功;false-删除失败
     */
    public static boolean delete(String filePath) {
        File file = new File(filePath);
        if (file.isFile()) {
            file.delete();
            return true;
        }
        return false;
    }

    /**
     * 返回文件保存路径
     *
     * @param savePath         保存路径
     * @param originalFilename 文件名
     * @return 文件保存路径
     */
    private static File getFile(String savePath, String originalFilename) {
        String filename = System.currentTimeMillis() + "_" + originalFilename;
        File file = new File(savePath + filename);
        if (file.exists()) {
            //如果文件存在,则重新调用该方法，生成新文件
            return getFile(savePath, originalFilename);
        }
        return file;
    }
}
