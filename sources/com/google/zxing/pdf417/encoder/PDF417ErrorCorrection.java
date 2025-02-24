package com.google.zxing.pdf417.encoder;

import com.google.android.gms.ads.AdRequest;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import okhttp3.internal.http.StatusLine;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS;

    static {
        int[] iArr = new int[AdRequest.MAX_CONTENT_URL_LENGTH];
        // fill-array-data instruction
        iArr[0] = 352;
        iArr[1] = 77;
        iArr[2] = 373;
        iArr[3] = 504;
        iArr[4] = 35;
        iArr[5] = 599;
        iArr[6] = 428;
        iArr[7] = 207;
        iArr[8] = 409;
        iArr[9] = 574;
        iArr[10] = 118;
        iArr[11] = 498;
        iArr[12] = 285;
        iArr[13] = 380;
        iArr[14] = 350;
        iArr[15] = 492;
        iArr[16] = 197;
        iArr[17] = 265;
        iArr[18] = 920;
        iArr[19] = 155;
        iArr[20] = 914;
        iArr[21] = 299;
        iArr[22] = 229;
        iArr[23] = 643;
        iArr[24] = 294;
        iArr[25] = 871;
        iArr[26] = 306;
        iArr[27] = 88;
        iArr[28] = 87;
        iArr[29] = 193;
        iArr[30] = 352;
        iArr[31] = 781;
        iArr[32] = 846;
        iArr[33] = 75;
        iArr[34] = 327;
        iArr[35] = 520;
        iArr[36] = 435;
        iArr[37] = 543;
        iArr[38] = 203;
        iArr[39] = 666;
        iArr[40] = 249;
        iArr[41] = 346;
        iArr[42] = 781;
        iArr[43] = 621;
        iArr[44] = 640;
        iArr[45] = 268;
        iArr[46] = 794;
        iArr[47] = 534;
        iArr[48] = 539;
        iArr[49] = 781;
        iArr[50] = 408;
        iArr[51] = 390;
        iArr[52] = 644;
        iArr[53] = 102;
        iArr[54] = 476;
        iArr[55] = 499;
        iArr[56] = 290;
        iArr[57] = 632;
        iArr[58] = 545;
        iArr[59] = 37;
        iArr[60] = 858;
        iArr[61] = 916;
        iArr[62] = 552;
        iArr[63] = 41;
        iArr[64] = 542;
        iArr[65] = 289;
        iArr[66] = 122;
        iArr[67] = 272;
        iArr[68] = 383;
        iArr[69] = 800;
        iArr[70] = 485;
        iArr[71] = 98;
        iArr[72] = 752;
        iArr[73] = 472;
        iArr[74] = 761;
        iArr[75] = 107;
        iArr[76] = 784;
        iArr[77] = 860;
        iArr[78] = 658;
        iArr[79] = 741;
        iArr[80] = 290;
        iArr[81] = 204;
        iArr[82] = 681;
        iArr[83] = 407;
        iArr[84] = 855;
        iArr[85] = 85;
        iArr[86] = 99;
        iArr[87] = 62;
        iArr[88] = 482;
        iArr[89] = 180;
        iArr[90] = 20;
        iArr[91] = 297;
        iArr[92] = 451;
        iArr[93] = 593;
        iArr[94] = 913;
        iArr[95] = 142;
        iArr[96] = 808;
        iArr[97] = 684;
        iArr[98] = 287;
        iArr[99] = 536;
        iArr[100] = 561;
        iArr[101] = 76;
        iArr[102] = 653;
        iArr[103] = 899;
        iArr[104] = 729;
        iArr[105] = 567;
        iArr[106] = 744;
        iArr[107] = 390;
        iArr[108] = 513;
        iArr[109] = 192;
        iArr[110] = 516;
        iArr[111] = 258;
        iArr[112] = 240;
        iArr[113] = 518;
        iArr[114] = 794;
        iArr[115] = 395;
        iArr[116] = 768;
        iArr[117] = 848;
        iArr[118] = 51;
        iArr[119] = 610;
        iArr[120] = 384;
        iArr[121] = 168;
        iArr[122] = 190;
        iArr[123] = 826;
        iArr[124] = 328;
        iArr[125] = 596;
        iArr[126] = 786;
        iArr[127] = 303;
        iArr[128] = 570;
        iArr[129] = 381;
        iArr[130] = 415;
        iArr[131] = 641;
        iArr[132] = 156;
        iArr[133] = 237;
        iArr[134] = 151;
        iArr[135] = 429;
        iArr[136] = 531;
        iArr[137] = 207;
        iArr[138] = 676;
        iArr[139] = 710;
        iArr[140] = 89;
        iArr[141] = 168;
        iArr[142] = 304;
        iArr[143] = 402;
        iArr[144] = 40;
        iArr[145] = 708;
        iArr[146] = 575;
        iArr[147] = 162;
        iArr[148] = 864;
        iArr[149] = 229;
        iArr[150] = 65;
        iArr[151] = 861;
        iArr[152] = 841;
        iArr[153] = 512;
        iArr[154] = 164;
        iArr[155] = 477;
        iArr[156] = 221;
        iArr[157] = 92;
        iArr[158] = 358;
        iArr[159] = 785;
        iArr[160] = 288;
        iArr[161] = 357;
        iArr[162] = 850;
        iArr[163] = 836;
        iArr[164] = 827;
        iArr[165] = 736;
        iArr[166] = 707;
        iArr[167] = 94;
        iArr[168] = 8;
        iArr[169] = 494;
        iArr[170] = 114;
        iArr[171] = 521;
        iArr[172] = 2;
        iArr[173] = 499;
        iArr[174] = 851;
        iArr[175] = 543;
        iArr[176] = 152;
        iArr[177] = 729;
        iArr[178] = 771;
        iArr[179] = 95;
        iArr[180] = 248;
        iArr[181] = 361;
        iArr[182] = 578;
        iArr[183] = 323;
        iArr[184] = 856;
        iArr[185] = 797;
        iArr[186] = 289;
        iArr[187] = 51;
        iArr[188] = 684;
        iArr[189] = 466;
        iArr[190] = 533;
        iArr[191] = 820;
        iArr[192] = 669;
        iArr[193] = 45;
        iArr[194] = 902;
        iArr[195] = 452;
        iArr[196] = 167;
        iArr[197] = 342;
        iArr[198] = 244;
        iArr[199] = 173;
        iArr[200] = 35;
        iArr[201] = 463;
        iArr[202] = 651;
        iArr[203] = 51;
        iArr[204] = 699;
        iArr[205] = 591;
        iArr[206] = 452;
        iArr[207] = 578;
        iArr[208] = 37;
        iArr[209] = 124;
        iArr[210] = 298;
        iArr[211] = 332;
        iArr[212] = 552;
        iArr[213] = 43;
        iArr[214] = 427;
        iArr[215] = 119;
        iArr[216] = 662;
        iArr[217] = 777;
        iArr[218] = 475;
        iArr[219] = 850;
        iArr[220] = 764;
        iArr[221] = 364;
        iArr[222] = 578;
        iArr[223] = 911;
        iArr[224] = 283;
        iArr[225] = 711;
        iArr[226] = 472;
        iArr[227] = 420;
        iArr[228] = 245;
        iArr[229] = 288;
        iArr[230] = 594;
        iArr[231] = 394;
        iArr[232] = 511;
        iArr[233] = 327;
        iArr[234] = 589;
        iArr[235] = 777;
        iArr[236] = 699;
        iArr[237] = 688;
        iArr[238] = 43;
        iArr[239] = 408;
        iArr[240] = 842;
        iArr[241] = 383;
        iArr[242] = 721;
        iArr[243] = 521;
        iArr[244] = 560;
        iArr[245] = 644;
        iArr[246] = 714;
        iArr[247] = 559;
        iArr[248] = 62;
        iArr[249] = 145;
        iArr[250] = 873;
        iArr[251] = 663;
        iArr[252] = 713;
        iArr[253] = 159;
        iArr[254] = 672;
        iArr[255] = 729;
        iArr[256] = 624;
        iArr[257] = 59;
        iArr[258] = 193;
        iArr[259] = 417;
        iArr[260] = 158;
        iArr[261] = 209;
        iArr[262] = 563;
        iArr[263] = 564;
        iArr[264] = 343;
        iArr[265] = 693;
        iArr[266] = 109;
        iArr[267] = 608;
        iArr[268] = 563;
        iArr[269] = 365;
        iArr[270] = 181;
        iArr[271] = 772;
        iArr[272] = 677;
        iArr[273] = 310;
        iArr[274] = 248;
        iArr[275] = 353;
        iArr[276] = 708;
        iArr[277] = 410;
        iArr[278] = 579;
        iArr[279] = 870;
        iArr[280] = 617;
        iArr[281] = 841;
        iArr[282] = 632;
        iArr[283] = 860;
        iArr[284] = 289;
        iArr[285] = 536;
        iArr[286] = 35;
        iArr[287] = 777;
        iArr[288] = 618;
        iArr[289] = 586;
        iArr[290] = 424;
        iArr[291] = 833;
        iArr[292] = 77;
        iArr[293] = 597;
        iArr[294] = 346;
        iArr[295] = 269;
        iArr[296] = 757;
        iArr[297] = 632;
        iArr[298] = 695;
        iArr[299] = 751;
        iArr[300] = 331;
        iArr[301] = 247;
        iArr[302] = 184;
        iArr[303] = 45;
        iArr[304] = 787;
        iArr[305] = 680;
        iArr[306] = 18;
        iArr[307] = 66;
        iArr[308] = 407;
        iArr[309] = 369;
        iArr[310] = 54;
        iArr[311] = 492;
        iArr[312] = 228;
        iArr[313] = 613;
        iArr[314] = 830;
        iArr[315] = 922;
        iArr[316] = 437;
        iArr[317] = 519;
        iArr[318] = 644;
        iArr[319] = 905;
        iArr[320] = 789;
        iArr[321] = 420;
        iArr[322] = 305;
        iArr[323] = 441;
        iArr[324] = 207;
        iArr[325] = 300;
        iArr[326] = 892;
        iArr[327] = 827;
        iArr[328] = 141;
        iArr[329] = 537;
        iArr[330] = 381;
        iArr[331] = 662;
        iArr[332] = 513;
        iArr[333] = 56;
        iArr[334] = 252;
        iArr[335] = 341;
        iArr[336] = 242;
        iArr[337] = 797;
        iArr[338] = 838;
        iArr[339] = 837;
        iArr[340] = 720;
        iArr[341] = 224;
        iArr[342] = 307;
        iArr[343] = 631;
        iArr[344] = 61;
        iArr[345] = 87;
        iArr[346] = 560;
        iArr[347] = 310;
        iArr[348] = 756;
        iArr[349] = 665;
        iArr[350] = 397;
        iArr[351] = 808;
        iArr[352] = 851;
        iArr[353] = 309;
        iArr[354] = 473;
        iArr[355] = 795;
        iArr[356] = 378;
        iArr[357] = 31;
        iArr[358] = 647;
        iArr[359] = 915;
        iArr[360] = 459;
        iArr[361] = 806;
        iArr[362] = 590;
        iArr[363] = 731;
        iArr[364] = 425;
        iArr[365] = 216;
        iArr[366] = 548;
        iArr[367] = 249;
        iArr[368] = 321;
        iArr[369] = 881;
        iArr[370] = 699;
        iArr[371] = 535;
        iArr[372] = 673;
        iArr[373] = 782;
        iArr[374] = 210;
        iArr[375] = 815;
        iArr[376] = 905;
        iArr[377] = 303;
        iArr[378] = 843;
        iArr[379] = 922;
        iArr[380] = 281;
        iArr[381] = 73;
        iArr[382] = 469;
        iArr[383] = 791;
        iArr[384] = 660;
        iArr[385] = 162;
        iArr[386] = 498;
        iArr[387] = 308;
        iArr[388] = 155;
        iArr[389] = 422;
        iArr[390] = 907;
        iArr[391] = 817;
        iArr[392] = 187;
        iArr[393] = 62;
        iArr[394] = 16;
        iArr[395] = 425;
        iArr[396] = 535;
        iArr[397] = 336;
        iArr[398] = 286;
        iArr[399] = 437;
        iArr[400] = 375;
        iArr[401] = 273;
        iArr[402] = 610;
        iArr[403] = 296;
        iArr[404] = 183;
        iArr[405] = 923;
        iArr[406] = 116;
        iArr[407] = 667;
        iArr[408] = 751;
        iArr[409] = 353;
        iArr[410] = 62;
        iArr[411] = 366;
        iArr[412] = 691;
        iArr[413] = 379;
        iArr[414] = 687;
        iArr[415] = 842;
        iArr[416] = 37;
        iArr[417] = 357;
        iArr[418] = 720;
        iArr[419] = 742;
        iArr[420] = 330;
        iArr[421] = 5;
        iArr[422] = 39;
        iArr[423] = 923;
        iArr[424] = 311;
        iArr[425] = 424;
        iArr[426] = 242;
        iArr[427] = 749;
        iArr[428] = 321;
        iArr[429] = 54;
        iArr[430] = 669;
        iArr[431] = 316;
        iArr[432] = 342;
        iArr[433] = 299;
        iArr[434] = 534;
        iArr[435] = 105;
        iArr[436] = 667;
        iArr[437] = 488;
        iArr[438] = 640;
        iArr[439] = 672;
        iArr[440] = 576;
        iArr[441] = 540;
        iArr[442] = 316;
        iArr[443] = 486;
        iArr[444] = 721;
        iArr[445] = 610;
        iArr[446] = 46;
        iArr[447] = 656;
        iArr[448] = 447;
        iArr[449] = 171;
        iArr[450] = 616;
        iArr[451] = 464;
        iArr[452] = 190;
        iArr[453] = 531;
        iArr[454] = 297;
        iArr[455] = 321;
        iArr[456] = 762;
        iArr[457] = 752;
        iArr[458] = 533;
        iArr[459] = 175;
        iArr[460] = 134;
        iArr[461] = 14;
        iArr[462] = 381;
        iArr[463] = 433;
        iArr[464] = 717;
        iArr[465] = 45;
        iArr[466] = 111;
        iArr[467] = 20;
        iArr[468] = 596;
        iArr[469] = 284;
        iArr[470] = 736;
        iArr[471] = 138;
        iArr[472] = 646;
        iArr[473] = 411;
        iArr[474] = 877;
        iArr[475] = 669;
        iArr[476] = 141;
        iArr[477] = 919;
        iArr[478] = 45;
        iArr[479] = 780;
        iArr[480] = 407;
        iArr[481] = 164;
        iArr[482] = 332;
        iArr[483] = 899;
        iArr[484] = 165;
        iArr[485] = 726;
        iArr[486] = 600;
        iArr[487] = 325;
        iArr[488] = 498;
        iArr[489] = 655;
        iArr[490] = 357;
        iArr[491] = 752;
        iArr[492] = 768;
        iArr[493] = 223;
        iArr[494] = 849;
        iArr[495] = 647;
        iArr[496] = 63;
        iArr[497] = 310;
        iArr[498] = 863;
        iArr[499] = 251;
        iArr[500] = 366;
        iArr[501] = 304;
        iArr[502] = 282;
        iArr[503] = 738;
        iArr[504] = 675;
        iArr[505] = 410;
        iArr[506] = 389;
        iArr[507] = 244;
        iArr[508] = 31;
        iArr[509] = 121;
        iArr[510] = 303;
        iArr[511] = 263;
        EC_COEFFICIENTS = new int[][]{new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, StatusLine.HTTP_PERM_REDIRECT, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, LogSeverity.EMERGENCY_VALUE, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, LogSeverity.WARNING_VALUE, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, LogSeverity.WARNING_VALUE, 925, 749, 415, 822, 93, 217, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, LogSeverity.CRITICAL_VALUE, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, StatusLine.HTTP_TEMP_REDIRECT, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, Constants.MAX_HOST_LENGTH, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, StatusLine.HTTP_TEMP_REDIRECT, 159, 924, 558, 648, 55, 497, 10}, iArr};
    }

    private PDF417ErrorCorrection() {
    }

    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            char c = cArr[i4];
            if (c != 0) {
                cArr[i4] = (char) (929 - c);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i) {
        if (i >= 0 && i <= 8) {
            return 1 << (i + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i <= 40) {
            return 2;
        } else {
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }
}
