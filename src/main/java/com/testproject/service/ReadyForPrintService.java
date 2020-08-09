package com.testproject.service;

import com.testproject.dto.HardDriveStatistics;

public class ReadyForPrintService {
    public String dataToShow(String line) {
        CastToDtoService castToDtoService = new CastToDtoService();
        HardDriveStatistics statistics = castToDtoService.castToDto(line);
        CalculationsService calculations = new CalculationsService();

        return "All normalized data for " + statistics.getSerial_number() + " model: " + statistics.getModel()
                + "for date " + statistics.getDate().toString() + " sum of normalized data "
                + calculations.allNormalized(statistics) + " sum of raw data " + calculations.allRaw(statistics);
    }
}
