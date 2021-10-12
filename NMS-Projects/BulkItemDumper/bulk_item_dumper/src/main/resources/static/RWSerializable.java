/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nms.bulkitem.bulk_item_dumper.Entity;

import java.io.Serializable;

/**
 *
 * @author vino
 */
public abstract interface RWSerializable extends Serializable {
      public void setFactory(RWCommonFactory factory);
      public RWCommonFactory getFactory();
}
