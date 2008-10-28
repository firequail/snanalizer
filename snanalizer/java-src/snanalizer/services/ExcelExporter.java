package snanalizer.services;

import java.io.IOException;
import java.io.OutputStream;

public interface ExcelExporter {

	public void export(int redId, OutputStream out) throws IOException;

}