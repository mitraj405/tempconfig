package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonNodeDeserializer */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    /* compiled from: JsonNodeDeserializer */
    public static final class ContainerStack {
        private int _end;
        private ContainerNode[] _stack;
        private int _top;

        public ContainerNode popOrNull() {
            int i = this._top;
            if (i == 0) {
                return null;
            }
            ContainerNode[] containerNodeArr = this._stack;
            int i2 = i - 1;
            this._top = i2;
            return containerNodeArr[i2];
        }

        public void push(ContainerNode containerNode) {
            int i = this._top;
            int i2 = this._end;
            if (i < i2) {
                ContainerNode[] containerNodeArr = this._stack;
                this._top = i + 1;
                containerNodeArr[i] = containerNode;
                return;
            }
            if (this._stack == null) {
                this._end = 10;
                this._stack = new ContainerNode[10];
            } else {
                int min = Math.min(4000, Math.max(20, i2 >> 1)) + i2;
                this._end = min;
                this._stack = (ContainerNode[]) Arrays.copyOf(this._stack, min);
            }
            ContainerNode[] containerNodeArr2 = this._stack;
            int i3 = this._top;
            this._top = i3 + 1;
            containerNodeArr2[i3] = containerNode;
        }
    }

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
    }

    public final JsonNode _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        int currentTokenId = jsonParser.currentTokenId();
        if (currentTokenId == 2) {
            return nodeFactory.objectNode();
        }
        switch (currentTokenId) {
            case 6:
                return nodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, nodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, nodeFactory);
            case 9:
                return nodeFactory.booleanNode(true);
            case 10:
                return nodeFactory.booleanNode(false);
            case 11:
                return nodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    public final ContainerNode<?> _deserializeContainerNoRecursion(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack, ContainerNode<?> containerNode) throws IOException {
        ObjectNode objectNode;
        JsonNode textNode;
        ObjectNode objectNode2;
        JsonParser jsonParser2 = jsonParser;
        JsonNodeFactory jsonNodeFactory2 = jsonNodeFactory;
        ContainerStack containerStack2 = containerStack;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures() & StdDeserializer.F_MASK_INT_COERCIONS;
        ContainerNode<?> containerNode2 = containerNode;
        do {
            boolean z = true;
            if (!(containerNode2 instanceof ObjectNode)) {
                ArrayNode arrayNode = (ArrayNode) containerNode2;
                while (true) {
                    JsonToken nextToken = jsonParser.nextToken();
                    if (nextToken == null) {
                        nextToken = JsonToken.NOT_AVAILABLE;
                    }
                    switch (nextToken.id()) {
                        case 1:
                            containerStack2.push(containerNode2);
                            containerNode2 = jsonNodeFactory.objectNode();
                            arrayNode.add(containerNode2);
                            continue;
                        case 3:
                            containerStack2.push(containerNode2);
                            containerNode2 = jsonNodeFactory.arrayNode();
                            arrayNode.add(containerNode2);
                            continue;
                        case 4:
                            break;
                        case 6:
                            arrayNode.add(jsonNodeFactory2.textNode(jsonParser.getText()));
                            break;
                        case 7:
                            arrayNode.add(_fromInt(jsonParser2, deserializationFeatures, jsonNodeFactory2));
                            break;
                        case 8:
                            arrayNode.add(_fromFloat(jsonParser, deserializationContext, jsonNodeFactory));
                            break;
                        case 9:
                            arrayNode.add(jsonNodeFactory2.booleanNode(true));
                            break;
                        case 10:
                            arrayNode.add(jsonNodeFactory2.booleanNode(false));
                            break;
                        case 11:
                            arrayNode.add(jsonNodeFactory.nullNode());
                            break;
                        default:
                            arrayNode.add(_deserializeRareScalar(jsonParser, deserializationContext));
                            break;
                    }
                }
            } else {
                ObjectNode objectNode3 = containerNode2;
                ObjectNode objectNode4 = (ObjectNode) containerNode2;
                String nextFieldName = jsonParser.nextFieldName();
                while (true) {
                    if (nextFieldName != null) {
                        JsonToken nextToken2 = jsonParser.nextToken();
                        if (nextToken2 == null) {
                            nextToken2 = JsonToken.NOT_AVAILABLE;
                        }
                        int id = nextToken2.id();
                        if (id == z) {
                            ObjectNode objectNode5 = objectNode4;
                            ObjectNode objectNode6 = jsonNodeFactory.objectNode();
                            JsonNode replace = objectNode5.replace(nextFieldName, objectNode6);
                            if (replace != null) {
                                ObjectNode objectNode7 = objectNode5;
                                objectNode = objectNode6;
                                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, nextFieldName, objectNode7, replace, objectNode6);
                            } else {
                                objectNode = objectNode6;
                            }
                            containerStack2.push(objectNode3);
                            objectNode4 = objectNode;
                            objectNode3 = objectNode4;
                        } else if (id != 3) {
                            switch (id) {
                                case 6:
                                    textNode = jsonNodeFactory2.textNode(jsonParser.getText());
                                    break;
                                case 7:
                                    textNode = _fromInt(jsonParser2, deserializationFeatures, jsonNodeFactory2);
                                    break;
                                case 8:
                                    textNode = _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
                                    break;
                                case 9:
                                    textNode = jsonNodeFactory2.booleanNode(z);
                                    break;
                                case 10:
                                    textNode = jsonNodeFactory2.booleanNode(false);
                                    break;
                                case 11:
                                    textNode = jsonNodeFactory.nullNode();
                                    break;
                                default:
                                    textNode = _deserializeRareScalar(jsonParser, deserializationContext);
                                    break;
                            }
                            JsonNode jsonNode = textNode;
                            JsonNode replace2 = objectNode4.replace(nextFieldName, jsonNode);
                            if (replace2 != null) {
                                objectNode2 = objectNode4;
                                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, nextFieldName, objectNode4, replace2, jsonNode);
                            } else {
                                objectNode2 = objectNode4;
                            }
                            objectNode4 = objectNode2;
                        } else {
                            ObjectNode objectNode8 = objectNode4;
                            ArrayNode arrayNode2 = jsonNodeFactory.arrayNode();
                            JsonNode replace3 = objectNode8.replace(nextFieldName, arrayNode2);
                            if (replace3 != null) {
                                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, nextFieldName, objectNode8, replace3, arrayNode2);
                            }
                            containerStack2.push(objectNode3);
                            containerNode2 = arrayNode2;
                            continue;
                        }
                        nextFieldName = jsonParser.nextFieldName();
                        z = true;
                    }
                }
            }
            containerNode2 = containerStack.popOrNull();
            continue;
        } while (containerNode2 != null);
        return containerNode;
    }

    public final ObjectNode _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, ContainerStack containerStack) throws IOException {
        JsonNode jsonNode;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String currentName = jsonParser.currentName();
        while (currentName != null) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == null) {
                nextToken = JsonToken.NOT_AVAILABLE;
            }
            int id = nextToken.id();
            if (id == 1) {
                jsonNode = _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.objectNode());
            } else if (id != 3) {
                jsonNode = _deserializeAnyScalar(jsonParser, deserializationContext);
            } else {
                jsonNode = _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, containerStack, jsonNodeFactory.arrayNode());
            }
            JsonNode jsonNode2 = jsonNode;
            JsonNode replace = objectNode.replace(currentName, jsonNode2);
            if (replace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, currentName, objectNode, replace, jsonNode2);
            }
            currentName = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    public final JsonNode _deserializeRareScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int currentTokenId = jsonParser.currentTokenId();
        if (currentTokenId == 2) {
            return deserializationContext.getNodeFactory().objectNode();
        }
        if (currentTokenId == 8) {
            return _fromFloat(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
        }
        if (currentTokenId != 12) {
            return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
        return _fromEmbedded(jsonParser, deserializationContext);
    }

    public final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        Object embeddedObject = jsonParser.getEmbeddedObject();
        if (embeddedObject == null) {
            return nodeFactory.nullNode();
        }
        if (embeddedObject.getClass() == byte[].class) {
            return nodeFactory.binaryNode((byte[]) embeddedObject);
        }
        if (embeddedObject instanceof RawValue) {
            return nodeFactory.rawValueNode((RawValue) embeddedObject);
        }
        if (embeddedObject instanceof JsonNode) {
            return (JsonNode) embeddedObject;
        }
        return nodeFactory.pojoNode(embeddedObject);
    }

    public final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType = jsonParser.getNumberType();
        if (numberType == JsonParser.NumberType.BIG_DECIMAL) {
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        }
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (jsonParser.isNaN()) {
                return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
            }
            return jsonNodeFactory.numberNode(jsonParser.getDecimalValue());
        } else if (numberType == JsonParser.NumberType.FLOAT) {
            return jsonNodeFactory.numberNode(jsonParser.getFloatValue());
        } else {
            return jsonNodeFactory.numberNode(jsonParser.getDoubleValue());
        }
    }

    public final JsonNode _fromInt(JsonParser jsonParser, int i, JsonNodeFactory jsonNodeFactory) throws IOException {
        if (i == 0) {
            JsonParser.NumberType numberType = jsonParser.getNumberType();
            if (numberType == JsonParser.NumberType.INT) {
                return jsonNodeFactory.numberNode(jsonParser.getIntValue());
            }
            if (numberType == JsonParser.NumberType.LONG) {
                return jsonNodeFactory.numberNode(jsonParser.getLongValue());
            }
            return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(i)) {
            return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
        } else {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
    }

    public void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportInputMismatch((Class<?>) JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (!deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            return;
        }
        if (jsonNode.isArray()) {
            ((ArrayNode) jsonNode).add(jsonNode2);
            objectNode.replace(str, jsonNode);
            return;
        }
        ArrayNode arrayNode = jsonNodeFactory.arrayNode();
        arrayNode.add(jsonNode);
        arrayNode.add(jsonNode2);
        objectNode.replace(str, arrayNode);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public boolean isCachable() {
        return true;
    }

    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    public final JsonNode updateObject(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectNode objectNode, ContainerStack containerStack) throws IOException {
        String str;
        JsonNode jsonNode;
        if (jsonParser.isExpectedStartObjectToken()) {
            str = jsonParser.nextFieldName();
        } else if (!jsonParser.hasToken(JsonToken.FIELD_NAME)) {
            return (JsonNode) deserialize(jsonParser, deserializationContext);
        } else {
            str = jsonParser.currentName();
        }
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        while (str != null) {
            JsonToken nextToken = jsonParser.nextToken();
            JsonNode jsonNode2 = objectNode.get(str);
            if (jsonNode2 != null) {
                if (jsonNode2 instanceof ObjectNode) {
                    if (nextToken == JsonToken.START_OBJECT) {
                        JsonNode updateObject = updateObject(jsonParser, deserializationContext, (ObjectNode) jsonNode2, containerStack);
                        if (updateObject != jsonNode2) {
                            objectNode.set(str, updateObject);
                        }
                        str = jsonParser.nextFieldName();
                    }
                } else if ((jsonNode2 instanceof ArrayNode) && nextToken == JsonToken.START_ARRAY) {
                    _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, containerStack, (ArrayNode) jsonNode2);
                    str = jsonParser.nextFieldName();
                }
            }
            if (nextToken == null) {
                nextToken = JsonToken.NOT_AVAILABLE;
            }
            int id = nextToken.id();
            if (id == 1) {
                jsonNode = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, containerStack, nodeFactory.objectNode());
            } else if (id == 3) {
                jsonNode = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, containerStack, nodeFactory.arrayNode());
            } else if (id == 6) {
                jsonNode = nodeFactory.textNode(jsonParser.getText());
            } else if (id != 7) {
                switch (id) {
                    case 9:
                        jsonNode = nodeFactory.booleanNode(true);
                        break;
                    case 10:
                        jsonNode = nodeFactory.booleanNode(false);
                        break;
                    case 11:
                        jsonNode = nodeFactory.nullNode();
                        break;
                    default:
                        jsonNode = _deserializeRareScalar(jsonParser, deserializationContext);
                        break;
                }
            } else {
                jsonNode = _fromInt(jsonParser, deserializationContext, nodeFactory);
            }
            objectNode.set(str, jsonNode);
            str = jsonParser.nextFieldName();
        }
        return objectNode;
    }

    public final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberType;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((StdDeserializer.F_MASK_INT_COERCIONS & deserializationFeatures) == 0) {
            numberType = jsonParser.getNumberType();
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
            numberType = JsonParser.NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
            numberType = JsonParser.NumberType.LONG;
        } else {
            numberType = jsonParser.getNumberType();
        }
        if (numberType == JsonParser.NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (numberType == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.getLongValue());
        }
        return jsonNodeFactory.numberNode(jsonParser.getBigIntegerValue());
    }
}
