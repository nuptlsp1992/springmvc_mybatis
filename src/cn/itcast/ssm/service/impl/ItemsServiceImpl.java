package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public class ItemsServiceImpl implements ItemsService{
	@Autowired 
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		//通过ItemsMapperCustom来查询数据库

		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ItemsCustom itemsCustom=new ItemsCustom();
		Items items=itemsMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
		
	}
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		// TODO Auto-generated method stub
		//itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	@Override
	public void deleteItems(Integer[] items_id) throws Exception {
		// TODO Auto-generated method stub
		itemsMapperCustom.deleteItems(items_id);
	}
	

}
