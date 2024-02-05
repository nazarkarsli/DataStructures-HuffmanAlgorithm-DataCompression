class Link {
    char karakter;
    int frekans;
    Link next;

    public Link(char karakter, int frekans) {
        this.karakter = karakter;
        this.frekans = frekans;
        this.next = null;
    }

    public void display() {
        System.out.println("Karakter: " + karakter + ", Frekans: " + frekans);
    }
}