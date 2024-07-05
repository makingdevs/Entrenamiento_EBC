package mx.ebc.web.view

import mx.ebc.model.Empleado
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.springframework.stereotype.Component
import org.springframework.web.servlet.view.document.AbstractXlsxView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.poi.ss.usermodel.Workbook

@Component
class EmpleadoExcelView  extends AbstractXlsxView {
    @Override
    void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) {
        List<Empleado> empleados = model.empleados

        Sheet sheet = workbook.createSheet("Empleados")
        Row header = sheet.createRow(0)
        header.createCell(0).cellValue = "Nombre completo"

        Integer rowNum = 1
        empleados.each { empleado ->
            Row row = sheet.createRow(rowNum++)
            row.createCell(0).cellValue = "${empleado.nombre} ${empleado.paterno}"
        }
    }
}
