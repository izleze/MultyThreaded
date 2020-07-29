package com.testproject.andrey.service;

import com.testproject.andrey.dto.HardDriveStatistics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CastToDtoService {
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public HardDriveStatistics castToDto(String line) {
        int counter = 0;
        String[] strings = line.split(",");
        return HardDriveStatistics.builder()
                .date(LocalDate.parse(strings[counter++], df))
                .serial_number(strings[counter++])
                .model(strings[counter++])
                .capacity_bytes(parseLong(strings[counter++]))
                .failure(parseInt(strings[counter++]))
                .smart_1_normalized(parseLong(strings[counter++]))
                .smart_1_raw(parseLong(strings[counter++]))
                .smart_2_normalized(parseLong(strings[counter++]))
                .smart_2_raw(parseLong(strings[counter++]))
                .smart_3_normalized(parseLong(strings[counter++]))
                .smart_3_raw(parseLong(strings[counter++]))
                .smart_4_normalized(parseLong(strings[counter++]))
                .smart_4_raw(parseLong(strings[counter++]))
                .smart_5_normalized(parseLong(strings[counter++]))
                .smart_5_raw(parseLong(strings[counter++]))
                .smart_7_normalized(parseLong(strings[counter++]))
                .smart_7_raw(parseLong(strings[counter++]))
                .smart_8_normalized(parseLong(strings[counter++]))
                .smart_8_raw(parseLong(strings[counter++]))
                .smart_9_normalized(parseLong(strings[counter++]))
                .smart_9_raw(parseLong(strings[counter++]))
                .smart_10_normalized(parseLong(strings[counter++]))
                .smart_10_raw(parseLong(strings[counter++]))
                .smart_11_normalized(parseLong(strings[counter++]))
                .smart_11_raw(parseLong(strings[counter++]))
                .smart_12_normalized(parseLong(strings[counter++]))
                .smart_12_raw(parseLong(strings[counter++]))
                .smart_13_normalized(parseLong(strings[counter++]))
                .smart_13_raw(parseLong(strings[counter++]))
                .smart_15_normalized(parseLong(strings[counter++]))
                .smart_15_raw(parseLong(strings[counter++]))
                .smart_16_normalized(parseLong(strings[counter++]))
                .smart_16_raw(parseLong(strings[counter++]))
                .smart_17_normalized(parseLong(strings[counter++]))
                .smart_17_raw(parseLong(strings[counter++]))
                .smart_22_normalized(parseLong(strings[counter++]))
                .smart_22_raw(parseLong(strings[counter++]))
                .smart_23_normalized(parseLong(strings[counter++]))
                .smart_23_raw(parseLong(strings[counter++]))
                .smart_24_normalized(parseLong(strings[counter++]))
                .smart_24_raw(parseLong(strings[counter++]))
                .smart_168_normalized(parseLong(strings[counter++]))
                .smart_168_raw(parseLong(strings[counter++]))
                .smart_170_normalized(parseLong(strings[counter++]))
                .smart_170_raw(parseLong(strings[counter++]))
                .smart_173_normalized(parseLong(strings[counter++]))
                .smart_173_raw(parseLong(strings[counter++]))
                .smart_174_normalized(parseLong(strings[counter++]))
                .smart_174_raw(parseLong(strings[counter++]))
                .smart_177_normalized(parseLong(strings[counter++]))
                .smart_177_raw(parseLong(strings[counter++]))
                .smart_179_normalized(parseLong(strings[counter++]))
                .smart_179_raw(parseLong(strings[counter++]))
                .smart_181_normalized(parseLong(strings[counter++]))
                .smart_181_raw(parseLong(strings[counter++]))
                .smart_182_normalized(parseLong(strings[counter++]))
                .smart_182_raw(parseLong(strings[counter++]))
                .smart_183_normalized(parseLong(strings[counter++]))
                .smart_183_raw(parseLong(strings[counter++]))
                .smart_184_normalized(parseLong(strings[counter++]))
                .smart_184_raw(parseLong(strings[counter++]))
                .smart_187_normalized(parseLong(strings[counter++]))
                .smart_187_raw(parseLong(strings[counter++]))
                .smart_188_normalized(parseLong(strings[counter++]))
                .smart_188_raw(parseLong(strings[counter++]))
                .smart_189_normalized(parseLong(strings[counter++]))
                .smart_189_raw(parseLong(strings[counter++]))
                .smart_190_normalized(parseLong(strings[counter++]))
                .smart_190_raw(parseLong(strings[counter++]))
                .smart_191_normalized(parseLong(strings[counter++]))
                .smart_191_raw(parseLong(strings[counter++]))
                .smart_192_normalized(parseLong(strings[counter++]))
                .smart_192_raw(parseLong(strings[counter++]))
                .smart_193_normalized(parseLong(strings[counter++]))
                .smart_193_raw(parseLong(strings[counter++]))
                .smart_194_normalized(parseLong(strings[counter++]))
                .smart_194_raw(parseLong(strings[counter++]))
                .smart_195_normalized(parseLong(strings[counter++]))
                .smart_195_raw(parseLong(strings[counter++]))
                .smart_196_normalized(parseLong(strings[counter++]))
                .smart_196_raw(parseLong(strings[counter++]))
                .smart_197_normalized(parseLong(strings[counter++]))
                .smart_197_raw(parseLong(strings[counter++]))
                .smart_198_normalized(parseLong(strings[counter++]))
                .smart_198_raw(parseLong(strings[counter++]))
                .smart_199_normalized(parseLong(strings[counter++]))
                .smart_199_raw(parseLong(strings[counter++]))
                .smart_200_normalized(parseLong(strings[counter++]))
                .smart_200_raw(parseLong(strings[counter++]))
                .smart_201_normalized(parseLong(strings[counter++]))
                .smart_201_raw(parseLong(strings[counter++]))
                .smart_218_normalized(parseLong(strings[counter++]))
                .smart_218_raw(parseLong(strings[counter++]))
                .smart_220_normalized(parseLong(strings[counter++]))
                .smart_220_raw(parseLong(strings[counter++]))
                .smart_222_normalized(parseLong(strings[counter++]))
                .smart_222_raw(parseLong(strings[counter++]))
                .smart_223_normalized(parseLong(strings[counter++]))
                .smart_223_raw(parseLong(strings[counter++]))
                .smart_224_normalized(parseLong(strings[counter++]))
                .smart_224_raw(parseLong(strings[counter++]))
                .smart_225_normalized(parseLong(strings[counter++]))
                .smart_225_raw(parseLong(strings[counter++]))
                .smart_226_normalized(parseLong(strings[counter++]))
                .smart_226_raw(parseLong(strings[counter++]))
                .smart_231_normalized(parseLong(strings[counter++]))
                .smart_231_raw(parseLong(strings[counter++]))
                .smart_232_normalized(parseLong(strings[counter++]))
                .smart_232_raw(parseLong(strings[counter++]))
                .smart_233_normalized(parseLong(strings[counter++]))
                .smart_233_raw(parseLong(strings[counter++]))
                .smart_235_normalized(parseLong(strings[counter++]))
                .smart_235_raw(parseLong(strings[counter++]))
                .smart_240_normalized(parseLong(strings[counter++]))
                .smart_240_raw(parseLong(strings[counter++]))
                .smart_241_normalized(parseLong(strings[counter++]))
                .smart_241_raw(parseLong(strings[counter++]))
                .smart_242_normalized(parseLong(strings[counter++]))
                .smart_242_raw(parseLong(strings[counter++]))
                .smart_250_normalized(parseLong(strings[counter++]))
                .smart_250_raw(parseLong(strings[counter++]))
                .smart_251_normalized(parseLong(strings[counter++]))
                .smart_251_raw(parseLong(strings[counter++]))
                .smart_252_normalized(parseLong(strings[counter++]))
                .smart_252_raw(parseLong(strings[counter++]))
                .smart_254_normalized(parseLong(strings[counter++]))
                .smart_254_raw(parseLong(strings[counter++]))
                .smart_255_normalized(parseLong(strings[counter++]))
                .smart_255_raw(parseLong(strings[counter]))
                .build();
    }
    
    private int parseInt(String string) {
        if (string != null && string.equals("")) {
            return 0;
        }
        
        return Integer.parseInt(string);
    }    
    
    private long parseLong(String string) {
        if (string != null && string.equals("")) {
            return 0L;
        }
        
        return Long.parseLong(string);
    }
}
