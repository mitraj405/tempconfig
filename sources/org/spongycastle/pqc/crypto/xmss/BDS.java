package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import org.spongycastle.pqc.crypto.xmss.HashTreeAddress;
import org.spongycastle.pqc.crypto.xmss.LTreeAddress;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;

public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    public final ArrayList a;

    /* renamed from: a  reason: collision with other field name */
    public final List<BDSTreeHash> f6749a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<Integer, LinkedList<XMSSNode>> f6750a;

    /* renamed from: a  reason: collision with other field name */
    public final Stack<XMSSNode> f6751a;

    /* renamed from: a  reason: collision with other field name */
    public final TreeMap f6752a;

    /* renamed from: a  reason: collision with other field name */
    public transient WOTSPlus f6753a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSNode f6754a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6755a;
    public final int c;
    public final int d;
    public int e;

    public BDS(WOTSPlus wOTSPlus, int i, int i2) {
        this.f6753a = wOTSPlus;
        this.c = i;
        this.d = i2;
        if (i2 <= i && i2 >= 2) {
            int i3 = i - i2;
            if (i3 % 2 == 0) {
                this.a = new ArrayList();
                this.f6750a = new TreeMap();
                this.f6751a = new Stack<>();
                this.f6749a = new ArrayList();
                for (int i4 = 0; i4 < i3; i4++) {
                    this.f6749a.add(new BDSTreeHash(i4));
                }
                this.f6752a = new TreeMap();
                this.e = 0;
                this.f6755a = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((XMSSNode) it.next()).clone());
        }
        return arrayList;
    }

    public final void b(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        int i;
        OTSHashAddress oTSHashAddress2;
        OTSHashAddress oTSHashAddress3 = oTSHashAddress;
        LTreeAddress.Builder builder = new LTreeAddress.Builder();
        int i2 = oTSHashAddress3.a;
        long j = oTSHashAddress3.f6765a;
        LTreeAddress.Builder builder2 = (LTreeAddress.Builder) ((LTreeAddress.Builder) builder.c(i2)).d(j);
        builder2.getClass();
        LTreeAddress lTreeAddress = new LTreeAddress(builder2);
        HashTreeAddress.Builder builder3 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i2)).d(j);
        builder3.getClass();
        HashTreeAddress hashTreeAddress = new HashTreeAddress(builder3);
        int i3 = 0;
        while (true) {
            int i4 = this.c;
            int i5 = 1 << i4;
            Stack<XMSSNode> stack = this.f6751a;
            if (i3 < i5) {
                OTSHashAddress.Builder builder4 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress3.a)).d(oTSHashAddress3.f6765a);
                builder4.d = i3;
                builder4.e = oTSHashAddress3.e;
                builder4.f = oTSHashAddress3.f;
                OTSHashAddress.Builder builder5 = (OTSHashAddress.Builder) builder4.b(oTSHashAddress3.c);
                builder5.getClass();
                OTSHashAddress oTSHashAddress4 = new OTSHashAddress(builder5);
                WOTSPlus wOTSPlus = this.f6753a;
                wOTSPlus.f(wOTSPlus.e(bArr2, oTSHashAddress4), bArr);
                WOTSPlusPublicKeyParameters d2 = this.f6753a.d(oTSHashAddress4);
                LTreeAddress.Builder builder6 = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(lTreeAddress.a)).d(lTreeAddress.f6765a);
                builder6.d = i3;
                builder6.e = lTreeAddress.e;
                builder6.f = lTreeAddress.f;
                LTreeAddress.Builder builder7 = (LTreeAddress.Builder) builder6.b(lTreeAddress.c);
                builder7.getClass();
                LTreeAddress lTreeAddress2 = new LTreeAddress(builder7);
                XMSSNode a2 = XMSSNodeUtil.a(this.f6753a, d2, lTreeAddress2);
                HashTreeAddress.Builder builder8 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress.a)).d(hashTreeAddress.f6765a);
                builder8.e = i3;
                HashTreeAddress.Builder builder9 = (HashTreeAddress.Builder) builder8.b(hashTreeAddress.c);
                builder9.getClass();
                hashTreeAddress = new HashTreeAddress(builder9);
                while (!stack.isEmpty() && stack.peek().c == (i = a2.c)) {
                    int floor = (int) Math.floor((double) (i3 / (1 << i)));
                    if (floor == 1) {
                        this.a.add(a2.clone());
                    }
                    int i6 = this.d;
                    int i7 = a2.c;
                    if (floor != 3 || i7 >= i4 - i6) {
                        oTSHashAddress2 = oTSHashAddress4;
                    } else {
                        BDSTreeHash bDSTreeHash = this.f6749a.get(i7);
                        XMSSNode a3 = a2.clone();
                        bDSTreeHash.a = a3;
                        int i8 = a3.c;
                        bDSTreeHash.d = i8;
                        oTSHashAddress2 = oTSHashAddress4;
                        if (i8 == bDSTreeHash.c) {
                            bDSTreeHash.b = true;
                        }
                    }
                    if (floor >= 3 && (floor & 1) == 1 && i7 >= i4 - i6 && i7 <= i4 - 2) {
                        Integer valueOf = Integer.valueOf(i7);
                        Map<Integer, LinkedList<XMSSNode>> map = this.f6750a;
                        if (map.get(valueOf) == null) {
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(a2.clone());
                            map.put(Integer.valueOf(i7), linkedList);
                        } else {
                            map.get(Integer.valueOf(i7)).add(a2.clone());
                        }
                    }
                    HashTreeAddress.Builder builder10 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress.a)).d(hashTreeAddress.f6765a);
                    builder10.d = hashTreeAddress.d;
                    builder10.e = (hashTreeAddress.e - 1) / 2;
                    HashTreeAddress.Builder builder11 = (HashTreeAddress.Builder) builder10.b(hashTreeAddress.c);
                    builder11.getClass();
                    HashTreeAddress hashTreeAddress2 = new HashTreeAddress(builder11);
                    XMSSNode b = XMSSNodeUtil.b(this.f6753a, stack.pop(), a2, hashTreeAddress2);
                    XMSSNode xMSSNode = new XMSSNode(b.c + 1, b.b());
                    HashTreeAddress.Builder builder12 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress2.a)).d(hashTreeAddress2.f6765a);
                    builder12.d = hashTreeAddress2.d + 1;
                    builder12.e = hashTreeAddress2.e;
                    HashTreeAddress.Builder builder13 = (HashTreeAddress.Builder) builder12.b(hashTreeAddress2.c);
                    builder13.getClass();
                    HashTreeAddress hashTreeAddress3 = new HashTreeAddress(builder13);
                    a2 = xMSSNode;
                    hashTreeAddress = hashTreeAddress3;
                    oTSHashAddress4 = oTSHashAddress2;
                }
                stack.push(a2);
                i3++;
                lTreeAddress = lTreeAddress2;
                oTSHashAddress3 = oTSHashAddress4;
            } else {
                this.f6754a = stack.pop();
                return;
            }
        }
    }

    public final void c(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        int i;
        List<BDSTreeHash> list;
        OTSHashAddress oTSHashAddress2;
        Stack<XMSSNode> stack;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        OTSHashAddress oTSHashAddress3 = oTSHashAddress;
        if (!this.f6755a) {
            int i7 = this.e;
            int i8 = this.c;
            int i9 = 1 << i8;
            if (i7 <= i9 - 2) {
                LTreeAddress.Builder builder = new LTreeAddress.Builder();
                int i10 = oTSHashAddress3.a;
                long j2 = oTSHashAddress3.f6765a;
                LTreeAddress.Builder builder2 = (LTreeAddress.Builder) ((LTreeAddress.Builder) builder.c(i10)).d(j2);
                builder2.getClass();
                LTreeAddress lTreeAddress = new LTreeAddress(builder2);
                HashTreeAddress.Builder builder3 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i10)).d(j2);
                builder3.getClass();
                HashTreeAddress hashTreeAddress = new HashTreeAddress(builder3);
                int i11 = this.e;
                int i12 = 0;
                while (true) {
                    if (i12 >= i8) {
                        i12 = 0;
                        break;
                    } else if (((i11 >> i12) & 1) == 0) {
                        break;
                    } else {
                        i12++;
                    }
                }
                int i13 = (this.e >> (i12 + 1)) & 1;
                TreeMap treeMap = this.f6752a;
                ArrayList arrayList = this.a;
                if (i13 == 0 && i12 < i8 - 1) {
                    treeMap.put(Integer.valueOf(i12), ((XMSSNode) arrayList.get(i12)).clone());
                }
                List<BDSTreeHash> list2 = this.f6749a;
                int i14 = this.d;
                if (i12 == 0) {
                    OTSHashAddress.Builder builder4 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(i10)).d(j2);
                    builder4.d = this.e;
                    builder4.e = oTSHashAddress3.e;
                    builder4.f = oTSHashAddress3.f;
                    OTSHashAddress.Builder builder5 = (OTSHashAddress.Builder) builder4.b(oTSHashAddress3.c);
                    builder5.getClass();
                    OTSHashAddress oTSHashAddress4 = new OTSHashAddress(builder5);
                    WOTSPlus wOTSPlus = this.f6753a;
                    wOTSPlus.f(wOTSPlus.e(bArr4, oTSHashAddress4), bArr3);
                    WOTSPlusPublicKeyParameters d2 = this.f6753a.d(oTSHashAddress4);
                    LTreeAddress.Builder builder6 = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(lTreeAddress.a)).d(lTreeAddress.f6765a);
                    builder6.d = this.e;
                    builder6.e = lTreeAddress.e;
                    builder6.f = lTreeAddress.f;
                    LTreeAddress.Builder builder7 = (LTreeAddress.Builder) builder6.b(lTreeAddress.c);
                    builder7.getClass();
                    arrayList.set(0, XMSSNodeUtil.a(this.f6753a, d2, new LTreeAddress(builder7)));
                    oTSHashAddress3 = oTSHashAddress4;
                } else {
                    HashTreeAddress.Builder builder8 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress.a)).d(hashTreeAddress.f6765a);
                    int i15 = i12 - 1;
                    builder8.d = i15;
                    builder8.e = this.e >> i12;
                    HashTreeAddress.Builder builder9 = (HashTreeAddress.Builder) builder8.b(hashTreeAddress.c);
                    builder9.getClass();
                    XMSSNode b = XMSSNodeUtil.b(this.f6753a, (XMSSNode) arrayList.get(i15), (XMSSNode) treeMap.get(Integer.valueOf(i15)), new HashTreeAddress(builder9));
                    arrayList.set(i12, new XMSSNode(b.c + 1, b.b()));
                    treeMap.remove(Integer.valueOf(i15));
                    for (int i16 = 0; i16 < i12; i16++) {
                        if (i16 < i8 - i14) {
                            arrayList.set(i16, list2.get(i16).a.clone());
                        } else {
                            arrayList.set(i16, this.f6750a.get(Integer.valueOf(i16)).removeFirst());
                        }
                    }
                    int min = Math.min(i12, i8 - i14);
                    for (int i17 = 0; i17 < min; i17++) {
                        int i18 = ((1 << i17) * 3) + this.e + 1;
                        if (i18 < i9) {
                            BDSTreeHash bDSTreeHash = list2.get(i17);
                            bDSTreeHash.a = null;
                            bDSTreeHash.d = bDSTreeHash.c;
                            bDSTreeHash.e = i18;
                            bDSTreeHash.f6756a = true;
                            bDSTreeHash.b = false;
                        }
                    }
                }
                int i19 = 0;
                for (int i20 = 1; i19 < ((i8 - i14) >> i20); i20 = 1) {
                    BDSTreeHash bDSTreeHash2 = null;
                    for (BDSTreeHash next : list2) {
                        if (!next.b && next.f6756a) {
                            if (bDSTreeHash2 == null || next.a() < bDSTreeHash2.a() || (next.a() == bDSTreeHash2.a() && next.e < bDSTreeHash2.e)) {
                                bDSTreeHash2 = next;
                            }
                        }
                    }
                    if (bDSTreeHash2 != null) {
                        WOTSPlus wOTSPlus2 = this.f6753a;
                        if (bDSTreeHash2.b || !bDSTreeHash2.f6756a) {
                            throw new IllegalStateException("finished or not initialized");
                        }
                        OTSHashAddress.Builder builder10 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress3.a)).d(oTSHashAddress3.f6765a);
                        builder10.d = bDSTreeHash2.e;
                        builder10.e = oTSHashAddress3.e;
                        builder10.f = oTSHashAddress3.f;
                        OTSHashAddress.Builder builder11 = (OTSHashAddress.Builder) builder10.b(oTSHashAddress3.c);
                        builder11.getClass();
                        OTSHashAddress oTSHashAddress5 = new OTSHashAddress(builder11);
                        long j3 = oTSHashAddress5.f6765a;
                        LTreeAddress.Builder builder12 = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(oTSHashAddress5.a)).d(j3);
                        builder12.d = bDSTreeHash2.e;
                        LTreeAddress lTreeAddress2 = new LTreeAddress(builder12);
                        HashTreeAddress.Builder builder13 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(oTSHashAddress5.a)).d(j3);
                        builder13.e = bDSTreeHash2.e;
                        HashTreeAddress hashTreeAddress2 = new HashTreeAddress(builder13);
                        wOTSPlus2.f(wOTSPlus2.e(bArr4, oTSHashAddress5), bArr3);
                        XMSSNode a2 = XMSSNodeUtil.a(wOTSPlus2, wOTSPlus2.d(oTSHashAddress5), lTreeAddress2);
                        while (true) {
                            stack = this.f6751a;
                            boolean isEmpty = stack.isEmpty();
                            i2 = bDSTreeHash2.c;
                            i3 = hashTreeAddress2.a;
                            i4 = hashTreeAddress2.c;
                            i5 = hashTreeAddress2.e;
                            oTSHashAddress2 = oTSHashAddress3;
                            i6 = hashTreeAddress2.d;
                            list = list2;
                            j = hashTreeAddress2.f6765a;
                            if (isEmpty) {
                                i = i14;
                                break;
                            }
                            i = i14;
                            if (stack.peek().c != a2.c || stack.peek().c == i2) {
                                break;
                            }
                            HashTreeAddress.Builder builder14 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i3)).d(j);
                            builder14.d = i6;
                            builder14.e = (i5 - 1) / 2;
                            HashTreeAddress.Builder builder15 = (HashTreeAddress.Builder) builder14.b(i4);
                            builder15.getClass();
                            HashTreeAddress hashTreeAddress3 = new HashTreeAddress(builder15);
                            XMSSNode b2 = XMSSNodeUtil.b(wOTSPlus2, stack.pop(), a2, hashTreeAddress3);
                            a2 = new XMSSNode(b2.c + 1, b2.b());
                            HashTreeAddress.Builder builder16 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress3.a)).d(hashTreeAddress3.f6765a);
                            builder16.d = hashTreeAddress3.d + 1;
                            builder16.e = hashTreeAddress3.e;
                            HashTreeAddress.Builder builder17 = (HashTreeAddress.Builder) builder16.b(hashTreeAddress3.c);
                            builder17.getClass();
                            hashTreeAddress2 = new HashTreeAddress(builder17);
                            byte[] bArr5 = bArr;
                            byte[] bArr6 = bArr2;
                            oTSHashAddress3 = oTSHashAddress2;
                            list2 = list;
                            i14 = i;
                        }
                        XMSSNode xMSSNode = bDSTreeHash2.a;
                        if (xMSSNode == null) {
                            bDSTreeHash2.a = a2;
                        } else {
                            if (xMSSNode.c == a2.c) {
                                HashTreeAddress.Builder builder18 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i3)).d(j);
                                builder18.d = i6;
                                builder18.e = (i5 - 1) / 2;
                                HashTreeAddress.Builder builder19 = (HashTreeAddress.Builder) builder18.b(i4);
                                builder19.getClass();
                                HashTreeAddress hashTreeAddress4 = new HashTreeAddress(builder19);
                                a2 = new XMSSNode(bDSTreeHash2.a.c + 1, XMSSNodeUtil.b(wOTSPlus2, bDSTreeHash2.a, a2, hashTreeAddress4).b());
                                bDSTreeHash2.a = a2;
                                HashTreeAddress.Builder builder20 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress4.a)).d(hashTreeAddress4.f6765a);
                                builder20.d = hashTreeAddress4.d + 1;
                                builder20.e = hashTreeAddress4.e;
                                ((HashTreeAddress.Builder) builder20.b(hashTreeAddress4.c)).e();
                            } else {
                                stack.push(a2);
                            }
                        }
                        if (bDSTreeHash2.a.c == i2) {
                            bDSTreeHash2.b = true;
                        } else {
                            bDSTreeHash2.d = a2.c;
                            bDSTreeHash2.e++;
                        }
                    } else {
                        oTSHashAddress2 = oTSHashAddress3;
                        i = i14;
                        list = list2;
                    }
                    i19++;
                    bArr3 = bArr;
                    bArr4 = bArr2;
                    oTSHashAddress3 = oTSHashAddress2;
                    list2 = list;
                    i14 = i;
                }
                this.e++;
                return;
            }
            throw new IllegalStateException("index out of bounds");
        }
        throw new IllegalStateException("index already used");
    }

    public BDS(XMSSParameters xMSSParameters, int i) {
        this(xMSSParameters.f6789a, xMSSParameters.a, xMSSParameters.b);
        this.e = i;
        this.f6755a = true;
    }

    public BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this(xMSSParameters.f6789a, xMSSParameters.a, xMSSParameters.b);
        b(bArr, bArr2, oTSHashAddress);
    }

    public BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress, int i) {
        this(xMSSParameters.f6789a, xMSSParameters.a, xMSSParameters.b);
        b(bArr, bArr2, oTSHashAddress);
        while (this.e < i) {
            c(bArr, bArr2, oTSHashAddress);
            this.f6755a = false;
        }
    }

    public BDS(BDS bds, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this.f6753a = bds.f6753a;
        this.c = bds.c;
        this.d = bds.d;
        this.f6754a = bds.f6754a;
        this.a = new ArrayList(bds.a);
        this.f6750a = bds.f6750a;
        this.f6751a = (Stack) bds.f6751a.clone();
        this.f6749a = bds.f6749a;
        this.f6752a = new TreeMap(bds.f6752a);
        this.e = bds.e;
        c(bArr, bArr2, oTSHashAddress);
        bds.f6755a = true;
    }
}
