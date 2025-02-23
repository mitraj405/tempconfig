package com.google.android.material.color.utilities;

import com.google.firebase.perf.util.Constants;

public class HctSolver {
    static final double[] CRITICAL_PLANES;
    static final double[][] LINRGB_FROM_SCALED_DISCOUNT = {new double[]{1373.2198709594231d, -1100.4251190754821d, -7.278681089101213d}, new double[]{-271.815969077903d, 559.6580465940733d, -32.46047482791194d}, new double[]{1.9622899599665666d, -57.173814538844006d, 308.7233197812385d}};
    static final double[][] SCALED_DISCOUNT_FROM_LINRGB = {new double[]{0.001200833568784504d, 0.002389694492170889d, 2.795742885861124E-4d}, new double[]{5.891086651375999E-4d, 0.0029785502573438758d, 3.270666104008398E-4d}, new double[]{1.0146692491640572E-4d, 5.364214359186694E-4d, 0.0032979401770712076d}};
    static final double[] Y_FROM_LINRGB = {0.2126d, 0.7152d, 0.0722d};

    static {
        double[] dArr = new double[Constants.MAX_HOST_LENGTH];
        // fill-array-data instruction
        dArr[0] = 4579902191445101026;
        dArr[1] = 4586722248283830121;
        dArr[2] = 4590132276703194669;
        dArr[3] = 4592319419119206566;
        dArr[4] = 4594089090726562190;
        dArr[5] = 4595182661934568139;
        dArr[6] = 4596276233142574086;
        dArr[7] = 4597369804350580035;
        dArr[8] = 4598319297551931200;
        dArr[9] = 4598866083155934174;
        dArr[10] = 4599415152223961264;
        dArr[11] = 4599993339557554103;
        dArr[12] = 4600604127797384872;
        dArr[13] = 4601248022022383854;
        dArr[14] = 4601925516007072940;
        dArr[15] = 4602637092872232998;
        dArr[16] = 4603031022424726288;
        dArr[17] = 4603421598565390387;
        dArr[18] = 4603829911699615164;
        dArr[19] = 4604256184796179975;
        dArr[20] = 4604700636746540938;
        dArr[21] = 4605163482557825057;
        dArr[22] = 4605644933531403035;
        dArr[23] = 4606145197428491360;
        dArr[24] = 4606664478624053163;
        dArr[25] = 4607192698525064880;
        dArr[26] = 4607471656564740588;
        dArr[27] = 4607760420350332768;
        dArr[28] = 4608059085967490067;
        dArr[29] = 4608367748123105663;
        dArr[30] = 4608686500196850546;
        dArr[31] = 4609015434289647817;
        dArr[32] = 4609354641269333833;
        dArr[33] = 4609704210813727368;
        dArr[34] = 4610064231451306159;
        dArr[35] = 4610434790599671070;
        dArr[36] = 4610815974601961079;
        dArr[37] = 4611207868761367246;
        dArr[38] = 4611610557373880335;
        dArr[39] = 4611855071093391427;
        dArr[40] = 4612067334359334994;
        dArr[41] = 4612285118425960339;
        dArr[42] = 4612508463574977203;
        dArr[43] = 4612737409655089301;
        dArr[44] = 4612971996094189114;
        dArr[45] = 4613212261911004224;
        dArr[46] = 4613458245726228713;
        dArr[47] = 4613709985773170670;
        dArr[48] = 4613967519907944419;
        dArr[49] = 4614230885619234013;
        dArr[50] = 4614500120037652566;
        dArr[51] = 4614775259944720202;
        dArr[52] = 4615056341781481853;
        dArr[53] = 4615343401656784577;
        dArr[54] = 4615636475355232722;
        dArr[55] = 4615935598344838114;
        dArr[56] = 4616215211919569774;
        dArr[57] = 4616370875292628065;
        dArr[58] = 4616529615599632208;
        dArr[59] = 4616691449976872178;
        dArr[60] = 4616856395419441158;
        dArr[61] = 4617024468784296090;
        dArr[62] = 4617195686793211866;
        dArr[63] = 4617370066035634218;
        dArr[64] = 4617547622971436010;
        dArr[65] = 4617728373933581454;
        dArr[66] = 4617912335130702427;
        dArr[67] = 4618099522649590851;
        dArr[68] = 4618289952457610916;
        dArr[69] = 4618483640405034599;
        dArr[70] = 4618680602227303887;
        dArr[71] = 4618880853547222806;
        dArr[72] = 4619084409877082270;
        dArr[73] = 4619291286620720537;
        dArr[74] = 4619501499075521954;
        dArr[75] = 4619715062434356516;
        dArr[76] = 4619931991787462676;
        dArr[77] = 4620152302124275621;
        dArr[78] = 4620376008335203209;
        dArr[79] = 4620603125213351606;
        dArr[80] = 4620763442569165759;
        dArr[81] = 4620880433674686702;
        dArr[82] = 4620999152019843489;
        dArr[83] = 4621119604814744327;
        dArr[84] = 4621241799224816048;
        dArr[85] = 4621365742371534952;
        dArr[86] = 4621491441333138438;
        dArr[87] = 4621618903145318084;
        dArr[88] = 4621748134801894866;
        dArr[89] = 4621879143255477120;
        dArr[90] = 4622011935418101880;
        dArr[91] = 4622146518161860145;
        dArr[92] = 4622282898319506637;
        dArr[93] = 4622421082685054575;
        dArr[94] = 4622561078014355982;
        dArr[95] = 4622702891025667973;
        dArr[96] = 4622846528400205557;
        dArr[97] = 4622991996782681293;
        dArr[98] = 4623139302781832335;
        dArr[99] = 4623288452970935186;
        dArr[100] = 4623439453888308616;
        dArr[101] = 4623592312037805078;
        dArr[102] = 4623747033889290991;
        dArr[103] = 4623903625879116247;
        dArr[104] = 4624062094410573275;
        dArr[105] = 4624222445854345961;
        dArr[106] = 4624384686548948761;
        dArr[107] = 4624548822801156258;
        dArr[108] = 4624714860886423508;
        dArr[109] = 4624882807049297389;
        dArr[110] = 4625052667503819266;
        dArr[111] = 4625210632871709275;
        dArr[112] = 4625297486651650571;
        dArr[113] = 4625385306808911890;
        dArr[114] = 4625474096391433360;
        dArr[115] = 4625563858432847940;
        dArr[116] = 4625654595952659106;
        dArr[117] = 4625746311956415008;
        dArr[118] = 4625839009435879146;
        dArr[119] = 4625932691369197680;
        dArr[120] = 4626027360721063483;
        dArr[121] = 4626123020442876984;
        dArr[122] = 4626219673472903927;
        dArr[123] = 4626317322736430091;
        dArr[124] = 4626415971145913094;
        dArr[125] = 4626515621601131305;
        dArr[126] = 4626616276989329999;
        dArr[127] = 4626717940185364762;
        dArr[128] = 4626820614051842266;
        dArr[129] = 4626924301439258476;
        dArr[130] = 4627029005186134299;
        dArr[131] = 4627134728119148831;
        dArr[132] = 4627241473053270172;
        dArr[133] = 4627349242791883926;
        dArr[134] = 4627458040126919441;
        dArr[135] = 4627567867838973780;
        dArr[136] = 4627678728697433589;
        dArr[137] = 4627790625460594799;
        dArr[138] = 4627903560875780285;
        dArr[139] = 4628017537679455519;
        dArr[140] = 4628132558597342234;
        dArr[141] = 4628248626344530177;
        dArr[142] = 4628365743625587008;
        dArr[143] = 4628483913134666308;
        dArr[144] = 4628603137555613863;
        dArr[145] = 4628723419562072149;
        dArr[146] = 4628844761817583119;
        dArr[147] = 4628967166975689348;
        dArr[148] = 4629090637680033469;
        dArr[149] = 4629215176564456113;
        dArr[150] = 4629340786253092199;
        dArr[151] = 4629467469360465727;
        dArr[152] = 4629595228491583094;
        dArr[153] = 4629712241589447398;
        dArr[154] = 4629777201067453150;
        dArr[155] = 4629842702436743186;
        dArr[156] = 4629908746981237562;
        dArr[157] = 4629975335980320128;
        dArr[158] = 4630042470708880985;
        dArr[159] = 4630110152437358354;
        dArr[160] = 4630178382431779783;
        dArr[161] = 4630247161953802740;
        dArr[162] = 4630316492260754622;
        dArr[163] = 4630386374605672153;
        dArr[164] = 4630456810237340203;
        dArr[165] = 4630527800400330062;
        dArr[166] = 4630599346335037121;
        dArr[167] = 4630671449277718047;
        dArr[168] = 4630744110460527385;
        dArr[169] = 4630817331111553677;
        dArr[170] = 4630891112454855033;
        dArr[171] = 4630965455710494212;
        dArr[172] = 4631040362094573213;
        dArr[173] = 4631115832819267388;
        dArr[174] = 4631191869092859051;
        dArr[175] = 4631268472119770665;
        dArr[176] = 4631345643100597525;
        dArr[177] = 4631423383232140038;
        dArr[178] = 4631501693707435534;
        dArr[179] = 4631580575715789650;
        dArr[180] = 4631660030442807299;
        dArr[181] = 4631740059070423220;
        dArr[182] = 4631820662776932122;
        dArr[183] = 4631901842737018425;
        dArr[184] = 4631983600121785599;
        dArr[185] = 4632065936098785144;
        dArr[186] = 4632148851832045157;
        dArr[187] = 4632232348482098562;
        dArr[188] = 4632316427206010939;
        dArr[189] = 4632401089157408025;
        dArr[190] = 4632486335486502848;
        dArr[191] = 4632572167340122509;
        dArr[192] = 4632658585861734647;
        dArr[193] = 4632745592191473537;
        dArr[194] = 4632833187466165889;
        dArr[195] = 4632921372819356314;
        dArr[196] = 4633010149381332451;
        dArr[197] = 4633099518279149837;
        dArr[198] = 4633189480636656412;
        dArr[199] = 4633280037574516751;
        dArr[200] = 4633371190210236008;
        dArr[201] = 4633462939658183536;
        dArr[202] = 4633555287029616272;
        dArr[203] = 4633648233432701789;
        dArr[204] = 4633741779972541089;
        dArr[205] = 4633835927751191153;
        dArr[206] = 4633930677867687184;
        dArr[207] = 4634026031418064590;
        dArr[208] = 4634121989495380747;
        dArr[209] = 4634211284876988415;
        dArr[210] = 4634259870076268772;
        dArr[211] = 4634308759169777192;
        dArr[212] = 4634357952698192419;
        dArr[213] = 4634407451200756650;
        dArr[214] = 4634457255215285655;
        dArr[215] = 4634507365278178801;
        dArr[216] = 4634557781924428958;
        dArr[217] = 4634608505687632279;
        dArr[218] = 4634659537099997902;
        dArr[219] = 4634710876692357502;
        dArr[220] = 4634762524994174769;
        dArr[221] = 4634814482533554771;
        dArr[222] = 4634866749837253199;
        dArr[223] = 4634919327430685537;
        dArr[224] = 4634972215837936106;
        dArr[225] = 4635025415581767022;
        dArr[226] = 4635078927183627061;
        dArr[227] = 4635132751163660409;
        dArr[228] = 4635186888040715339;
        dArr[229] = 4635241338332352781;
        dArr[230] = 4635296102554854808;
        dArr[231] = 4635351181223233026;
        dArr[232] = 4635406574851236876;
        dArr[233] = 4635462283951361850;
        dArr[234] = 4635518309034857618;
        dArr[235] = 4635574650611736079;
        dArr[236] = 4635631309190779308;
        dArr[237] = 4635688285279547439;
        dArr[238] = 4635745579384386464;
        dArr[239] = 4635803192010435943;
        dArr[240] = 4635861123661636633;
        dArr[241] = 4635919374840738054;
        dArr[242] = 4635977946049305967;
        dArr[243] = 4636036837787729777;
        dArr[244] = 4636096050555229854;
        dArr[245] = 4636155584849864797;
        dArr[246] = 4636215441168538620;
        dArr[247] = 4636275620007007844;
        dArr[248] = 4636336121859888558;
        dArr[249] = 4636396947220663375;
        dArr[250] = 4636458096581688329;
        dArr[251] = 4636519570434199722;
        dArr[252] = 4636581369268320872;
        dArr[253] = 4636643493573068830;
        dArr[254] = 4636705943836361001;
        CRITICAL_PLANES = dArr;
    }

