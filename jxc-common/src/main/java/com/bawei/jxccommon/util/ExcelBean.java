package com.bawei.jxccommon.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * 
* @Description: 导入导出excel
* @author haipeng
* @date 2017年4月11日
 */
@Getter
@Setter
public class ExcelBean implements java.io.Serializable {
    private String headTextName;//列头（标题）名
     private String propertyName;//对应字段名
     private Integer cols;//合并单元格数
     private XSSFCellStyle cellStyle;//2007 excel
     
     public ExcelBean(){

     }
     public ExcelBean(String headTextName, String propertyName){
    	 this.headTextName = headTextName;
         this.propertyName = propertyName;
     }
     public ExcelBean(String headTextName, String propertyName, Integer cols) {
         super();
         this.headTextName = headTextName;
         this.propertyName = propertyName;
         this.cols = cols;
     }

}