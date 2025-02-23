package org.xmlpull.v1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    static final Class referenceContextClass = XmlPullParserFactory.class;
    protected String classNamesLocation;
    protected Hashtable features = new Hashtable();
    protected Vector parserClasses;
    protected Vector serializerClasses;

    static {
        new XmlPullParserFactory();
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance((String) null, (Class) null);
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector vector = this.parserClasses;
        if (vector == null) {
            throw new XmlPullParserException("Factory initialization was incomplete - has not tried " + this.classNamesLocation);
        } else if (vector.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (i < this.parserClasses.size()) {
                Class cls = (Class) this.parserClasses.elementAt(i);
                try {
                    XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                    Enumeration keys = this.features.keys();
                    while (keys.hasMoreElements()) {
                        String str = (String) keys.nextElement();
                        Boolean bool = (Boolean) this.features.get(str);
                        if (bool != null && bool.booleanValue()) {
                            xmlPullParser.setFeature(str, true);
                        }
                    }
                    return xmlPullParser;
                } catch (Exception e) {
                    stringBuffer.append(cls.getName() + ": " + e.toString() + "; ");
                    i++;
                }
            }
            throw new XmlPullParserException("could not create parser: " + stringBuffer);
        } else {
            throw new XmlPullParserException("No valid parser classes found in " + this.classNamesLocation);
        }
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector vector = this.serializerClasses;
        if (vector == null) {
            throw new XmlPullParserException("Factory initialization incomplete - has not tried " + this.classNamesLocation);
        } else if (vector.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (i < this.serializerClasses.size()) {
                Class cls = (Class) this.serializerClasses.elementAt(i);
                try {
                    return (XmlSerializer) cls.newInstance();
                } catch (Exception e) {
                    stringBuffer.append(cls.getName() + ": " + e.toString() + "; ");
                    i++;
                }
            }
            throw new XmlPullParserException("could not create serializer: " + stringBuffer);
        } else {
            throw new XmlPullParserException("No valid serializer classes found in " + this.classNamesLocation);
        }
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.features.put(str, new Boolean(z));
    }

    public void setNamespaceAware(boolean z) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z));
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x009d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.xmlpull.v1.XmlPullParserFactory newInstance(java.lang.String r12, java.lang.Class r13) throws org.xmlpull.v1.XmlPullParserException {
        /*
            if (r13 != 0) goto L_0x0004
            java.lang.Class r13 = referenceContextClass
        L_0x0004:
            java.lang.String r0 = "'"
            r1 = 0
            if (r12 == 0) goto L_0x001f
            int r2 = r12.length()
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = "DEFAULT"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0018
            goto L_0x001f
        L_0x0018:
            java.lang.String r13 = "parameter classNames to newInstance() that contained '"
            java.lang.String r13 = defpackage.lf.j(r13, r12, r0)
            goto L_0x003f
        L_0x001f:
            java.lang.String r12 = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory"
            java.io.InputStream r12 = r13.getResourceAsStream(r12)     // Catch:{ Exception -> 0x00c0 }
            if (r12 == 0) goto L_0x00b8
            java.lang.StringBuffer r13 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00c0 }
            r13.<init>()     // Catch:{ Exception -> 0x00c0 }
        L_0x002c:
            int r2 = r12.read()     // Catch:{ Exception -> 0x00c0 }
            if (r2 >= 0) goto L_0x00ae
            r12.close()     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r13 = "resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '"
            java.lang.String r13 = defpackage.lf.j(r13, r12, r0)
        L_0x003f:
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            java.util.Vector r2 = new java.util.Vector
            r2.<init>()
            r3 = 0
            r5 = r1
            r4 = r3
        L_0x004c:
            int r6 = r12.length()
            if (r4 >= r6) goto L_0x00a0
            r6 = 44
            int r6 = r12.indexOf(r6, r4)
            r7 = -1
            if (r6 != r7) goto L_0x005f
            int r6 = r12.length()
        L_0x005f:
            java.lang.String r4 = r12.substring(r4, r6)
            java.lang.Class r7 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x006c }
            java.lang.Object r8 = r7.newInstance()     // Catch:{ Exception -> 0x006d }
            goto L_0x006e
        L_0x006c:
            r7 = r1
        L_0x006d:
            r8 = r1
        L_0x006e:
            if (r7 == 0) goto L_0x009d
            boolean r9 = r8 instanceof org.xmlpull.v1.XmlPullParser
            r10 = 1
            if (r9 == 0) goto L_0x007a
            r0.addElement(r7)
            r9 = r10
            goto L_0x007b
        L_0x007a:
            r9 = r3
        L_0x007b:
            boolean r11 = r8 instanceof org.xmlpull.v1.XmlSerializer
            if (r11 == 0) goto L_0x0083
            r2.addElement(r7)
            r9 = r10
        L_0x0083:
            boolean r7 = r8 instanceof org.xmlpull.v1.XmlPullParserFactory
            if (r7 == 0) goto L_0x008d
            if (r5 != 0) goto L_0x008e
            r5 = r8
            org.xmlpull.v1.XmlPullParserFactory r5 = (org.xmlpull.v1.XmlPullParserFactory) r5
            goto L_0x008e
        L_0x008d:
            r10 = r9
        L_0x008e:
            if (r10 == 0) goto L_0x0091
            goto L_0x009d
        L_0x0091:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r13 = "incompatible class: "
            java.lang.String r13 = defpackage.C0709Uj.i(r13, r4)
            r12.<init>(r13)
            throw r12
        L_0x009d:
            int r4 = r6 + 1
            goto L_0x004c
        L_0x00a0:
            if (r5 != 0) goto L_0x00a7
            org.xmlpull.v1.XmlPullParserFactory r5 = new org.xmlpull.v1.XmlPullParserFactory
            r5.<init>()
        L_0x00a7:
            r5.parserClasses = r0
            r5.serializerClasses = r2
            r5.classNamesLocation = r13
            return r5
        L_0x00ae:
            r3 = 32
            if (r2 <= r3) goto L_0x002c
            char r2 = (char) r2
            r13.append(r2)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x002c
        L_0x00b8:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r13 = "resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available"
            r12.<init>(r13)     // Catch:{ Exception -> 0x00c0 }
            throw r12     // Catch:{ Exception -> 0x00c0 }
        L_0x00c0:
            r12 = move-exception
            org.xmlpull.v1.XmlPullParserException r13 = new org.xmlpull.v1.XmlPullParserException
            r13.<init>(r1, r1, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserFactory.newInstance(java.lang.String, java.lang.Class):org.xmlpull.v1.XmlPullParserFactory");
    }
}
