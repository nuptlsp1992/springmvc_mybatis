package cn.itcast.ssm.po;

public class ItemsQueryVo {
	private Items items;
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	//为了系统的可扩展性，对原始生成的po类进行扩展
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	private ItemsCustom itemsCustom;
}
