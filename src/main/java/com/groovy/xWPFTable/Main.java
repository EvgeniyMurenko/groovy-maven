package com.groovy.xWPFTable;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Main {

    private static final List<Integer> saleDetailsTableColumns = List.of(0, 1, 2, 3, 4, 5);
    private static final List<String> headersTableColumns = List.of("№",
        "Назва товару",
        "Од.вим.",
        "Кількість в од. виміру",
        "Ціна за одиницю, без ПДВ. грн.",
        "Загальна вартість, без ПДВ. грн."
    );

    public static void main(String[] args) throws IOException {

//        XWPFDocument document = new XWPFDocument();
//        setDocumentStyle(document);
//
//        File file = new File("create_table.docx");
//
//        //Write the Document in file system
//        FileOutputStream out = new FileOutputStream(file);
//
//
//        //create table
//        XWPFTable table = document.createTable();
//
//
//        createTableHeader(headersTableColumns, saleDetailsTableColumns, table);


        XWPFDocument document= new XWPFDocument();
        setDocumentStyle(document);
        XWPFTable table = document.createTable();
        setTableStyle(table);



        createTableHeader(headersTableColumns, saleDetailsTableColumns, table);
//        //create second row
//        XWPFTableRow tableRow2 = table.createRow();
//        tableRow2.getCell(0).setText("AccountID");
//        tableRow2.getCell(1).setText("ACCID001");



        document.write(new FileOutputStream("CreateWordTableColumnWidth.docx"));
        document.close();
    }

    private static void createTableHeader(List<String> data, List<Integer> column, XWPFTable table) {
        assert data.size() == column.size();
        XWPFTableRow firstRow = table.getRow(0);
        firstRow.getCell(0).setText(data.get(0));
        for (int i = 1; i < column.size(); i++) {
            firstRow.addNewTableCell().setText(data.get(i));
        }
    }

    private static void setDocumentStyle(XWPFDocument document) {
        document.getParagraphs().forEach(par -> {
            par.getRuns().forEach(r -> r.setFontSize(BillGeneratorConstants.FONT_SIZE));
            CTPPr ppr = par.getCTP().getPPr();
            if (ppr == null) ppr = par.getCTP().addNewPPr();
            CTSpacing spacing = ppr.isSetSpacing()? ppr.getSpacing() : ppr.addNewSpacing();
            spacing.setAfter(BillGeneratorConstants.SPACING_AFTER);
            spacing.setBefore(BillGeneratorConstants.SPACING_BEFORE);
            spacing.setLineRule(STLineSpacingRule.AUTO);
            spacing.setLine(BillGeneratorConstants.SPACING_LINE);
        });

        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BillGeneratorConstants.SIDE_MARGINS);
        pageMar.setRight(BillGeneratorConstants.SIDE_MARGINS);
    }

    private static void setTableStyle(XWPFTable table) {
        //values are in unit twentieths of a point (1/1440 of an inch)
        table.setWidth(7*1440); //should be 5 inches width

        //create CTTblGrid for this table with widths of the 2 columns.
        //necessary for Libreoffice/Openoffice to accept the column widths.
        //first column = 2 inches width
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(740));
        //other columns (only one in this case) = 3 inches width
        for (int col = 1 ; col < headersTableColumns.size(); col++) {
            if (col ==1){
                table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(2*1440));
            } else {
                table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1040));
            }
        }

//        //set width for first column = 2 inches
//        CTTblWidth tblWidth = table.getRow(0).getCell(0).getCTTc().addNewTcPr().addNewTcW();
//        tblWidth.setW(BigInteger.valueOf(1440));
//        //STTblWidth.DXA is used to specify width in twentieths of a point.
//        tblWidth.setType(STTblWidth.DXA);

        //set width for second column = 3 inches
//        XWPFTableRow row = table.getRow(0);
//        tblWidth = row.getCell(1).getCTTc().addNewTcPr().addNewTcW();
//        tblWidth.setW(BigInteger.valueOf(2*1440));
//        tblWidth.setType(STTblWidth.DXA);
    }

}
