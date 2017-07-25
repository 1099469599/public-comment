package com.cheng.controller.api;

import com.cheng.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/7/22.
 * 大众点评api控制层
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * 首页 —— 广告（超值特惠）
     *
     * @return 超值特惠信息
     * @throws IOException
     */
    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdDto> homead() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "[{\"title\":\"暑假5折\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191639092-2000037796.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"特价出国\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191648124-298129318.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"亮亮车\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191653983-1962772127.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"学钢琴\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191700420-1584459466.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"电影\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191706733-367929553.png\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"旅游热线\",\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016191713186-495002222.png\",\"link\":\"http://www.imooc.com/wap/index\"}]";
        //字符串转json对象
        return mapper.readValue(info, new TypeReference<List<AdDto>>() {
        });
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     *
     * @param businessDto
     * @return 猜你喜欢信息
     * @throws IOException
     */
    @RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
    public BusinessListDto homelist(BusinessDto businessDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<BusinessListDto>() {
        });
    }

    /**
     * 搜索结果页 - 三个参数
     *
     * @param businessDto
     * @return 搜索结果信息
     * @throws IOException
     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<BusinessListDto>() {
        });
    }

    /**
     * 搜索结果页 - 两个参数
     *
     * @param businessDto
     * @return 搜索结果信息
     * @throws IOException
     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<BusinessListDto>() {
        });
    }

    /**
     * 详情页 - 商户信息
     *
     * @param id 商户注册id
     * @return 商户信息
     * @throws IOException
     */
    @RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") long id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<BusinessDto>() {
        });
    }

    /**
     * 详情页 - 用户评论
     *
     * @return 用户评论
     * @throws IOException
     */
    @RequestMapping(value = "/detail/comment/{page}/{id}", method = RequestMethod.GET)
    public CommentListDto detail() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<CommentListDto>() {
        });
    }

    /**
     * 订单列表
     *
     * @return 当前用户订单信息
     * @throws IOException
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String info = "";
        return mapper.readValue(info, new TypeReference<List<OrdersDto>>() {
        });
    }

    /**
     * 提交评论页
     *
     * @return 用户提交成功
     */
    @RequestMapping(value = "/submitcomment", method = RequestMethod.GET)
    public Map<String, Object> submitComment() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", "ok");
        return result;
    }
}