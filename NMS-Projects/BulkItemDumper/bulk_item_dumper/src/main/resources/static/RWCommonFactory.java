/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.bulkitem.bulk_item_dumper.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retailwave.rwos.dal.how.RWTagDefinition;
import com.retailwave.rwos.dal.how.RWTaxGroupCodeSet;
import com.retailwave.rwos.dal.how.RWCommonCodeSet;
import com.retailwave.rwos.dal.how.RWUOMCodeSet;
import com.retailwave.rwos.dal.how.RWClassificationCodeSet;
import com.retailwave.rwos.dal.exceptions.RWNullPointerException;
import com.retailwave.rwos.dal.exceptions.RWTxnException;
import com.retailwave.rwos.dal.exceptions.RWValidationException;
import com.retailwave.rwos.dal.how.IdGen;
import com.retailwave.rwos.dal.how.RWCodeSet;
import com.retailwave.rwos.dal.how.RWIdGen;
import com.retailwave.rwos.dal.party.RWBusinessUnit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author vino
 */
public class RWCommonFactory implements Serializable {

    //private transient HashMap userSession;
    private transient EntityManager manager;
    private transient String userID;
    private static final Short TRUE_FLAG_SHORT = 1;
    private static final Short FALSE_FLAG_SHORT = 0;

    //private static final Logger log = LoggerFactory.getLogger(RWCommonFactory.class);

    public RWCommonFactory(EntityManager mngr) {
      //  userSession = new HashMap();
        this.manager = mngr;
    }

    public RWCommonFactory(EntityManager mngr, String userID) {
        this(mngr);
        this.userID = userID;
    }

    public Date formatToDate(String val) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        return format.parse(val);
    }

    public String formatToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        return format.format(date);

    }

    public void setUserID(String user) {
        this.userID = user;
    }

    public String getUserID() {
        return userID == null ? "RwAdmin" : userID;
    }

    public void setEntityManager(EntityManager mngr) {
        this.manager = mngr;
    }

    @XmlTransient
    @JsonIgnore
    public EntityManager getEntityManager() {
        return manager;
    }

