package com.testproject.service;

import com.testproject.dto.HardDriveStatistics;

import java.math.BigDecimal;

public class CalculationsService {

    public BigDecimal allNormalized(HardDriveStatistics hardDriveStatistics) {
        return BigDecimal.valueOf(
                hardDriveStatistics.getSmart_1_normalized() +
                hardDriveStatistics.getSmart_2_normalized() +
                hardDriveStatistics.getSmart_3_normalized() +
                hardDriveStatistics.getSmart_4_normalized() +
                hardDriveStatistics.getSmart_5_normalized() +
                hardDriveStatistics.getSmart_7_normalized() +
                hardDriveStatistics.getSmart_8_normalized() +
                hardDriveStatistics.getSmart_9_normalized() +
                hardDriveStatistics.getSmart_10_normalized() +
                hardDriveStatistics.getSmart_11_normalized() +
                hardDriveStatistics.getSmart_12_normalized() +
                hardDriveStatistics.getSmart_13_normalized() +
                hardDriveStatistics.getSmart_15_normalized() +
                hardDriveStatistics.getSmart_16_normalized() +
                hardDriveStatistics.getSmart_17_normalized() +
                hardDriveStatistics.getSmart_22_normalized() +
                hardDriveStatistics.getSmart_23_normalized() +
                hardDriveStatistics.getSmart_24_normalized() +
                hardDriveStatistics.getSmart_168_normalized() +
                hardDriveStatistics.getSmart_170_normalized() +
                hardDriveStatistics.getSmart_173_normalized() +
                hardDriveStatistics.getSmart_174_normalized() +
                hardDriveStatistics.getSmart_177_normalized() +
                hardDriveStatistics.getSmart_179_normalized() +
                hardDriveStatistics.getSmart_181_normalized() +
                hardDriveStatistics.getSmart_182_normalized() +
                hardDriveStatistics.getSmart_183_normalized() +
                hardDriveStatistics.getSmart_184_normalized() +
                hardDriveStatistics.getSmart_187_normalized() +
                hardDriveStatistics.getSmart_188_normalized() +
                hardDriveStatistics.getSmart_189_normalized() +
                hardDriveStatistics.getSmart_190_normalized() +
                hardDriveStatistics.getSmart_191_normalized() +
                hardDriveStatistics.getSmart_192_normalized() +
                hardDriveStatistics.getSmart_193_normalized() +
                hardDriveStatistics.getSmart_194_normalized() +
                hardDriveStatistics.getSmart_195_normalized() +
                hardDriveStatistics.getSmart_196_normalized() +
                hardDriveStatistics.getSmart_197_normalized() +
                hardDriveStatistics.getSmart_198_normalized() +
                hardDriveStatistics.getSmart_199_normalized() +
                hardDriveStatistics.getSmart_200_normalized() +
                hardDriveStatistics.getSmart_201_normalized() +
                hardDriveStatistics.getSmart_218_normalized() +
                hardDriveStatistics.getSmart_220_normalized() +
                hardDriveStatistics.getSmart_222_normalized() +
                hardDriveStatistics.getSmart_223_normalized() +
                hardDriveStatistics.getSmart_224_normalized() +
                hardDriveStatistics.getSmart_225_normalized() +
                hardDriveStatistics.getSmart_226_normalized() +
                hardDriveStatistics.getSmart_231_normalized() +
                hardDriveStatistics.getSmart_231_normalized() +
                hardDriveStatistics.getSmart_232_normalized() +
                hardDriveStatistics.getSmart_232_normalized() +
                hardDriveStatistics.getSmart_233_normalized() +
                hardDriveStatistics.getSmart_235_normalized() +
                hardDriveStatistics.getSmart_240_normalized() +
                hardDriveStatistics.getSmart_241_normalized() +
                hardDriveStatistics.getSmart_242_normalized() +
                hardDriveStatistics.getSmart_250_normalized() +
                hardDriveStatistics.getSmart_251_normalized() +
                hardDriveStatistics.getSmart_252_normalized() +
                hardDriveStatistics.getSmart_254_normalized() +
                hardDriveStatistics.getSmart_255_normalized());
    }

