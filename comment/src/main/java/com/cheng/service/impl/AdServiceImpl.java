package com.cheng.service.impl;

import com.cheng.bean.Ad;
import com.cheng.dao.impl.AdDaoImpl;
import com.cheng.dto.AdDto;
import com.cheng.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 广告模块service实现类
 * Created by cheng on 2017/7/22.
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdDaoImpl adDao;

    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Override
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        ad.setTitle(adDto.getTitle());
        ad.setLink(adDto.getLink());
        ad.setWeight(adDto.getWeight());
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
            File file = new File(adImageSavePath + fileName);
            File fileFolder = new File(adImageSavePath);
            if (fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                //将spring接收的文件转移到一个文件
                adDto.getImgFile().transferTo(file);
                ad.setImgFileName(fileName);
                adDao.insert(ad);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
