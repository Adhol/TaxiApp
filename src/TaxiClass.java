public enum TaxiClass {
    ECONOMY,
    COMFORT,
    BUSINESS;

    public static TaxiClass getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
