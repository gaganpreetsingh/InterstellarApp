package com.gagan.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.gagan.model.Edge;
import com.gagan.model.PlanetVertex;

public class ExcelReader {
	
	public static final BigDecimal lightSpeed = new BigDecimal("9460730472580800");
	public static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);
	
	public static void main(String g[]){
		saveFileToDB("D:\\assignment\\InterstellarApp\\src\\main\\java\\com\\gagan\\util\\Planet_Travel_Info.xlsx");
	}
	public static void saveFileToDB(String filePath) {
		Transaction tx = null;
		Session session = null;
		Workbook workbook = null;
		try {
			//String filePath = new ExcelReader().getClass().getResource(SAMPLE_XLSX_FILE_PATH).getFile();
			workbook = WorkbookFactory.create(new File(filePath));

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			logger.info("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

			logger.info("Retrieving Sheets using Java 8 forEach with lambda");

			List<PlanetVertex> l =session.createCriteria(PlanetVertex.class).list();
			
			if(l==null || l.isEmpty()){
				readPlanetSheet(workbook, session);
				readRouteSheet(workbook, session);
				// readTravelSheet(workbook, session);
				logger.info("File persistsed into DB");
			}
			else{
				logger.info("File data is already saved into DB");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null)
				tx.commit();
			if (session != null)
				session.close();

			HibernateUtil.shutdown();
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void readPlanetSheet(Workbook workbook, Session session) {
		workbook.forEach(sheet -> {
			logger.info("=> " + sheet.getSheetName());
		});

		Sheet planetName = workbook.getSheetAt(0);
		planetName.forEach(row -> {
			logger.info(row.getRowNum()+"");
			if (row.getRowNum() != 0 && !StringUtils.isEmpty(row.getCell(0).getStringCellValue())) {
				PlanetVertex p = new PlanetVertex(row.getCell(0).getStringCellValue());
				p.setPlanetName(row.getCell(1).getStringCellValue());
				session.save(p);
				logger.info("Saved");
			}
		});

	}

	private static void readRouteSheet(Workbook workbook, Session session) {
		Sheet route = workbook.getSheetAt(1);
		route.forEach(row -> {
			if (row.getRowNum() != 0 && row.getCell(1)!=null) {
				PlanetVertex vertex1 = session.get(PlanetVertex.class, row.getCell(1).getStringCellValue());
				PlanetVertex vertex2 = session.get(PlanetVertex.class, row.getCell(2).getStringCellValue());

				if(vertex1!=null && vertex2!=null){
					logger.info("===================================");
					logger.info(vertex1.toString());
					logger.info(vertex2.toString());
					//row.getCell(2).setCellType(CellType.NUMERIC);
					Edge e= new Edge((int)row.getCell(0).getNumericCellValue(), vertex2,vertex1, row.getCell(3).getNumericCellValue()*lightSpeed.doubleValue() );
					vertex1.addNeighbour(e);
					session.update(vertex1);
				}
			}
		});
	}

	private static void readTravelSheet(Workbook workbook, Session session) {
		Sheet route = workbook.getSheetAt(2);

		route.forEach(row -> {
			if (row.getRowNum() != 0) {
				int id = (int) row.getCell(0).getNumericCellValue();
				Edge e = session.get(Edge.class, id);
				if (e != null) {
					row.getCell(2).setCellType(CellType.NUMERIC);
					//e.setTrafficDelay(row.getCell(2).getNumericCellValue() * lightSpeed.doubleValue());
					// session.update(r);
				}
			}
		});
	}
}
