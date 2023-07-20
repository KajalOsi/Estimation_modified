package com.osi.estimationmodule.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.dtos.EstimationResourceEffortDto;
import com.osi.estimationmodule.dtos.GlobalEstimationObject;
import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.ResourceEffort;
import com.osi.estimationmodule.services.IObjectTransformation;
import com.osi.estimationmodule.utils.CellEnum;

@Component
public class GlobalEstimationTransformation implements IObjectTransformation {

	@Override
	public GlobalEstimationObject transformObject(MultipartFile file) {
		GlobalEstimationObject globalEstimationObject = null;
		List<EstimationResourceEffortDto> estimationResourceEffortDtos = new LinkedList<>();

		InputStream inputStream = null;
		XSSFWorkbook workbook = null;
		try {
			inputStream = file.getInputStream();
			workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheet("Year 1");

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				if (row.getRowNum() <= 1) {
					continue;
				}

				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("Total Resources")) {
					break;
				}

				// Cell
				Iterator<Cell> cells = row.iterator();
				int cellId = 0;

				// To store data
				EstimationDetail estimation = new EstimationDetail();
				List<ResourceEffort> resourceEfforts = new ArrayList<>();

				while (cells.hasNext()) {
					Cell cell = cells.next();
					CellEnum cellEnum = CellEnum.fromCellId(cellId);
					if (cellEnum != null) {
						switch (cellEnum) {
						case ROLE:
							estimation.setRole(cell.getStringCellValue());
							break;

						case NO_OF_RESOURCES:
							estimation.setNoOfResources((int) cell.getNumericCellValue());
							break;
						case EMP_NAME:
							estimation.setEmpName(cell.getStringCellValue());
							break;
						case PROJECT_LOCATION:
							estimation.setProjectLocation(cell.getStringCellValue());
							break;
						case PRACTICE:
							estimation.setPractice(cell.getStringCellValue());
							break;
						case SUB_PRACTICE:
							estimation.setSubPractice(cell.getStringCellValue());
							break;
						case JOB_CODE:
							estimation.setJobCode(cell.getStringCellValue());
							break;
						case PREMIUM:
							estimation.setPreminum(cell.getStringCellValue());
							break;
						case JAN:
						case FEB:
						case MAR:
						case APR:
						case MAY:
						case JUN:
						case JUL:
						case AUG:
						case SEP:
						case OCT:
						case NOV:
						case DEC:

							int cellValue = (int) cell.getNumericCellValue();
							if (cellValue != 0) {
								ResourceEffort resourceEffort = new ResourceEffort();
								resourceEffort.setMonthName(cellEnum.name().substring(0, 3));
								resourceEffort.setManDays(cellValue);
								resourceEfforts.add(resourceEffort);
							}
							break;

						case TOTAL_DAYS:
							estimation.setTotalDays((int) cell.getNumericCellValue());
							break;
						case TOTAL_HOURS:
							estimation.setTotalHours((int) cell.getNumericCellValue());
							break;
						case SUGGESTED_HOURLY_RATE:
							estimation.setSuggestedHourlyRate((int) cell.getNumericCellValue());
							break;
						case HOURLY_RATE:
							estimation.setHourlyRate((int) cell.getNumericCellValue());
							break;
						case DAILY_RATE:
							estimation.setDailyRate((int) cell.getNumericCellValue());
							break;
						case TOTAL_FEES:
							estimation.setTotalFees((int) cell.getNumericCellValue());
							break;
						case HOURLY_COST:
							estimation.setHourlyCost((int) cell.getNumericCellValue());
							break;
						case STANDARD_TOTAL_COST:
							estimation.setStandardTotalCost((int) cell.getNumericCellValue());
							break;
						case OVERHEAD_COST:
							estimation.setOverheadCost((int) cell.getNumericCellValue());
							break;
						case NEW_HOURLY_COST:
							estimation.setNewHourlyCost((int) cell.getNumericCellValue());
							break;
						case TOTAL_COST:
							estimation.setTotalCost((int) cell.getNumericCellValue());
							break;
						case GROSS_MARGIN:
							estimation.setGrossMargin((int) cell.getNumericCellValue());
							break;
//						case GROSS_MARGIN_PERCENTAGE:
//							estimation.setGrossMarginPercentage((int) cell.getNumericCellValue());
//							break;
						default:
							break;
						}
					}
					cellId++;
				}

				if (!allFieldsAreEmpty(estimation)) {
					EstimationResourceEffortDto estimationResourceEffortDto = new EstimationResourceEffortDto();
					estimationResourceEffortDto.setEstimationDetail(estimation);
					estimationResourceEffortDto.setResourceEfforts(resourceEfforts);
					estimationResourceEffortDtos.add(estimationResourceEffortDto);
				}

			}
			globalEstimationObject = new GlobalEstimationObject();
			globalEstimationObject.setEstimationResourceEffortDtos(estimationResourceEffortDtos);
		} catch (Exception e) {
			System.err.println("first catch");
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				inputStream.close();
			} catch (IOException e) {
				System.err.println("second catch");
				e.printStackTrace();
			}
		}

		return globalEstimationObject;
	}

	private boolean allFieldsAreEmpty(EstimationDetail estimation) {
		return StringUtils.isAllBlank(estimation.getRole(), estimation.getEmpName(), estimation.getProjectLocation(),
				estimation.getPractice(), estimation.getSubPractice(), estimation.getJobCode(),
				estimation.getPreminum()) && estimation.getNoOfResources() == 0 && estimation.getTotalDays() == 0
				&& estimation.getTotalHours() == 0 && estimation.getSuggestedHourlyRate() == 0
				&& estimation.getHourlyRate() == 0 && estimation.getDailyRate() == 0 && estimation.getTotalFees() == 0
				&& estimation.getHourlyCost() == 0 && estimation.getStandardTotalCost() == 0
				&& estimation.getOverheadCost() == 0 && estimation.getNewHourlyCost() == 0
				&& estimation.getTotalCost() == 0 && estimation.getGrossMargin() == 0
				&& estimation.getGrossMarginPercentage() == 0;
	}

}
