package com.cheng.service.impl;

import com.cheng.bean.Ad;
import com.cheng.dao.impl.AdDaoImpl;
import com.cheng.dto.AdDto;
import com.cheng.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @Value("${adImage.url}")
    private String adImageUrl;

    @Override
    //TODO 可以改成获取失败的详细信息
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
                //TODO 需要添加日志
                return false;
            }
        } else {
            return false;
        }
    }

    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result = new ArrayList<AdDto>();
        Ad condition = new Ad();
        BeanUtils.copyProperties(adDto, condition);
        List<Ad> adList = adDao.selectByPage(condition);
        for (Ad ad : adList) {
            AdDto addtoTemp = new AdDto();
            addtoTemp.setImg(adImageUrl + ad.getImgFileName());
            BeanUtils.copyProperties(ad, addtoTemp);
            result.add(addtoTemp);
        }
        return result;
    }

    //TODO 事务
    @Override
    public boolean remove(Long id) {
        return adDao.delete(id);
    }
}