    private HctSolver() {
    }

    public static boolean areInCyclicOrder(double d, double d2, double d3) {
        if (sanitizeRadians(d2 - d) < sanitizeRadians(d3 - d)) {
            return true;
        }
        return false;
    }

    public static double[] bisectToLimit(double d, double d2) {
        int i;
        int i2;
        double[][] bisectToSegment = bisectToSegment(d, d2);
        double[] dArr = bisectToSegment[0];
        double hueOf = hueOf(dArr);
        double[] dArr2 = bisectToSegment[1];
        for (int i3 = 0; i3 < 3; i3++) {
            double d3 = dArr[i3];
            double d4 = dArr2[i3];
            if (d3 != d4) {
                if (d3 < d4) {
                    i2 = criticalPlaneBelow(trueDelinearized(d3));
                    i = criticalPlaneAbove(trueDelinearized(dArr2[i3]));
                } else {
                    i2 = criticalPlaneAbove(trueDelinearized(d3));
                    i = criticalPlaneBelow(trueDelinearized(dArr2[i3]));
                }
                int i4 = i2;
                int i5 = i;
                for (int i6 = 0; i6 < 8 && Math.abs(i5 - i4) > 1; i6++) {
                    int floor = (int) Math.floor(((double) (i4 + i5)) / 2.0d);
                    double[] coordinate = setCoordinate(dArr, CRITICAL_PLANES[floor], dArr2, i3);
                    double hueOf2 = hueOf(coordinate);
                    int i7 = floor;
                    if (areInCyclicOrder(hueOf, d2, hueOf2)) {
                        dArr2 = coordinate;
                        i5 = i7;
                    } else {
                        dArr = coordinate;
                        hueOf = hueOf2;
                        i4 = i7;
                    }
                }
            }
        }
        return midpoint(dArr, dArr2);
    }

