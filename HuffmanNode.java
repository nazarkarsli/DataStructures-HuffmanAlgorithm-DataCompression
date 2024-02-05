class HuffmanNode {
    public Link next;
    char karakter;
    int frekans;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char karakter, int frekans) {
        this.karakter = karakter;
        this.frekans = frekans;
        this.left = null;
        this.right = null;
    }
    public boolean isLeaf() {
        return left == null && right == null;
    }
}