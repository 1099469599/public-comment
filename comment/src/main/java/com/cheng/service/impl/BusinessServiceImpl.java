package com.cheng.service.impl;

import com.cheng.bean.Business;
import com.cheng.dao.impl.BusinessDaoImpl;
import com.cheng.dto.BusinessDto;
import com.cheng.service.BusinessService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商户模块业务层实现
 * Created by cheng on 2017/7/22.
 */

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDaoImpl businessesDao;

    @Value("${businessImage.savePath}")
    private String savePath;

    @Value("${businessImage.url}")
    private String url;

    @Override
    public PageInfo<BusinessDto> searchByPage(BusinessDto businessDto) {
        Business businessTemp = new Business();
        BeanUtils.copyProperties(businessDto, businessTemp);
        List<Business> businessList = businessesDao.selectByPage(businessTemp);
        //用PageInfo对结果进行包装
        PageInfo<Business> pageInfo = new PageInfo<>(businessList);

        List<Business> businessListTemp = new ArrayList<>();
        for (Business business : businessListTemp) {
            Business businessTemp1 = new Business();
            BeanUtils.copyProperties(business, businessTemp1);
            businessListTemp.add(businessTemp1);
        }

        PageInfo<BusinessDto> list = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo,list);
        list.getList().clear();
        list.setList(new ArrayList<BusinessDto>());

        for (Business business : businessListTemp) {
            BusinessDto businessDtoTemp = new BusinessDto();
            BeanUtils.copyProperties(business, businessDtoTemp);
            list.getList().add(businessDtoTemp);
        }
        return list;
    }
}