    public static double[][] bisectToSegment(double d, double d2) {
        double[] dArr = {-1.0d, -1.0d, -1.0d};
        double[] dArr2 = dArr;
        double d3 = 0.0d;
        double d4 = 0.0d;
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < 12; i++) {
            double[] nthVertex = nthVertex(d, i);
            if (nthVertex[0] >= 0.0d) {
                double hueOf = hueOf(nthVertex);
                if (!z) {
                    z = true;
                    dArr = nthVertex;
                    dArr2 = dArr;
                    d3 = hueOf;
                    d4 = d3;
                } else if (z2 || areInCyclicOrder(d3, hueOf, d4)) {
                    if (areInCyclicOrder(d3, d2, hueOf)) {
                        z2 = false;
                        dArr2 = nthVertex;
                        d4 = hueOf;
                    } else {
                        z2 = false;
                        dArr = nthVertex;
                        d3 = hueOf;
                    }
                }
            }
        }
        return new double[][]{dArr, dArr2};
    }

    public static double chromaticAdaptation(double d) {
        double pow = Math.pow(Math.abs(d), 0.42d);
        return ((((double) MathUtils.signum(d)) * 400.0d) * pow) / (pow + 27.13d);
    }

    public static int criticalPlaneAbove(double d) {
        return (int) Math.ceil(d - 0.5d);
    }

    public static int criticalPlaneBelow(double d) {
        return (int) Math.floor(d - 0.5d);
    }

    public static int findResultByJ(double d, double d2, double d3) {
        double d4;
        double[] matrixMultiply;
        double sqrt = Math.sqrt(d3) * 11.0d;
        ViewingConditions viewingConditions = ViewingConditions.DEFAULT;
        double pow = 1.0d / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * (Math.cos(d + 2.0d) + 3.8d) * 0.25d * 3846.153846153846d;
        double sin = Math.sin(d);
        double cos = Math.cos(d);
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            }
            double d5 = sqrt / 100.0d;
            if (d2 == 0.0d || sqrt == 0.0d) {
                d4 = 0.0d;
            } else {
                d4 = d2 / Math.sqrt(d5);
            }
            double d6 = d4 * pow;
            double d7 = pow;
            double pow2 = Math.pow(d6, 1.1111111111111112d);
            double d8 = sqrt;
            double pow3 = (Math.pow(d5, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw()) / viewingConditions.getNbb();
            double d9 = (((0.305d + pow3) * 23.0d) * pow2) / (((pow2 * 108.0d) * sin) + (((pow2 * 11.0d) * cos) + (23.0d * ncb)));
            double d10 = d9 * cos;
            double d11 = d9 * sin;
            double d12 = pow3 * 460.0d;
            matrixMultiply = MathUtils.matrixMultiply(new double[]{inverseChromaticAdaptation(((288.0d * d11) + ((451.0d * d10) + d12)) / 1403.0d), inverseChromaticAdaptation(((d12 - (891.0d * d10)) - (261.0d * d11)) / 1403.0d), inverseChromaticAdaptation(((d12 - (d10 * 220.0d)) - (d11 * 6300.0d)) / 1403.0d)}, LINRGB_FROM_SCALED_DISCOUNT);
            double d13 = matrixMultiply[0];
            if (d13 < 0.0d) {
                break;
            }
            double d14 = matrixMultiply[1];
            if (d14 < 0.0d) {
                break;
            }
            double d15 = matrixMultiply[2];
            if (d15 >= 0.0d) {
                double[] dArr = Y_FROM_LINRGB;
                double d16 = dArr[0];
                double d17 = (dArr[2] * d15) + (dArr[1] * d14) + (d16 * d13);
                if (d17 > 0.0d) {
                    if (i == 4) {
                        break;
                    }
                    double d18 = d17 - d3;
                    if (Math.abs(d18) < 0.002d) {
                        break;
                    }
                    double d19 = d8;
                    sqrt = d19 - ((d18 * d19) / (d17 * 2.0d));
                    i++;
                    pow = d7;
                } else {
                    return 0;
                }
            } else {
                break;
            }
        }
        if (matrixMultiply[0] <= 100.01d && matrixMultiply[1] <= 100.01d && matrixMultiply[2] <= 100.01d) {
            return ColorUtils.argbFromLinrgb(matrixMultiply);
        }
        return 0;
    }

    public static double hueOf(double[] dArr) {
        double[] matrixMultiply = MathUtils.matrixMultiply(dArr, SCALED_DISCOUNT_FROM_LINRGB);
        double chromaticAdaptation = chromaticAdaptation(matrixMultiply[0]);
        double chromaticAdaptation2 = chromaticAdaptation(matrixMultiply[1]);
        double chromaticAdaptation3 = chromaticAdaptation(matrixMultiply[2]);
        return Math.atan2(((chromaticAdaptation + chromaticAdaptation2) - (chromaticAdaptation3 * 2.0d)) / 9.0d, (((-12.0d * chromaticAdaptation2) + (chromaticAdaptation * 11.0d)) + chromaticAdaptation3) / 11.0d);
    }

    public static double intercept(double d, double d2, double d3) {
        return (d2 - d) / (d3 - d);
    }

    public static double inverseChromaticAdaptation(double d) {
        double abs = Math.abs(d);
        return Math.pow(Math.max(0.0d, (27.13d * abs) / (400.0d - abs)), 2.380952380952381d) * ((double) MathUtils.signum(d));
    }

    public static boolean isBounded(double d) {
        if (0.0d > d || d > 100.0d) {
            return false;
        }
        return true;
    }

    public static double[] lerpPoint(double[] dArr, double d, double[] dArr2) {
        double d2 = dArr[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        return new double[]{((dArr2[0] - d2) * d) + d2, ((dArr2[1] - d3) * d) + d3, ((dArr2[2] - d4) * d) + d4};
    }

    public static double[] midpoint(double[] dArr, double[] dArr2) {
        return new double[]{(dArr[0] + dArr2[0]) / 2.0d, (dArr[1] + dArr2[1]) / 2.0d, (dArr[2] + dArr2[2]) / 2.0d};
    }

    public static double[] nthVertex(double d, int i) {
        double d2;
        int i2 = i;
        double[] dArr = Y_FROM_LINRGB;
        double d3 = dArr[0];
        double d4 = dArr[1];
        double d5 = dArr[2];
        double d6 = 0.0d;
        if (i2 % 4 <= 1) {
            d2 = 0.0d;
        } else {
            d2 = 100.0d;
        }
        if (i2 % 2 != 0) {
            d6 = 100.0d;
        }
        if (i2 < 4) {
            double d7 = ((d - (d4 * d2)) - (d5 * d6)) / d3;
            if (!isBounded(d7)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d7, d2, d6};
        } else if (i2 < 8) {
            double d8 = ((d - (d3 * d6)) - (d5 * d2)) / d4;
            if (!isBounded(d8)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d6, d8, d2};
        } else {
            double d9 = ((d - (d3 * d2)) - (d4 * d6)) / d5;
            if (!isBounded(d9)) {
                return new double[]{-1.0d, -1.0d, -1.0d};
            }
            return new double[]{d2, d6, d9};
        }
    }

    public static double sanitizeRadians(double d) {
        return (d + 25.132741228718345d) % 6.283185307179586d;
    }

    public static double[] setCoordinate(double[] dArr, double d, double[] dArr2, int i) {
        return lerpPoint(dArr, intercept(dArr[i], d, dArr2[i]), dArr2);
    }

    public static Cam16 solveToCam(double d, double d2, double d3) {
        return Cam16.fromInt(solveToInt(d, d2, d3));
    }

    public static int solveToInt(double d, double d2, double d3) {
        if (d2 < 1.0E-4d || d3 < 1.0E-4d || d3 > 99.9999d) {
            return ColorUtils.argbFromLstar(d3);
        }
        double sanitizeDegreesDouble = (MathUtils.sanitizeDegreesDouble(d) / 180.0d) * 3.141592653589793d;
        double yFromLstar = ColorUtils.yFromLstar(d3);
        int findResultByJ = findResultByJ(sanitizeDegreesDouble, d2, yFromLstar);
        if (findResultByJ != 0) {
            return findResultByJ;
        }
        return ColorUtils.argbFromLinrgb(bisectToLimit(yFromLstar, sanitizeDegreesDouble));
    }

    public static double trueDelinearized(double d) {
        double d2;
        double d3 = d / 100.0d;
        if (d3 <= 0.0031308d) {
            d2 = d3 * 12.92d;
        } else {
            d2 = (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        return d2 * 255.0d;
    }
}
