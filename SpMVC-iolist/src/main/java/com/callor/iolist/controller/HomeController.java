package com.callor.iolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.iolist.models.IolistVO;
import com.callor.iolist.persistance.IolistDao;

@Controller
public class HomeController {

	private final IolistDao iolistDao;

	public HomeController(IolistDao iolistDao) {
		this.iolistDao = iolistDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<IolistVO> ioList = iolistDao.selectAll();

		int iTotal = 0;
		int oTotal = 0;

		for (IolistVO item : ioList) {
			iTotal += item.getIprice() * item.getQuan();
			oTotal += item.getOprice() * item.getQuan();
		}

		model.addAttribute("IO_LIST", ioList);
		model.addAttribute("iTotal", iTotal);
		model.addAttribute("oTotal", oTotal);

		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "input";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(IolistVO vo, Model model) {
		try {

			int result = iolistDao.insert(vo);
			if (result > 0) {
				return "redirect:/";
			} else {
				model.addAttribute("MSG", "INSERT ERROR");
				return "input";
			}

		} catch (Exception e) {
			model.addAttribute("MSG", "INSERT SQL ERROR");
			return "input";
		}
	}
	
	/*
	 * 거래처 코드를 전달받아 거래처를 select 하고 select 한 거래처 정보를 detail 화면에서 보여주기
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("io_seq") String io_seq, Model model,
			@RequestParam(name = "msg", required = false, defaultValue = "OK") String msg) {
		IolistVO iolistVO = iolistDao.findById(io_seq);

		model.addAttribute("IOLIST", iolistVO);
		model.addAttribute("MSG", msg);
		return "detail";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("io_seq") String io_seq, Model model) {
		IolistVO iolistVO = iolistDao.findById(io_seq);
		model.addAttribute("IOLIST", iolistVO);

		return "input";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(IolistVO iolistVO) {
		int result = iolistDao.update(iolistVO);
		String retString = String.format("redirect:/detail?io_seq=%s", iolistVO.getIo_seq());
		return retString;

	}
	
	@RequestMapping(value = "/delete/{io_seq}", method = RequestMethod.GET)
	public String delete(@PathVariable("io_seq") String io_seq) {
		int result = 0;
		try {
			result = iolistDao.delete(io_seq);

		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/detail?io_seq=" + io_seq + "&msg=FK";
		}

		if (result > 0) {
			return "redirect:/";

		} else {
			return "redirect:/detail?io_seq=" + io_seq + "&msg=NOT";
		}
	}
	

}
