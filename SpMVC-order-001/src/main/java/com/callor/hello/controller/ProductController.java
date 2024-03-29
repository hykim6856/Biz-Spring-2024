package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.CustomVO;
import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private final ProductDao productDao;

	public ProductController(ProductDao productDao) {
		this.productDao = productDao;

	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Model model) {
		List<ProductVO> productList = productDao.selectAll();
		model.addAttribute("PRODUCT_LIST", productList);
		return "product/list";
	}

//---

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "product/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ProductVO vo, Model model) {
		try {

			int result = productDao.insert(vo);
			if (result > 0) {
				return "redirect:/product";
			} else {
				model.addAttribute("MSG", "INSERT ERROR");
				return "product/input";
			}

		} catch (Exception e) {
			model.addAttribute("MSG", "INSERT SQL ERROR");
			return "product/input";
		}
	}

	/*
	 * 거래처 코드를 전달받아 거래처를 select 하고 select 한 거래처 정보를 detail 화면에서 보여주기
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("p_code") String pCode, Model model,
			@RequestParam(name = "msg", required = false, defaultValue = "OK") String msg) {
		ProductVO productVO = productDao.findById(pCode);

		model.addAttribute("CUST", productVO);
		model.addAttribute("MSG", msg);
		return "product/detail";

	}
}
