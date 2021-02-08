package com.Danny.Mall.controller;

import com.Danny.Mall.common.api.CommonPage;
import com.Danny.Mall.common.api.CommonResult;
import com.Danny.Mall.mbg.model.PmsBrand;
import com.Danny.Mall.service.PmsBrandService;
import com.Danny.Mall.service.impl.PmsBrandServericeImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*   品牌管理controller
 *

**/

@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/crate",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id,
                                    @RequestBody PmsBrand pmsBrand,
                                    BindingResult result) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id,pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}",pmsBrand);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        CommonResult commonResult;
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            commonResult = CommonResult.success(id);
            LOGGER.debug("deleteBrand success:id={}",id);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("deleteBrand failed:id={}",id);
        }
        return commonResult;
    }


    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNumber,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }


    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }

}
