package com.zealot.dcasting.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

/**
 * 自定義報價單明細管理Dao
 * Created by LeoLiu on 2021/6/4.
 */
public interface QuotationDetailsDao {
    /**
     * 根據指定的Id把QuotationDetail的flag變成0, 假刪除
     */
    int deleteDetailsById(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("id") Long id);
    
    /**
     * 根據指定的quotationId把QuotationDetail的flag變成0, 假刪除
     */
    int deleteDetailsByQuotationId(@Param("update_datetime") Date update_datetime, @Param("update_user_id") Long update_user_id, @Param("quotationId") String quotationId);
    
    /**
     * 根據指定的quotationId把作業項目小計值加總
     */
    Long sumByQuotationId(@Param("quotationId") String quotationId);
}
