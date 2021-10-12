package com.nms.bulkitem.bulk_item_dumper.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RWInventoryDto {
	
	
	@NotNull
	private String itemId;
	@NotNull
	private String buId;
	@Pattern(regexp="^[\\w\\d-/]+")
	private String binNumber;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getBuId() {
		return buId;
	}
	public void setBuId(String buId) {
		this.buId = buId;
	}
	public String getBinNumber() {
		return binNumber;
	}
	public void setBinNumber(String binNumber) {
		this.binNumber = binNumber;
	}
	@Override
	public String toString() {
		return "RWInventoryDto [itemId=" + itemId + ", buId=" + buId + ", binNumber=" + binNumber + "]";
	}
	
}
