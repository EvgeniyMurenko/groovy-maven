package com.groovy;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {

    public static final int ITEM_COLUMN_NUMBER = 0;
    public static final int DESCRIPTION_COLUMN_NUMBER = 1;
    public static final int GROUPS_COLUMN_NUMBER = 2;

    public static void main(String[] args) throws IOException {

        File excel =  new File ("/home/evgeniy/Рабочий стол/aaaa.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheetAt(0);

        Iterator<Row> rows = ws.rowIterator();

        if (rows.hasNext()) {
            rows.next();
        }

        List<Mapping> mappingList = new ArrayList<Mapping>();

        while (rows.hasNext()){
            Row row = rows.next();

            row.getCell(1).toString();


            mappingList.add(new Mapping(row.getCell(ITEM_COLUMN_NUMBER).toString(), row.getCell(DESCRIPTION_COLUMN_NUMBER).toString(), row.getCell(GROUPS_COLUMN_NUMBER).toString()));

        }


        System.out.println(mappingList);

        /*byte[] fileAsByteArray = {
                70, 105, 108, 101, 32,
                116, 111, 32, 98, 121,
                116, 101, 32, 97, 114,
                114, 97, 121};

9010.2.9.03


        File fileToWriteTo = new File("aaaa.xlsx");

        FileUtils.writeByteArrayToFile(fileToWriteTo, fileAsByteArray);
*/
    }
}
