package com.wangshuo.springMybatis.Controller;
import com.google.common.collect.Lists;
import common.mapper.JsonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
@Controller
public class EchartController {
    @RequestMapping("/echart")
    public ModelAndView queryItems(){
        List<String> month= Lists.newArrayList();
        List<Integer> zfl=Lists.newArrayList();
        List<Integer> jyl=Lists.newArrayList();
        for(int i=1;i<13;i++){
            month.add(i+"月");
            zfl.add(i*5);
            jyl.add(i+10);
        }
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("month", JsonMapper.getInstance().toJson(month));
        modelAndView.addObject("zfl", JsonMapper.getInstance().toJson(zfl));
        modelAndView.addObject("jyl", JsonMapper.getInstance().toJson(jyl));
        //指定视图
        modelAndView.setViewName("/WEB-INF/views/moudels/echarts.jsp");
        return modelAndView;
    }
}
