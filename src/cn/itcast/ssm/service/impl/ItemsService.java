package cn.itcast.ssm.service.impl;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//根据id更新商品信息
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	
	//根据id删除商品信息
	public void deleteItems(Integer[] items_id) throws Exception;
}
