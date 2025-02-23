package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: Reader */
public interface G {
    <K, V> void a(Map<K, V> map, w.a<K, V> aVar, C0132i iVar) throws IOException;

    x3 b() throws IOException;

    @Deprecated
    <T> T c(kv<T> kvVar, C0132i iVar) throws IOException;

    <T> void d(List<T> list, kv<T> kvVar, C0132i iVar) throws IOException;

    <T> T e(kv<T> kvVar, C0132i iVar) throws IOException;

    @Deprecated
    <T> void f(List<T> list, kv<T> kvVar, C0132i iVar) throws IOException;

    int getFieldNumber() throws IOException;

    int getTag();

    boolean readBool() throws IOException;

    void readBoolList(List<Boolean> list) throws IOException;

    void readBytesList(List<x3> list) throws IOException;

    double readDouble() throws IOException;

    void readDoubleList(List<Double> list) throws IOException;

    int readEnum() throws IOException;

    void readEnumList(List<Integer> list) throws IOException;

    int readFixed32() throws IOException;

    void readFixed32List(List<Integer> list) throws IOException;

    long readFixed64() throws IOException;

    void readFixed64List(List<Long> list) throws IOException;

    float readFloat() throws IOException;

    void readFloatList(List<Float> list) throws IOException;

    int readInt32() throws IOException;

    void readInt32List(List<Integer> list) throws IOException;

    long readInt64() throws IOException;

    void readInt64List(List<Long> list) throws IOException;

    int readSFixed32() throws IOException;

    void readSFixed32List(List<Integer> list) throws IOException;

    long readSFixed64() throws IOException;

    void readSFixed64List(List<Long> list) throws IOException;

    int readSInt32() throws IOException;

    void readSInt32List(List<Integer> list) throws IOException;

    long readSInt64() throws IOException;

    void readSInt64List(List<Long> list) throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    void readStringListRequireUtf8(List<String> list) throws IOException;

    String readStringRequireUtf8() throws IOException;

    int readUInt32() throws IOException;

    void readUInt32List(List<Integer> list) throws IOException;

    long readUInt64() throws IOException;

    void readUInt64List(List<Long> list) throws IOException;

    boolean skipField() throws IOException;
}