//    public void setUserSession(HashMap ses) {
//        this.userSession = ses;
//    }
//
//    public HashMap getUserSession() {
//        return userSession;
//    }

    public RWClassificationCodeSet getClassificationCodeSet(String name, String value) {
        Query query = manager.createNamedQuery(RWClassificationCodeSet.FIND_CODE_NAME_CODE_VALUE);
        query.setParameter("codeName", name);
        query.setParameter("codeValue", value);
        List resultList = query.getResultList();
        return resultList.isEmpty() ? null : (RWClassificationCodeSet) resultList.get(0);
    }

    public RWCommonCodeSet getCommonCodeSet(String name, String value) {
        Query query = manager.createNamedQuery(RWCommonCodeSet.FIND_CODE_NAME_CODE_VALUE);
        query.setParameter("codeName", name.trim());
        query.setParameter("codeValue", value.trim());
        List l = query.getResultList();
        if (l.isEmpty()) {
            return null;
        } else {
            return (RWCommonCodeSet) l.get(0);
        }
    }

    public RWTaxGroupCodeSet getTaxCodeset(String name, String value) {
        Query query = manager.createNamedQuery(RWCommonCodeSet.FIND_CODE_NAME_CODE_VALUE);
        query.setParameter("codeName", name);
        query.setParameter("codeValue", value);
        List l = query.getResultList();
        if (l.isEmpty()) {
            return null;
        } else {
            return (RWTaxGroupCodeSet) l.get(0);
        }
    }

    public Object getDBObject(Class className, String queryStr, String queryName, Object keyParam) {
        Query query = manager.createNamedQuery(queryStr);
        query.setParameter(queryName, keyParam);
        List l = query.getResultList();
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public Object getDBObjectWithoutNull(Class className, String queryStr, String queryName, Object keyParam) throws RWNullPointerException {
        Query query = manager.createNamedQuery(queryStr);
        query.setParameter(queryName, keyParam);
        List l = query.getResultList();
        if (l.isEmpty()) {
            throw new RWNullPointerException(className.getName() + ":" + keyParam + " OBJ NOT FOUND IN DB");
        } else {
            return l.get(0);
        }
    }

    public Object getDBObjectWithoutNull(Class className, String queryStr, String[] queryName, Object[] keyParam) throws RWNullPointerException {
        Query query = manager.createNamedQuery(queryStr);
        for (int i = 0; i < queryName.length; i++) {
            query.setParameter(queryName[i], keyParam[i]);
        }
        List l = query.getResultList();
        if (l.isEmpty()) {
            throw new RWNullPointerException(className.getName() + ":" + keyParam + " OBJ NOT FOUND IN DB");
        } else {
            return l.get(0);
        }
    }

    public RWTagDefinition getTagDefination(String tagName) {
        Query query = manager.createNamedQuery(RWTagDefinition.FIND_BY_TAG_NAME);
        query.setParameter("tagName", tagName);
        List l = query.getResultList();
        if (l.isEmpty()) {
            Query query1 = manager.createNamedQuery(RWTagDefinition.FIND_BY_TAG_NAME);
            query1.setParameter("tagName", tagName.toUpperCase());
            l = query1.getResultList();
            if (l.isEmpty()) {
                return null;
            }
        }
        return (RWTagDefinition) l.get(0);
    }

    public RWTagDefinition getTagDefination(String tagName, String tagCategory) {
        Query query = manager.createNamedQuery(RWTagDefinition.FIND_BY_NAME_AND_TAG_CATEGORY);
        query.setParameter("tagName", tagName.toUpperCase());
        query.setParameter("tagCategory", tagCategory);
        List l = query.getResultList();
        if (l.isEmpty()) {
            return null;
        } else {
            return (RWTagDefinition) l.get(0);
        }
    }

    public RWUOMCodeSet getUOMCode(String name, String value) {
        Query query = manager.createNamedQuery(RWUOMCodeSet.FIND_CODE_NAME_CODE_VALUE);
        query.setParameter("codeName", name);
        query.setParameter("codeValue", value);
        List l = query.getResultList();
        if (l.isEmpty()) {
            return null;
        } else {
            return (RWUOMCodeSet) l.get(0);
        }
    }

    public void save(RWSerializable obj) {
        obj.setFactory(this);
        manager.persist(obj);
    }

    public void commit() {
        manager.getTransaction().commit();
    }

    public boolean rollback() {
        if (manager.getTransaction().isActive()) {
            manager.getTransaction().rollback();
            return true;
        }
        return false;
    }

    public void begin() {
        if (!manager.getTransaction().isActive()) {
            manager.getTransaction().begin();
        }
    }

    public void close() {
        manager.close();
    }

    public void update(RWSerializable obj) {
        obj.setFactory(this);
        manager.persist(obj);
    }

    public void remove(RWSerializable obj) {
        manager.remove(obj);
    }

    public Object getObj(Class c, String id) {
        Object obj = manager.find(c, id);
        return obj;
    }

    public Object getObj(Class c, int id) {
        Object obj = manager.find(c, id);
        return obj;
    }

    public static Object getObj(EntityManager manager, Class c, int id) {
        Object obj = manager.find(c, id);
        return obj;
    }

    public List findEntityList(String queryName, String[] fieldNames, Object[] fieldValues) {
        Query q = getProcessedQuery(queryName, fieldNames, fieldValues);
        return q != null ? q.getResultList() : null;
    }

    public Object findEntity(String queryName, String[] fieldNames, Object[] fieldValues) {
        Query q = getProcessedQuery(queryName, fieldNames, fieldValues);
        List list = q.getResultList();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public RWSerializable getSingleResultIfFound(Query processedQuery) {
        List list = processedQuery.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            throw new RWValidationException(RWStatus.INVALID_DATA, "", "", "SingleResultIfFound query retrives more than one result");
        }
        return (RWSerializable) list.get(0);
    }

    public Object getSingleResult(Query processedQuery) {
        try {
            return processedQuery.getSingleResult();
        } catch (NoResultException ee) {
            return null;
        } catch (NonUniqueResultException ee) {
            throw ee;
        }
    }

    private Query getProcessedQuery(String queryName, String[] fieldNames, Object[] fieldValues) {
        Query q = null;
        if (fieldNames != null && fieldValues != null && fieldValues.length == fieldNames.length) {
            q = getEntityManager().createNamedQuery(queryName);
            for (int i = 0; i < fieldValues.length; i++) {
                q.setParameter(fieldNames[i], fieldValues[i]);
            }
            return q;
        } else {
            return null;
        }
    }

    public Query createNamedQuery(String queryName) {
        return getEntityManager().createNamedQuery(queryName);
    }

    public byte[] convertToByteArray(Object obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream encoder;
        try {
            encoder = new ObjectOutputStream(out);
            encoder.writeObject(obj);
            encoder.flush();
            encoder.close();
            out.flush();
            return out.toByteArray();
        } catch (IOException ex) {
            throw new RWTxnException(ex.getMessage(), RWStatus.INTERNAL_ERROR);
        }
    }

    public Object convertToObject(byte[] b) {
        ByteArrayInputStream bin = new ByteArrayInputStream(b);
        ObjectInputStream decoder;
        try {
            decoder = new ObjectInputStream(bin);
            Object obj = decoder.readObject();
            return obj;
        } catch (IOException ex) {
            throw new RWTxnException(ex.getMessage(), RWStatus.INTERNAL_ERROR);
        } catch (ClassNotFoundException ex) {
            throw new RWTxnException(ex.getMessage(), RWStatus.INTERNAL_ERROR);
        }
    }

    public static String isAnySpecialChar(String regex, String input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        String specialChar = "";
        while (m.find()) {
            specialChar = specialChar.concat(m.group());
        }
        return specialChar;
    }

    public static String replaceEmptySpecialChar(String regex, String input) {
        return replaceSpecialChar(regex, input, "");
    }

    public static String replaceSpecialChar(String regex, String input, String replacer) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()) {
            input = input.replace(m.group(), replacer);
        }
        return input;
    }

    /**
     * @param inputFlag
     * @return short value true = 1 and false =0
     */
    public static short getShortValue(boolean inputFlag) {
        if (inputFlag) {
            return TRUE_FLAG_SHORT.shortValue();
        } else {
            return FALSE_FLAG_SHORT.shortValue();
        }
    }

    /**
     * @param outputFlag
     * @return boolean value short value 1=true and 0=false
     */
    public static boolean getBooleanValue(Short outputFlag) {
        boolean flag = false;
        if (outputFlag != null) {
            flag = outputFlag.equals(TRUE_FLAG_SHORT);
        }
        return flag;
    }

    public String getBugBuID(RWBusinessUnit bu) {
        String iDGenBug = bu.getBuId();
        return iDGenBug;
    }

    public static void main(String ar[]) {
        getBooleanValue(Short.valueOf("1"));
    }

    public static String extractStream(byte[] byteA) {
        if (byteA == null || byteA.length == 0) {
            return "";
        }
        ByteArrayInputStream bin = new ByteArrayInputStream(byteA);
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gzos = new GZIPInputStream(bin);
            BufferedOutputStream out = new BufferedOutputStream(arrayOutputStream);
            byte[] buffer = new byte[1024];
            int i;
            while ((i = gzos.read(buffer)) >= 0) {
                out.write(buffer, 0, i);
            }
            out.close();
            out.flush();
            gzos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RWTxnException(ex.getMessage(), RWStatus.INTERNAL_ERROR);
        }
        return arrayOutputStream.toString();
    }

    public static byte[] compressStream(String attachmentStream) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        if (attachmentStream == null || attachmentStream.trim().equals("")) {
            return bos.toByteArray();
        }
        try {
            GZIPOutputStream gzos = new GZIPOutputStream(bos);
            BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(attachmentStream.getBytes()));
            byte[] buffer = new byte[1024];
            int i;
            while ((i = in.read(buffer)) >= 0) {
                gzos.write(buffer, 0, i);
            }
            in.close();
            bos.flush();
            gzos.close();
        } catch (IOException ex) {
            throw new RWTxnException(ex.getMessage(), RWStatus.INTERNAL_ERROR);
        }
        return bos.toByteArray();
    }

    public boolean isValidCodeset(String codeName, String codeValue, boolean isNullable, boolean isNaAcceptable) {
        if (isNullable && codeValue == null) {
            return true;
        }
        if (isNaAcceptable && codeValue != null && codeValue.equals("NA")) {
            return true;
        }
        return getCommonCodeSet(codeName, codeValue) != null;
    }

    /**
     * validating code value from table RWCodeSet
     *
     * @param codeName
     * @param codeValue may be null
     */
    public void validateCode(RWCode codeName, String codeValue) {
        if (codeValue == null) {
            return;
        }
        validateNotNullCode(codeName, codeValue);
    }

    /**
     * validating code value from table RWCodeSet
     *
     * @param codeName
     * @param codeValue should not be null
     */
    public void validateNotNullCode(RWCode codeName, String codeValue) {
        RWCodeSet code = getCommonCodeSet(codeName.name(), codeValue);
        if (code == null) {
            throw new RWValidationException(RWStatus.INVALID_DATA, codeName.name(), codeValue, "RWCodeSet not found");
        }
    }

    public RWIdGen getRWIdGen(String entity, String buid) {
        RWIdGen idGen = (RWIdGen) findEntity("RWIdGen.findByEntityBuId", new String[]{"entity", "buid"}, new Object[]{entity, buid});
        if (idGen == null) {
            String msg = "Entity:" + entity + ",BuId:" + buid;
            throw new RWTxnException(RWStatus.IDGEN_NOT_FOUND, msg);
        }
        return idGen;
    }

    public RWIdGen getRWIdGenByYear(String entity, String buid) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        SimpleDateFormat format = new SimpleDateFormat("yy");
        if (month <= 2) {
            cal.add(Calendar.YEAR, -1);
        }
        String year = format.format(cal.getTime());
        int yr = Integer.parseInt(year);
        RWIdGen idGen = (RWIdGen) findEntity("RWIdGen.findByEntityBuIdYear", new String[]{"entity", "buid", "year"}, new Object[]{entity, buid, yr});
        if (idGen == null) {
            String msg = "Entity:" + entity + ",Year:" + yr + ",BuId:" + buid;
            throw new RWTxnException(RWStatus.IDGEN_NOT_FOUND, msg);
        }
        return idGen;
    }
    
    public IdGen getIdGen(String entityName) {
        IdGen idGen = (IdGen) getSingleResult(getEntityManager().createNamedQuery("IdGen.findByEntityName").setParameter("entityName",entityName));
        return idGen;
    }
}
