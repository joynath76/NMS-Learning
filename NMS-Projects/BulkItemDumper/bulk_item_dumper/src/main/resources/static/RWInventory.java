/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.bulkitem.bulk_item_dumper.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 *
 * @author sakthivel
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class RWInventory implements Serializable, RWSerializable {

    private String uom;
    @Column(name = "BAR_CODE")
    private String barCode;
    @Column(name = "PACK_SIZE")
    private Integer packSize;
    @Column(name = "MANUFACTURED_DATE")
    @Temporal(TemporalType.DATE)
    private Date manufacturedDate;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = RWDateUtil.RWDATE_PATTERN, timezone = "Asia/Calcutta")
    private Date expiryDate;
    @Column(name = "LAST_PURCHASE_SUPPLIER")
    private String lastPurchaseSupplier;
    @Column(name = "LAST_PURCHASE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPurchaseDate;
    @Column(name = "LAST_SALE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSaleDate;
    @Column(name = "LAST_PURCHASE_MARGIN")
    private BigDecimal lastPurchaseMargin;
    @Column(name = "PTR")
    private BigDecimal ptr;
    @Column(name = "AVERAGE_COST")
    private BigDecimal averageCost;
    @Column(name = "PRIMARY_EPC")
    private BigDecimal primaryEPC;
    @Column(name = "LAST_PURCHASE_COST")
    private BigDecimal lastPurchaseCost;
    @Column(name = "COST_PRICE")
    private BigDecimal costPrice;
    @Column(name = "MRP_RATE")
    private BigDecimal mrpRate;
    @Column(name = "OPEN_QTY")
    private BigDecimal openQty;
    @Column(name = "ORDER_UN_FILLED_QTY")
    private BigDecimal orderUnFilledQty;
    @Column(name = "VEND_SUPPLY_PENDING_QTY")
    private BigDecimal vendSupplyPendingQty;

    @Column(name = "RESERVED_QTY")
    private BigDecimal reservedQty;
    @Column(name = "PICKED_QTY")
    private BigDecimal pickedQty;
    @Column(name = "PACKED_QTY")
    private BigDecimal packedQty;
    @Column(name = "CUST_ORDER_QTY")
    private BigDecimal custOrderQty;
    @Column(name = "VEND_ORDER_QTY")
    private BigDecimal vendOrderQty;

    @Column(name = "RECEIVED_QTY")
    private BigDecimal receivedQty;
    @Column(name = "CUST_RETURN_QTY")
    private BigDecimal custReturnQty;
    @Column(name = "TRANSFER_IN_QTY")
    private BigDecimal transferInQty;

    @Column(name = "SALES_QTY")
    private BigDecimal salesQty;
    @Column(name = "RETURN_VENDOR_QTY")
    private BigDecimal returnVendorQty;
    @Column(name = "TRANSFER_OUT_QTY")
    private BigDecimal transferOutQty;
    @Column(name = "ADJUSTMENT_QTY")
    private BigDecimal adjustmentQty;
    @Column(name = "WASTED_QTY")
    private BigDecimal wastedQty;
    @Column(name = "AVAILABLE_QTY")
    private BigDecimal availableQty;
    @Column(name = "CURRENT_QTY")
    private BigDecimal currentQty;
    @Column(name = "REJECT_VEN_QTY")
    private BigDecimal rejectVenQty;
    @Column(name = "REJECT_CUST_QTY")
    private BigDecimal rejectCustQty;
    @Column(name = "ESTIMATE_QTY")
    private BigDecimal estimateQty;
    @Column(name = "QUOTE_QTY")
    private BigDecimal quoteQty;
    @Column(name = "MADE_QTY")
    private BigDecimal madeQty;
    @Column(name = "CONSUMED_QTY")
    private BigDecimal consumedQty;
    @Column(name = "DISPOSITION_QTY")
    private BigDecimal dispositionQty;
    @Column(name = "LOCATION_ID")
    private String locationId;
    @Column(name = "RACK_NUMBER")
    private String rackNumber;
    @Column(name = "SHELF_NUMBER")
    private String shelfNumber;
    @Column(name = "BOX_NUMBER")
    private String boxNumber;
    @Column(name = "WEIGHTED_COST_VALUATION_AMOUNT")
    private BigDecimal weightedCostValuationAmount;
    @Column(name = "CURRENT_COST_VALUATION_AMOUNT")
    private BigDecimal currentCostValuationAmount;
    @Column(name = "CURRENT_PRICE_VALUATION_AMOUNT")
    private BigDecimal currentPriceValuationAmount;
    @Column(name = "MANUFACTURER_ID")
    private String manufacturerId;
    @Column(name = "MFR_BU_ID")
    private String mfrBuId;
    private String type;
    @Column(name = "SUB_TYPE")
    private String subType;
    private String description;
    @Column(name = "WARANTY_CODE")
    private String warantyCode;
    @Column(name = "ITEM_INVENTORY_STATE_ID")
    private Integer itemInventoryStateId;
    //set true if need to create history 
    @Column(name = "HISTORY_FLAG")
    private Boolean historyFlag;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "CREATED_USER")
    private String createdUser;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;
    @Column(name = "ACTIVE_STATUS_CODE")
    private String activeStatusCode;
    @Transient
    protected RWCommonFactory factory;

    public RWInventory() {
        init();
    }

    private void init() {
        openQty = BigDecimal.ZERO;
        orderUnFilledQty = BigDecimal.ZERO;
        vendSupplyPendingQty = BigDecimal.ZERO;
        custOrderQty = BigDecimal.ZERO;
        vendOrderQty = BigDecimal.ZERO;
        reservedQty = BigDecimal.ZERO;
        receivedQty = BigDecimal.ZERO;
        custReturnQty = BigDecimal.ZERO;
        transferInQty = BigDecimal.ZERO;
        pickedQty = BigDecimal.ZERO;
        packedQty = BigDecimal.ZERO;
        salesQty = BigDecimal.ZERO;
        returnVendorQty = BigDecimal.ZERO;
        transferOutQty = BigDecimal.ZERO;
        adjustmentQty = BigDecimal.ZERO;
        wastedQty = BigDecimal.ZERO;
        availableQty = BigDecimal.ZERO;
        currentQty = BigDecimal.ZERO;
        rejectVenQty = BigDecimal.ZERO;
        rejectCustQty = BigDecimal.ZERO;
        estimateQty = BigDecimal.ZERO;
        quoteQty = BigDecimal.ZERO;
        madeQty = BigDecimal.ZERO;
        consumedQty = BigDecimal.ZERO;
        dispositionQty = BigDecimal.ZERO;

        weightedCostValuationAmount = BigDecimal.ZERO;
        currentCostValuationAmount = BigDecimal.ZERO;
        currentPriceValuationAmount = BigDecimal.ZERO;

        ptr = BigDecimal.ZERO;
        averageCost = BigDecimal.ZERO;
        lastPurchaseCost = BigDecimal.ZERO;
        costPrice = BigDecimal.ZERO;
        mrpRate = BigDecimal.ZERO;
    }

    public abstract String getBuId() ;
    public abstract String getItemId();
    
    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public void setPackSize(Integer packSize) {
        this.packSize = packSize;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLastPurchaseSupplier() {
        return lastPurchaseSupplier;
    }

    public void setLastPurchaseSupplier(String lastPurchaseSupplier) {
        this.lastPurchaseSupplier = lastPurchaseSupplier;
    }

    public BigDecimal getPtr() {
        return ptr;
    }

    public void setPtr(BigDecimal ptr) {
        this.ptr = ptr;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public Date getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(Date lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    public BigDecimal getLastPurchaseMargin() {
        return lastPurchaseMargin;
    }

    public void setLastPurchaseMargin(BigDecimal lastPurchaseMargin) {
        this.lastPurchaseMargin = lastPurchaseMargin;
    }

    public BigDecimal getLastPurchaseCost() {
        return lastPurchaseCost;
    }

    public void setLastPurchaseCost(BigDecimal lastPurchaseCost) {
        this.lastPurchaseCost = lastPurchaseCost;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getMrpRate() {
        return mrpRate;
    }

    public void setMrpRate(BigDecimal mrpRate) {
        this.mrpRate = mrpRate;
    }

    public BigDecimal getOpenQty() {
        return openQty;
    }

    public void setOpenQty(BigDecimal openQty) {
        this.openQty = openQty;
    }

    public BigDecimal getOrderUnFilledQty() {
        return orderUnFilledQty;
    }

    public void setOrderUnFilledQty(BigDecimal orderUnFilledQty) {
        this.orderUnFilledQty = orderUnFilledQty;
    }

    public BigDecimal getVendSupplyPendingQty() {
        return vendSupplyPendingQty;
    }

    public void setVendSupplyPendingQty(BigDecimal vendSupplyPendingQty) {
        this.vendSupplyPendingQty = vendSupplyPendingQty;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public BigDecimal getPickedQty() {
        return pickedQty;
    }

    public void setPickedQty(BigDecimal pickedQty) {
        this.pickedQty = pickedQty;
    }

    public BigDecimal getPackedQty() {
        return packedQty;
    }

    public void setPackedQty(BigDecimal packedQty) {
        this.packedQty = packedQty;
    }

    public BigDecimal getCustOrderQty() {
        return custOrderQty;
    }

    public void setCustOrderQty(BigDecimal custOrderQty) {
        this.custOrderQty = custOrderQty;
    }

    public BigDecimal getVendOrderQty() {
        return vendOrderQty;
    }

    public void setVendOrderQty(BigDecimal vendOrderQty) {
        this.vendOrderQty = vendOrderQty;
    }

    public BigDecimal getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(BigDecimal receivedQty) {
        this.receivedQty = receivedQty;
    }

    public BigDecimal getCustReturnQty() {
        return custReturnQty;
    }

    public void setCustReturnQty(BigDecimal custReturnQty) {
        this.custReturnQty = custReturnQty;
    }

    public BigDecimal getTransferInQty() {
        return transferInQty;
    }

    public void setTransferInQty(BigDecimal transferInQty) {
        this.transferInQty = transferInQty;
    }

    public BigDecimal getSalesQty() {
        return salesQty;
    }

    public void setSalesQty(BigDecimal salesQty) {
        this.salesQty = salesQty;
    }

    public BigDecimal getReturnVendorQty() {
        return returnVendorQty;
    }

    public void setReturnVendorQty(BigDecimal returnVendorQty) {
        this.returnVendorQty = returnVendorQty;
    }

    public BigDecimal getTransferOutQty() {
        return transferOutQty;
    }

    public void setTransferOutQty(BigDecimal transferOutQty) {
        this.transferOutQty = transferOutQty;
    }

    public BigDecimal getAdjustmentQty() {
        return adjustmentQty;
    }

    public void setAdjustmentQty(BigDecimal adjustmentQty) {
        this.adjustmentQty = adjustmentQty;
    }

    public BigDecimal getWastedQty() {
        return wastedQty;
    }

    public void setWastedQty(BigDecimal wastedQty) {
        this.wastedQty = wastedQty;
    }

    public BigDecimal getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(BigDecimal availableQty) {
        this.availableQty = availableQty;
    }

    public BigDecimal getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(BigDecimal currentQty) {
        this.currentQty = currentQty;
    }

    public BigDecimal getRejectVenQty() {
        return rejectVenQty;
    }

    public void setRejectVenQty(BigDecimal rejectVenQty) {
        this.rejectVenQty = rejectVenQty;
    }

    public BigDecimal getRejectCustQty() {
        return rejectCustQty;
    }

    public void setRejectCustQty(BigDecimal rejectCustQty) {
        this.rejectCustQty = rejectCustQty;
    }

    public BigDecimal getEstimateQty() {
        return estimateQty;
    }

    public void setEstimateQty(BigDecimal estimateQty) {
        this.estimateQty = estimateQty;
    }

    public BigDecimal getQuoteQty() {
        return quoteQty;
    }

    public void setQuoteQty(BigDecimal quoteQty) {
        this.quoteQty = quoteQty;
    }

    public BigDecimal getMadeQty() {
        return madeQty;
    }

    public void setMadeQty(BigDecimal madeQty) {
        this.madeQty = madeQty;
    }

    public BigDecimal getConsumedQty() {
        return consumedQty;
    }

    public void setConsumedQty(BigDecimal consumedQty) {
        this.consumedQty = consumedQty;
    }

    public BigDecimal getDispositionQty() {
        return dispositionQty;
    }

    public void setDispositionQty(BigDecimal dispositionQty) {
        this.dispositionQty = dispositionQty;
    }

    
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public BigDecimal getWeightedCostValuationAmount() {
        return weightedCostValuationAmount;
    }

    public void setWeightedCostValuationAmount(BigDecimal weightedCostValuationAmount) {
        this.weightedCostValuationAmount = weightedCostValuationAmount;
    }

    public BigDecimal getCurrentCostValuationAmount() {
        return currentCostValuationAmount;
    }

    public void setCurrentCostValuationAmount(BigDecimal currentCostValuationAmount) {
        this.currentCostValuationAmount = currentCostValuationAmount;
    }

    public BigDecimal getCurrentPriceValuationAmount() {
        return currentPriceValuationAmount;
    }

    public void setCurrentPriceValuationAmount(BigDecimal currentPriceValuationAmount) {
        this.currentPriceValuationAmount = currentPriceValuationAmount;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getMfrBuId() {
        return mfrBuId;
    }

    public void setMfrBuId(String mfrBuId) {
        this.mfrBuId = mfrBuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarantyCode() {
        return warantyCode;
    }

    public void setWarantyCode(String warantyCode) {
        this.warantyCode = warantyCode;
    }

    public Integer getItemInventoryStateId() {
        return itemInventoryStateId;
    }

    public void setItemInventoryStateId(Integer itemInventoryStateId) {
        this.itemInventoryStateId = itemInventoryStateId;
    }

    public Boolean getHistoryFlag() {
        return historyFlag;
    }

    public void setHistoryFlag(Boolean historyFlag) {
        this.historyFlag = historyFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public BigDecimal getPrimaryEPC() {
        return primaryEPC;
    }

    public void setPrimaryEPC(BigDecimal primaryEPC) {
        this.primaryEPC = primaryEPC;
    }

    public String getActiveStatusCode() {
        return activeStatusCode;
    }

    public void setActiveStatusCode(String activeStatusCode) {
        this.activeStatusCode = activeStatusCode;
    }
    
    public void reCalculate() {
        BigDecimal inQty = getOpenQty()
                .add(getReceivedQty())
                .add(getMadeQty())
                .add(getRejectCustQty())
                .add(getCustReturnQty())
                .add(getAdjustmentQty())
                .add(getTransferInQty());
        BigDecimal outQty = getReturnVendorQty()
                .add(getTransferOutQty())
                .add(getConsumedQty())
                .add(getSalesQty())
                .add(getRejectVenQty())
                .add(getWastedQty());
        setCurrentQty(inQty.subtract(outQty));
        setAvailableQty(getCurrentQty().subtract(getReservedQty()));
    }

    @Override
    @XmlTransient
    public RWCommonFactory getFactory() {
        return this.factory;
    }

    @Override
    public void setFactory(RWCommonFactory factory) {
        this.factory = factory;
    }

    @PrePersist
    public void prePersist() {
        setCreatedDate(new Date());
        RWCommonFactory cf = getFactory();
         if (cf != null) {
             setCreatedUser(cf.getUserID());
         }
        setHistory();
    }
    
    @PreUpdate
    public void setHistory() {
        RWCommonFactory cf = getFactory();
        if (cf != null) {
            setLastUpdateUser(cf.getUserID());
        }
        //setLastUpdateDate(new Date());
    }
    
    public abstract String getDisplayString() ;
}
