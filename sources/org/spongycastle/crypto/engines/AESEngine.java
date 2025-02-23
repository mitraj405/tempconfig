package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.BlockCipher;

public class AESEngine implements BlockCipher {
    public static final int[] a = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    public static final byte[] b = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, UnsignedBytes.MAX_POWER_OF_TWO, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, -68, -74, -38, 33, Ascii.DLE, -1, -13, -46, -51, Ascii.FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, Ascii.VT, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.FS, -90, -76, -58, -24, -35, 116, Ascii.US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.SO, 97, 53, 87, -71, -122, -63, Ascii.GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.CR, -65, -26, 66, 104, 65, -103, 45, Ascii.SI, -80, 84, -69, Ascii.SYN};

    /* renamed from: b  reason: collision with other field name */
    public static final int[] f5901b = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    public static final byte[] c = {82, 9, 106, -43, 48, 54, -91, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, 61, -18, 76, -107, Ascii.VT, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, Ascii.SYN, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, Ascii.NAK, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, Ascii.RS, -113, -54, 63, Ascii.SI, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, Ascii.FS, 117, -33, 110, 71, -15, Ascii.SUB, 113, Ascii.GS, 41, -59, -119, 111, -73, 98, Ascii.SO, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, 49, -79, Ascii.DC2, Ascii.DLE, 89, 39, UnsignedBytes.MAX_POWER_OF_TWO, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, Ascii.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, Ascii.ETB, 43, 4, 126, -70, 119, -42, 38, -31, 105, Ascii.DC4, 99, 85, 33, Ascii.FF, 125};

    /* renamed from: c  reason: collision with other field name */
    public static final int[] f5902c = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    /* renamed from: a  reason: collision with other field name */
    public int f5903a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5904a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5905a;

    /* renamed from: a  reason: collision with other field name */
    public int[][] f5906a = null;

    /* renamed from: b  reason: collision with other field name */
    public int f5907b;

    /* renamed from: c  reason: collision with other field name */
    public int f5908c;
    public int d;
    public int e;

    public static int f(int i) {
        byte[] bArr = b;
        return (bArr[(i >> 24) & Constants.MAX_HOST_LENGTH] << Ascii.CAN) | (bArr[i & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) | ((bArr[(i >> 8) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[(i >> 16) & Constants.MAX_HOST_LENGTH] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: int[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r18, org.spongycastle.crypto.CipherParameters r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof org.spongycastle.crypto.params.KeyParameter
            if (r3 == 0) goto L_0x0268
            org.spongycastle.crypto.params.KeyParameter r2 = (org.spongycastle.crypto.params.KeyParameter) r2
            byte[] r2 = r2.a
            int r3 = r2.length
            r4 = 16
            if (r3 < r4) goto L_0x0260
            r5 = 32
            if (r3 > r5) goto L_0x0260
            r5 = r3 & 7
            if (r5 != 0) goto L_0x0260
            r5 = 2
            int r3 = r3 >>> r5
            int r6 = r3 + 6
            r0.f5903a = r6
            r7 = 1
            int r6 = r6 + r7
            int[] r8 = new int[r5]
            r9 = 4
            r8[r7] = r9
            r10 = 0
            r8[r10] = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r6, r8)
            int[][] r6 = (int[][]) r6
            r8 = 3
            r11 = 8
            r12 = 12
            if (r3 == r9) goto L_0x01b5
            r13 = 6
            r14 = 20
            if (r3 == r13) goto L_0x00e9
            if (r3 != r11) goto L_0x00e1
            int r3 = org.spongycastle.util.Pack.f(r10, r2)
            r13 = r6[r10]
            r13[r10] = r3
            int r9 = org.spongycastle.util.Pack.f(r9, r2)
            r13 = r6[r10]
            r13[r7] = r9
            int r11 = org.spongycastle.util.Pack.f(r11, r2)
            r13 = r6[r10]
            r13[r5] = r11
            int r12 = org.spongycastle.util.Pack.f(r12, r2)
            r13 = r6[r10]
            r13[r8] = r12
            int r4 = org.spongycastle.util.Pack.f(r4, r2)
            r13 = r6[r7]
            r13[r10] = r4
            int r13 = org.spongycastle.util.Pack.f(r14, r2)
            r14 = r6[r7]
            r14[r7] = r13
            r14 = 24
            int r14 = org.spongycastle.util.Pack.f(r14, r2)
            r15 = r6[r7]
            r15[r5] = r14
            r15 = 28
            int r2 = org.spongycastle.util.Pack.f(r15, r2)
            r15 = r6[r7]
            r15[r8] = r2
            r8 = r5
            r15 = r7
        L_0x0087:
            r5 = 14
            if (r8 >= r5) goto L_0x00c5
            int r5 = r2 >>> 8
            int r16 = r2 << -8
            r5 = r16 | r5
            int r5 = f(r5)
            r5 = r5 ^ r15
            int r15 = r15 << 1
            r3 = r3 ^ r5
            r5 = r6[r8]
            r5[r10] = r3
            r9 = r9 ^ r3
            r5[r7] = r9
            r11 = r11 ^ r9
            r16 = 2
            r5[r16] = r11
            r12 = r12 ^ r11
            r16 = 3
            r5[r16] = r12
            int r5 = f(r12)
            r4 = r4 ^ r5
            int r5 = r8 + 1
            r5 = r6[r5]
            r5[r10] = r4
            r13 = r13 ^ r4
            r5[r7] = r13
            r14 = r14 ^ r13
            r16 = 2
            r5[r16] = r14
            r2 = r2 ^ r14
            r16 = 3
            r5[r16] = r2
            int r8 = r8 + 2
            goto L_0x0087
        L_0x00c5:
            int r4 = r2 >>> 8
            int r2 = r2 << -8
            r2 = r2 | r4
            int r2 = f(r2)
            r2 = r2 ^ r15
            r2 = r2 ^ r3
            r3 = r6[r5]
            r3[r10] = r2
            r2 = r2 ^ r9
            r3[r7] = r2
            r2 = r2 ^ r11
            r4 = 2
            r3[r4] = r2
            r2 = r2 ^ r12
            r4 = 3
            r3[r4] = r2
            goto L_0x0200
        L_0x00e1:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Should never get here"
            r1.<init>(r2)
            throw r1
        L_0x00e9:
            int r3 = org.spongycastle.util.Pack.f(r10, r2)
            r5 = r6[r10]
            r5[r10] = r3
            r5 = 4
            int r5 = org.spongycastle.util.Pack.f(r5, r2)
            r8 = r6[r10]
            r8[r7] = r5
            int r8 = org.spongycastle.util.Pack.f(r11, r2)
            r9 = r6[r10]
            r11 = 2
            r9[r11] = r8
            int r9 = org.spongycastle.util.Pack.f(r12, r2)
            r11 = r6[r10]
            r13 = 3
            r11[r13] = r9
            int r4 = org.spongycastle.util.Pack.f(r4, r2)
            r11 = r6[r7]
            r11[r10] = r4
            int r2 = org.spongycastle.util.Pack.f(r14, r2)
            r11 = r6[r7]
            r11[r7] = r2
            int r11 = r2 >>> 8
            int r13 = r2 << -8
            r11 = r11 | r13
            int r11 = f(r11)
            r11 = r11 ^ r7
            r3 = r3 ^ r11
            r11 = r6[r7]
            r13 = 2
            r11[r13] = r3
            r5 = r5 ^ r3
            r14 = 3
            r11[r14] = r5
            r8 = r8 ^ r5
            r11 = r6[r13]
            r11[r10] = r8
            r9 = r9 ^ r8
            r11[r7] = r9
            r4 = r4 ^ r9
            r11[r13] = r4
            r2 = r2 ^ r4
            r11[r14] = r2
            r11 = 3
            r13 = r11
            r11 = r9
            r9 = r8
            r8 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 2
        L_0x0147:
            if (r13 >= r12) goto L_0x019a
            int r14 = r3 >>> 8
            int r15 = r3 << -8
            r14 = r14 | r15
            int r14 = f(r14)
            r14 = r14 ^ r2
            int r2 = r2 << 1
            r4 = r4 ^ r14
            r14 = r6[r13]
            r14[r10] = r4
            r8 = r8 ^ r4
            r14[r7] = r8
            r9 = r9 ^ r8
            r15 = 2
            r14[r15] = r9
            r11 = r11 ^ r9
            r15 = 3
            r14[r15] = r11
            r5 = r5 ^ r11
            int r14 = r13 + 1
            r15 = r6[r14]
            r15[r10] = r5
            r3 = r3 ^ r5
            r15[r7] = r3
            int r15 = r3 >>> 8
            int r16 = r3 << -8
            r15 = r16 | r15
            int r15 = f(r15)
            r15 = r15 ^ r2
            int r2 = r2 << r7
            r4 = r4 ^ r15
            r14 = r6[r14]
            r15 = 2
            r14[r15] = r4
            r8 = r8 ^ r4
            r15 = 3
            r14[r15] = r8
            r9 = r9 ^ r8
            int r14 = r13 + 2
            r14 = r6[r14]
            r14[r10] = r9
            r11 = r11 ^ r9
            r14[r7] = r11
            r5 = r5 ^ r11
            r16 = 2
            r14[r16] = r5
            r3 = r3 ^ r5
            r14[r15] = r3
            int r13 = r13 + 3
            goto L_0x0147
        L_0x019a:
            int r5 = r3 >>> 8
            int r3 = r3 << -8
            r3 = r3 | r5
            int r3 = f(r3)
            r2 = r2 ^ r3
            r2 = r2 ^ r4
            r3 = r6[r12]
            r3[r10] = r2
            r2 = r2 ^ r8
            r3[r7] = r2
            r2 = r2 ^ r9
            r4 = 2
            r3[r4] = r2
            r2 = r2 ^ r11
            r4 = 3
            r3[r4] = r2
            goto L_0x0200
        L_0x01b5:
            int r3 = org.spongycastle.util.Pack.f(r10, r2)
            r4 = r6[r10]
            r4[r10] = r3
            r4 = 4
            int r4 = org.spongycastle.util.Pack.f(r4, r2)
            r5 = r6[r10]
            r5[r7] = r4
            int r5 = org.spongycastle.util.Pack.f(r11, r2)
            r8 = r6[r10]
            r9 = 2
            r8[r9] = r5
            int r2 = org.spongycastle.util.Pack.f(r12, r2)
            r8 = r6[r10]
            r9 = 3
            r8[r9] = r2
            r8 = r7
        L_0x01d9:
            r9 = 10
            if (r8 > r9) goto L_0x0200
            int r9 = r2 >>> 8
            int r11 = r2 << -8
            r9 = r9 | r11
            int r9 = f(r9)
            int[] r11 = a
            int r12 = r8 + -1
            r11 = r11[r12]
            r9 = r9 ^ r11
            r3 = r3 ^ r9
            r9 = r6[r8]
            r9[r10] = r3
            r4 = r4 ^ r3
            r9[r7] = r4
            r5 = r5 ^ r4
            r11 = 2
            r9[r11] = r5
            r2 = r2 ^ r5
            r11 = 3
            r9[r11] = r2
            int r8 = r8 + 1
            goto L_0x01d9
        L_0x0200:
            if (r1 != 0) goto L_0x0248
            r2 = r7
        L_0x0203:
            int r3 = r0.f5903a
            if (r2 >= r3) goto L_0x0248
            r3 = 4
            r4 = r10
        L_0x0209:
            if (r4 >= r3) goto L_0x0244
            r5 = r6[r2]
            r8 = r5[r4]
            int r9 = r8 >>> 8
            int r11 = r8 << -8
            r9 = r9 | r11
            r9 = r9 ^ r8
            r11 = 2139062143(0x7f7f7f7f, float:3.3961514E38)
            r11 = r11 & r9
            int r11 = r11 << r7
            r12 = -2139062144(0xffffffff80808080, float:-1.180104E-38)
            r12 = r12 & r9
            int r12 = r12 >>> 7
            int r12 = r12 * 27
            r11 = r11 ^ r12
            r8 = r8 ^ r11
            r11 = 1061109567(0x3f3f3f3f, float:0.7470588)
            r11 = r11 & r8
            r12 = 2
            int r11 = r11 << r12
            r13 = -1061109568(0xffffffffc0c0c0c0, float:-6.023529)
            r13 = r13 & r8
            int r14 = r13 >>> 1
            r13 = r13 ^ r14
            int r14 = r13 >>> 2
            r11 = r11 ^ r14
            int r13 = r13 >>> 5
            r11 = r11 ^ r13
            r9 = r9 ^ r11
            int r11 = r9 >>> 16
            int r13 = r9 << -16
            r11 = r11 | r13
            r9 = r9 ^ r11
            r8 = r8 ^ r9
            r5[r4] = r8
            int r4 = r4 + 1
            goto L_0x0209
        L_0x0244:
            r12 = 2
            int r2 = r2 + 1
            goto L_0x0203
        L_0x0248:
            r0.f5906a = r6
            r0.f5904a = r1
            if (r1 == 0) goto L_0x0257
            byte[] r1 = b
            byte[] r1 = org.spongycastle.util.Arrays.c(r1)
            r0.f5905a = r1
            goto L_0x025f
        L_0x0257:
            byte[] r1 = c
            byte[] r1 = org.spongycastle.util.Arrays.c(r1)
            r0.f5905a = r1
        L_0x025f:
            return
        L_0x0260:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Key length not 128/192/256 bits."
            r1.<init>(r2)
            throw r1
        L_0x0268:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "invalid parameter passed to AES init - "
            java.lang.String r2 = defpackage.xx.H(r2, r3)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.AESEngine.a(boolean, org.spongycastle.crypto.CipherParameters):void");
    }

    public final String b() {
        return "AES";
    }

    public final int c() {
        return 16;
    }

    public final void d(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = this.f5907b;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.f5908c;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.d;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.e;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: int[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v45, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v53, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v87, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v69, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v110, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v125, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v95, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e(int r21, int r22, byte[] r23, byte[] r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            int[][] r5 = r0.f5906a
            if (r5 == 0) goto L_0x0649
            int r5 = r1 + 16
            int r6 = r3.length
            if (r5 > r6) goto L_0x0641
            int r5 = r2 + 16
            int r6 = r4.length
            if (r5 > r6) goto L_0x0639
            boolean r5 = r0.f5904a
            r6 = 3
            r7 = 2
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x0330
            r0.g(r1, r3)
            int[][] r1 = r0.f5906a
            int r3 = r0.f5907b
            r5 = r1[r8]
            r11 = r5[r8]
            r3 = r3 ^ r11
            int r11 = r0.f5908c
            r12 = r5[r9]
            r11 = r11 ^ r12
            int r12 = r0.d
            r13 = r5[r7]
            r12 = r12 ^ r13
            int r13 = r0.e
            r5 = r5[r6]
            r5 = r5 ^ r13
            r13 = r9
        L_0x003c:
            int r14 = r0.f5903a
            int r14 = r14 - r9
            int[] r15 = f5901b
            if (r13 >= r14) goto L_0x01bf
            r14 = r3 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r10 = r11 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r16 = r10 >>> 24
            int r10 = r10 << -24
            r10 = r10 | r16
            r10 = r10 ^ r14
            int r14 = r12 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r16 = r14 >>> 16
            int r14 = r14 << -16
            r14 = r14 | r16
            r10 = r10 ^ r14
            int r14 = r5 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r16 = r14 >>> 8
            int r14 = r14 << -8
            r14 = r14 | r16
            r10 = r10 ^ r14
            r14 = r1[r13]
            r16 = r14[r8]
            r10 = r10 ^ r16
            r8 = r11 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r6 = r12 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r15[r6]
            int r17 = r6 >>> 24
            int r6 = r6 << -24
            r6 = r6 | r17
            r6 = r6 ^ r8
            int r8 = r5 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r17 = r8 >>> 16
            int r8 = r8 << -16
            r8 = r8 | r17
            r6 = r6 ^ r8
            int r8 = r3 >> 24
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r17 = r8 >>> 8
            int r8 = r8 << -8
            r8 = r8 | r17
            r6 = r6 ^ r8
            r8 = r14[r9]
            r6 = r6 ^ r8
            r8 = r12 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r9 = r5 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r18 = r9 >>> 24
            int r9 = r9 << -24
            r9 = r9 | r18
            r8 = r8 ^ r9
            int r9 = r3 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r18 = r9 >>> 16
            int r9 = r9 << -16
            r9 = r9 | r18
            r8 = r8 ^ r9
            int r9 = r11 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r18 = r9 >>> 8
            int r9 = r9 << -8
            r9 = r9 | r18
            r8 = r8 ^ r9
            r9 = r14[r7]
            r8 = r8 ^ r9
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r3 = r3 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r15[r3]
            int r9 = r3 >>> 24
            int r3 = r3 << -24
            r3 = r3 | r9
            r3 = r3 ^ r5
            int r5 = r11 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r9 = r5 >>> 16
            int r5 = r5 << -16
            r5 = r5 | r9
            r3 = r3 ^ r5
            int r5 = r12 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r9 = r5 >>> 8
            int r5 = r5 << -8
            r5 = r5 | r9
            r3 = r3 ^ r5
            int r13 = r13 + 1
            r5 = 3
            r9 = r14[r5]
            r3 = r3 ^ r9
            r5 = r10 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r9 = r6 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r11 = r9 >>> 24
            int r9 = r9 << -24
            r9 = r9 | r11
            r5 = r5 ^ r9
            int r9 = r8 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r11 = r9 >>> 16
            int r9 = r9 << -16
            r9 = r9 | r11
            r5 = r5 ^ r9
            int r9 = r3 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r11 = r9 >>> 8
            int r9 = r9 << -8
            r9 = r9 | r11
            r5 = r5 ^ r9
            r9 = r1[r13]
            r11 = 0
            r12 = r9[r11]
            r5 = r5 ^ r12
            r11 = r6 & 255(0xff, float:3.57E-43)
            r11 = r15[r11]
            int r12 = r8 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r15[r12]
            int r14 = r12 >>> 24
            int r12 = r12 << -24
            r12 = r12 | r14
            r11 = r11 ^ r12
            int r12 = r3 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r15[r12]
            int r14 = r12 >>> 16
            int r12 = r12 << -16
            r12 = r12 | r14
            r11 = r11 ^ r12
            int r12 = r10 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r15[r12]
            int r14 = r12 >>> 8
            int r12 = r12 << -8
            r12 = r12 | r14
            r11 = r11 ^ r12
            r12 = 1
            r14 = r9[r12]
            r11 = r11 ^ r14
            r12 = r8 & 255(0xff, float:3.57E-43)
            r12 = r15[r12]
            int r14 = r3 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 24
            int r14 = r14 << -24
            r14 = r14 | r18
            r12 = r12 ^ r14
            int r14 = r10 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 16
            int r14 = r14 << -16
            r14 = r14 | r18
            r12 = r12 ^ r14
            int r14 = r6 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 8
            int r14 = r14 << -8
            r14 = r14 | r18
            r12 = r12 ^ r14
            r14 = r9[r7]
            r12 = r12 ^ r14
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r15[r3]
            int r10 = r10 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r14 = r10 >>> 24
            int r10 = r10 << -24
            r10 = r10 | r14
            r3 = r3 ^ r10
            r10 = 16
            int r6 = r6 >> r10
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r15[r6]
            int r10 = r6 >>> 16
            int r6 = r6 << -16
            r6 = r6 | r10
            r3 = r3 ^ r6
            int r6 = r8 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r15[r6]
            int r8 = r6 >>> 8
            int r6 = r6 << -8
            r6 = r6 | r8
            r3 = r3 ^ r6
            r6 = 1
            int r13 = r13 + r6
            r6 = 3
            r8 = r9[r6]
            r3 = r3 ^ r8
            r6 = 3
            r8 = 0
            r9 = 1
            r19 = r5
            r5 = r3
            r3 = r19
            goto L_0x003c
        L_0x01bf:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r6 = r15[r6]
            int r8 = r11 >> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r9 = r8 >>> 24
            int r8 = r8 << -24
            r8 = r8 | r9
            r6 = r6 ^ r8
            int r8 = r12 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r9 = r8 >>> 16
            int r8 = r8 << -16
            r8 = r8 | r9
            r6 = r6 ^ r8
            int r8 = r5 >> 24
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r15[r8]
            int r9 = r8 >>> 8
            int r8 = r8 << -8
            r8 = r8 | r9
            r6 = r6 ^ r8
            r8 = r1[r13]
            r9 = 0
            r10 = r8[r9]
            r6 = r6 ^ r10
            r9 = r11 & 255(0xff, float:3.57E-43)
            r9 = r15[r9]
            int r10 = r12 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r14 = r10 >>> 24
            int r10 = r10 << -24
            r10 = r10 | r14
            r9 = r9 ^ r10
            int r10 = r5 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r14 = r10 >>> 16
            int r10 = r10 << -16
            r10 = r10 | r14
            r9 = r9 ^ r10
            int r10 = r3 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r14 = r10 >>> 8
            int r10 = r10 << -8
            r10 = r10 | r14
            r9 = r9 ^ r10
            r10 = 1
            r14 = r8[r10]
            r9 = r9 ^ r14
            r10 = r12 & 255(0xff, float:3.57E-43)
            r10 = r15[r10]
            int r14 = r5 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 24
            int r14 = r14 << -24
            r14 = r14 | r18
            r10 = r10 ^ r14
            int r14 = r3 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 16
            int r14 = r14 << -16
            r14 = r14 | r18
            r10 = r10 ^ r14
            int r14 = r11 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r15[r14]
            int r18 = r14 >>> 8
            int r14 = r14 << -8
            r14 = r14 | r18
            r10 = r10 ^ r14
            r14 = r8[r7]
            r10 = r10 ^ r14
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r3 = r3 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r15[r3]
            int r14 = r3 >>> 24
            int r3 = r3 << -24
            r3 = r3 | r14
            r3 = r3 ^ r5
            r5 = 16
            int r11 = r11 >> r5
            r5 = r11 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r11 = r5 >>> 16
            int r5 = r5 << -16
            r5 = r5 | r11
            r3 = r3 ^ r5
            int r5 = r12 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r15[r5]
            int r11 = r5 >>> 8
            int r5 = r5 << -8
            r5 = r5 | r11
            r3 = r3 ^ r5
            r5 = 1
            int r13 = r13 + r5
            r5 = 3
            r8 = r8[r5]
            r3 = r3 ^ r8
            byte[] r5 = b
            r8 = r6 & 255(0xff, float:3.57E-43)
            byte r8 = r5[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r11 = r9 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = r5[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r8 = r8 ^ r11
            byte[] r11 = r0.f5905a
            int r12 = r10 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r11[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r14 = 16
            int r12 = r12 << r14
            r8 = r8 ^ r12
            int r12 = r3 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r11[r12]
            int r12 = r12 << 24
            r8 = r8 ^ r12
            r1 = r1[r13]
            r12 = 0
            r12 = r1[r12]
            r8 = r8 ^ r12
            r0.f5907b = r8
            r8 = r9 & 255(0xff, float:3.57E-43)
            byte r8 = r11[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r12 = r10 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r5[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            r8 = r8 ^ r12
            int r12 = r3 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r5[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r13 = 16
            int r12 = r12 << r13
            r8 = r8 ^ r12
            int r12 = r6 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r11[r12]
            int r12 = r12 << 24
            r8 = r8 ^ r12
            r12 = 1
            r12 = r1[r12]
            r8 = r8 ^ r12
            r0.f5908c = r8
            r8 = r10 & 255(0xff, float:3.57E-43)
            byte r8 = r11[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r12 = r3 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r5[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << 8
            r8 = r8 ^ r12
            int r12 = r6 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r5[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r13 = 16
            int r12 = r12 << r13
            r8 = r8 ^ r12
            int r12 = r9 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = r5[r12]
            int r12 = r12 << 24
            r8 = r8 ^ r12
            r7 = r1[r7]
            r7 = r7 ^ r8
            r0.d = r7
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r11[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r6 = r6 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r11[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r3 = r3 ^ r6
            r6 = 16
            int r7 = r9 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r11[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r6
            r3 = r3 ^ r7
            int r6 = r10 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r5 = r5[r6]
            int r5 = r5 << 24
            r3 = r3 ^ r5
            r5 = 3
            r1 = r1[r5]
            r1 = r1 ^ r3
            r0.e = r1
            r0.d(r2, r4)
            goto L_0x0636
        L_0x0330:
            r0.g(r1, r3)
            int[][] r1 = r0.f5906a
            int r3 = r0.f5907b
            int r5 = r0.f5903a
            r6 = r1[r5]
            r8 = 0
            r9 = r6[r8]
            r3 = r3 ^ r9
            int r8 = r0.f5908c
            r9 = 1
            r10 = r6[r9]
            r8 = r8 ^ r10
            int r10 = r0.d
            r11 = r6[r7]
            r10 = r10 ^ r11
            int r5 = r5 - r9
            int r11 = r0.e
            r12 = 3
            r6 = r6[r12]
            r6 = r6 ^ r11
        L_0x0351:
            int[] r11 = f5902c
            if (r5 <= r9) goto L_0x04cc
            r9 = r3 & 255(0xff, float:3.57E-43)
            r9 = r11[r9]
            int r12 = r6 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 24
            int r12 = r12 << -24
            r12 = r12 | r13
            r9 = r9 ^ r12
            int r12 = r10 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 16
            int r12 = r12 << -16
            r12 = r12 | r13
            r9 = r9 ^ r12
            int r12 = r8 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 8
            int r12 = r12 << -8
            r12 = r12 | r13
            r9 = r9 ^ r12
            r12 = r1[r5]
            r13 = 0
            r14 = r12[r13]
            r9 = r9 ^ r14
            r13 = r8 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r3 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 24
            int r14 = r14 << -24
            r14 = r14 | r15
            r13 = r13 ^ r14
            int r14 = r6 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 16
            int r14 = r14 << -16
            r14 = r14 | r15
            r13 = r13 ^ r14
            int r14 = r10 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 8
            int r14 = r14 << -8
            r14 = r14 | r15
            r13 = r13 ^ r14
            r14 = 1
            r15 = r12[r14]
            r13 = r13 ^ r15
            r14 = r10 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r8 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 24
            int r15 = r15 << -24
            r15 = r15 | r18
            r14 = r14 ^ r15
            int r15 = r3 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 16
            int r15 = r15 << -16
            r15 = r15 | r18
            r14 = r14 ^ r15
            int r15 = r6 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 8
            int r15 = r15 << -8
            r15 = r15 | r18
            r14 = r14 ^ r15
            r15 = r12[r7]
            r14 = r14 ^ r15
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r10 = r10 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r11[r10]
            int r15 = r10 >>> 24
            int r10 = r10 << -24
            r10 = r10 | r15
            r6 = r6 ^ r10
            int r8 = r8 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r10 = r8 >>> 16
            int r8 = r8 << -16
            r8 = r8 | r10
            r6 = r6 ^ r8
            int r3 = r3 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r8 = r3 >>> 8
            int r3 = r3 << -8
            r3 = r3 | r8
            r3 = r3 ^ r6
            int r5 = r5 + -1
            r6 = 3
            r8 = r12[r6]
            r3 = r3 ^ r8
            r6 = r9 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r8 = r3 >> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r10 = r8 >>> 24
            int r8 = r8 << -24
            r8 = r8 | r10
            r6 = r6 ^ r8
            int r8 = r14 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r10 = r8 >>> 16
            int r8 = r8 << -16
            r8 = r8 | r10
            r6 = r6 ^ r8
            int r8 = r13 >> 24
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r10 = r8 >>> 8
            int r8 = r8 << -8
            r8 = r8 | r10
            r6 = r6 ^ r8
            r8 = r1[r5]
            r10 = 0
            r12 = r8[r10]
            r6 = r6 ^ r12
            r10 = r13 & 255(0xff, float:3.57E-43)
            r10 = r11[r10]
            int r12 = r9 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r15 = r12 >>> 24
            int r12 = r12 << -24
            r12 = r12 | r15
            r10 = r10 ^ r12
            int r12 = r3 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r15 = r12 >>> 16
            int r12 = r12 << -16
            r12 = r12 | r15
            r10 = r10 ^ r12
            int r12 = r14 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r15 = r12 >>> 8
            int r12 = r12 << -8
            r12 = r12 | r15
            r10 = r10 ^ r12
            r12 = 1
            r15 = r8[r12]
            r10 = r10 ^ r15
            r12 = r14 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r15 = r13 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 24
            int r15 = r15 << -24
            r15 = r15 | r18
            r12 = r12 ^ r15
            int r15 = r9 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 16
            int r15 = r15 << -16
            r15 = r15 | r18
            r12 = r12 ^ r15
            int r15 = r3 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r18 = r15 >>> 8
            int r15 = r15 << -8
            r15 = r15 | r18
            r12 = r12 ^ r15
            r15 = r8[r7]
            r12 = r12 ^ r15
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r14 = r14 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 24
            int r14 = r14 << -24
            r14 = r14 | r15
            r3 = r3 ^ r14
            r14 = 16
            int r13 = r13 >> r14
            r13 = r13 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r13 >>> 16
            int r13 = r13 << -16
            r13 = r13 | r14
            r3 = r3 ^ r13
            int r9 = r9 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r11[r9]
            int r11 = r9 >>> 8
            int r9 = r9 << -8
            r9 = r9 | r11
            r3 = r3 ^ r9
            int r5 = r5 + -1
            r9 = 3
            r8 = r8[r9]
            r3 = r3 ^ r8
            r8 = r10
            r10 = r12
            r9 = 1
            r19 = r6
            r6 = r3
            r3 = r19
            goto L_0x0351
        L_0x04cc:
            r9 = r3 & 255(0xff, float:3.57E-43)
            r9 = r11[r9]
            int r12 = r6 >> 8
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 24
            int r12 = r12 << -24
            r12 = r12 | r13
            r9 = r9 ^ r12
            int r12 = r10 >> 16
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 16
            int r12 = r12 << -16
            r12 = r12 | r13
            r9 = r9 ^ r12
            int r12 = r8 >> 24
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r12 >>> 8
            int r12 = r12 << -8
            r12 = r12 | r13
            r9 = r9 ^ r12
            r5 = r1[r5]
            r12 = 0
            r13 = r5[r12]
            r9 = r9 ^ r13
            r12 = r8 & 255(0xff, float:3.57E-43)
            r12 = r11[r12]
            int r13 = r3 >> 8
            r13 = r13 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r13 >>> 24
            int r13 = r13 << -24
            r13 = r13 | r14
            r12 = r12 ^ r13
            int r13 = r6 >> 16
            r13 = r13 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r13 >>> 16
            int r13 = r13 << -16
            r13 = r13 | r14
            r12 = r12 ^ r13
            int r13 = r10 >> 24
            r13 = r13 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r13 >>> 8
            int r13 = r13 << -8
            r13 = r13 | r14
            r12 = r12 ^ r13
            r13 = 1
            r14 = r5[r13]
            r12 = r12 ^ r14
            r13 = r10 & 255(0xff, float:3.57E-43)
            r13 = r11[r13]
            int r14 = r8 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 24
            int r14 = r14 << -24
            r14 = r14 | r15
            r13 = r13 ^ r14
            int r14 = r3 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 16
            int r14 = r14 << -16
            r14 = r14 | r15
            r13 = r13 ^ r14
            int r14 = r6 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r11[r14]
            int r15 = r14 >>> 8
            int r14 = r14 << -8
            r14 = r14 | r15
            r13 = r13 ^ r14
            r14 = r5[r7]
            r13 = r13 ^ r14
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r10 = r10 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r11[r10]
            int r14 = r10 >>> 24
            int r10 = r10 << -24
            r10 = r10 | r14
            r6 = r6 ^ r10
            r10 = 16
            int r8 = r8 >> r10
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r10 = r8 >>> 16
            int r8 = r8 << -16
            r8 = r8 | r10
            r6 = r6 ^ r8
            int r3 = r3 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r8 = r3 >>> 8
            int r3 = r3 << -8
            r3 = r3 | r8
            r3 = r3 ^ r6
            r6 = 3
            r5 = r5[r6]
            r3 = r3 ^ r5
            byte[] r5 = c
            r6 = r9 & 255(0xff, float:3.57E-43)
            byte r6 = r5[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r8 = r0.f5905a
            int r10 = r3 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r6 = r6 ^ r10
            int r10 = r13 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 16
            int r10 = r10 << r11
            r6 = r6 ^ r10
            int r10 = r12 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r5[r10]
            int r10 = r10 << 24
            r6 = r6 ^ r10
            r10 = 0
            r1 = r1[r10]
            r10 = r1[r10]
            r6 = r6 ^ r10
            r0.f5907b = r6
            r6 = r12 & 255(0xff, float:3.57E-43)
            byte r6 = r8[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r10 = r9 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r6 = r6 ^ r10
            int r10 = r3 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r5[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 16
            int r10 = r10 << r11
            r6 = r6 ^ r10
            int r10 = r13 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r8[r10]
            int r10 = r10 << 24
            r6 = r6 ^ r10
            r10 = 1
            r10 = r1[r10]
            r6 = r6 ^ r10
            r0.f5908c = r6
            r6 = r13 & 255(0xff, float:3.57E-43)
            byte r6 = r8[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r10 = r12 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r5[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r6 = r6 ^ r10
            int r10 = r9 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r5[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 16
            int r10 = r10 << r11
            r6 = r6 ^ r10
            int r10 = r3 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = r8[r10]
            int r10 = r10 << 24
            r6 = r6 ^ r10
            r7 = r1[r7]
            r6 = r6 ^ r7
            r0.d = r6
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r5 = r13 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r8[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            r3 = r3 ^ r5
            r5 = 16
            int r6 = r12 >> 16
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r8[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r5
            r3 = r3 ^ r6
            int r5 = r9 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = r8[r5]
            int r5 = r5 << 24
            r3 = r3 ^ r5
            r5 = 3
            r1 = r1[r5]
            r1 = r1 ^ r3
            r0.e = r1
            r0.d(r2, r4)
        L_0x0636:
            r1 = 16
            return r1
        L_0x0639:
            org.spongycastle.crypto.OutputLengthException r1 = new org.spongycastle.crypto.OutputLengthException
            java.lang.String r2 = "output buffer too short"
            r1.<init>(r2)
            throw r1
        L_0x0641:
            org.spongycastle.crypto.DataLengthException r1 = new org.spongycastle.crypto.DataLengthException
            java.lang.String r2 = "input buffer too short"
            r1.<init>(r2)
            throw r1
        L_0x0649:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "AES engine not initialised"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.AESEngine.e(int, int, byte[], byte[]):int");
    }

    public final void g(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        byte b2 = (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8);
        int i4 = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i5 = i4 + 1;
        this.f5907b = b3 | (bArr[i4] << Ascii.CAN);
        int i6 = i5 + 1;
        byte b4 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        int i7 = i6 + 1;
        byte b5 = ((bArr[i6] & UnsignedBytes.MAX_VALUE) << 8) | b4;
        int i8 = i7 + 1;
        byte b6 = b5 | ((bArr[i7] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i9 = i8 + 1;
        this.f5908c = b6 | (bArr[i8] << Ascii.CAN);
        int i10 = i9 + 1;
        byte b7 = bArr[i9] & UnsignedBytes.MAX_VALUE;
        int i11 = i10 + 1;
        byte b8 = ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 8) | b7;
        int i12 = i11 + 1;
        byte b9 = b8 | ((bArr[i11] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        int i13 = i12 + 1;
        this.d = b9 | (bArr[i12] << Ascii.CAN);
        int i14 = i13 + 1;
        byte b10 = bArr[i13] & UnsignedBytes.MAX_VALUE;
        int i15 = i14 + 1;
        this.e = ((bArr[i14] & UnsignedBytes.MAX_VALUE) << 8) | b10 | ((bArr[i15] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | (bArr[i15 + 1] << Ascii.CAN);
    }

    public final void reset() {
    }
}
