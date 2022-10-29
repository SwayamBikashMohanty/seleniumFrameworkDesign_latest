package swayam.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Apache POI API
Maven dependencies setup:
poi-ooxml and poi

Startegy to Access Excel Data
===================================
Create obejct for XSSFWorkbook class
Get Access to sheet
Get Access to all rows of sheet
Access to specific row from all rows
Get Access to all cells of Row
Access the Data from Excel into Arrays
 */
public class dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> al = new ArrayList<String>();

		FileInputStream inputStream = new FileInputStream("C:\\Users\\swaya\\Desktop\\dataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		int sheetscount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetscount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify Testcases column by scanning the entire 1st row.

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator();// rows is collection of cell
				int k = 0;
				int coloumn = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						coloumn = k;// identify the desired column number
					}
					k++;
				}
				System.out.println(coloumn);
				// once column is identified then scan entire testcase column to identify
				// purchase testcase row
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName)) {// test case name is
																									// purchase in excel
																									// sheet
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {// Checking cell data type
								al.add(c.getStringCellValue());// Adding the data into arraylist object
							} else {
								al.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								// al.add(c.getNumericCellValue());//it checks numeric but arraylist returntype
								// is string
							}

						}
					}
				}

			}
		}
		return al;

	}
}
