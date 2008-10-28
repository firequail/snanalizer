package snanalizer.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

@Transactional
public class ExcelExporterImpl implements ExcelExporter {

	@Resource
	RedesService redesService;

	public RedesService getRedesService() {
		return redesService;
	}

	public void setRedesService(RedesService redesService) {
		this.redesService = redesService;
	}

	public void export(int redId, OutputStream out) throws IOException {
		Red red = redesService.getRedById(redId);
		exportarRed(red, out);
	}

	public void export(Red red, OutputStream out) throws IOException {
		exportarRed(red, out);
	}

	private void exportarRed(Red red, OutputStream out) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();

		for (PuntoDeVista puntoDeVista : red.getPuntosDeVista()) {
			exportarPuntoDeVista(workbook, puntoDeVista);
		}

		workbook.write(out);
	}

	private void exportarPuntoDeVista(HSSFWorkbook workbook,
			PuntoDeVista puntodeVista) throws IOException {

		try {
			String descripcion = puntodeVista.getDescripcion().replace("?", "");
			HSSFSheet sheet = workbook.createSheet(descripcion);

			exportarTitulos(puntodeVista, sheet, workbook);
			exportarRelaciones(puntodeVista, sheet);

		} catch (IllegalArgumentException e) {
		}
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
