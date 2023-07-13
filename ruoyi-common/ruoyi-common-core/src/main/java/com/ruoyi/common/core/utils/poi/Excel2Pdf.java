package com.ruoyi.common.core.utils.poi;

import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Excel2Pdf
 * 请查看 aspose的demo
 *
 * @see #excel2pdf
 * @author WangYouzheng
 * @version 1.0
 * @since 2023-7-12 15:02
 */
public class Excel2Pdf {


    public static void main(String[] args) throws Exception {
        // itextDemo();
        // iceblueDemo();
        String[] source = {"结算单模板(2).xls", "清洗模板.xlsx", "出口模板.xlsx", "清洗模板 (2).xlsx", "出口模板 (2).xlsx"};
        String basePath = "D:\\exceltopdf\\";
        for (String filename : source) {
            excel2pdf(basePath + filename, basePath + filename + ".pdf");
        }
    }

    /**
     * itextDemo，此demo只能验证数据层的迁移，但是需要自己去完善读取excel的style并且转制成对应的pdf style
     *
     * @throws Exception
     */
    static void itextDemo() throws Exception {

        FileInputStream input_document = new FileInputStream(new File("D:\\exceltopdf\\test1.xls"));

        // Read workbook into HSSFWorkbook

        HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);

        // Read worksheet into HSSFSheet

        HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

        // To iterate over the rows

        Iterator<Row> rowIterator = my_worksheet.iterator();

        // We will create output PDF document objects at this point

        Document iText_xls_2_pdf = new Document();

        PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("D:\\exceltopdf\\Excel2PDF_Output.pdf"));

        iText_xls_2_pdf.open();

        // we have two columns in the Excel sheet, so we create a PDF table with two columns

        // Note: There are ways to make this dynamic in nature, if you want to.

        PdfPTable my_table = new PdfPTable(2);

        // We will use the object below to dynamically add new data to the table

        PdfPCell table_cell;

        // Loop through rows.

        Set setCell = new HashSet();

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next(); // Fetch CELL
                setCell.add(cell.getCellType());
                switch (cell.getCellType()) { // Identify CELL type

                    // you need to add more code here based on

                    // your requirement / transformations

                    case STRING:

                        // Push the data from Excel to PDF Cell

                        table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));

                        // feel free to move the code below to suit to your needs

                        my_table.addCell(table_cell);

                        break;
                    case NUMERIC:
                        table_cell = new PdfPCell(new Phrase(String.valueOf(cell.getNumericCellValue())));
                        my_table.addCell(table_cell);
                        break;
                    case BLANK:
                        table_cell = new PdfPCell(new Phrase(""));
                        my_table.addCell(table_cell);
                        break;
                    /* default:
                        table_cell = new PdfPCell(new Phrase(cell.getBooleanCellValue()));
                        my_table.addCell(table_cell); */
                }

                // next line

            }

        }

        // Finally add the table to PDF document

        iText_xls_2_pdf.add(my_table);

        iText_xls_2_pdf.close();

        // we created our pdf file..

        input_document.close(); // close xls

        System.out.println(setCell);
    }

    /**
     * iceblue demo
     * 看起来是可以，并且是基于image的 需要破解，公司不会付费的。。
     */
    static void iceblueDemo() {
        //创建一个Workbook实例并加载Excel文件
        Workbook workbook = new Workbook();
        workbook.loadFromFile("D:\\exceltopdf\\test3.xls");

        //设置转换后的PDF页面高宽适应工作表的内容大小
        workbook.getConverterSetting().setSheetFitToPage(true);

        //将生成的文档保存到指定路径
        workbook.saveToFile("D:\\exceltopdf\\spireOutput/ExcelToPdf", FileFormat.PDF);
    }

    static void aspose() {

    }

    /**
     * 验证证书
     *
     * @return
     */
    public static boolean authrolizeLicense() {
        boolean result = false;
        try {
            InputStream is = com.aspose.cells.License.class.getResourceAsStream("/com.aspose.cells.lic_2999.xml");
            License asposeLicense = new License();
            asposeLicense.setLicense(is);
            is.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * excel 转为pdf 输出。
     *
     * @param sourceFilePath excel文件
     * @param desFilePathd   pad 输出文件目录
     */
    public static void excel2pdf(String sourceFilePath, String desFilePathd) {
        // 验证License 若不验证则转化出的pdf文档会有水印产生
        if (!authrolizeLicense()) {
            return;
        }
        try {
            // Workbook wb = new Workbook(sourceFilePath);// 原始excel路径
            com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(sourceFilePath);
            FileOutputStream fileOS = new FileOutputStream(desFilePathd);
            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
            pdfSaveOptions.setOnePagePerSheet(true);//把内容放在一张PDF 页面上；
            wb.save(fileOS, pdfSaveOptions);
            fileOS.flush();
            fileOS.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
