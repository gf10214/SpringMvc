package com.wangshuo.springMybatis.Controller;


import com.wangshuo.springMybatis.Entity.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/4/19 0019.
 */
@Controller
public class ItemsController{
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(){
        Items items_1 = new Items();
        items_1.setName("好好学习天天向上");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 我的哈哈！");
        ModelAndView modelAndView =  new ModelAndView();
        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("item", items_1);

        //指定视图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        return modelAndView;
    }
}


