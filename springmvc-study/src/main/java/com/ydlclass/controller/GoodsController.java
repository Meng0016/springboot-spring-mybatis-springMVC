package com.ydlclass.controller;

import com.ydlclass.common.R;
import com.ydlclass.entity.po.GoodsPo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Controller*/
@RestController  //用这个 就不用在下面写ResponseBody了
@RequestMapping("goods")
@CrossOrigin(origins = "*",maxAge = 1000)
public class GoodsController {

    //根据ID获取商品  /goods/1
   /* @ResponseBody*/
    @GetMapping("{id}")
    public R getoneGoods(@PathVariable Integer id){

        //省略查询过程
        return R.success(new GoodsPo("肥皂", 1235));
    }

    //根据获取商品
   /* @ResponseBody*/
    @GetMapping
    public R getAllGoods(){

        List<GoodsPo> goodsPos = List.of(new GoodsPo("肥皂", 1235), new GoodsPo("干脆哥", 555));
        //省略查询过程
        return R.success(goodsPos);

    }

    //新增商品
   /* @ResponseBody*/
    @PostMapping
    public R insert(GoodsPo goodsPo){

        //省略过程
        return R.success();
    }


    //修改
    /*@ResponseBody*/
    @PutMapping
    public R Update(@RequestBody GoodsPo goodsPo){

        //省略过程
        return R.success();
    }

    //删除
    /*@ResponseBody*/
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        //省略过程
        return "操作成功";
    }
}
