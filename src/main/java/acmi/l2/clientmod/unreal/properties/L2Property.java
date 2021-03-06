/*
 * Copyright (c) 2014 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.properties;

import acmi.l2.clientmod.unreal.core.Property;
import acmi.l2.clientmod.unreal.core.StructProperty;

import java.util.Arrays;
import java.util.List;

public final class L2Property {
    private final Property template;
    private final Object[] value;

    public L2Property(Property template) {
        this.template = template;
        this.value = new Object[template.arrayDimension];
    }

    public String getName() {
        return template.entry.getObjectName().getName();
    }

    public Property getTemplate() {
        return template;
    }

    public int getSize() {
        return value.length;
    }

    public Object getAt(int index) {
        return value[index];
    }

    public void putAt(int index, Object value) {
        this.value[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof L2Property)) return false;

        L2Property that = (L2Property) o;

        return template.equals(that.template) && Arrays.deepEquals(value, that.value);

    }

    @Override
    public int hashCode() {
        int result = template.hashCode();
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "L2Property[" + template + "]";
    }

    public L2Property copy() {
        L2Property copy = new L2Property(template);
        boolean primitive = PropertiesUtil.isPrimitive(template);
        boolean isStruct = template instanceof StructProperty;
        for (int i = 0; i < getSize(); i++) {
            if (primitive)
                copy.putAt(i, getAt(i));
            else if (isStruct)
                copy.putAt(i, PropertiesUtil.cloneStruct((List<L2Property>) getAt(i)));
            //else ???
        }
        return copy;
    }
}
