/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.octa.invocetransform.Business;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.ComprobanteRetencion;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.FacturaComprobante;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.Impuesto;
import com.octa.invocetransform.Models.ComprobanteRetencionModel.Impuestos;
import com.octa.invocetransform.Models.ComprobanteRetencionModelSingleImp.FacturaComprobante_S;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author dskat
 */
public class XmlToAppModel {

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    private static final String[] headerTitles = {"SERIE_COMPROBANTE", "RUC_EMISOR", "RAZON_SOCIAL_EMISOR", "FECHA_EMISION", "FECHA_AUTORIZACION", "TIPO_EMISION", "IDENTIFICACION_RECEPTOR", "CLAVE_ACCESO", "NUMERO_AUTORIZACION", "BASE_IMPONIBLE", "PORCENTAJE", "VALOR_RETENIDO"};

    private static final ArrayList<String> excelHeaderTitles = new ArrayList<>(Arrays.asList(headerTitles));

    // THIS WORKS FOR AUTHORIZATION FILES
    public static FacturaComprobante transformXMLComprobanteRetencion(String filepath) {

        FacturaComprobante facturaComprobante = new FacturaComprobante();
        try {

            //Init auth XML doc
            DocumentBuilderFactory dbf_auth = DocumentBuilderFactory.newInstance();
            dbf_auth.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            //Parse XML file
            DocumentBuilder db_auth = dbf_auth.newDocumentBuilder();

            //Get document
            Document doc_auth = db_auth.parse(new File(filepath));
            doc_auth.getDocumentElement().normalize();

            NodeList list = doc_auth.getElementsByTagName("autorizacion");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    //Get comprobante items
                    String fechaAutorizacionXMLString = element.getElementsByTagName("fechaAutorizacion").item(0).getTextContent();
                    String numeroAutorizacionXMLString = element.getElementsByTagName("numeroAutorizacion").item(0).getTextContent();
                    String estadoXMLString = element.getElementsByTagName("estado").item(0).getTextContent();
                    String invoceXmlString = element.getElementsByTagName("comprobante").item(0).getTextContent();

                    //Convert XML to JSON
                    JSONObject xmlJSONObj = XML.toJSONObject(invoceXmlString);
                    String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);

                    //Delete the signing information
                    Gson gson = new Gson();
                    JsonElement comprobanteRetencionJsonObj = gson.fromJson(jsonPrettyPrintString, JsonElement.class);
                    comprobanteRetencionJsonObj.getAsJsonObject().get("comprobanteRetencion").getAsJsonObject().remove("ds:Signature");

                    //Check if is valid doc
                    boolean isValidImpDoc;
                    try {
                        System.out.println("Documento valido: " + comprobanteRetencionJsonObj.getAsJsonObject().get("comprobanteRetencion").getAsJsonObject().get("impuestos").getAsJsonObject());
                        isValidImpDoc = true;
                    } catch (Exception e) {
                        isValidImpDoc = false;
                        System.out.println("Tipo documento no valido: ");

                    }

                    if (isValidImpDoc) {

                        boolean isJsonArray = false;
                        try {

                            System.out.println("Size: " + comprobanteRetencionJsonObj.getAsJsonObject().get("comprobanteRetencion").getAsJsonObject().get("impuestos").getAsJsonObject().get("impuesto").getAsJsonArray().size());
                            isJsonArray = true;

                        } catch (Exception e) {

                            System.out.println("Not an array: ");
                            isJsonArray = false;
                        }

                        if (isJsonArray) {
                            facturaComprobante = gson.fromJson(comprobanteRetencionJsonObj.toString(), FacturaComprobante.class);
                            facturaComprobante.setIsValidDocApp(true);
                        } else {
                            FacturaComprobante_S tempFac = gson.fromJson(comprobanteRetencionJsonObj.toString(), FacturaComprobante_S.class);

                            //Comprobante retencion
                            ComprobanteRetencion compRent = new ComprobanteRetencion();
                            compRent.setId(tempFac.getComprobanteRetencion().getId()); //id
                            compRent.setVersion(tempFac.getComprobanteRetencion().getVersion()); //version
                            compRent.setInfoTributaria(tempFac.getComprobanteRetencion().getInfoTributaria()); //infoTributaria
                            compRent.setInfoCompRetencion(tempFac.getComprobanteRetencion().getInfoCompRetencion());

                            //Impuesto
                            List<Impuesto> impList = new ArrayList<Impuesto>();
                            impList.add(tempFac.getComprobanteRetencion().getImpuestos().getImpuesto());
                            Impuestos imps = new Impuestos();
                            imps.setImpuesto(impList);

                            compRent.setImpuestos(imps);
                            facturaComprobante.setComprobanteRetencion(compRent);
                            facturaComprobante.setIsValidDocApp(true);

                        }
                    } else {
                        facturaComprobante.setIsValidDocApp(false);
                    }

                    facturaComprobante.setEstado(estadoXMLString);
                    facturaComprobante.setFechaAutorizacion(fechaAutorizacionXMLString);
                    facturaComprobante.setNumeroAutorizacion(numeroAutorizacionXMLString);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XmlToAppModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(XmlToAppModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return facturaComprobante;
    }

    public static boolean generateExcelDocument(ArrayList<FacturaComprobante> facturasLs, String path) {

        boolean finished = false;

        try {
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Comprobantes Retencion");
            OutputStream os = new FileOutputStream(path + "\\ListaComprobantesRetencion.xlsx");

            //Create the row
            Row row = sheet.getRow(0);
            if (row == null) {
                row = sheet.createRow(0);
            }

            for (int x = 0; x < excelHeaderTitles.size(); x++) {

                //Append the Header titles
                Cell cellTitle = row.getCell(x);
                if (cellTitle == null) {
                    cellTitle = row.createCell(x, CellType.STRING);
                }
                if (x % 2 == 1) {
                    changeCellBackgroundColor(cellTitle, wb, x, IndexedColors.LIGHT_BLUE.index);
                } else {
                    changeCellBackgroundColor(cellTitle, wb, x, IndexedColors.AQUA.index);
                }
                cellTitle.setCellValue(excelHeaderTitles.get(x));

                //sheet.autoSizeColumn(x);
            }

            //Append the non numeric values 
            int initalVal = 1;
            for (int y = 0; y < facturasLs.size(); y++) {

                FacturaComprobante facObj = facturasLs.get(y);

                String serieComprobante = facObj.getComprobanteRetencion().getInfoTributaria().getEstab() + "-" + facObj.getComprobanteRetencion().getInfoTributaria().getPtoEmi() + "-" + facObj.getComprobanteRetencion().getInfoTributaria().getSecuencial();
                String RUC = facObj.getComprobanteRetencion().getInfoTributaria().getRuc();
                String razonSocial = facObj.getComprobanteRetencion().getInfoTributaria().getRazonSocial();
                String fechaEmision = facObj.getComprobanteRetencion().getInfoCompRetencion().getFechaEmision();
                String fechaAutorizacion = facObj.getFechaAutorizacion();
                String tipoEmision = String.valueOf(facObj.getComprobanteRetencion().getInfoTributaria().getTipoEmision());
                String identificacionReceptor = facObj.getComprobanteRetencion().getInfoCompRetencion().getIdentificacionSujetoRetenido();
                String claveAcceso = facObj.getComprobanteRetencion().getInfoTributaria().getClaveAcceso();
                String numeroAutorizacion = facObj.getNumeroAutorizacion();

                Row iterRow = sheet.createRow(initalVal + y);

                iterRow.createCell(0).setCellValue(serieComprobante);
                iterRow.createCell(1).setCellValue(RUC);
                iterRow.createCell(2).setCellValue(razonSocial);
                iterRow.createCell(3).setCellValue(fechaEmision);
                iterRow.createCell(4).setCellValue(fechaAutorizacion);
                iterRow.createCell(5).setCellValue(tipoEmision);
                iterRow.createCell(6).setCellValue(identificacionReceptor);
                iterRow.createCell(7).setCellValue(claveAcceso);
                iterRow.createCell(8).setCellValue(numeroAutorizacion);

                if (facObj.getComprobanteRetencion().getImpuestos() != null) {
                    List<Impuesto> lsImpuesto = facObj.getComprobanteRetencion().getImpuestos().getImpuesto();
                    if (lsImpuesto != null) {
                        initalVal = initalVal + lsImpuesto.size();
                    }
                }

            }

            //Create temporal list to store the valures
            ArrayList<String> bIList = new ArrayList<>();
            ArrayList<String> pRList = new ArrayList<>();
            ArrayList<String> vRList = new ArrayList<>();
            ArrayList<String> columnTemp = new ArrayList<>();

            for (int x = 0; x < facturasLs.size(); x++) {
                FacturaComprobante facObj = facturasLs.get(x);
                if (facObj.getComprobanteRetencion().getImpuestos() != null) {
                    List<Impuesto> lsImpuesto = facObj.getComprobanteRetencion().getImpuestos().getImpuesto();
                    if (lsImpuesto != null) {
                        for (int y = 0; y < lsImpuesto.size(); y++) {
                            double bI = lsImpuesto.get(y).getBaseImponible();
                            double pR = lsImpuesto.get(y).getPorcentajeRetener();
                            double vR = lsImpuesto.get(y).getValorRetenido();

                            bIList.add(String.valueOf(bI));
                            pRList.add(String.valueOf(pR));
                            vRList.add(String.valueOf(vR));
                        }
                    }

                } else {
                }

            }

            //Get the total of rows appended
            int rowTotal = sheet.getLastRowNum();
            if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
                rowTotal++;
            }
            System.out.println("Number of columns: " + rowTotal);

            for (int x = 0; x < rowTotal; x++) {
                Row rowIter = CellUtil.getRow(x, sheet);
                Cell cell = CellUtil.getCell(rowIter, 0);
                if (cell.getStringCellValue().equals("")) {
                    columnTemp.add(String.valueOf(x));
                }
            }

            //Add the last item index
            int calcSize = bIList.size() - columnTemp.size();

            int sumVal = 0;
            if (calcSize > 0) {
                for (int x = 0; x < calcSize; x++) {
                    sumVal = (rowTotal + x) + 1;
                    columnTemp.add(String.valueOf(sumVal));
                }
            }
            System.out.println("sumed: " + sumVal);

            for (int x = 0; x < sumVal; x++) {

                for (int y = 0; y < columnTemp.size(); y++) {

                    String biVal = bIList.get(y);
                    String pRVal = pRList.get(y);
                    String vRVal = vRList.get(y);

                    if (x == Integer.valueOf(columnTemp.get(y))) {

                        Row rIterval = sheet.getRow(Integer.valueOf(columnTemp.get(y)) - 1);
                        if (rIterval == null) {
                            // First cell in the row, create
                            rIterval = sheet.createRow(Integer.valueOf(columnTemp.get(y)) - 1);
                        }

                        Cell cBI = rIterval.getCell(9);
                        if (cBI == null) {
                            cBI = rIterval.createCell(9, CellType.NUMERIC);
                        }
                        cBI.setCellValue(biVal);

                        Cell cPR = rIterval.getCell(10);
                        if (cPR == null) {
                            cPR = rIterval.createCell(10, CellType.NUMERIC);
                        }
                        cPR.setCellValue(pRVal);

                        Cell cVR = rIterval.getCell(11);
                        if (cVR == null) {
                            cVR = rIterval.createCell(11, CellType.NUMERIC);
                        }
                        cVR.setCellValue(vRVal);

                    }
                }

            }
            autoSizeColumns(wb);
            wb.write(os);
            os.close();
            wb.close();
            finished = true;
        } catch (IOException ex) {
            Logger.getLogger(XmlToAppModel.class.getName()).log(Level.SEVERE, null, ex);
            finished = false;
        }
        return finished;
    }

    private static void changeCellBackgroundColor(Cell cell, Workbook wb, int x, short s) {
        CellStyle cellStyle = wb.getCellStyleAt(x);
        if (cellStyle == null) {
            cellStyle = cell.getSheet().getWorkbook().createCellStyle();
        }
        cellStyle.setFillForegroundColor(s);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
    }

    private static void autoSizeColumns(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }
}
