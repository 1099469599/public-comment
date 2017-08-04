package com.cheng.service.impl;

import com.cheng.bean.Business;
import com.cheng.constant.CategoryConst;
import com.cheng.dao.BusinessDao;
import com.cheng.dao.impl.BusinessDaoImpl;
import com.cheng.dto.BusinessDto;
import com.cheng.dto.BusinessListDto;
import com.cheng.service.BusinessService;
import com.cheng.util.CommonUtil;
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
 * 商户模块业务层实现
 * Created by cheng on 2017/7/22.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDaoImpl businessDao;

    @Value("${businessImage.savePath}")
    private String businessImgSavePath;

    @Value("${businessImage.url}")
    private String businessImgUrl;

    @Override
    public PageInfo<BusinessDto> searchByPage(BusinessDto businessDto) {
        Business businessTemp = new Business();
        BeanUtils.copyProperties(businessDto, businessTemp);
        List<Business> businessList = businessDao.selectByPage(businessTemp);
        //用PageInfo对结果进行包装
        PageInfo<Business> pageInfo = new PageInfo<>(businessList);

        List<Business> businessListTemp = new ArrayList<>();
        for (Business business : businessList) {
            Business businessTemp1 = new Business();
            BeanUtils.copyProperties(business, businessTemp1);
            businessListTemp.add(businessTemp1);
        }

        PageInfo<BusinessDto> list = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, list);
        list.getList().clear();
        list.setList(new ArrayList<BusinessDto>());

        for (Business business : businessListTemp) {
            BusinessDto businessDtoTemp = new BusinessDto();
            BeanUtils.copyProperties(business, businessDtoTemp);
            list.getList().add(businessDtoTemp);
            businessDtoTemp.setImg(businessImgUrl + business.getImgFileName());
            businessDtoTemp.setStar(this.getStar(business));
        }
        return list;
    }

    @Override
    public BusinessListDto searchByPageForApi(BusinessDto businessDto) {
        BusinessListDto result = new BusinessListDto();
        //组织查询条件
        Business businessForSelect = new Business();
        BeanUtils.copyProperties(businessDto, businessForSelect);
        //当关键字不为空时，把关键字的值分别设置到标题、副标题、描述中
        //TODO 改进做法：全文检索
        if (!CommonUtil.isEmpty(businessDto.getKeyword())) {
            businessForSelect.setTitle(businessDto.getKeyword());
            businessForSelect.setSubtitle(businessDto.getKeyword());
            businessForSelect.setDesc(businessDto.getKeyword());
        }
        //当类别为全部(all)时，需要将类别清空，不作为过滤条件
        if (businessDto.getCategory() != null && CategoryConst.ALL.equals(businessDto.getCategory())) {
            businessForSelect.setCategory(null);
        }
        //前端app页码从0开始计算，这里需要+1
        int pageNum = businessForSelect.getPage().getPageNum();
        businessForSelect.getPage().setPageNum(pageNum + 1);

        List<Business> list = businessDao.selectLikeByPage(businessForSelect);

        //经过查询后根据pageInfo对象设置hasMore
        PageInfo<Business> pageInfo = new PageInfo<>(list);
        result.setHasMore(pageInfo.getPageNum() < pageInfo.getPages());

        //对查询出的结果进行格式化
        for (Business business : list) {
            BusinessDto businessDtoTemp = new BusinessDto();
            result.getData().add(businessDtoTemp);
            BeanUtils.copyProperties(business, businessDtoTemp);
            businessDtoTemp.setImg(businessImgUrl + business.getImgFileName());
            //为兼容前端mumber这个属性
            businessDtoTemp.setMumber(business.getNumber());
            businessDtoTemp.setStar(this.getStar(business));
        }
        return result;
    }

    @Override
    public boolean remove(Long id) {
        Business business = businessDao.selectById(id);
        String path = businessImgSavePath + business.getImgFileName();
        if (businessDao.delete(id)) {
            FileUtil.delete(path);
            return true;
        }
        return false;
    }

    @Override
    public BusinessDto getById(Long id) {
        BusinessDto result = new BusinessDto();
        Business business = businessDao.selectById(id);
        BeanUtils.copyProperties(business, result);

        result.setImg(businessImgUrl + business.getImgFileName());
        result.setStar(this.getStar(business));
        return result;
    }

    @Override
    public boolean modify(BusinessDto businessDto) {
        Business business = new Business();
        BeanUtils.copyProperties(businessDto, business);
        String filename = null;
        if (businessDto.getImgFile() != null && businessDto.getImgFile().getSize() > 0) {
            try {
                filename = FileUtil.save(businessDto.getImgFile(), businessImgSavePath);
                business.setImgFileName(filename);
            } catch (IOException e) {
                return false;
            }
        }
        int updateCount = businessDao.update(business);
        if (updateCount != 1) {
            return false;
        }
        if (filename != null) {
            FileUtil.delete(businessImgSavePath + businessDto.getImgFileName());
        }
        businessDto.setImgFileName(filename);
        return true;
    }

    @Override
    public boolean add(BusinessDto businessDto) {
        Business business = new Business();
        BeanUtils.copyProperties(businessDto, business);
        try {
            String filename = FileUtil.save(businessDto.getImgFile(), businessImgSavePath);
            business.setImgFileName(filename);
            return businessDao.insert(business);
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 获得商户星级
     *
     * @param business 商户
     * @return 星级
     */
    private int getStar(Business business) {
        if (business.getStarTotalNum() != null && business.getCommentTotalNum() != null
                && business.getCommentTotalNum() != 0) {
            return (int) (business.getStarTotalNum() / business.getCommentTotalNum());
        } else {
            return 0;
        }
    }
}
