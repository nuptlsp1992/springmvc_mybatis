package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.impl.ItemsService;

@Controller
public class ItemsCustomController {
	@Autowired
	private  ItemsService itemsService;
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
		System.out.println(request.getParameter("id"));
		List<ItemsCustom> itemsList=itemsService.findItemsList(itemsQueryVo);
		//返回ModelAndView
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
	@RequestMapping("/editItems")
//	public ModelAndView editItems() throws Exception{
//		ModelAndView modelAndView=new ModelAndView();
//		ItemsCustom itemsCustom=itemsService.findItemsById(1);
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		modelAndView.setViewName("/items/editItems");
//		return modelAndView;
//	}
	//RequestParam将request的传入参数与controller方法的形参进行绑定
	//通过required属性来指定参数是否必须传入，如果设置为true而没有传入id参数则会报错
	public String editItems(Model model, Integer id) throws Exception{
		ItemsCustom itemsCustom=itemsService.findItemsById(id);
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}
	@RequestMapping("/editItemsSubmit")
//	public ModelAndView editItemsSubmit() throws Exception{
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("/success");
//		return modelAndView;
//	}
	public String editItemsSubmit(HttpServletRequest request,Integer id, ItemsCustom itemsCustom) throws Exception{
		itemsService.updateItems(id, itemsCustom);
		//return "forward:queryItems.action";
		return "success";
	}
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		//itemsService.deleteItems(items_id);
		return "success";
	}
}
