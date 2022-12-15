package ch7.volume;

public class TV implements Volume{
    private int volumeLevel;

    public TV(){}

    @Override
    public void volumeUp(int level) {
        volumeLevel = volumeLevel + level > 100 ? 100 : volumeLevel + level;
        System.out.println(String.format("Volume Up %d level, Current Volume : %d (Max 100)", level, volumeLevel));
    }

    @Override
    public void volumeDown(int level) {
        volumeLevel = volumeLevel - level < 0 ? 0 : volumeLevel - level;
        System.out.println(String.format("Volume Down %d level, Current Volume : %d (Min 0)", level, volumeLevel));
    }
}
