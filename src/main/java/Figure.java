import java.util.Random;

public enum Figure {
    FIGURE1 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1},
                    {1, 0},
                    {1, 0}
            };
        }
    },

    FIGURE2 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0, 0},
                    {1, 1, 1}
            };
        }
    },

    FIGURE3 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1},
                    {0, 1},
                    {1, 1}
            };
        }
    },

    FIGURE4 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 0, 1}
            };
        }
    },

    FIGURE5 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1},
                    {0, 1},
                    {0, 1}
            };
        }
    },

    FIGURE6 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 0, 1},
                    {1, 1, 1}
            };
        }
    },
    FIGURE7 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0},
                    {1, 0},
                    {1, 1}
            };
        }
    },

    FIGURE8 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1},
                    {1, 0, 0}
            };
        }
    },

    FIGURE9 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1}
            };
        }
    },

    FIGURE10 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1, 1},
                    {1, 1, 0}
            };
        }
    },

    FIGURE11 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1},
                    {1, 1},
                    {1, 0}
            };
        }
    },

    FIGURE12 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 0},
                    {0, 1, 1}
            };
        }
    },

    FIGURE13 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 1}
            };
        }
    },

    FIGURE14 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 1, 0}
            };
        }
    },

    FIGURE15 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0, 0},
                    {1, 1, 1},
                    {1, 0, 0}
            };
        }
    },

    FIGURE16 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 1}
            };
        }
    },
    FIGURE17 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1}
            };
        }
    },

    FIGURE18 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1},
                    {1},
                    {1}
            };
        }
    },

    FIGURE19 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1}
            };
        }
    },

    FIGURE20 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1},
                    {1, 0}
            };
        }
    },

    FIGURE21 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1},
                    {0, 1}
            };
        }
    },

    FIGURE22 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1},
                    {1, 1}
            };
        }
    },

    FIGURE23 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0},
                    {1, 1}
            };
        }
    },

    FIGURE24 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 0},
                    {1, 1},
                    {1, 0}
            };
        }
    },
    FIGURE25 {
        public int[][] getMatrix() {
            return new int[][]{
                    {1, 1, 1},
                    {0, 1, 0}
            };
        }
    },

    FIGURE26 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1},
                    {1, 1},
                    {0, 1}
            };
        }
    },
    FIGURE27 {
        public int[][] getMatrix() {
            return new int[][]{
                    {0, 1, 0},
                    {1, 1, 1}
            };
        }
    };

    public abstract int[][] getMatrix();

    public static Figure getFigure(int index) {
        Figure[] _figures = Figure.values();
        return _figures[index];
    }
}
