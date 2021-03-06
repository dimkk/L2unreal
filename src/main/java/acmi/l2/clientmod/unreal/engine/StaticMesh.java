/*
 * Copyright (c) 2016 acmi
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
package acmi.l2.clientmod.unreal.engine;

import acmi.l2.clientmod.io.annotation.UShort;

public class StaticMesh extends Primitive {
    public StaticMeshSection[] sections;
    public Box boundingBox2;
    public StaticMeshVertexStream vertexStream;
    public RawColorStream colorStream1;
    public RawColorStream colorStream2;
    public StaticMeshUVStream[] UVStream;
    public RawIndexBuffer indexStream1;
    public RawIndexBuffer indexStream2;

    public static class StaticMeshSection {
        public int f4;
        @UShort
        public int firstIndex;
        @UShort
        public int firstVertex;
        @UShort
        public int lastVertex;
        @UShort
        public int fE;
        @UShort
        public int numFaces;
    }

    public static class StaticMeshVertexStream {
        public StaticMeshVertex[] vert;
        public int revision;
    }

    public static class StaticMeshVertex {
        public Vector pos;
        public Vector normal;
    }

    public static class RawColorStream {
        public Color[] color;
        public int revision;
    }

    public static class StaticMeshUVStream {
        public MeshUVFloat[] data;
        public int f10;
        public int f1C;
    }

    public static class MeshUVFloat {
        public float u;
        public float v;
    }

    public static class RawIndexBuffer {
        @UShort
        public int[] indices;
        public int revision;
    }
}
