package Algorithms;

public class Tree {
    public static void main(String[] args) {
        Tree1 root = new Tree1(20,
                new Tree1(7,
                        new Tree1(4, null, new Tree1(6)),
                        new Tree1(9)),
                new Tree1(35,
                        new Tree1(31, new Tree1(28), null),
                        new Tree1(40, new Tree1(38), new Tree1(52))));

        System.out.println("Рекурсивный обход в глубину. Сумма дерева равна = " + root.sum());
    }

    static class Tree1 {
        int value;
        Tree1 left;
        Tree1 right;

        public Tree1(int value, Tree1 left, Tree1 right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Tree1(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }
            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }
}
