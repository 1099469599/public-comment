package com.cheng.service.impl;

import com.cheng.bean.Ad;
import com.cheng.dao.impl.AdDaoImpl;
import com.cheng.dto.AdDto;
import com.cheng.service.AdService;
import com.cheng.util.FileUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告模块业务层实现
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
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            try {
                Ad ad = new Ad();
                ad.setTitle(adDto.getTitle());
                ad.setLink(adDto.getLink());
                ad.setWeight(adDto.getWeight());
                String fileName = FileUtil.save(adDto.getImgFile(), adImageSavePath);

                ad.setImgFileName(fileName);
                adDao.insert(ad);
                return true;
            } catch (IOException e) {
                //TODO 需要添加日志
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public PageInfo<AdDto> searchByPage(AdDto adDto) {
        Ad adTemp = new Ad();
        BeanUtils.copyProperties(adDto, adTemp);
        List<Ad> adList = adDao.selectByPage(adTemp);
        //用PageInfo对结果进行包装
        PageInfo<Ad> pageInfo = new PageInfo<>(adList);

        List<Ad> adListTemp = new ArrayList<>();
        for (Ad ad : adList) {
            Ad adTemp2 = new Ad();
            BeanUtils.copyProperties(ad, adTemp2);
            adListTemp.add(adTemp2);
        }

        PageInfo<AdDto> list = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, list);
        list.getList().clear();
        list.setList(new ArrayList<AdDto>());

        for (Ad ad : adListTemp) {
            AdDto adDtoTemp = new AdDto();
            BeanUtils.copyProperties(ad, adDtoTemp);
            adDtoTemp.setImg(adImageUrl + ad.getImgFileName());
            list.getList().add(adDtoTemp);
        }
        return list;
    }

    //TODO 事务
    @Override
    public boolean remove(Long id) {
        Ad ad = adDao.selectById(id);
        String path = adImageSavePath + ad.getImgFileName();
        if (adDao.delete(id)) {
            FileUtil.delete(path);
            return true;
        }
        return false;
    }

    @Override
    public AdDto getById(Long id) {
        Ad ad = adDao.selectById(id);
        AdDto adDto = new AdDto();
        BeanUtils.copyProperties(ad, adDto);
        adDto.setImg(adImageUrl + ad.getImgFileName());
        return adDto;
    }

    @Override
    public boolean modify(AdDto adDto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto, ad);
        String fileName = null;
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            try {
                fileName = FileUtil.save(adDto.getImgFile(), adImageSavePath);
                ad.setImgFileName(fileName);

            } catch (IOException e) {
                return false;
            }
        }
        int updateCount = adDao.update(ad);
        if (updateCount != 1) {
            return false;
        }
        if (fileName != null) {
            FileUtil.delete(adImageSavePath + adDto.getImgFileName());
        }
        adDto.setImgFileName(fileName);
        return true;
    }
}
