/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.bulkitem.bulk_item_dumper.Entity;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakthivel
 */
@Entity
@Table(name = "RWITEMINVENTORY")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "RWItemInventory.findByPrimaryKey", query = "SELECT r FROM RWItemInventory r where r.rWItemInventoryPK.retailStoreId = :buId and r.rWItemInventoryPK.itemId = :itemId"),
//    @NamedQuery(name = "RWItemInventory.findByBuIdAndItemIds", query = "SELECT r FROM RWItemInventory r where r.rWItemInventoryPK.retailStoreId = :buId and r.rWItemInventoryPK.itemId IN :itemIds"),
//    @NamedQuery(name = "RWItemInventory.findItemIdByLastUpdateTimeHistoryFlag", query = "SELECT r.rWItemInventoryPK.itemId FROM RWItemInventory r where r.lastUpdateDate < :lastUpdateDate and r.historyFlag = TRUE and r.rWItemInventoryPK.retailStoreId = :buId"),
//    @NamedQuery(name = "RWItemInventory.findPackageItemStocks", query = "SELECT r.rWItemInventoryPK.itemId, r.currentQty, r.rWItemInventoryPK.retailStoreId FROM RWItemInventory r where r.rWItemInventoryPK.retailStoreId IN :retailStoreIds and r.currentQty > 0"),
//    @NamedQuery(name = "RWItemInventory.findUpdatedPackageItemStocks", query = "SELECT r.rWItemInventoryPK.itemId, r.currentQty, r.rWItemInventoryPK.retailStoreId FROM RWItemInventory r where r.rWItemInventoryPK.retailStoreId IN :retailStoreIds and r.lastUpdateDate >= :lastUpdateDate"),
//    @NamedQuery(name = "RWItemInventory.findByBuId", query = "SELECT r FROM RWItemInventory r where r.rWItemInventoryPK.retailStoreId = :buId")
//})
public class RWItemInventory extends RWItemInventory{

//    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected RWItemInventoryPK rWItemInventoryPK;
//    @Column(name = "SHORT_EXP_QTY")
//    private BigDecimal shortExpQty;
//    @Column(name = "EXPIRED_QTY")
//    private BigDecimal expiredQty;
//
//    public RWItemInventory() {
//        super();
//        this.rWItemInventoryPK = new RWItemInventoryPK();
//    }
//
//    public RWItemInventory(RWItemInventoryPK rWItemInventoryPK) {
//        super();
//        this.rWItemInventoryPK = rWItemInventoryPK;
//    }
//
//    public RWItemInventory(String retailStoreId, String itemId) {
//        super();
//        this.rWItemInventoryPK = new RWItemInventoryPK(retailStoreId, itemId);
//        shortExpQty = BigDecimal.ZERO;
//        expiredQty = BigDecimal.ZERO;
//    }
//
//    @XmlTransient
//    public RWItemInventoryPK getRWItemInventoryPK() {
//        return rWItemInventoryPK;
//    }
//
//    @Override
//    public String getBuId() {
//        return getRWItemInventoryPK().getRetailStoreId();
//    }
//
//    public void setBuId(String buId) {
//        this.getRWItemInventoryPK().setRetailStoreId(buId);
//    }
//
//    @Override
//    public String getItemId() {
//        return getRWItemInventoryPK().getItemId();
//    }
//
//    public void setItemId(String itemId) {
//        this.getRWItemInventoryPK().setItemId(itemId);
//    }
//
//    public BigDecimal getShortExpQty() {
//        return shortExpQty;
//    }
//
//    public void setShortExpQty(BigDecimal shortExpQty) {
//        this.shortExpQty = shortExpQty;
//    }
//
//    public BigDecimal getExpiredQty() {
//        return expiredQty;
//    }
//
//    public void setExpiredQty(BigDecimal expiredQty) {
//        this.expiredQty = expiredQty;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (rWItemInventoryPK != null ? rWItemInventoryPK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof RWItemInventory)) {
//            return false;
//        }
//        RWItemInventory other = (RWItemInventory) object;
//        if ((this.rWItemInventoryPK == null && other.rWItemInventoryPK != null) || (this.rWItemInventoryPK != null && !this.rWItemInventoryPK.equals(other.rWItemInventoryPK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "RWItemInventory[ rWItemInventoryPK=" + rWItemInventoryPK + " ]";
//    }
//
//    public RWItemInventory findByPrimaryKey(RWCommonFactory cf, String buId, String itemId) {
//        Query q = cf.createNamedQuery("RWItemInventory.findByPrimaryKey");
//        q.setHint("javax.persistence.cache.storeMode", "REFRESH");
//        q.setParameter("buId", buId);
//        q.setParameter("itemId", itemId);
//        return (RWItemInventory) cf.getSingleResult(q);
//    }
//
//	@Override
//    public String getDisplayString() {
//        return "ItemInventory[Bu:"+getBuId()+",ItemId:"+getItemId()+"]";
//    }
}
