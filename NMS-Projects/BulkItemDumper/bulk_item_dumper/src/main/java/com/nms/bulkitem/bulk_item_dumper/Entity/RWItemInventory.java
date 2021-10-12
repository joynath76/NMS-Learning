package com.nms.bulkitem.bulk_item_dumper.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RWITEMINVENTORY")
public class RWItemInventory extends RWItemInventoryPK {
	@EmbeddedId
    protected RWItemInventoryPK rWItemInventoryPK;
	@Column(name = "RACK_NUMBER")
    private String rackNumber;
	public RWItemInventory() {
		super();
	}
	public RWItemInventory(String retailStoreId, String itemId) {
		super(retailStoreId, itemId);
	}
	
	public String getBuId() {
		return rWItemInventoryPK.getRetailStoreId();
	}
	
	public String getItemId() {
		return rWItemInventoryPK.getItemId();
	}
	
	public String getRackNumber() {
		return rackNumber;
	}
	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}
	
}
