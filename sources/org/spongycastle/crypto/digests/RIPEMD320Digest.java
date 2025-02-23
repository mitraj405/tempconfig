package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;

public class RIPEMD320Digest extends GeneralDigest {
    public final int[] a = new int[16];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public RIPEMD320Digest() {
        reset();
    }

    public final Memoable a() {
        return new RIPEMD320Digest(this);
    }

    public final String b() {
        return "RIPEMD320";
    }

    public final int c(int i2, byte[] bArr) {
        j();
        u(this.b, bArr, i2);
        u(this.c, bArr, i2 + 4);
        u(this.d, bArr, i2 + 8);
        u(this.e, bArr, i2 + 12);
        u(this.f, bArr, i2 + 16);
        u(this.g, bArr, i2 + 20);
        u(this.h, bArr, i2 + 24);
        u(this.i, bArr, i2 + 28);
        u(this.j, bArr, i2 + 32);
        u(this.k, bArr, i2 + 36);
        reset();
        return 40;
    }

    public final void e(Memoable memoable) {
        o((RIPEMD320Digest) memoable);
    }

    public final int f() {
        return 40;
    }

    public final void k() {
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        int i5 = this.e;
        int i6 = this.f;
        int i7 = this.g;
        int i8 = this.h;
        int i9 = this.i;
        int i10 = this.j;
        int i11 = this.k;
        int[] iArr = this.a;
        int d2 = C0709Uj.d(p(i3, i4, i5) + i2, iArr[0], this, 11, i6);
        int n = n(i4, 10);
        int d3 = C0709Uj.d(p(d2, i3, n) + i6, iArr[1], this, 14, i5);
        int n2 = n(i3, 10);
        int d4 = C0709Uj.d(p(d3, d2, n2) + i5, iArr[2], this, 15, n);
        int n3 = n(d2, 10);
        int d5 = C0709Uj.d(p(d4, d3, n3) + n, iArr[3], this, 12, n2);
        int n4 = n(d3, 10);
        int d6 = C0709Uj.d(p(d5, d4, n4) + n2, iArr[4], this, 5, n3);
        int n5 = n(d4, 10);
        int d7 = C0709Uj.d(p(d6, d5, n5) + n3, iArr[5], this, 8, n4);
        int n6 = n(d5, 10);
        int d8 = C0709Uj.d(p(d7, d6, n6) + n4, iArr[6], this, 7, n5);
        int n7 = n(d6, 10);
        int d9 = C0709Uj.d(p(d8, d7, n7) + n5, iArr[7], this, 9, n6);
        int n8 = n(d7, 10);
        int d10 = C0709Uj.d(p(d9, d8, n8) + n6, iArr[8], this, 11, n7);
        int n9 = n(d8, 10);
        int d11 = C0709Uj.d(p(d10, d9, n9) + n7, iArr[9], this, 13, n8);
        int n10 = n(d9, 10);
        int d12 = C0709Uj.d(p(d11, d10, n10) + n8, iArr[10], this, 14, n9);
        int n11 = n(d10, 10);
        int d13 = C0709Uj.d(p(d12, d11, n11) + n9, iArr[11], this, 15, n10);
        int n12 = n(d11, 10);
        int d14 = C0709Uj.d(p(d13, d12, n12) + n10, iArr[12], this, 6, n11);
        int n13 = n(d12, 10);
        int d15 = C0709Uj.d(p(d14, d13, n13) + n11, iArr[13], this, 7, n12);
        int n14 = n(d13, 10);
        int d16 = C0709Uj.d(p(d15, d14, n14) + n12, iArr[14], this, 9, n13);
        int n15 = n(d14, 10);
        int d17 = C0709Uj.d(p(d16, d15, n15) + n13, iArr[15], this, 8, n14);
        int d18 = lf.d(t(i8, i9, i10) + i7, iArr[5], 1352829926, this, 8, i11);
        int n16 = n(i9, 10);
        int i12 = d18;
        int d19 = lf.d(t(d18, i8, n16) + i11, iArr[14], 1352829926, this, 9, i10);
        int n17 = n(i8, 10);
        int i13 = d19;
        int d20 = lf.d(t(d19, i12, n17) + i10, iArr[7], 1352829926, this, 9, n16);
        int n18 = n(i12, 10);
        int i14 = d20;
        int d21 = lf.d(t(d20, i13, n18) + n16, iArr[0], 1352829926, this, 11, n17);
        int n19 = n(i13, 10);
        int i15 = d21;
        int d22 = lf.d(t(d21, i14, n19) + n17, iArr[9], 1352829926, this, 13, n18);
        int n20 = n(i14, 10);
        int i16 = d22;
        int d23 = lf.d(t(d22, i15, n20) + n18, iArr[2], 1352829926, this, 15, n19);
        int n21 = n(i15, 10);
        int i17 = d23;
        int d24 = lf.d(t(d23, i16, n21) + n19, iArr[11], 1352829926, this, 15, n20);
        int n22 = n(i16, 10);
        int i18 = d24;
        int d25 = lf.d(t(d24, i17, n22) + n20, iArr[4], 1352829926, this, 5, n21);
        int n23 = n(i17, 10);
        int i19 = d25;
        int d26 = lf.d(t(d25, i18, n23) + n21, iArr[13], 1352829926, this, 7, n22);
        int n24 = n(i18, 10);
        int i20 = d26;
        int d27 = lf.d(t(d26, i19, n24) + n22, iArr[6], 1352829926, this, 7, n23);
        int n25 = n(i19, 10);
        int i21 = d27;
        int d28 = lf.d(t(d27, i20, n25) + n23, iArr[15], 1352829926, this, 8, n24);
        int n26 = n(i20, 10);
        int i22 = d28;
        int d29 = lf.d(t(d28, i21, n26) + n24, iArr[8], 1352829926, this, 11, n25);
        int n27 = n(i21, 10);
        int i23 = d29;
        int d30 = lf.d(t(d29, i22, n27) + n25, iArr[1], 1352829926, this, 14, n26);
        int n28 = n(i22, 10);
        int i24 = d30;
        int d31 = lf.d(t(d30, i23, n28) + n26, iArr[10], 1352829926, this, 14, n27);
        int n29 = n(i23, 10);
        int i25 = d31;
        int d32 = lf.d(t(d31, i24, n29) + n27, iArr[3], 1352829926, this, 12, n28);
        int n30 = n(i24, 10);
        int i26 = d32;
        int d33 = lf.d(t(d32, i25, n30) + n28, iArr[12], 1352829926, this, 6, n29);
        int n31 = n(i25, 10);
        int n32 = n(d15, 10);
        int i27 = n32;
        int i28 = d33;
        int d34 = lf.d(q(d33, d16, n32) + n14, iArr[7], 1518500249, this, 7, n15);
        int n33 = n(d16, 10);
        int i29 = d34;
        int d35 = lf.d(q(d34, i28, n33) + n15, iArr[4], 1518500249, this, 6, i27);
        int n34 = n(i28, 10);
        int i30 = d35;
        int d36 = lf.d(q(d35, i29, n34) + i27, iArr[13], 1518500249, this, 8, n33);
        int n35 = n(i29, 10);
        int i31 = i30;
        int i32 = d36;
        int d37 = lf.d(q(d36, i31, n35) + n33, iArr[1], 1518500249, this, 13, n34);
        int n36 = n(i31, 10);
        int i33 = i32;
        int i34 = d37;
        int d38 = lf.d(q(d37, i33, n36) + n34, iArr[10], 1518500249, this, 11, n35);
        int n37 = n(i33, 10);
        int i35 = n37;
        int i36 = d38;
        int d39 = lf.d(q(d38, i34, n37) + n35, iArr[6], 1518500249, this, 9, n36);
        int n38 = n(i34, 10);
        int i37 = d39;
        int d40 = lf.d(q(d39, i36, n38) + n36, iArr[15], 1518500249, this, 7, i35);
        int n39 = n(i36, 10);
        int i38 = d40;
        int d41 = lf.d(q(d40, i37, n39) + i35, iArr[3], 1518500249, this, 15, n38);
        int n40 = n(i37, 10);
        int i39 = i38;
        int i40 = d41;
        int d42 = lf.d(q(d41, i39, n40) + n38, iArr[12], 1518500249, this, 7, n39);
        int n41 = n(i39, 10);
        int i41 = i40;
        int i42 = d42;
        int d43 = lf.d(q(d42, i41, n41) + n39, iArr[0], 1518500249, this, 12, n40);
        int n42 = n(i41, 10);
        int i43 = i42;
        int i44 = d43;
        int d44 = lf.d(q(d43, i43, n42) + n40, iArr[9], 1518500249, this, 15, n41);
        int n43 = n(i43, 10);
        int i45 = i44;
        int i46 = d44;
        int d45 = lf.d(q(d44, i45, n43) + n41, iArr[5], 1518500249, this, 9, n42);
        int n44 = n(i45, 10);
        int i47 = i46;
        int i48 = d45;
        int d46 = lf.d(q(d45, i47, n44) + n42, iArr[2], 1518500249, this, 11, n43);
        int n45 = n(i47, 10);
        int i49 = n45;
        int i50 = d46;
        int d47 = lf.d(q(d46, i48, n45) + n43, iArr[14], 1518500249, this, 7, n44);
        int n46 = n(i48, 10);
        int i51 = d47;
        int d48 = lf.d(q(d47, i50, n46) + n44, iArr[11], 1518500249, this, 13, i49);
        int n47 = n(i50, 10);
        int i52 = d48;
        int d49 = lf.d(q(d48, i51, n47) + i49, iArr[8], 1518500249, this, 12, n46);
        int n48 = n(i51, 10);
        int i53 = d17;
        int i54 = i53;
        int i55 = d49;
        int d50 = lf.d(s(i53, i26, n31) + n29, iArr[6], 1548603684, this, 9, n30);
        int n49 = n(i26, 10);
        int i56 = d50;
        int d51 = lf.d(s(d50, i54, n49) + n30, iArr[11], 1548603684, this, 13, n31);
        int n50 = n(i54, 10);
        int i57 = d51;
        int d52 = lf.d(s(d51, i56, n50) + n31, iArr[3], 1548603684, this, 15, n49);
        int n51 = n(i56, 10);
        int i58 = d52;
        int d53 = lf.d(s(d52, i57, n51) + n49, iArr[7], 1548603684, this, 7, n50);
        int n52 = n(i57, 10);
        int i59 = d53;
        int d54 = lf.d(s(d53, i58, n52) + n50, iArr[0], 1548603684, this, 12, n51);
        int n53 = n(i58, 10);
        int i60 = d54;
        int d55 = lf.d(s(d54, i59, n53) + n51, iArr[13], 1548603684, this, 8, n52);
        int n54 = n(i59, 10);
        int i61 = d55;
        int d56 = lf.d(s(d55, i60, n54) + n52, iArr[5], 1548603684, this, 9, n53);
        int n55 = n(i60, 10);
        int i62 = d56;
        int d57 = lf.d(s(d56, i61, n55) + n53, iArr[10], 1548603684, this, 11, n54);
        int n56 = n(i61, 10);
        int i63 = d57;
        int d58 = lf.d(s(d57, i62, n56) + n54, iArr[14], 1548603684, this, 7, n55);
        int n57 = n(i62, 10);
        int i64 = d58;
        int d59 = lf.d(s(d58, i63, n57) + n55, iArr[15], 1548603684, this, 7, n56);
        int n58 = n(i63, 10);
        int i65 = d59;
        int d60 = lf.d(s(d59, i64, n58) + n56, iArr[8], 1548603684, this, 12, n57);
        int n59 = n(i64, 10);
        int i66 = d60;
        int d61 = lf.d(s(d60, i65, n59) + n57, iArr[12], 1548603684, this, 7, n58);
        int n60 = n(i65, 10);
        int i67 = d61;
        int d62 = lf.d(s(d61, i66, n60) + n58, iArr[4], 1548603684, this, 6, n59);
        int n61 = n(i66, 10);
        int i68 = d62;
        int d63 = lf.d(s(d62, i67, n61) + n59, iArr[9], 1548603684, this, 15, n60);
        int n62 = n(i67, 10);
        int i69 = d63;
        int d64 = lf.d(s(d63, i68, n62) + n60, iArr[1], 1548603684, this, 13, n61);
        int n63 = n(i68, 10);
        int i70 = d64;
        int d65 = lf.d(s(d64, i69, n63) + n61, iArr[2], 1548603684, this, 11, n62);
        int n64 = n(i69, 10);
        int i71 = i52;
        int i72 = i55;
        int i73 = i72;
        int i74 = d65;
        int d66 = lf.d(r(i72, i71, n64) + n46, iArr[3], 1859775393, this, 11, n47);
        int n65 = n(i71, 10);
        int i75 = n65;
        int i76 = d66;
        int d67 = lf.d(r(d66, i73, n65) + n47, iArr[10], 1859775393, this, 13, n64);
        int n66 = n(i73, 10);
        int i77 = d67;
        int d68 = lf.d(r(d67, i76, n66) + n64, iArr[14], 1859775393, this, 6, i75);
        int n67 = n(i76, 10);
        int i78 = d68;
        int d69 = lf.d(r(d68, i77, n67) + i75, iArr[4], 1859775393, this, 7, n66);
        int n68 = n(i77, 10);
        int i79 = i78;
        int i80 = d69;
        int d70 = lf.d(r(d69, i79, n68) + n66, iArr[9], 1859775393, this, 14, n67);
        int n69 = n(i79, 10);
        int i81 = i80;
        int i82 = d70;
        int d71 = lf.d(r(d70, i81, n69) + n67, iArr[15], 1859775393, this, 9, n68);
        int n70 = n(i81, 10);
        int i83 = i82;
        int i84 = d71;
        int d72 = lf.d(r(d71, i83, n70) + n68, iArr[8], 1859775393, this, 13, n69);
        int n71 = n(i83, 10);
        int i85 = n71;
        int i86 = d72;
        int d73 = lf.d(r(d72, i84, n71) + n69, iArr[1], 1859775393, this, 15, n70);
        int n72 = n(i84, 10);
        int i87 = d73;
        int d74 = lf.d(r(d73, i86, n72) + n70, iArr[2], 1859775393, this, 14, i85);
        int n73 = n(i86, 10);
        int i88 = d74;
        int d75 = lf.d(r(d74, i87, n73) + i85, iArr[7], 1859775393, this, 8, n72);
        int n74 = n(i87, 10);
        int i89 = i88;
        int i90 = d75;
        int d76 = lf.d(r(d75, i89, n74) + n72, iArr[0], 1859775393, this, 13, n73);
        int n75 = n(i89, 10);
        int i91 = n75;
        int i92 = d76;
        int d77 = lf.d(r(d76, i90, n75) + n73, iArr[6], 1859775393, this, 6, n74);
        int n76 = n(i90, 10);
        int i93 = d77;
        int d78 = lf.d(r(d77, i92, n76) + n74, iArr[13], 1859775393, this, 5, i91);
        int n77 = n(i92, 10);
        int i94 = d78;
        int d79 = lf.d(r(d78, i93, n77) + i91, iArr[11], 1859775393, this, 12, n76);
        int n78 = n(i93, 10);
        int i95 = i94;
        int i96 = d79;
        int d80 = lf.d(r(d79, i95, n78) + n76, iArr[5], 1859775393, this, 7, n77);
        int n79 = n(i95, 10);
        int i97 = i96;
        int i98 = d80;
        int d81 = lf.d(r(d80, i97, n79) + n77, iArr[12], 1859775393, this, 5, n78);
        int n80 = n(i97, 10);
        int i99 = i70;
        int i100 = d81;
        int d82 = lf.d(r(i74, i99, n48) + n62, iArr[15], 1836072691, this, 9, n63);
        int n81 = n(i99, 10);
        int i101 = d82;
        int d83 = lf.d(r(d82, i74, n81) + n63, iArr[5], 1836072691, this, 7, n48);
        int n82 = n(i74, 10);
        int i102 = d83;
        int d84 = lf.d(r(d83, i101, n82) + n48, iArr[1], 1836072691, this, 15, n81);
        int n83 = n(i101, 10);
        int i103 = d84;
        int d85 = lf.d(r(d84, i102, n83) + n81, iArr[3], 1836072691, this, 11, n82);
        int n84 = n(i102, 10);
        int i104 = d85;
        int d86 = lf.d(r(d85, i103, n84) + n82, iArr[7], 1836072691, this, 8, n83);
        int n85 = n(i103, 10);
        int i105 = d86;
        int d87 = lf.d(r(d86, i104, n85) + n83, iArr[14], 1836072691, this, 6, n84);
        int n86 = n(i104, 10);
        int i106 = d87;
        int d88 = lf.d(r(d87, i105, n86) + n84, iArr[6], 1836072691, this, 6, n85);
        int n87 = n(i105, 10);
        int i107 = d88;
        int d89 = lf.d(r(d88, i106, n87) + n85, iArr[9], 1836072691, this, 14, n86);
        int n88 = n(i106, 10);
        int i108 = d89;
        int d90 = lf.d(r(d89, i107, n88) + n86, iArr[11], 1836072691, this, 12, n87);
        int n89 = n(i107, 10);
        int i109 = d90;
        int d91 = lf.d(r(d90, i108, n89) + n87, iArr[8], 1836072691, this, 13, n88);
        int n90 = n(i108, 10);
        int i110 = d91;
        int d92 = lf.d(r(d91, i109, n90) + n88, iArr[12], 1836072691, this, 5, n89);
        int n91 = n(i109, 10);
        int i111 = d92;
        int d93 = lf.d(r(d92, i110, n91) + n89, iArr[2], 1836072691, this, 14, n90);
        int n92 = n(i110, 10);
        int i112 = d93;
        int d94 = lf.d(r(d93, i111, n92) + n90, iArr[10], 1836072691, this, 13, n91);
        int n93 = n(i111, 10);
        int i113 = d94;
        int d95 = lf.d(r(d94, i112, n93) + n91, iArr[0], 1836072691, this, 13, n92);
        int n94 = n(i112, 10);
        int i114 = d95;
        int d96 = lf.d(r(d95, i113, n94) + n92, iArr[4], 1836072691, this, 7, n93);
        int n95 = n(i113, 10);
        int i115 = d96;
        int d97 = lf.d(r(d96, i114, n95) + n93, iArr[13], 1836072691, this, 5, n94);
        int n96 = n(i114, 10);
        int i116 = i98;
        int i117 = i100;
        int i118 = i117;
        int i119 = d97;
        int d98 = lf.d(s(i117, i116, n80) + n94, iArr[1], -1894007588, this, 11, n79);
        int n97 = n(i116, 10);
        int i120 = n97;
        int i121 = d98;
        int d99 = lf.d(s(d98, i118, n97) + n79, iArr[9], -1894007588, this, 12, n80);
        int n98 = n(i118, 10);
        int i122 = d99;
        int d100 = lf.d(s(d99, i121, n98) + n80, iArr[11], -1894007588, this, 14, i120);
        int n99 = n(i121, 10);
        int i123 = d100;
        int d101 = lf.d(s(d100, i122, n99) + i120, iArr[10], -1894007588, this, 15, n98);
        int n100 = n(i122, 10);
        int i124 = i123;
        int i125 = d101;
        int d102 = lf.d(s(d101, i124, n100) + n98, iArr[0], -1894007588, this, 14, n99);
        int n101 = n(i124, 10);
        int i126 = n101;
        int i127 = d102;
        int d103 = lf.d(s(d102, i125, n101) + n99, iArr[8], -1894007588, this, 15, n100);
        int n102 = n(i125, 10);
        int i128 = d103;
        int d104 = lf.d(s(d103, i127, n102) + n100, iArr[12], -1894007588, this, 9, i126);
        int n103 = n(i127, 10);
        int i129 = d104;
        int d105 = lf.d(s(d104, i128, n103) + i126, iArr[4], -1894007588, this, 8, n102);
        int n104 = n(i128, 10);
        int i130 = i129;
        int i131 = d105;
        int d106 = lf.d(s(d105, i130, n104) + n102, iArr[13], -1894007588, this, 9, n103);
        int n105 = n(i130, 10);
        int i132 = n105;
        int i133 = d106;
        int d107 = lf.d(s(d106, i131, n105) + n103, iArr[3], -1894007588, this, 14, n104);
        int n106 = n(i131, 10);
        int i134 = d107;
        int d108 = lf.d(s(d107, i133, n106) + n104, iArr[7], -1894007588, this, 5, i132);
        int n107 = n(i133, 10);
        int i135 = d108;
        int d109 = lf.d(s(d108, i134, n107) + i132, iArr[15], -1894007588, this, 6, n106);
        int n108 = n(i134, 10);
        int i136 = i135;
        int i137 = d109;
        int d110 = lf.d(s(d109, i136, n108) + n106, iArr[14], -1894007588, this, 8, n107);
        int n109 = n(i136, 10);
        int i138 = n109;
        int i139 = d110;
        int d111 = lf.d(s(d110, i137, n109) + n107, iArr[5], -1894007588, this, 6, n108);
        int n110 = n(i137, 10);
        int i140 = d111;
        int d112 = lf.d(s(d111, i139, n110) + n108, iArr[6], -1894007588, this, 5, i138);
        int n111 = n(i139, 10);
        int i141 = d112;
        int d113 = lf.d(s(d112, i140, n111) + i138, iArr[2], -1894007588, this, 12, n110);
        int n112 = n(i140, 10);
        int i142 = i119;
        int i143 = i142;
        int i144 = d113;
        int d114 = lf.d(q(i142, i115, n96) + n78, iArr[8], 2053994217, this, 15, n95);
        int n113 = n(i115, 10);
        int i145 = d114;
        int d115 = lf.d(q(d114, i143, n113) + n95, iArr[6], 2053994217, this, 5, n96);
        int n114 = n(i143, 10);
        int i146 = d115;
        int d116 = lf.d(q(d115, i145, n114) + n96, iArr[4], 2053994217, this, 8, n113);
        int n115 = n(i145, 10);
        int i147 = d116;
        int d117 = lf.d(q(d116, i146, n115) + n113, iArr[1], 2053994217, this, 11, n114);
        int n116 = n(i146, 10);
        int i148 = d117;
        int d118 = lf.d(q(d117, i147, n116) + n114, iArr[3], 2053994217, this, 14, n115);
        int n117 = n(i147, 10);
        int i149 = d118;
        int d119 = lf.d(q(d118, i148, n117) + n115, iArr[11], 2053994217, this, 14, n116);
        int n118 = n(i148, 10);
        int i150 = d119;
        int d120 = lf.d(q(d119, i149, n118) + n116, iArr[15], 2053994217, this, 6, n117);
        int n119 = n(i149, 10);
        int i151 = d120;
        int d121 = lf.d(q(d120, i150, n119) + n117, iArr[0], 2053994217, this, 14, n118);
        int n120 = n(i150, 10);
        int i152 = d121;
        int d122 = lf.d(q(d121, i151, n120) + n118, iArr[5], 2053994217, this, 6, n119);
        int n121 = n(i151, 10);
        int i153 = d122;
        int d123 = lf.d(q(d122, i152, n121) + n119, iArr[12], 2053994217, this, 9, n120);
        int n122 = n(i152, 10);
        int i154 = d123;
        int d124 = lf.d(q(d123, i153, n122) + n120, iArr[2], 2053994217, this, 12, n121);
        int n123 = n(i153, 10);
        int i155 = d124;
        int d125 = lf.d(q(d124, i154, n123) + n121, iArr[13], 2053994217, this, 9, n122);
        int n124 = n(i154, 10);
        int i156 = d125;
        int d126 = lf.d(q(d125, i155, n124) + n122, iArr[9], 2053994217, this, 12, n123);
        int n125 = n(i155, 10);
        int i157 = d126;
        int d127 = lf.d(q(d126, i156, n125) + n123, iArr[7], 2053994217, this, 5, n124);
        int n126 = n(i156, 10);
        int i158 = d127;
        int d128 = lf.d(q(d127, i157, n126) + n124, iArr[10], 2053994217, this, 15, n125);
        int n127 = n(i157, 10);
        int i159 = d128;
        int d129 = lf.d(q(d128, i158, n127) + n125, iArr[14], 2053994217, this, 8, n126);
        int n128 = n(i158, 10);
        int i160 = i144;
        int i161 = i160;
        int i162 = d129;
        int d130 = lf.d(t(i160, i159, n112) + n110, iArr[4], -1454113458, this, 9, n111);
        int n129 = n(i159, 10);
        int i163 = d130;
        int d131 = lf.d(t(d130, i161, n129) + n111, iArr[0], -1454113458, this, 15, n112);
        int n130 = n(i161, 10);
        int i164 = d131;
        int d132 = lf.d(t(d131, i163, n130) + n112, iArr[5], -1454113458, this, 5, n129);
        int n131 = n(i163, 10);
        int i165 = d132;
        int d133 = lf.d(t(d132, i164, n131) + n129, iArr[9], -1454113458, this, 11, n130);
        int n132 = n(i164, 10);
        int i166 = d133;
        int d134 = lf.d(t(d133, i165, n132) + n130, iArr[7], -1454113458, this, 6, n131);
        int n133 = n(i165, 10);
        int i167 = d134;
        int d135 = lf.d(t(d134, i166, n133) + n131, iArr[12], -1454113458, this, 8, n132);
        int n134 = n(i166, 10);
        int i168 = d135;
        int d136 = lf.d(t(d135, i167, n134) + n132, iArr[2], -1454113458, this, 13, n133);
        int n135 = n(i167, 10);
        int i169 = d136;
        int d137 = lf.d(t(d136, i168, n135) + n133, iArr[10], -1454113458, this, 12, n134);
        int n136 = n(i168, 10);
        int i170 = d137;
        int d138 = lf.d(t(d137, i169, n136) + n134, iArr[14], -1454113458, this, 5, n135);
        int n137 = n(i169, 10);
        int i171 = d138;
        int d139 = lf.d(t(d138, i170, n137) + n135, iArr[1], -1454113458, this, 12, n136);
        int n138 = n(i170, 10);
        int i172 = d139;
        int d140 = lf.d(t(d139, i171, n138) + n136, iArr[3], -1454113458, this, 13, n137);
        int n139 = n(i171, 10);
        int i173 = d140;
        int d141 = lf.d(t(d140, i172, n139) + n137, iArr[8], -1454113458, this, 14, n138);
        int n140 = n(i172, 10);
        int i174 = d141;
        int d142 = lf.d(t(d141, i173, n140) + n138, iArr[11], -1454113458, this, 11, n139);
        int n141 = n(i173, 10);
        int i175 = d142;
        int d143 = lf.d(t(d142, i174, n141) + n139, iArr[6], -1454113458, this, 8, n140);
        int n142 = n(i174, 10);
        int i176 = d143;
        int d144 = lf.d(t(d143, i175, n142) + n140, iArr[15], -1454113458, this, 5, n141);
        int n143 = n(i175, 10);
        int i177 = d144;
        int d145 = lf.d(t(d144, i176, n143) + n141, iArr[13], -1454113458, this, 6, n142);
        int n144 = n(i176, 10);
        int i178 = i141;
        int i179 = i162;
        int d146 = C0709Uj.d(p(i179, i178, n128) + n126, iArr[12], this, 8, n127);
        int n145 = n(i178, 10);
        int d147 = C0709Uj.d(p(d146, i179, n145) + n127, iArr[15], this, 5, n128);
        int n146 = n(i179, 10);
        int d148 = C0709Uj.d(p(d147, d146, n146) + n128, iArr[10], this, 12, n145);
        int n147 = n(d146, 10);
        int d149 = C0709Uj.d(p(d148, d147, n147) + n145, iArr[4], this, 9, n146);
        int n148 = n(d147, 10);
        int d150 = C0709Uj.d(p(d149, d148, n148) + n146, iArr[1], this, 12, n147);
        int n149 = n(d148, 10);
        int d151 = C0709Uj.d(p(d150, d149, n149) + n147, iArr[5], this, 5, n148);
        int n150 = n(d149, 10);
        int d152 = C0709Uj.d(p(d151, d150, n150) + n148, iArr[8], this, 14, n149);
        int n151 = n(d150, 10);
        int d153 = C0709Uj.d(p(d152, d151, n151) + n149, iArr[7], this, 6, n150);
        int n152 = n(d151, 10);
        int d154 = C0709Uj.d(p(d153, d152, n152) + n150, iArr[6], this, 8, n151);
        int n153 = n(d152, 10);
        int d155 = C0709Uj.d(p(d154, d153, n153) + n151, iArr[2], this, 13, n152);
        int n154 = n(d153, 10);
        int d156 = C0709Uj.d(p(d155, d154, n154) + n152, iArr[13], this, 6, n153);
        int n155 = n(d154, 10);
        int d157 = C0709Uj.d(p(d156, d155, n155) + n153, iArr[14], this, 5, n154);
        int n156 = n(d155, 10);
        int d158 = C0709Uj.d(p(d157, d156, n156) + n154, iArr[0], this, 15, n155);
        int n157 = n(d156, 10);
        int d159 = C0709Uj.d(p(d158, d157, n157) + n155, iArr[3], this, 13, n156);
        int n158 = n(d157, 10);
        int d160 = C0709Uj.d(p(d159, d158, n158) + n156, iArr[9], this, 11, n157);
        int n159 = n(d158, 10);
        int d161 = C0709Uj.d(p(d160, d159, n159) + n157, iArr[11], this, 11, n158);
        int n160 = n(d159, 10);
        this.b += n142;
        this.c += d145;
        this.d += i177;
        this.e += n144;
        this.f += n159;
        this.g += n158;
        this.h += d161;
        this.i += d160;
        this.j += n160;
        this.k += n143;
        this.l = 0;
        for (int i180 = 0; i180 != iArr.length; i180++) {
            iArr[i180] = 0;
        }
    }

