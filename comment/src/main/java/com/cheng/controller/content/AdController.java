package com.cheng.controller.content;

import com.cheng.dto.AdDto;
import com.cheng.service.impl.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;

/**
 * 广告模块控制层
 * Created by cheng on 2017/7/22.
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdServiceImpl adService;

    /**
     * 列表页跳转
     */
    @RequestMapping
    public String initList() {
        return "/content/adList";
    }

    /**
     * 新增页跳转
     */
    @RequestMapping(value = "/addinit", method = RequestMethod.GET)
    public String initModify() {
        return "/content/adAdd";
    }

    /**
     * 添加广告信息
     *
     * @param adDto
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add( AdDto adDto) {
        adService.add(adDto);
        return "/content/adAdd";
    }
}