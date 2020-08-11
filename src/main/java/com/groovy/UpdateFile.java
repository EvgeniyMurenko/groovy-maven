package com.groovy;

import com.groovy.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class UpdateFile {

    public static final int CODE_COLUMN_NUMBER = 0;
    public static final int DESCRIPTION_COLUMN_NUMBER = 1;

    public static void main(String[] args) throws IOException {

        File excel = new File("/home/evgeniy/Рабочий стол/items_original.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wbRead = new XSSFWorkbook(fis);
        XSSFSheet ws = wbRead.getSheetAt(0);

        Iterator<Row> rows = ws.rowIterator();

        if (rows.hasNext()) {
            rows.next();
        }

        List<Item> itemList = new ArrayList<>();

        while (rows.hasNext()) {
            Row row = rows.next();
            String code = row.getCell(CODE_COLUMN_NUMBER).toString();
            String desc = row.getCell(DESCRIPTION_COLUMN_NUMBER).toString();
            Item item = new Item(code, desc);
            itemList.add(item);
        }

        System.out.println(itemList.size());


        HSSFWorkbook wbWrite = new HSSFWorkbook();
        HSSFSheet sheet = wbWrite.createSheet("Result");

        String[] collums = {"Code", "Description"};

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < collums.length; i++) {
            HSSFCell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(collums[i]);
        }


        //iterating r number of rows
        for (int rowIndex = 1; rowIndex < itemList.size(); rowIndex++) {
            HSSFRow row = sheet.createRow(rowIndex);

            //iterating c number of columns
            for (int columIndex = 0; columIndex < collums.length; columIndex++) {
                HSSFCell cell = row.createCell(columIndex);

                if (columIndex == 0) {
                    cell.setCellValue(itemList.get(rowIndex - 1).getCode().trim());
                } else {
                    cell.setCellValue(itemList.get(rowIndex - 1).getDescription());
                }
            }
        }

        FileOutputStream fileOut = new FileOutputStream("result.xlsx");

        //write this workbook to an Outputstream.
        wbWrite.write(fileOut);
        fileOut.flush();
        fileOut.close();


        //String s = "9010.2.3.01 ";


    }
}
