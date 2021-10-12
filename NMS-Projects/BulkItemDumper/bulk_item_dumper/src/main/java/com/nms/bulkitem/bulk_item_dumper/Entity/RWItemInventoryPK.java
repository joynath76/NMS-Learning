/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.bulkitem.bulk_item_dumper.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sakthivel
 */
@Embeddable
public class RWItemInventoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "RETAIL_STORE_ID")
    private String retailStoreId;
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private String itemId;

    public RWItemInventoryPK() {
    }

    public RWItemInventoryPK(String retailStoreId, String itemId) {
        this.retailStoreId = retailStoreId;
        this.itemId = itemId;
    }

    public String getRetailStoreId() {
        return retailStoreId;
    }

    public void setRetailStoreId(String retailStoreId) {
        this.retailStoreId = retailStoreId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retailStoreId != null ? retailStoreId.hashCode() : 0);
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RWItemInventoryPK)) {
            return false;
        }
        RWItemInventoryPK other = (RWItemInventoryPK) object;
        if ((this.retailStoreId == null && other.retailStoreId != null) || (this.retailStoreId != null && !this.retailStoreId.equals(other.retailStoreId))) {
            return false;
        }
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RWItemInventoryPK[ retailStoreId=" + retailStoreId + ", itemId=" + itemId + " ]";
    }
    
}
