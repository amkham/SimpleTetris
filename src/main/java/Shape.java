/**
 * Перечисление фигур игры
 */
public enum Shape {


    SHAPE1 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1},
                    {1, 0},
                    {1, 0}
            };
        }
    },

    SHAPE2 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0, 0},
                    {1, 1, 1}
            };
        }
    },

    SHAPE3 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1},
                    {0, 1},
                    {1, 1}
            };
        }
    },

    SHAPE4 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 0, 1}
            };
        }
    },

    SHAPE5 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1},
                    {0, 1},
                    {0, 1}
            };
        }
    },

    SHAPE6 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 0, 1},
                    {1, 1, 1}
            };
        }
    },
    SHAPE7 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0},
                    {1, 0},
                    {1, 1}
            };
        }
    },

    SHAPE8 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 1},
                    {1, 0, 0}
            };
        }
    },

    SHAPE9 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1}
            };
        }
    },

    SHAPE10 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1, 1},
                    {1, 1, 0}
            };
        }
    },

    SHAPE11 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1},
                    {1, 1},
                    {1, 0}
            };
        }
    },

    SHAPE12 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 0},
                    {0, 1, 1}
            };
        }
    },

    SHAPE13 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 1}
            };
        }
    },

    SHAPE14 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 1, 0}
            };
        }
    },

    SHAPE15 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0, 0},
                    {1, 1, 1},
                    {1, 0, 0}
            };
        }
    },

    SHAPE16 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 1}
            };
        }
    },
    SHAPE17 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 1}
            };
        }
    },

    SHAPE18 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1},
                    {1},
                    {1}
            };
        }
    },

    SHAPE19 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1}
            };
        }
    },

    SHAPE20 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1},
                    {1, 0}
            };
        }
    },

    SHAPE21 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1},
                    {0, 1}
            };
        }
    },

    SHAPE22 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1},
                    {1, 1}
            };
        }
    },

    SHAPE23 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0},
                    {1, 1}
            };
        }
    },

    SHAPE24 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 0},
                    {1, 1},
                    {1, 0}
            };
        }
    },
    SHAPE25 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 1, 0}
            };
        }
    },

    SHAPE26 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1},
                    {1, 1},
                    {0, 1}
            };
        }
    },
    SHAPE27 {
        public int[][] getShapeStructure() {
            return new int[][]{
                    {0, 1, 0},
                    {1, 1, 1}
            };
        }
    };


    public static Shape getFigure(int index) {
        Shape[] shapes = Shape.values();
        return shapes[index];
    }

    public abstract int[][] getShapeStructure();
}
