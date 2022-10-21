package swayam.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class pdfToExcel {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\swaya\\Desktop\\doc.pdf");
		FileInputStream fis = new FileInputStream(file);

		PDDocument pdfDocument = PDDocument.load(fis);
		System.out.println(pdfDocument.getPages().getCount());
		// pdfDocument.save("C:\\Users\\swaya\\eclipse-workspace\\NewWorkSpace\\seleniumFrameworkDesign\\Excel\\test.xlsx");

		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		String doctext = pdfTextStripper.getText(pdfDocument); // System.out.println(doctext);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		sheet.createRow(0);
		sheet.getRow(0).createCell(1).setCellValue(doctext);
		FileOutputStream fileout = new FileOutputStream(
				"C:\\Users\\swaya\\eclipse-workspace\\NewWorkSpace\\seleniumFrameworkDesign\\Excel\\test.xlsx");
		workbook.write(fileout);
		workbook.close();

		pdfDocument.close();
		fis.close();

	}
	

}
