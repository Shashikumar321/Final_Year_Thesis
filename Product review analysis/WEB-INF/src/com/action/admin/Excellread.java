package com.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dao.AdminDAO;



public class Excellread 
{
public static void readexcell(String path,String productname)
{
	try
    {
        FileInputStream file = new FileInputStream(new File(path));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
             
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.println("the valu"+cell.getNumericCellValue() + "t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getRichStringCellValue() + "t");
                        System.out.println("____"+cell.getRichStringCellValue().length());
                        if(cell.getColumnIndex()==0)
                        {
                        	
                        	
                        }
                        else
                        {
                      boolean flag=AdminDAO.addReviewDetails(productname, cell.getRichStringCellValue());
                        }
                        break;
                }
            }
            System.out.println("");
        }
        file.close();
    } 
    catch (Exception e1) 
    {
        e1.printStackTrace();
    }
}
}
