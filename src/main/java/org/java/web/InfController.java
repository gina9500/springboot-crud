package org.java.web;

import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class InfController {

    @Autowired
    private InfService infService;

 /*   @GetMapping("forward/{target}")
    public String forward(@PathVariable("target") String target){
        return "/"+target;
    }*/

    @GetMapping(value = {"init", "init/{page}", "init/{page}/{size}"})
    public String init(Model model, @PathVariable(value = "page", required = false) Integer page, @PathVariable(value = "size", required = false) Integer size) {

        if (page == null) {
            page = 1;//当前页
        }
        if (size == null) {
            size = 6;//每页6条
        }

        //计算总条数
        int count = infService.getCount();
        int MaxPage = count % size == 0 ? count / size : count / size + 1;

        List<Map> list = infService.findAll(page, size);
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("count", count);
        model.addAttribute("MaxPage", MaxPage);
        return "init";
    }

    @PostMapping("save")
    public String save(@RequestParam Map map) {
        //判断是添加还是修改
        String id = (String) map.get("id");
        if (id == null || id.equals("")) {
            //添加
            infService.save(map);
        } else {
            //修改
            infService.update(map);
        }
        return "redirect:init";
    }

    @GetMapping("update/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        Map map = infService.findById(id);
        model.addAttribute("m", map);
        return "/add";
    }

    @GetMapping("del/{id}")
    public String del(@PathVariable("id") Integer id) {
        infService.del(id);
        return "redirect:/init";
    }


}
