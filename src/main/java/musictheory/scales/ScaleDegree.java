package musictheory.scales;

public enum ScaleDegree {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    i(1),
    ii(2),
    iii(3),
    iv(4),
    v(5),
    vi(6),
    vii(7);


    private final int scaleDegree;

    ScaleDegree(int scaleDegree) {
        this.scaleDegree = scaleDegree;
    }

    public int getScaleDegree(){
        return scaleDegree;
    }

}