    public BigDecimal allRaw(HardDriveStatistics hardDriveStatistics) {
        return BigDecimal.valueOf(
                hardDriveStatistics.getSmart_1_raw() +
                hardDriveStatistics.getSmart_2_raw() +
                hardDriveStatistics.getSmart_3_raw() +
                hardDriveStatistics.getSmart_4_raw() +
                hardDriveStatistics.getSmart_5_raw() +
                hardDriveStatistics.getSmart_7_raw() +
                hardDriveStatistics.getSmart_8_raw() +
                hardDriveStatistics.getSmart_9_raw() +
                hardDriveStatistics.getSmart_10_raw() +
                hardDriveStatistics.getSmart_11_raw() +
                hardDriveStatistics.getSmart_12_raw() +
                hardDriveStatistics.getSmart_13_raw() +
                hardDriveStatistics.getSmart_15_raw() +
                hardDriveStatistics.getSmart_16_raw() +
                hardDriveStatistics.getSmart_17_raw() +
                hardDriveStatistics.getSmart_22_raw() +
                hardDriveStatistics.getSmart_23_raw() +
                hardDriveStatistics.getSmart_24_raw() +
                hardDriveStatistics.getSmart_168_raw() +
                hardDriveStatistics.getSmart_170_raw() +
                hardDriveStatistics.getSmart_173_raw() +
                hardDriveStatistics.getSmart_174_raw() +
                hardDriveStatistics.getSmart_177_raw() +
                hardDriveStatistics.getSmart_179_raw() +
                hardDriveStatistics.getSmart_181_raw() +
                hardDriveStatistics.getSmart_182_raw() +
                hardDriveStatistics.getSmart_183_raw() +
                hardDriveStatistics.getSmart_184_raw() +
                hardDriveStatistics.getSmart_187_raw() +
                hardDriveStatistics.getSmart_188_raw() +
                hardDriveStatistics.getSmart_189_raw() +
                hardDriveStatistics.getSmart_190_raw() +
                hardDriveStatistics.getSmart_191_raw() +
                hardDriveStatistics.getSmart_192_raw() +
                hardDriveStatistics.getSmart_193_raw() +
                hardDriveStatistics.getSmart_194_raw() +
                hardDriveStatistics.getSmart_195_raw() +
                hardDriveStatistics.getSmart_196_raw() +
                hardDriveStatistics.getSmart_197_raw() +
                hardDriveStatistics.getSmart_198_raw() +
                hardDriveStatistics.getSmart_199_raw() +
                hardDriveStatistics.getSmart_200_raw() +
                hardDriveStatistics.getSmart_201_raw() +
                hardDriveStatistics.getSmart_218_raw() +
                hardDriveStatistics.getSmart_220_raw() +
                hardDriveStatistics.getSmart_222_raw() +
                hardDriveStatistics.getSmart_223_raw() +
                hardDriveStatistics.getSmart_224_raw() +
                hardDriveStatistics.getSmart_225_raw() +
                hardDriveStatistics.getSmart_226_raw() +
                hardDriveStatistics.getSmart_231_raw() +
                hardDriveStatistics.getSmart_231_raw() +
                hardDriveStatistics.getSmart_232_raw() +
                hardDriveStatistics.getSmart_232_raw() +
                hardDriveStatistics.getSmart_233_raw() +
                hardDriveStatistics.getSmart_235_raw() +
                hardDriveStatistics.getSmart_240_raw() +
                hardDriveStatistics.getSmart_241_raw() +
                hardDriveStatistics.getSmart_242_raw() +
                hardDriveStatistics.getSmart_250_raw() +
                hardDriveStatistics.getSmart_251_raw() +
                hardDriveStatistics.getSmart_252_raw() +
                hardDriveStatistics.getSmart_254_raw() +
                hardDriveStatistics.getSmart_255_raw());
    }
}
