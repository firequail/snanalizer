package snanalizer.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

public class ExcelExporter {

	public void export(Red red) {
		try {
			exportarRed(red);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void exportarRed(Red red) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		String descripcion = red.getDescripcion().replace("?", "");

		for (PuntoDeVista puntoDeVista : red.getPuntosDeVista()) {
			exportarPuntoDeVista(workbook, puntoDeVista);
		}

		FileOutputStream file = new FileOutputStream(descripcion + ".xls");
		workbook.write(file);
		file.close();
	}

	private void exportarPuntoDeVista(HSSFWorkbook workbook,
			PuntoDeVista puntodeVista) throws IOException {
		String descripcion = puntodeVista.getDescripcion().replace("?", "");

		HSSFSheet sheet = workbook.createSheet(descripcion);

		exportarTitulos(puntodeVista, sheet, workbook);
		exportarRelaciones(puntodeVista, sheet);
	}

	private void exportarTitulos(PuntoDeVista puntodeVista, HSSFSheet sheet,
			HSSFWorkbook workbook) {
		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		int cellCount = 1;
		for (Nodo nodo : puntodeVista.getNodos()) {
			HSSFCell cell = row.createCell(cellCount);
			cell.setCellValue(new HSSFRichTextString(nodo.getRecurso()
					.getNombreYApellido()));
			cell.setCellStyle(style);
			cellCount++;
		}

		int rowCount = 1;
		for (Nodo nodo : puntodeVista.getNodos()) {
			row = sheet.createRow(rowCount);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(new HSSFRichTextString(nodo.getRecurso()
					.getNombreYApellido()));
			cell.setCellStyle(style);
			rowCount++;
		}
	}

	private void exportarRelaciones(PuntoDeVista puntodeVista, HSSFSheet sheet) {
		int rowCount = 1;
		for (Nodo origen : puntodeVista.getNodos()) {
			HSSFRow row = sheet.getRow(rowCount);

			createCells(row, origen, puntodeVista.getNodos());

			rowCount++;
		}
	}

	private void createCells(HSSFRow row, Nodo origen, List<Nodo> nodos) {
		int cellCount = 1;
		for (Nodo destino : nodos) {
			HSSFCell cell = row.createCell(cellCount);
			cell.setCellValue(origen.intensidadCon(destino));
			cellCount++;
		}
	}
}
