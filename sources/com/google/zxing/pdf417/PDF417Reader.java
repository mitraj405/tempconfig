package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Map;

public final class PDF417Reader implements Reader, MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];

    private static int getMaxCodewordWidth(ResultPoint[] resultPointArr) {
        return Math.max(Math.max(getMaxWidth(resultPointArr[0], resultPointArr[4]), (getMaxWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.max(getMaxWidth(resultPointArr[1], resultPointArr[5]), (getMaxWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    private static int getMaxWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    private static int getMinCodewordWidth(ResultPoint[] resultPointArr) {
        return Math.min(Math.min(getMinWidth(resultPointArr[0], resultPointArr[4]), (getMinWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), Math.min(getMinWidth(resultPointArr[1], resultPointArr[5]), (getMinWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    private static int getMinWidth(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException, ChecksumException {
        return decode(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        Result result;
        Result[] decode = decode(binaryBitmap, map, false);
        if (decode.length != 0 && (result = decode[0]) != null) {
            return result;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return decode(binaryBitmap, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static Result[] decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        PDF417DetectorResult detect = Detector.detect(binaryBitmap, map, z);
        for (ResultPoint[] next : detect.getPoints()) {
            DecoderResult decode = PDF417ScanningDecoder.decode(detect.getBits(), next[4], next[5], next[6], next[7], getMinCodewordWidth(next), getMaxCodewordWidth(next));
            Result result = new Result(decode.getText(), decode.getRawBytes(), next, BarcodeFormat.PDF_417);
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, decode.getECLevel());
            PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata) decode.getOther();
            if (pDF417ResultMetadata != null) {
                result.putMetadata(ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
            }
            arrayList.add(result);
        }
        return (Result[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }

    public void reset() {
    }
}
