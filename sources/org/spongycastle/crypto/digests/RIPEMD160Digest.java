package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;

public class RIPEMD160Digest extends GeneralDigest {
    public final int[] a = new int[16];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public RIPEMD160Digest() {
        reset();
    }

    public final Memoable a() {
        return new RIPEMD160Digest(this);
    }

    public final String b() {
        return "RIPEMD160";
    }

    public final int c(int i, byte[] bArr) {
        j();
        u(this.b, bArr, i);
        u(this.c, bArr, i + 4);
        u(this.d, bArr, i + 8);
        u(this.e, bArr, i + 12);
        u(this.f, bArr, i + 16);
        reset();
        return 20;
    }

    public final void e(Memoable memoable) {
        o((RIPEMD160Digest) memoable);
    }

    public final int f() {
        return 20;
    }

    public final void k() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.e;
        int i5 = this.f;
        int[] iArr = this.a;
        int c2 = C0709Uj.c(p(i2, i3, i4) + i, iArr[0], this, 11, i5);
        int n = n(i3, 10);
        int c3 = C0709Uj.c(p(c2, i2, n) + i5, iArr[1], this, 14, i4);
        int n2 = n(i2, 10);
        int c4 = C0709Uj.c(p(c3, c2, n2) + i4, iArr[2], this, 15, n);
        int n3 = n(c2, 10);
        int c5 = C0709Uj.c(p(c4, c3, n3) + n, iArr[3], this, 12, n2);
        int n4 = n(c3, 10);
        int c6 = C0709Uj.c(p(c5, c4, n4) + n2, iArr[4], this, 5, n3);
        int n5 = n(c4, 10);
        int c7 = C0709Uj.c(p(c6, c5, n5) + n3, iArr[5], this, 8, n4);
        int n6 = n(c5, 10);
        int c8 = C0709Uj.c(p(c7, c6, n6) + n4, iArr[6], this, 7, n5);
        int n7 = n(c6, 10);
        int c9 = C0709Uj.c(p(c8, c7, n7) + n5, iArr[7], this, 9, n6);
        int n8 = n(c7, 10);
        int c10 = C0709Uj.c(p(c9, c8, n8) + n6, iArr[8], this, 11, n7);
        int n9 = n(c8, 10);
        int c11 = C0709Uj.c(p(c10, c9, n9) + n7, iArr[9], this, 13, n8);
        int n10 = n(c9, 10);
        int c12 = C0709Uj.c(p(c11, c10, n10) + n8, iArr[10], this, 14, n9);
        int n11 = n(c10, 10);
        int c13 = C0709Uj.c(p(c12, c11, n11) + n9, iArr[11], this, 15, n10);
        int n12 = n(c11, 10);
        int c14 = C0709Uj.c(p(c13, c12, n12) + n10, iArr[12], this, 6, n11);
        int n13 = n(c12, 10);
        int c15 = C0709Uj.c(p(c14, c13, n13) + n11, iArr[13], this, 7, n12);
        int n14 = n(c13, 10);
        int c16 = C0709Uj.c(p(c15, c14, n14) + n12, iArr[14], this, 9, n13);
        int n15 = n(c14, 10);
        int c17 = C0709Uj.c(p(c16, c15, n15) + n13, iArr[15], this, 8, n14);
        int n16 = n(c15, 10);
        int i6 = c17;
        int c18 = lf.c(i + t(i2, i3, i4), iArr[5], 1352829926, this, 8, i5);
        int n17 = n(i3, 10);
        int i7 = c18;
        int c19 = lf.c(t(c18, i2, n17) + i5, iArr[14], 1352829926, this, 9, i4);
        int n18 = n(i2, 10);
        int i8 = c19;
        int c20 = lf.c(t(c19, i7, n18) + i4, iArr[7], 1352829926, this, 9, n17);
        int n19 = n(i7, 10);
        int i9 = c20;
        int c21 = lf.c(t(c20, i8, n19) + n17, iArr[0], 1352829926, this, 11, n18);
        int n20 = n(i8, 10);
        int i10 = c21;
        int c22 = lf.c(t(c21, i9, n20) + n18, iArr[9], 1352829926, this, 13, n19);
        int n21 = n(i9, 10);
        int i11 = c22;
        int c23 = lf.c(t(c22, i10, n21) + n19, iArr[2], 1352829926, this, 15, n20);
        int n22 = n(i10, 10);
        int i12 = c23;
        int c24 = lf.c(t(c23, i11, n22) + n20, iArr[11], 1352829926, this, 15, n21);
        int n23 = n(i11, 10);
        int i13 = c24;
        int c25 = lf.c(t(c24, i12, n23) + n21, iArr[4], 1352829926, this, 5, n22);
        int n24 = n(i12, 10);
        int i14 = c25;
        int c26 = lf.c(t(c25, i13, n24) + n22, iArr[13], 1352829926, this, 7, n23);
        int n25 = n(i13, 10);
        int i15 = c26;
        int c27 = lf.c(t(c26, i14, n25) + n23, iArr[6], 1352829926, this, 7, n24);
        int n26 = n(i14, 10);
        int i16 = c27;
        int c28 = lf.c(t(c27, i15, n26) + n24, iArr[15], 1352829926, this, 8, n25);
        int n27 = n(i15, 10);
        int i17 = c28;
        int c29 = lf.c(t(c28, i16, n27) + n25, iArr[8], 1352829926, this, 11, n26);
        int n28 = n(i16, 10);
        int i18 = c29;
        int c30 = lf.c(t(c29, i17, n28) + n26, iArr[1], 1352829926, this, 14, n27);
        int n29 = n(i17, 10);
        int i19 = c30;
        int c31 = lf.c(t(c30, i18, n29) + n27, iArr[10], 1352829926, this, 14, n28);
        int n30 = n(i18, 10);
        int i20 = c31;
        int c32 = lf.c(t(c31, i19, n30) + n28, iArr[3], 1352829926, this, 12, n29);
        int n31 = n(i19, 10);
        int i21 = c32;
        int c33 = lf.c(t(c32, i20, n31) + n29, iArr[12], 1352829926, this, 6, n30);
        int n32 = n(i20, 10);
        int i22 = n16;
        int i23 = i6;
        int i24 = i22;
        int i25 = c33;
        int c34 = lf.c(q(i23, c16, i22) + n14, iArr[7], 1518500249, this, 7, n15);
        int n33 = n(c16, 10);
        int i26 = i23;
        int i27 = c34;
        int c35 = lf.c(q(c34, i26, n33) + n15, iArr[4], 1518500249, this, 6, i24);
        int n34 = n(i26, 10);
        int i28 = n34;
        int i29 = c35;
        int c36 = lf.c(q(c35, i27, n34) + i24, iArr[13], 1518500249, this, 8, n33);
        int n35 = n(i27, 10);
        int i30 = i29;
        int i31 = c36;
        int c37 = lf.c(q(c36, i30, n35) + n33, iArr[1], 1518500249, this, 13, i28);
        int n36 = n(i30, 10);
        int i32 = i31;
        int i33 = c37;
        int c38 = lf.c(q(c37, i32, n36) + i28, iArr[10], 1518500249, this, 11, n35);
        int n37 = n(i32, 10);
        int i34 = i33;
        int i35 = i34;
        int i36 = n37;
        int i37 = c38;
        int c39 = lf.c(q(c38, i34, n37) + n35, iArr[6], 1518500249, this, 9, n36);
        int n38 = n(i35, 10);
        int i38 = n38;
        int i39 = c39;
        int c40 = lf.c(q(c39, i37, n38) + n36, iArr[15], 1518500249, this, 7, i36);
        int n39 = n(i37, 10);
        int i40 = c40;
        int c41 = lf.c(q(c40, i39, n39) + i36, iArr[3], 1518500249, this, 15, i38);
        int n40 = n(i39, 10);
        int i41 = i40;
        int i42 = c41;
        int c42 = lf.c(q(c41, i41, n40) + i38, iArr[12], 1518500249, this, 7, n39);
        int n41 = n(i41, 10);
        int i43 = i42;
        int i44 = i43;
        int i45 = n41;
        int i46 = c42;
        int c43 = lf.c(q(c42, i43, n41) + n39, iArr[0], 1518500249, this, 12, n40);
        int n42 = n(i44, 10);
        int i47 = i46;
        int i48 = c43;
        int c44 = lf.c(q(c43, i47, n42) + n40, iArr[9], 1518500249, this, 15, i45);
        int n43 = n(i47, 10);
        int i49 = i48;
        int i50 = c44;
        int c45 = lf.c(q(c44, i49, n43) + i45, iArr[5], 1518500249, this, 9, n42);
        int n44 = n(i49, 10);
        int i51 = i50;
        int i52 = i51;
        int i53 = n44;
        int i54 = c45;
        int c46 = lf.c(q(c45, i51, n44) + n42, iArr[2], 1518500249, this, 11, n43);
        int n45 = n(i52, 10);
        int i55 = n45;
        int i56 = c46;
        int c47 = lf.c(q(c46, i54, n45) + n43, iArr[14], 1518500249, this, 7, i53);
        int n46 = n(i54, 10);
        int i57 = c47;
        int c48 = lf.c(q(c47, i56, n46) + i53, iArr[11], 1518500249, this, 13, i55);
        int n47 = n(i56, 10);
        int i58 = i57;
        int i59 = c48;
        int c49 = lf.c(q(c48, i58, n47) + i55, iArr[8], 1518500249, this, 12, n46);
        int n48 = n(i58, 10);
        int i60 = c49;
        int c50 = lf.c(s(i25, i21, n32) + n30, iArr[6], 1548603684, this, 9, n31);
        int n49 = n(i21, 10);
        int i61 = c50;
        int c51 = lf.c(s(c50, i25, n49) + n31, iArr[11], 1548603684, this, 13, n32);
        int n50 = n(i25, 10);
        int i62 = c51;
        int c52 = lf.c(s(c51, i61, n50) + n32, iArr[3], 1548603684, this, 15, n49);
        int n51 = n(i61, 10);
        int i63 = c52;
        int c53 = lf.c(s(c52, i62, n51) + n49, iArr[7], 1548603684, this, 7, n50);
        int n52 = n(i62, 10);
        int i64 = c53;
        int c54 = lf.c(s(c53, i63, n52) + n50, iArr[0], 1548603684, this, 12, n51);
        int n53 = n(i63, 10);
        int i65 = c54;
        int c55 = lf.c(s(c54, i64, n53) + n51, iArr[13], 1548603684, this, 8, n52);
        int n54 = n(i64, 10);
        int i66 = c55;
        int c56 = lf.c(s(c55, i65, n54) + n52, iArr[5], 1548603684, this, 9, n53);
        int n55 = n(i65, 10);
        int i67 = c56;
        int c57 = lf.c(s(c56, i66, n55) + n53, iArr[10], 1548603684, this, 11, n54);
        int n56 = n(i66, 10);
        int i68 = c57;
        int c58 = lf.c(s(c57, i67, n56) + n54, iArr[14], 1548603684, this, 7, n55);
        int n57 = n(i67, 10);
        int i69 = c58;
        int c59 = lf.c(s(c58, i68, n57) + n55, iArr[15], 1548603684, this, 7, n56);
        int n58 = n(i68, 10);
        int i70 = c59;
        int c60 = lf.c(s(c59, i69, n58) + n56, iArr[8], 1548603684, this, 12, n57);
        int n59 = n(i69, 10);
        int i71 = c60;
        int c61 = lf.c(s(c60, i70, n59) + n57, iArr[12], 1548603684, this, 7, n58);
        int n60 = n(i70, 10);
        int c62 = lf.c(s(c61, i71, n60) + n58, iArr[4], 1548603684, this, 6, n59);
        int n61 = n(i71, 10);
        int c63 = lf.c(s(c62, c61, n61) + n59, iArr[9], 1548603684, this, 15, n60);
        int n62 = n(c61, 10);
        int c64 = lf.c(s(c63, c62, n62) + n60, iArr[1], 1548603684, this, 13, n61);
        int n63 = n(c62, 10);
        int c65 = lf.c(s(c64, c63, n63) + n61, iArr[2], 1548603684, this, 11, n62);
        int n64 = n(c63, 10);
        int i72 = i59;
        int i73 = n48;
        int i74 = i60;
        int i75 = i73;
        int i76 = i74;
        int i77 = c65;
        int c66 = lf.c(r(i74, i72, i73) + n46, iArr[3], 1859775393, this, 11, n47);
        int n65 = n(i72, 10);
        int i78 = n65;
        int i79 = c66;
        int c67 = lf.c(r(c66, i76, n65) + n47, iArr[10], 1859775393, this, 13, i75);
        int n66 = n(i76, 10);
        int i80 = c67;
        int c68 = lf.c(r(c67, i79, n66) + i75, iArr[14], 1859775393, this, 6, i78);
        int n67 = n(i79, 10);
        int i81 = i80;
        int i82 = c68;
        int c69 = lf.c(r(c68, i81, n67) + i78, iArr[4], 1859775393, this, 7, n66);
        int n68 = n(i81, 10);
        int i83 = i82;
        int i84 = n68;
        int i85 = c69;
        int c70 = lf.c(r(c69, i83, n68) + n66, iArr[9], 1859775393, this, 14, n67);
        int n69 = n(i83, 10);
        int i86 = i85;
        int i87 = c70;
        int c71 = lf.c(r(c70, i86, n69) + n67, iArr[15], 1859775393, this, 9, i84);
        int n70 = n(i86, 10);
        int i88 = i87;
        int i89 = c71;
        int c72 = lf.c(r(c71, i88, n70) + i84, iArr[8], 1859775393, this, 13, n69);
        int n71 = n(i88, 10);
        int i90 = i89;
        int i91 = n71;
        int i92 = c72;
        int c73 = lf.c(r(c72, i90, n71) + n69, iArr[1], 1859775393, this, 15, n70);
        int n72 = n(i90, 10);
        int i93 = n72;
        int i94 = c73;
        int c74 = lf.c(r(c73, i92, n72) + n70, iArr[2], 1859775393, this, 14, i91);
        int n73 = n(i92, 10);
        int i95 = c74;
        int c75 = lf.c(r(c74, i94, n73) + i91, iArr[7], 1859775393, this, 8, i93);
        int n74 = n(i94, 10);
        int i96 = i95;
        int i97 = c75;
        int c76 = lf.c(r(c75, i96, n74) + i93, iArr[0], 1859775393, this, 13, n73);
        int n75 = n(i96, 10);
        int i98 = i97;
        int i99 = n75;
        int i100 = c76;
        int c77 = lf.c(r(c76, i98, n75) + n73, iArr[6], 1859775393, this, 6, n74);
        int n76 = n(i98, 10);
        int i101 = n76;
        int i102 = c77;
        int c78 = lf.c(r(c77, i100, n76) + n74, iArr[13], 1859775393, this, 5, i99);
        int n77 = n(i100, 10);
        int i103 = c78;
        int c79 = lf.c(r(c78, i102, n77) + i99, iArr[11], 1859775393, this, 12, i101);
        int n78 = n(i102, 10);
        int i104 = i103;
        int i105 = c79;
        int c80 = lf.c(r(c79, i104, n78) + i101, iArr[5], 1859775393, this, 7, n77);
        int n79 = n(i104, 10);
        int i106 = i105;
        int i107 = i106;
        int i108 = n79;
        int i109 = c80;
        int c81 = lf.c(r(c80, i106, n79) + n77, iArr[12], 1859775393, this, 5, n78);
        int n80 = n(i107, 10);
        int i110 = c81;
        int c82 = lf.c(r(i77, c64, n64) + n62, iArr[15], 1836072691, this, 9, n63);
        int n81 = n(c64, 10);
        int i111 = c82;
        int c83 = lf.c(r(c82, i77, n81) + n63, iArr[5], 1836072691, this, 7, n64);
        int n82 = n(i77, 10);
        int i112 = c83;
        int c84 = lf.c(r(c83, i111, n82) + n64, iArr[1], 1836072691, this, 15, n81);
        int n83 = n(i111, 10);
        int i113 = c84;
        int c85 = lf.c(r(c84, i112, n83) + n81, iArr[3], 1836072691, this, 11, n82);
        int n84 = n(i112, 10);
        int i114 = c85;
        int c86 = lf.c(r(c85, i113, n84) + n82, iArr[7], 1836072691, this, 8, n83);
        int n85 = n(i113, 10);
        int i115 = c86;
        int c87 = lf.c(r(c86, i114, n85) + n83, iArr[14], 1836072691, this, 6, n84);
        int n86 = n(i114, 10);
        int i116 = c87;
        int c88 = lf.c(r(c87, i115, n86) + n84, iArr[6], 1836072691, this, 6, n85);
        int n87 = n(i115, 10);
        int c89 = lf.c(r(c88, i116, n87) + n85, iArr[9], 1836072691, this, 14, n86);
        int n88 = n(i116, 10);
        int c90 = lf.c(r(c89, c88, n88) + n86, iArr[11], 1836072691, this, 12, n87);
        int n89 = n(c88, 10);
        int c91 = lf.c(r(c90, c89, n89) + n87, iArr[8], 1836072691, this, 13, n88);
        int n90 = n(c89, 10);
        int c92 = lf.c(r(c91, c90, n90) + n88, iArr[12], 1836072691, this, 5, n89);
        int n91 = n(c90, 10);
        int c93 = lf.c(r(c92, c91, n91) + n89, iArr[2], 1836072691, this, 14, n90);
        int n92 = n(c91, 10);
        int c94 = lf.c(r(c93, c92, n92) + n90, iArr[10], 1836072691, this, 13, n91);
        int n93 = n(c92, 10);
        int i117 = c94;
        int c95 = lf.c(r(c94, c93, n93) + n91, iArr[0], 1836072691, this, 13, n92);
        int n94 = n(c93, 10);
        int c96 = lf.c(r(c95, i117, n94) + n92, iArr[4], 1836072691, this, 7, n93);
        int n95 = n(i117, 10);
        int c97 = lf.c(r(c96, c95, n95) + n93, iArr[13], 1836072691, this, 5, n94);
        int n96 = n(c95, 10);
        int i118 = i109;
        int i119 = i110;
        int i120 = i119;
        int i121 = n95;
        int i122 = i118;
        int c98 = lf.c(s(i119, i118, n80) + n78, iArr[1], -1894007588, this, 11, i108);
        int n97 = n(i122, 10);
        int i123 = c98;
        int c99 = lf.c(s(c98, i120, n97) + i108, iArr[9], -1894007588, this, 12, n80);
        int n98 = n(i120, 10);
        int i124 = i123;
        int i125 = c99;
        int c100 = lf.c(s(c99, i124, n98) + n80, iArr[11], -1894007588, this, 14, n97);
        int n99 = n(i124, 10);
        int i126 = n99;
        int i127 = c100;
        int c101 = lf.c(s(c100, i125, n99) + n97, iArr[10], -1894007588, this, 15, n98);
        int n100 = n(i125, 10);
        int i128 = c101;
        int c102 = lf.c(s(c101, i127, n100) + n98, iArr[0], -1894007588, this, 14, i126);
        int n101 = n(i127, 10);
        int i129 = c102;
        int c103 = lf.c(s(c102, i128, n101) + i126, iArr[8], -1894007588, this, 15, n100);
        int n102 = n(i128, 10);
        int i130 = i129;
        int i131 = c103;
        int c104 = lf.c(s(c103, i130, n102) + n100, iArr[12], -1894007588, this, 9, n101);
        int n103 = n(i130, 10);
        int i132 = n103;
        int i133 = c104;
        int c105 = lf.c(s(c104, i131, n103) + n101, iArr[4], -1894007588, this, 8, n102);
        int n104 = n(i131, 10);
        int i134 = c105;
        int c106 = lf.c(s(c105, i133, n104) + n102, iArr[13], -1894007588, this, 9, i132);
        int n105 = n(i133, 10);
        int i135 = c106;
        int c107 = lf.c(s(c106, i134, n105) + i132, iArr[3], -1894007588, this, 14, n104);
        int n106 = n(i134, 10);
        int i136 = i135;
        int i137 = c107;
        int c108 = lf.c(s(c107, i136, n106) + n104, iArr[7], -1894007588, this, 5, n105);
        int n107 = n(i136, 10);
        int i138 = n107;
        int i139 = c108;
        int c109 = lf.c(s(c108, i137, n107) + n105, iArr[15], -1894007588, this, 6, n106);
        int n108 = n(i137, 10);
        int i140 = c109;
        int c110 = lf.c(s(c109, i139, n108) + n106, iArr[14], -1894007588, this, 8, i138);
        int n109 = n(i139, 10);
        int i141 = c110;
        int c111 = lf.c(s(c110, i140, n109) + i138, iArr[5], -1894007588, this, 6, n108);
        int n110 = n(i140, 10);
        int i142 = i141;
        int i143 = c111;
        int c112 = lf.c(s(c111, i142, n110) + n108, iArr[6], -1894007588, this, 5, n109);
        int n111 = n(i142, 10);
        int i144 = i143;
        int i145 = c112;
        int c113 = lf.c(s(c112, i144, n111) + n109, iArr[2], -1894007588, this, 12, n110);
        int n112 = n(i144, 10);
        int i146 = c113;
        int c114 = lf.c(q(c97, c96, n96) + n94, iArr[8], 2053994217, this, 15, i121);
        int n113 = n(c96, 10);
        int i147 = c114;
        int c115 = lf.c(q(c114, c97, n113) + i121, iArr[6], 2053994217, this, 5, n96);
        int n114 = n(c97, 10);
        int i148 = c115;
        int c116 = lf.c(q(c115, i147, n114) + n96, iArr[4], 2053994217, this, 8, n113);
        int n115 = n(i147, 10);
        int i149 = c116;
        int c117 = lf.c(q(c116, i148, n115) + n113, iArr[1], 2053994217, this, 11, n114);
        int n116 = n(i148, 10);
        int i150 = c117;
        int c118 = lf.c(q(c117, i149, n116) + n114, iArr[3], 2053994217, this, 14, n115);
        int n117 = n(i149, 10);
        int i151 = c118;
        int c119 = lf.c(q(c118, i150, n117) + n115, iArr[11], 2053994217, this, 14, n116);
        int n118 = n(i150, 10);
        int i152 = c119;
        int c120 = lf.c(q(c119, i151, n118) + n116, iArr[15], 2053994217, this, 6, n117);
        int n119 = n(i151, 10);
        int i153 = c120;
        int c121 = lf.c(q(c120, i152, n119) + n117, iArr[0], 2053994217, this, 14, n118);
        int n120 = n(i152, 10);
        int i154 = c121;
        int c122 = lf.c(q(c121, i153, n120) + n118, iArr[5], 2053994217, this, 6, n119);
        int n121 = n(i153, 10);
        int i155 = c122;
        int c123 = lf.c(q(c122, i154, n121) + n119, iArr[12], 2053994217, this, 9, n120);
        int n122 = n(i154, 10);
        int i156 = c123;
        int c124 = lf.c(q(c123, i155, n122) + n120, iArr[2], 2053994217, this, 12, n121);
        int n123 = n(i155, 10);
        int i157 = c124;
        int c125 = lf.c(q(c124, i156, n123) + n121, iArr[13], 2053994217, this, 9, n122);
        int n124 = n(i156, 10);
        int i158 = c125;
        int c126 = lf.c(q(c125, i157, n124) + n122, iArr[9], 2053994217, this, 12, n123);
        int n125 = n(i157, 10);
        int i159 = c126;
        int c127 = lf.c(q(c126, i158, n125) + n123, iArr[7], 2053994217, this, 5, n124);
        int n126 = n(i158, 10);
        int i160 = c127;
        int c128 = lf.c(q(c127, i159, n126) + n124, iArr[10], 2053994217, this, 15, n125);
        int n127 = n(i159, 10);
        int i161 = c128;
        int c129 = lf.c(q(c128, i160, n127) + n125, iArr[14], 2053994217, this, 8, n126);
        int n128 = n(i160, 10);
        int i162 = n112;
        int i163 = i146;
        int i164 = i162;
        int i165 = i163;
        int i166 = c129;
        int c130 = lf.c(t(i163, i145, i162) + n110, iArr[4], -1454113458, this, 9, n111);
        int n129 = n(i145, 10);
        int i167 = c130;
        int c131 = lf.c(t(c130, i165, n129) + n111, iArr[0], -1454113458, this, 15, i164);
        int n130 = n(i165, 10);
        int i168 = c131;
        int c132 = lf.c(t(c131, i167, n130) + i164, iArr[5], -1454113458, this, 5, n129);
        int n131 = n(i167, 10);
        int i169 = i168;
        int i170 = c132;
        int c133 = lf.c(t(c132, i169, n131) + n129, iArr[9], -1454113458, this, 11, n130);
        int n132 = n(i169, 10);
        int i171 = n132;
        int i172 = c133;
        int c134 = lf.c(t(c133, i170, n132) + n130, iArr[7], -1454113458, this, 6, n131);
        int n133 = n(i170, 10);
        int i173 = c134;
        int c135 = lf.c(t(c134, i172, n133) + n131, iArr[12], -1454113458, this, 8, i171);
        int n134 = n(i172, 10);
        int i174 = c135;
        int c136 = lf.c(t(c135, i173, n134) + i171, iArr[2], -1454113458, this, 13, n133);
        int n135 = n(i173, 10);
        int i175 = i174;
        int i176 = c136;
        int c137 = lf.c(t(c136, i175, n135) + n133, iArr[10], -1454113458, this, 12, n134);
        int n136 = n(i175, 10);
        int i177 = n136;
        int i178 = c137;
        int c138 = lf.c(t(c137, i176, n136) + n134, iArr[14], -1454113458, this, 5, n135);
        int n137 = n(i176, 10);
        int i179 = c138;
        int c139 = lf.c(t(c138, i178, n137) + n135, iArr[1], -1454113458, this, 12, i177);
        int n138 = n(i178, 10);
        int i180 = c139;
        int c140 = lf.c(t(c139, i179, n138) + i177, iArr[3], -1454113458, this, 13, n137);
        int n139 = n(i179, 10);
        int i181 = i180;
        int i182 = c140;
        int c141 = lf.c(t(c140, i181, n139) + n137, iArr[8], -1454113458, this, 14, n138);
        int n140 = n(i181, 10);
        int i183 = n140;
        int i184 = c141;
        int c142 = lf.c(t(c141, i182, n140) + n138, iArr[11], -1454113458, this, 11, n139);
        int n141 = n(i182, 10);
        int i185 = c142;
        int c143 = lf.c(t(c142, i184, n141) + n139, iArr[6], -1454113458, this, 8, i183);
        int n142 = n(i184, 10);
        int i186 = c143;
        int c144 = lf.c(t(c143, i185, n142) + i183, iArr[15], -1454113458, this, 5, n141);
        int n143 = n(i185, 10);
        int i187 = i186;
        int i188 = c144;
        int c145 = lf.c(t(c144, i187, n143) + n141, iArr[13], -1454113458, this, 6, n142);
        int n144 = n(i187, 10);
        int i189 = i166;
        int c146 = C0709Uj.c(p(i189, i161, n128) + n126, iArr[12], this, 8, n127);
        int n145 = n(i161, 10);
        int c147 = C0709Uj.c(p(c146, i189, n145) + n127, iArr[15], this, 5, n128);
        int n146 = n(i189, 10);
        int c148 = C0709Uj.c(p(c147, c146, n146) + n128, iArr[10], this, 12, n145);
        int n147 = n(c146, 10);
        int c149 = C0709Uj.c(p(c148, c147, n147) + n145, iArr[4], this, 9, n146);
        int n148 = n(c147, 10);
        int c150 = C0709Uj.c(p(c149, c148, n148) + n146, iArr[1], this, 12, n147);
        int n149 = n(c148, 10);
        int c151 = C0709Uj.c(p(c150, c149, n149) + n147, iArr[5], this, 5, n148);
        int n150 = n(c149, 10);
        int c152 = C0709Uj.c(p(c151, c150, n150) + n148, iArr[8], this, 14, n149);
        int n151 = n(c150, 10);
        int c153 = C0709Uj.c(p(c152, c151, n151) + n149, iArr[7], this, 6, n150);
        int n152 = n(c151, 10);
        int c154 = C0709Uj.c(p(c153, c152, n152) + n150, iArr[6], this, 8, n151);
        int n153 = n(c152, 10);
        int c155 = C0709Uj.c(p(c154, c153, n153) + n151, iArr[2], this, 13, n152);
        int n154 = n(c153, 10);
        int c156 = C0709Uj.c(p(c155, c154, n154) + n152, iArr[13], this, 6, n153);
        int n155 = n(c154, 10);
        int c157 = C0709Uj.c(p(c156, c155, n155) + n153, iArr[14], this, 5, n154);
        int n156 = n(c155, 10);
        int c158 = C0709Uj.c(p(c157, c156, n156) + n154, iArr[0], this, 15, n155);
        int n157 = n(c156, 10);
        int c159 = C0709Uj.c(p(c158, c157, n157) + n155, iArr[3], this, 13, n156);
        int n158 = n(c157, 10);
        int c160 = C0709Uj.c(p(c159, c158, n158) + n156, iArr[9], this, 11, n157);
        int n159 = n(c158, 10);
        int c161 = C0709Uj.c(p(c160, c159, n159) + n157, iArr[11], this, 11, n158);
        int n160 = i188 + this.c + n(c159, 10);
        this.c = this.d + n144 + n159;
        this.d = this.e + n143 + n158;
        this.e = this.f + n142 + c161;
        this.f = this.b + c145 + c160;
        this.b = n160;
        this.g = 0;
        for (int i190 = 0; i190 != iArr.length; i190++) {
            iArr[i190] = 0;
        }
    }

    public final void l(long j) {
        if (this.g > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    public final void m(int i, byte[] bArr) {
        int i2 = this.g;
        int i3 = i2 + 1;
        this.g = i3;
        int i4 = (bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        this.a[i2] = i4 | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        if (i3 == 16) {
            k();
        }
    }

    public final int n(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public final void o(RIPEMD160Digest rIPEMD160Digest) {
        i(rIPEMD160Digest);
        this.b = rIPEMD160Digest.b;
        this.c = rIPEMD160Digest.c;
        this.d = rIPEMD160Digest.d;
        this.e = rIPEMD160Digest.e;
        this.f = rIPEMD160Digest.f;
        int[] iArr = this.a;
        int[] iArr2 = rIPEMD160Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.g = rIPEMD160Digest.g;
    }

    public final int p(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    public final int q(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public final int r(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    public final void reset() {
        super.reset();
        this.b = 1732584193;
        this.c = -271733879;
        this.d = -1732584194;
        this.e = 271733878;
        this.f = -1009589776;
        this.g = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public final int s(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    public final int t(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    public final void u(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super(rIPEMD160Digest);
        o(rIPEMD160Digest);
    }
}