    public final void l(long j2) {
        if (this.l > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (-1 & j2);
        iArr[15] = (int) (j2 >>> 32);
    }

    public final void m(int i2, byte[] bArr) {
        int i3 = this.l;
        int i4 = i3 + 1;
        this.l = i4;
        int i5 = (bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        this.a[i3] = i5 | (bArr[i2] & UnsignedBytes.MAX_VALUE) | ((bArr[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        if (i4 == 16) {
            k();
        }
    }

    public final int n(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void o(RIPEMD320Digest rIPEMD320Digest) {
        i(rIPEMD320Digest);
        this.b = rIPEMD320Digest.b;
        this.c = rIPEMD320Digest.c;
        this.d = rIPEMD320Digest.d;
        this.e = rIPEMD320Digest.e;
        this.f = rIPEMD320Digest.f;
        this.g = rIPEMD320Digest.g;
        this.h = rIPEMD320Digest.h;
        this.i = rIPEMD320Digest.i;
        this.j = rIPEMD320Digest.j;
        this.k = rIPEMD320Digest.k;
        int[] iArr = this.a;
        int[] iArr2 = rIPEMD320Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.l = rIPEMD320Digest.l;
    }

    public final int p(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    public final int q(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public final int r(int i2, int i3, int i4) {
        return (i2 | (~i3)) ^ i4;
    }

    public final void reset() {
        super.reset();
        this.b = 1732584193;
        this.c = -271733879;
        this.d = -1732584194;
        this.e = 271733878;
        this.f = -1009589776;
        this.g = 1985229328;
        this.h = -19088744;
        this.i = -1985229329;
        this.j = 19088743;
        this.k = 1009589775;
        this.l = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public final int s(int i2, int i3, int i4) {
        return (i2 & i4) | (i3 & (~i4));
    }

    public final int t(int i2, int i3, int i4) {
        return i2 ^ (i3 | (~i4));
    }

    public final void u(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    public RIPEMD320Digest(RIPEMD320Digest rIPEMD320Digest) {
        super(rIPEMD320Digest);
        o(rIPEMD320Digest);
    }
}
