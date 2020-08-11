package com.groovy;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CreateFile {

    public static void main(String[] args) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Result");

        String[] collums = {"Invoice", "Status", "Amount", "Company name", "Edrpou", "Balance before", "Balance After", "Error message"};

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < collums.length; i++){
            HSSFCell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(collums[i]);
        }


        //iterating r number of rows
        for (int r=1;r < 5; r++ )
        {
            HSSFRow row = sheet.createRow(r);

            //iterating c number of columns
            for (int c=0;c < collums.length; c++ )
            {
                HSSFCell cell = row.createCell(c);

                cell.setCellValue("Cell "+r+" "+c);
            }
        }

        FileOutputStream fileOut = new FileOutputStream("text.xlsx");

        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
