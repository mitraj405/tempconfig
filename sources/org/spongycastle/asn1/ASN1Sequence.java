package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public Vector a;

    /* renamed from: org.spongycastle.asn1.ASN1Sequence$1  reason: invalid class name */
    class AnonymousClass1 implements ASN1SequenceParser {
        public final ASN1Primitive a() {
            return null;
        }

        public final ASN1Primitive b() {
            return null;
        }
    }

    public ASN1Sequence() {
        this.a = new Vector();
    }

    public static ASN1Sequence q(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof ASN1SequenceParser) {
            return q(((ASN1SequenceParser) obj).b());
        }
        if (obj instanceof byte[]) {
            try {
                return q(ASN1Primitive.k((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct sequence from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive b = ((ASN1Encodable) obj).b();
                if (b instanceof ASN1Sequence) {
                    return (ASN1Sequence) b;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public static ASN1Sequence r(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.f5664a) {
                ASN1Primitive r = aSN1TaggedObject.r();
                r.getClass();
                return q(r);
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.f5664a) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSequence(aSN1TaggedObject.r());
            }
            return new DLSequence(aSN1TaggedObject.r());
        } else if (aSN1TaggedObject.r() instanceof ASN1Sequence) {
            return (ASN1Sequence) aSN1TaggedObject.r();
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(aSN1TaggedObject.getClass().getName()));
        }
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Primitive;
        if (size() != aSN1Sequence.size()) {
            return false;
        }
        Enumeration t = t();
        Enumeration t2 = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            ASN1Primitive b = ((ASN1Encodable) t.nextElement()).b();
            ASN1Primitive b2 = ((ASN1Encodable) t2.nextElement()).b();
            if (b != b2 && !b.equals(b2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Enumeration t = t();
        int size = size();
        while (t.hasMoreElements()) {
            size = (size * 17) ^ ((ASN1Encodable) t.nextElement()).hashCode();
        }
        return size;
    }

    public final Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(u());
    }

    public final boolean n() {
        return true;
    }

    public ASN1Primitive o() {
        DERSequence dERSequence = new DERSequence();
        dERSequence.a = this.a;
        return dERSequence;
    }

    public ASN1Primitive p() {
        DLSequence dLSequence = new DLSequence();
        dLSequence.a = this.a;
        return dLSequence;
    }

    public ASN1Encodable s(int i) {
        return (ASN1Encodable) this.a.elementAt(i);
    }

    public int size() {
        return this.a.size();
    }

    public Enumeration t() {
        return this.a.elements();
    }

    public final String toString() {
        return this.a.toString();
    }

    public final ASN1Encodable[] u() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = s(i);
        }
        return aSN1EncodableArr;
    }

    public ASN1Sequence(ASN1Primitive aSN1Primitive) {
        Vector vector = new Vector();
        this.a = vector;
        vector.addElement(aSN1Primitive);
    }

    public ASN1Sequence(ASN1EncodableVector aSN1EncodableVector) {
        this.a = new Vector();
        for (int i = 0; i != aSN1EncodableVector.c(); i++) {
            this.a.addElement(aSN1EncodableVector.b(i));
        }
    }

    public ASN1Sequence(ASN1Encodable[] aSN1EncodableArr) {
        this.a = new Vector();
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.a.addElement(aSN1EncodableArr[i]);
        }
    }
}
